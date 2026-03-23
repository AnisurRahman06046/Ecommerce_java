package ecommerce.order;
import ecommerce.payment.PaymentStrategy;

public class ShippedState implements OrderState{
    @Override
    public void payOrder(Order order,double amount){
        System.out.println("Order"+ order.getId()+" is already paid");
    }
    @Override
    public void shipOrder(Order order){
        System.out.println("Order"+ order.getId()+" shipped");
    }
    @Override
    public void deliverOrder(Order order){
        System.out.println("Order"+ order.getId()+" is delivered");
    }
}