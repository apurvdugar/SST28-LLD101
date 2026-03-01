public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { 
        this.audit = audit; 
    }
    
    // made this final to prevent overriding and breaking the audit log
    public final void send(Notification n) {
         if (n == null) {
            System.out.println("ERROR: invalid notification");
            audit.add("invalid");
            return;
        }

        doSend(n);
    }

    public abstract void doSend(Notification n);
}
