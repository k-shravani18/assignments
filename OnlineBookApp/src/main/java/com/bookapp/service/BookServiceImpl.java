package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	private IBookDao bookDao;

	@Autowired
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.addBook(book);
		System.out.println("book is added");
	}

	public void updateBook(int bookId, double price) {
		// TODO Auto-generated method stub
		bookDao.updateBook(bookId, price);
		System.out.println("price updated");
	}

	public void deleteBook(int bookId) {
	bookDao.deleteBook(bookId);
	System.out.println("book deleted");
	
	}

	public Book getById(int bookId) throws IdNotFoundException {
		Book book= bookDao.findById(bookId);
		if(book==null)
			throw new IdNotFoundException();
		return book;
	}

	public List<Book> getAll() {
		List<Book> books=bookDao.findAll();
		return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = bookDao.findByAuthor(author);
		if(booksByAuthor.isEmpty())
			throw new BookNotFoundException("Books by this author"+author+"not found");
		
		return booksByAuthor.stream().sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
	}

	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> booksByCategory = bookDao.findByCategory(category);
		if(booksByCategory.isEmpty())
			throw new BookNotFoundException("books in this category"+category+"not found");
		
		return booksByCategory.stream().sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
		
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByLesserPrice = bookDao.findByLesserPrice(price);
		if(booksByLesserPrice.isEmpty())
			throw new BookNotFoundException("books in this lesserprice"+price+"not found");
		
		return booksByLesserPrice.stream().sorted((o1,o2)->o1.getTitle().compareTo(o2.getTitle())).collect(Collectors.toList());
	}

	


}
