public class test
{
    public static void main(String args[])
    {
        Image obj1=new ProxyImage("image.jpg");
        System.out.println("This will load the image from remote server");
        obj1.display();
        System.out.println("Now this will directly display the image");
        obj1.display();
    }
}