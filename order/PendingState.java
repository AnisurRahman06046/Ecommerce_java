package ecommerce.order;
import ecommerce.payment.PaymentStrategy;

public class PendingState implements OrderState{
    @Override
    public void payOrder(Order order, double amount){
        System.out.println("Order"+ order.getId()+ " paid $"+ amount + ".Processing");
        order.setState(new PaidState());
    }
    @Override
    public void shipOrder(Order order){
        System.out.println("Cannot ship order.Payment is pending.....");
    }
    @Override
    public void deliverOrder(Order order){
        System.out.println("Cannot deliver order. Payment is pending......");
    }
}