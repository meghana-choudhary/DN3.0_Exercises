public class test
 {
    public static void main(String[] args) 
    {
        PaymentContext context = new PaymentContext();
        PaymentStrategy creditCardPayment =new CreditCardPayment("Anwesha","123-456-789");
        context.setPaymentContext(creditCardPayment);
        context.makepayment(3500);
        PaymentStrategy payPalPayment=new PayPalPayment("xyz@gmail.com");
        context.setPaymentContext(payPalPayment);
        context.makepayment(1000);
    }
}
