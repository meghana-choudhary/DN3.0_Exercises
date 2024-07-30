public class PaymentContext
{
    private PaymentStrategy ps;
    public void setPaymentContext(PaymentStrategy ps)
    {
        this.ps=ps;
    }
    public void makepayment(double amount)
    {
        ps.pay(amount);
    }
}