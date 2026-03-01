public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { 
        super(audit); 
    }

    @Override
    public void doSend(Notification n) {
        // Ignores subject; base type doesn't clarify expectations (smell)
        if (n.phone == null || n.body == null) {
            System.out.println("SMS ERROR: invalid notification");
            audit.add("sms error");
            return;
        }
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
