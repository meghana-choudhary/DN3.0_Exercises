public class test
{
    public static void main(String args[])
    {
       Notifier obj1=new EmailNotifier();
       obj1.send("Hello mail from EmailNotifier"); 
       Notifier obj2=new SMSNotifierDecorator(obj1);
       obj2.send("Hello from SMSNotifierDecorator");
       Notifier obj3=new SlackNotifierDecorator(obj2);
       obj3.send("Hello mail from SlackNotifierDecorator");

    }
}