import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        RuleInput r = new RuleInput();
        List<Rule> rules = List.of(
                new CgrRule(r),
                new AttendanceRule(r),
                new CreditRule(r),
                new DisciplinaryRule()
        );
        EligibilityEngine engine = new EligibilityEngine(new FakeEligibilityStore(), rules);
        engine.runAndPrint(s);
    }
}
