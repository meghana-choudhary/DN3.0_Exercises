public class PayPalAdapter implements PaymentProcessor {
    private PayPal pp;

    public PayPalAdapter(PayPal p) {
        this.pp = p;
    }

    @Override
    public void processPayment(double amt) {
        pp.p2(amt); 
    }
}
