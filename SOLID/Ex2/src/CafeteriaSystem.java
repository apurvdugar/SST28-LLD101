import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;

    private final PricingCalculator calculator;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceFormatter formatter;
    private final InvoiceRepository repository;

    public CafeteriaSystem(PricingCalculator calculator, TaxPolicy taxPolicy, DiscountPolicy discountPolicy, InvoiceFormatter formatter, InvoiceRepository repository) {
        this.calculator = calculator;
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
        this.formatter = formatter;
        this.repository = repository;
    }
    
    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    // Intentionally SRP-violating: menu mgmt + tax + discount + format + persistence.
    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = calculator.calculateSubtotal(lines, menu);
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        List<InvoiceLine> invoiceLines = new ArrayList<>();

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            invoiceLines.add(new InvoiceLine(item.name, l.qty, lineTotal));
        }
        
        Invoice invoice = new Invoice(invId, invoiceLines, subtotal, taxPct, tax, discount, total);

        String printable = formatter.identityFormat(invoice);
        System.out.print(printable);

        repository.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + repository.countLines(invId) + ")");
    }
}
