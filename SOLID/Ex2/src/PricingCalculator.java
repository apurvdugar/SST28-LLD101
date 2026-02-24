import java.util.*;

interface PricingCalculator {
    Invoice calculate(String invId, String customerType, List<OrderLine> lines, Map<String, MenuItem> menu, TaxPolicy taxPolicy, DiscountPolicy discountPolicy);
    // double calculateSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu);
}