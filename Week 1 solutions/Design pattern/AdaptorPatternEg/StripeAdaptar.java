public class StripeAdaptar implements PaymentProcessor
{
    private Stripe s;
    public StripeAdaptar(Stripe s)
    {
        this.s=s;
    }
    public void processPayment(double amt)
    {
        s.p2(amt);
    }
}