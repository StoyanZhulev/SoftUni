package p02_services;

public class Main {
    public static void main(String[] args) {
        ComositeNotificationService service  = new ComositeNotificationService(false, new EmailNotificationService(true));

        service.sendNotification();
    }
}
