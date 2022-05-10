package com.bookapp.testcases;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDtailsTest {
	
	
	@Mock
	IBookService bookService; //creating a proxy of BookService
	@InjectMocks
	OrderDetails orderDetails=null;
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
	@DisplayName("Testing By Author")
	void testBookByAuthor() throws BookNotFoundException {
		String author="Kathy";
		//mock the method and assume it returns a list of books by author
		when(bookService.getByauthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		
		List<Book> books=orderDetails.findByAuthor(author);
		assertNotNull(books);
	}

	@Test
	@DisplayName("Testing By AUthor -  null")
	void testBookByAuthorNull() throws BookNotFoundException {
		String author = "Kathy";
		when(bookService.getByauthor(author)).thenReturn(null);
		List<Book> actualList = orderDetails.findByAuthor(author); // should be null
		assertNull(actualList);
	}

	@Test
	@DisplayName("Testing by author-sort by name")
	void testByAuthorSorted() throws BookNotFoundException {
		String author = "Kathy";
		List<Book> expected=Arrays.asList(book2,book1,book5);//sorted
		when(bookService.getByauthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		//method to be tested
		List<Book> actualList=orderDetails.findByAuthor(author);
		assertEquals(expected.toString(), actualList.toString());
		
	}
	@Test
	@DisplayName("Testing by author - empty List")
	void testByAuthorEmpty() throws BookNotFoundException {
		String author = "Kathy";
		when(bookService.getByauthor(author)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
	}
	@Test
	@DisplayName("Testing by author- Exception")
	void testByAuthorException() throws BookNotFoundException {
		String author="paul";
		when(bookService.getByauthor(author)).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
		
	}
	@Test
	@DisplayName("Testing verify")
	void testVerify() throws BookNotFoundException {
		String author="Kathy";
		List<Book> expected=Arrays.asList(book2,book1,book5);
		
		when(bookService.getByauthor(author)).thenReturn(Arrays.asList(book1,book2,book5));
		List<Book> actualList=orderDetails.findByAuthor(author);
		assertEquals(expected.toString(), actualList.toString());
		assertNotNull(actualList);
		
		when(bookService.getByauthor(author)).thenReturn(null);
		List<Book> actual=orderDetails.findByAuthor(author);
		assertNull(actual);
		
		Mockito.verify(bookService,times(2)).getByauthor(author);
		Mockito.verify(bookService,atLeastOnce()).getByauthor(author);
		Mockito.verify(bookService,atLeast(2)).getByauthor(author);
	}

}
