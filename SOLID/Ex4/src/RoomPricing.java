class RoomPricing implements Pricing {
    private Money base;

    public RoomPricing(Money base) {
        this.base = base;
    }

    @Override
    public Money monthlyPrice(BookingRequest req) {
        return base;
    }
}