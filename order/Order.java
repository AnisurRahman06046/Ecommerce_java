package ecommerce.order;

public class Order{
    private OrderState state;
    private String id;
    private double totalAmount;


    public Order(String id,double totalAmount){
        this.id=id;
        this.totalAmount=totalAmount;
        this.state = new PendingState();
    }

    public void setState(OrderState state){
        this.state=state;
    }
    public OrderState getState(){
        return state;
    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public String getId(){
        return id;
    }
    public void payOrder(double amount){
        state.payOrder(this,amount);
    }
    public void shipOrder(){
        state.shipOrder(this);
    }
    public void deliverOrder(){
        state.deliverOrder(this);
    }
}