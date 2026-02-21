class CreditRule implements Rule {
    private int minCredits;

    CreditRule(RuleInput input) {
        this.minCredits = input.minCredits;
    }

    public String evaluate(StudentProfile s) {
        if(s.earnedCredits < minCredits) {
            return "credits below " + minCredits;
        }
        return null;
    }
}