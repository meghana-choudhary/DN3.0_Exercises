package cts.Rupsa.LibraryManagement;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class App{
    public static void main(String[] args) {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.method1();    
        context.close();
        //BookRepository bookRepository = (BookRepository)context.getBean("bookRepository");
        //bookRepository.method2();  -->1  
    }
}