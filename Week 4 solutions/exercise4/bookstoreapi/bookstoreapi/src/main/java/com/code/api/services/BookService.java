package com.code.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.code.api.dto.BookDTO;
import com.code.api.dto.CustomerDTO;
import com.code.api.entity.Book;
import com.code.api.exception.ResourceNotFoundException;
import com.code.api.repository.BookRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Service

public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	@Autowired
	 private ModelMapper modelMapper;

	private final Counter bookCounter;

    public BookService(MeterRegistry meterRegistry) {
        this.bookCounter = meterRegistry.counter("book.creation.counter");
    }
    
    private	<S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> modelMapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
    public List<BookDTO> getBooks()
    {
    	List<Book> books= bookRepository.findAll();
    	List<BookDTO> bookDTOs=mapList(books,BookDTO.class);
    	return bookDTOs;
    	
    }
    public Book getBookId(int id)
    {
    	return bookRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Error: Book not found with "+id));
    }
    public Book getBookById(int id) {
    	List<Book> books= bookRepository.findAll();
        return books.stream()
            .filter(book -> book.getId()==id)
            .findFirst()
            .orElseThrow(() ->  new ResourceNotFoundException("Error: Book not found with "+id));
    }

    public List<Book> filterBooks(String title, String author) {
    	List<Book> books= bookRepository.findAll();
        return books.stream()
            .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                            (author == null || book.getAuthor().equalsIgnoreCase(author)))
            .collect(Collectors.toList());
    }
    public List<Book> filterBooks1(String title, String author) {
    	List<Book> book1s= bookRepository.findAll();
        return book1s.stream()
            .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                            (author == null || book.getAuthor().equalsIgnoreCase(author)))
            .collect(Collectors.toList());
    }
    public Book addBook(Book book)
    {
    	//increment
        bookCounter.increment();
        //System.out.println( bookCounter.increment());
    	return bookRepository.save(book);
    }
    public Book updateBook(int bookid,Book book)
    {
    	Book oldbook= bookRepository.findById(bookid).get();
    	if(oldbook==null)
    	{
    		return null;
    	}
    	
    	oldbook.setAuthor(book.getAuthor());
    	oldbook.setIsbn(book.getIsbn());
    	oldbook.setPrice(book.getPrice());
    	oldbook.setTitle(book.getTitle());
    	return bookRepository.save(oldbook);
    }
    public String deleteBook(int id)
    {
    	Book book= bookRepository.findById(id).get();
    	if(book==null)
    	{
    		return "Book Id"+id+" not found";
    	}
    	bookRepository.delete(book);
    	return "Book Id"+id+" is deleted successfully";
    }
}
