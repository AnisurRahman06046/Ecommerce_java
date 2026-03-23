package ecommerce.notification;

public class SMSNotification implements NotificationStrategy{
    private String phone;
    
    public SMSNotification(String phone){
        this.phone=phone;
    }

    @Override
    public void send(String message){
        System.out.println("SMS to "+phone+": "+ message);
    }
}