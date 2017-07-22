package p02_services;

public class ComositeNotificationService implements NotificationService{

    NotificationService[] notificationServices;
    boolean isActive;

    public ComositeNotificationService(boolean isActive, NotificationService... services){
        this.notificationServices = services;
        this.isActive = isActive;
    }

    @Override
    public void sendNotification() {
        for (NotificationService notificationService : notificationServices) {
            if(notificationService.isActive()){
                notificationService.sendNotification();
            }
        }
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
