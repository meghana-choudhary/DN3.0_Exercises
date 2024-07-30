public class test
{
    public static void main(String args[])
    {
        PaymentProcessor paypal1=new PayPalAdapter(new PayPal());
        paypal1.processPayment(1000);
        PaymentProcessor stripe1=new StripeAdaptar(new Stripe());
        stripe1.processPayment(20050.67);
    }
}