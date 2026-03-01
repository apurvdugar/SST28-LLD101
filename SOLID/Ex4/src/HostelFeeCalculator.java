import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) { this.repo = repo; }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        List<Pricing> components = new ArrayList<>();
        components.add(RoomPrices.get(req.roomType));
        for (AddOn addOn : req.addOns) {
            components.add(AddOnPrices.get(addOn));
        }
        Money total = new Money(0.0);
        for (Pricing p : components) {
            total = total.plus(p.monthlyPrice(req));
        }
        return total;
    }
}
