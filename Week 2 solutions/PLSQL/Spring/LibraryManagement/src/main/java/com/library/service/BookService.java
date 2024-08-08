package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;
@Service
public class BookService {
@Autowired
private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository)
	{
		this.bookRepository = bookRepository;
	}
	public void setBookRepository(BookRepository br) {
		this.bookRepository = br;
	}
	
	public void method1()
	{
		System.out.println("Hello.Book service");
		bookRepository.method2();
	}
}
