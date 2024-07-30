public class test 
{
    public static void main(String[] args) 
    {
        StockMarket obj = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        obj.register(mobileApp);
        obj.register(webApp);
        obj.setStockPrice(40);
        obj.setStockPrice(34005.5);
        obj.deregister(webApp);
        obj.setStockPrice(200.45);
    }
}
