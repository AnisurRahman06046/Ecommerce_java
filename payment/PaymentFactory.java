package ecommerce.payment;
public class PaymentFactory{
    public static PaymentStrategy getPayment(String type,String details){
        switch(type.toLowerCase()){
            case "CREDITCARD":
            case "cc":
                return new CreditCardPayment(details);
            
            case "paypal":
            case "pp":
                return new PayPalPayment(details);
            case "crypto":
                return new CryptoPayment(details);
            default:
                throw new IllegalArgumentException("Invalid payment type: "+type);
        }
    }
}