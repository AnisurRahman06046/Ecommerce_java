package ecommerce.notification;

public class EmailNotification implements NotificationStrategy{
    private String email;

    public EmailNotification(String email){
        this.email=email;
    }

    @Override
    public void send(String message){
        System.out.println("Email to "+email+": "+ message);
    }
}