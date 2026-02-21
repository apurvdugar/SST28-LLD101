class CgrRule implements Rule {
    private double minCgr;

    CgrRule(RuleInput input) {
        this.minCgr = input.minCgr;
    }

    public String evaluate(StudentProfile s) {
        if(s.cgr < minCgr) {
            return "CGR below " + minCgr;
        }
        return null;
    }
}