package ecommerce.promotion;
import ecommerce.discount.Discount;
import ecommerce.discount.PercentageDiscount;


public class BlackFridayPromotion implements Promotion{
    @Override
    public Discount getDiscount(double orderAmount){
        return new PercentageDiscount(25);
    }
}