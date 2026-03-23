package ecommerce.main;
import ecommerce.payment.*;
import ecommerce.order.*;
import ecommerce.notification.*;

public class Main{
    public static void main(String[] args){
        System.out.println("E-commerce Payment System Simulation");
        // PaymentStrategy payment1 = PaymentFactory.getPayment("CC", "1234-5678-9012-3456");
        // payment1.pay(100.0);

        // PaymentStrategy payment2 = PaymentFactory.getPayment("PP", "user@example.com");
        // payment2.pay(200.0);
        // PaymentStrategy payment3 = PaymentFactory.getPayment("CRYPTO", "0xABCDEF1234567890");
        // payment3.pay(300.0);

        // Create order
        Order order = new Order("ORD123",299.99);

        // Choosing payment method dynamically ( strategy + factory)
        PaymentStrategy payment = PaymentFactory.getPayment("CC","1234-5678-9012-3456");
        payment.pay(order.getTotalAmount());

        // update order state
        order.payOrder(order.getTotalAmount());

        // Ship order
        order.shipOrder();

        // deliver order
        order.deliverOrder();

        // Notify 
        NotificationService email = new NotificationService(new EmailNotification("anis@gmail.com"));
        NotificationService sms = new NotificationService(new SMSNotification("01245784787"));

        email.send("Your order has been delivered");
        sms.send("Your order has been delivered");
    }
}