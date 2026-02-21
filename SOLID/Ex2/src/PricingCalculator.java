import java.util.*;

interface PricingCalculator {
    double calculateSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu);
}