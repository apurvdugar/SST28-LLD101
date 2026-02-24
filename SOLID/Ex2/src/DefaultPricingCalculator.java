import java.util.*;
class DefaultPricingCalculator implements PricingCalculator {
    // public double calculateSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
    //     double subtotal = 0.0;
    //     for (OrderLine l : lines) {
    //         MenuItem item = menu.get(l.itemId);
    //         double lineTotal = item.price * l.qty;
    //         subtotal += lineTotal;
    //     }
    //     return subtotal;
    // }

    public Invoice calculate(String invId, String customerType, List<OrderLine> lines, Map<String, MenuItem> menu, TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            invoiceLines.add(new InvoiceLine(item.name, l.qty, lineTotal));
        }
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;
        
        return new Invoice(invId, invoiceLines, subtotal, taxPct, tax, discount, total);
    }
}