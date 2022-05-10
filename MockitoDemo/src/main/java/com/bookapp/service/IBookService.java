package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

//this is the interface to be mocked.
public interface IBookService {
	List<Book> getByauthor(String author) throws BookNotFoundException;
	List<Book> getByLessPrice(double price);
	Book getById(int bookId) throws BookNotFoundException;
	void addBook(Book book);
	
}

