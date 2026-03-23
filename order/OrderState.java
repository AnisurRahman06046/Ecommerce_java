package ecommerce.order;

public interface OrderState{
    void payOrder(Order order,double amount);
    void shipOrder(Order order);
    void deliverOrder(Order order);
}