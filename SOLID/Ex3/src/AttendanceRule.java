class AttendanceRule implements Rule {
    private double minAttendance;

    AttendanceRule(RuleInput input) {
        this.minAttendance = input.minAttendance;
    }

    public String evaluate(StudentProfile s) {
        if(s.attendancePct < minAttendance) {
            return "attendance below " + minAttendance;
        }
        return null;
    }
}