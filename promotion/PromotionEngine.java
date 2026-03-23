package ecommerce.promotion;
import ecommerce.discount.Discount;
import ecommerce.discount.DiscountDecorator;
import java.util.ArrayList;
import java.util.List;

public class PromotionEngine{
    private List<Promotion> promotions = new ArrayList<>();
    public void addPromotion(Promotion promotion){
        promotions.add(promotion);
    }

    public Discount calculateBestDiscount(double orderAmount){
        if(promotions.isEmpty()) return amount->amount;
        Discount combined = promotions.get(0).getDiscount(orderAmount);

        for(int i=1;i<promotions.size();i++){
            combined = new DiscountDecorator(combined,promotions.get(i).getDiscount(orderAmount));
        }
        return combined;
    }
}