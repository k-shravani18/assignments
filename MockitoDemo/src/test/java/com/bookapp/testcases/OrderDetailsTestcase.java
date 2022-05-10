package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTestcase {
	
	@Mock
	IBookService bookService;
	@InjectMocks
	OrderDetails details;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1,book2,book3,book4,book5;
	@BeforeEach
	void setUp() throws Exception {
		//create an object of orderdetails to test the methods
		//
		book1= new Book(1,"Java","Kathy",900);
		book2= new Book(1,"Css","Kathy",200);
		book3= new Book(1,"Seven Habits","Steven",300);
		book4= new Book(1,"5am club","Robin",800);
		book5= new Book(1,"Spring","Kathy",1000);
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Testing coorect order")
	void testOrderBook() throws BookNotFoundException {
		int bookId=1;
		doReturn(book1).when(bookService).getById(bookId);
		String actual=details.orderBook(bookId);
		assertEquals("ordered succesfully",actual);
	}
	@Test
	@DisplayName("Testing book returned null")
	void testOrderBookNull() throws BookNotFoundException {
		int bookId=1;
		doReturn(null).when(bookService).getById(bookId);
		String actual=details.orderBook(bookId);
		assertEquals("book not ordered",actual);
	}
	@Test
	@DisplayName("Testing book returning exception")
	void testOrderBookException() throws BookNotFoundException {
		int bookId=1;
		doThrow(new BookNotFoundException()).when(bookService).getById(bookId);
		String atual=details.orderBook(bookId);
		assertEquals("Technical Issue-try again",atual);
	}
	
	//mocking a method that returns nothing- void return type
	@Test
	@DisplayName("Testing add book with void type")
	void testAddBook() {
		doNothing().when(bookService).addBook(book1);
		String actual=details.addBook(book1);
		assertEquals("Book Added", actual);
	}
		@Test
		@DisplayName("Testing add null book with void type")
		void testAddBookNull() {
			String actual=details.addBook(null);
			assertEquals("book not added", actual);
		
	}
		
	

}
