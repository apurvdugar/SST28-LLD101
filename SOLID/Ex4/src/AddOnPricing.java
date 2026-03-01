class AddOnPricing implements Pricing {
    
    private Money addOn;

    AddOnPricing(Money addOn) {
        this.addOn = addOn;
    }

    @Override
    public Money monthlyPrice(BookingRequest req) {
        return addOn;
    }
}