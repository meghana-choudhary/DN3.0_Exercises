public class RealImage implements Image
{
    private String filename;
    public RealImage(String fn)
    {
        this.filename=fn;
        loadimagefromremoteserver(filename);
    }
    private void loadimagefromremoteserver(String filename)
    {
        System.out.println("Loading an image from remote server = "+filename);
    }
    public void display()
    {
        System.out.println("Displaying image = "+filename);
    }
}