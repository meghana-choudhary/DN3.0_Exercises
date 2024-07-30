public class ProxyImage implements Image
{
    private String filename;
    private RealImage ri;
    public ProxyImage(String fn)
    {
        this.filename=fn;
    }
    public void display()
    {
        if(ri==null)
        {
            ri=new RealImage(filename);
        }
        ri.display();
    }
}
