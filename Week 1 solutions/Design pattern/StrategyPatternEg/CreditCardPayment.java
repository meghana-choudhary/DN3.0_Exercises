public class CreditCardPayment implements PaymentStrategy
{
    private String name;
    private String number;
    public CreditCardPayment(String nm,String no)
    {
        this.name=nm;
        this.number=no;
    }
    public void pay(double amount)
    {
        System.out.println(name+" paid "+amount+" using credit card  "+number);
    }
}