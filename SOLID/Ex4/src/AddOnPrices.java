import java.util.*;

class AddOnPrices {
    private static Map<AddOn, Pricing> addOns = Map.of(
        AddOn.MESS, new AddOnPricing(new Money(1000.0)),
        AddOn.LAUNDRY, new AddOnPricing(new Money(500.0)),
        AddOn.GYM, new AddOnPricing(new Money(300.0))
    );

    public static Pricing get(AddOn addOn) {
        return addOns.get(addOn);
    }
}