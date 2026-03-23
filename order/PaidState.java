package ecommerce.order;
import ecommerce.payment.PaymentStrategy;

public class PaidState implements OrderState{
    @Override
    public void payOrder(Order order, double amount){
        System.out.println("Order"+ order.getId()+" is already paid");
    }
    @Override
    public void shipOrder(Order order){
        System.out.println("Order"+ order.getId()+" shipped");
        order.setState(new ShippedState());
    }
    @Override
    public void deliverOrder(Order order){
        System.out.println("Cannot deliver order. order is not shipped yet");
    }
}