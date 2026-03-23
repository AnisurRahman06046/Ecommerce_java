package ecommerce.promotion;
import ecommerce.discount.Discount;
import ecommerce.discount.FlatDiscount;


public class LoyaltyPromotion implements Promotion{
    @Override
    public Discount getDiscount(double orderAmount){
        return new FlatDiscount(30);
    }
}