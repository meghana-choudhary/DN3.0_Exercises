package com.library.service;
import com.library.repository.BookRepository;


public class BookService {
	private BookRepository bookRepository1;
	private BookRepository bookRepository2;
	
	 public BookService(BookRepository bookRepository1) {
		this.bookRepository1 = bookRepository1;
	}
	
	public void setBookRepository2(BookRepository bookRepository2) {
		this.bookRepository2 = bookRepository2;
	}
	
	
	public void bookService() {
		System.out.println("Book servicing...");
		System.out.println("Using constructor...");
		bookRepository1.repositoryTask();
		System.out.println("Using setter method...");
		bookRepository2.repositoryTask();
		
	}

}
