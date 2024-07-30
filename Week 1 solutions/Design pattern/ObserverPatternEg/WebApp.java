public class WebApp implements Observer
{
    public void update(double amount)
    {
         System.out.println("Web App: Received update for stock market= "+amount);
    }
}