class InvoiceLine {
    String name;
    int qty;
    double lineTotal;

    InvoiceLine(String name, int qty, double lineTotal) {
        this.name = name;
        this.qty = qty;
        this.lineTotal = lineTotal;
    }
}