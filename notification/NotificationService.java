package ecommerce.notification;


public class NotificationService {
    private NotificationStrategy strategy;
    public NotificationService(NotificationStrategy strategy){
        this.strategy=strategy;
    }
    public void send(String message){
        strategy.send(message);
    }
}