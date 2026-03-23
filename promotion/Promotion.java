package ecommerce.promotion;
import ecommerce.discount.Discount;

public interface Promotion{
    Discount getDiscount(double orderAmount);
}