public class MobileApp implements Observer
{
    public void update(double amount)
    {
         System.out.println("Mobile App receiving update for stock market= "+amount);
    }
}