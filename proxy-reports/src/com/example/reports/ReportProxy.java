package com.example.reports;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    private boolean hasAccess(User user) {
        return accessControl.canAccess(user, classification);
    }

    private RealReport getReal() {
        if (realReport == null) {
            realReport = new RealReport(reportId, title, classification);
            System.out.println("[proxy] creating RealReport for " + reportId);
        }
        return realReport;
    }

    @Override
    public void display(User user) {
        if (!hasAccess(user)) {
            System.out.println("ACCESS DENIED for user " + user.getName() + " to report " + reportId);
            return;
        }
        getReal().display(user);
    }
}
