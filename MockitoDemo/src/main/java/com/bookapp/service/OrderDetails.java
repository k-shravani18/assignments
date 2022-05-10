package com.bookapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {
	//depend on IBookService
	IBookService bookService;
	
	
	public IBookService getBookService() {
		return bookService;
	}
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}
	
	public String orderBook(int bookId) {
		try {
		Book book = bookService.getById(bookId);
		if(book!=null)
			return "ordered succesfully";
		else
			return "book not ordered";
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "Technical Issue-try again";
		
	}
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		List<Book> books=bookService.getByauthor(author);
		if(books!=null) {
		if(books.isEmpty())
			throw new BookNotFoundException("author not found");
			return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		}else
			return books;
	}
	public String addBook(Book book) {
		if(book==null)
			return "book not added";
		else {
		bookService.addBook(book);
		return "Book Added";
		}
	}
}
