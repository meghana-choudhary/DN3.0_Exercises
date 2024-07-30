public class SMSNotifierDecorator extends NotifierDecorator
{
    public SMSNotifierDecorator(Notifier n)
    {
        super(n);
    }
    public void send(String msg)
    {
        super.send(msg);
        System.out.println("Sending SMS  "+msg);
    }
}