package ecommerce.discount;

public class PercentageDiscount implements Discount{
    private double percentage;

    public PercentageDiscount(double percentage){
        this.percentage = percentage;
    }

    @Override
    public double apply(double amount){
        double discounted = amount - (amount*percentage/100);
        System.out.println("Applying "+percentage+"% discount.New amount: "+discounted);
        return discounted;
    }
}