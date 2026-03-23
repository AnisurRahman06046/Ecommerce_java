package ecommerce.discount;

public class FlatDiscount implements Discount{
    private double flatAmount;

    public FlatDiscount(double flatAmount){
        this.flatAmount=flatAmount;
    }

    @Override
    public double apply(double amount){
        double discounted = amount - flatAmount;
        System.out.println("Applying "+flatAmount+"% discount.New amount: "+discounted);
        return discounted;
    }
}