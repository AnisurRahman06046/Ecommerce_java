package ecommerce.discount;


public class DiscountDecorator implements Discount{
    private Discount baseDiscount;
    private Discount additionalDiscount;


    public DiscountDecorator(Discount baseDiscount,Discount additionalDiscount){
        this.baseDiscount=baseDiscount;
        this.additionalDiscount=additionalDiscount;
    }
    @Override
    public double apply(double amount){
        double afterBase = baseDiscount.apply(amount);
        return additionalDiscount.apply(afterBase);
    }
}