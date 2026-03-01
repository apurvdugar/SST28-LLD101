public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { 
        super(audit); 
    }

    @Override
    public void doSend(Notification n) {
        // LSP smell: truncates silently, changing meaning
        if (n.email == null || n.body == null) {
            System.out.println("EMAIL ERROR: invalid notification");
            audit.add("email error");
            return;
        }
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
