public class test 
{
    public static void main(String[] args) 
    {
        Student model=new Student("ANWESHA","S001","A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("ANWESHA");
        controller.setStudentGrade("A");
        controller.updateView();
    }
}
