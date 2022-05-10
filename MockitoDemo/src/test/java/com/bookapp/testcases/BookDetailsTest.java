package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.service.BookDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class BookDetailsTest {
	@Spy///this will create an object for BookDetails and call the original methods
	BookDetails details;
	@Mock//this will create proxy for the BookDetails Class and will never call the original methods
	BookDetails mdetails;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		//create objects of BookDetails
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShowBooks() {
		List<String> books=details.showBooks();
		assertEquals(3, books.size());
	}

}
