public class singletonpatterntest
{
    public static void main(String[] args) 
    { 
        Logger log1=Logger.getInstance();
        Logger log2=Logger.getInstance();
        if(log1==log2)
        {
            System.out.println("Only one instance of logger is created and both are same");
        }
        else
        {
            System.out.println("Both instances of logger are different");
        }
    }
}