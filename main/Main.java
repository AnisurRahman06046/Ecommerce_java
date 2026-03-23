package ecommerce.main;
import ecommerce.payment.*;

public class Main{
    public static void main(String[] args){
        System.out.println("E-commerce Payment System Simulation");
        PaymentStrategy payment1 = PaymentFactory.getPayment("CC", "1234-5678-9012-3456");
        payment1.pay(100.0);

        PaymentStrategy payment2 = PaymentFactory.getPayment("PP", "user@example.com");
        payment2.pay(200.0);
        PaymentStrategy payment3 = PaymentFactory.getPayment("CRYPTO", "0xABCDEF1234567890");
        payment3.pay(300.0);
    }
}