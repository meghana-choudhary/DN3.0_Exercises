public class test
 {
    public static void main(String[] args) 
    {
        Light obj=new Light();
        LightOnCommand on = new LightOnCommand(obj);
        LightOffCommand off = new LightOffCommand(obj);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(on);
        remote.pressButton();
        remote.setCommand(off);
        remote.pressButton();
    }
}
