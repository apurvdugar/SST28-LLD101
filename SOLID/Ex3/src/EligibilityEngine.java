import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<Rule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<Rule> rules) { 
        this.store = store; 
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); 
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";
        
        for(Rule r : rules) {
            String reason = r.evaluate(s);
            if (reason != null) {
                status = "NOT_ELIGIBLE";
                reasons.add(reason);
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
