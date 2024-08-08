package com.Anwesha.LibraryManagement;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;
import com.library.repository.BookRepository;

public class App{
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        bookService.bookService();
        
        BookRepository bookRepository = (BookRepository)context.getBean("bookRepository");
        bookRepository.repositoryTask();
        
    }
}
