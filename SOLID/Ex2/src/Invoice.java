import java.util.*;
class Invoice {
    String invId;
    List<InvoiceLine> lines;
    double subtotal;
    double taxPct;
    double tax;
    double discount;
    double total;

    Invoice(String invId, List<InvoiceLine> lines, double subtotal, double taxPct, double tax, double discount, double total) {
        this.invId = invId;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}