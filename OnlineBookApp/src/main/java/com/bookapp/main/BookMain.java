package com.bookapp.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.bookapp");
		IBookService bookService = context.getBean("bookServiceImpl", BookServiceImpl.class);

		Scanner scanner = new Scanner(System.in);
		System.out.println("welcom to online Book app \n press 1 for admin..\n press 2 for customer... ");
		int input = scanner.nextInt();
		try {
			if (input == 1) {
				System.out.println("....Hello Admin....\n choose the option...\n enter 1 for add a book \n "
						+ "enter 2 for getBookById \n enter 3 for update a book \n enter 4 for delete a book");
				int optionA = scanner.nextInt();
				switch (optionA) {
				case 1:
					System.out.println("...Add a Book...");
					System.out.println("enter title");
					String title = scanner.next();
					System.out.println("enter author");
					String author = scanner.next();
					System.out.println("enter category");
					String category = scanner.next();
					System.out.println("enter bookid");
					int bookid = scanner.nextInt();

					System.out.println("enter price ");
					int price = scanner.nextInt();
					Book book = new Book(bookid,title, author, category, price);
					bookService.addBook(book);
					
					break;

				case 2:
					System.out.println("...Book By Id...");
					System.out.println("enter book id");
					int bookId = scanner.nextInt();
					System.out.println(bookService.getById(bookId));
					break;

				case 3:
					System.out.println("...update a book...");
					System.out.println("enter book id");
					int bookI = scanner.nextInt();
					System.out.println("update price");
					int updatePrice = scanner.nextInt();
					bookService.updateBook(bookI, updatePrice);
					
					break;

				case 4:
					System.out.println("...delete a book...");
					System.out.println("enter book id");
					int delBookId = scanner.nextInt();
					bookService.deleteBook(delBookId);
					
					break;

				default:
					System.err.println("...WRONG OPTION...");
					break;

				}
			} else if (input == 2) {
				System.out.println("....Hello Customer....\n choose the option....\n enter 1 for getAllBooks"
						+ " \n enter 2 for getBookByAuthor \n enter 3 for getBookByCategory");
				int optionC = scanner.nextInt();
				switch (optionC) {
				case 1:
					System.out.println("...all books...");
					System.out.println(bookService.getAll());
					break;
				case 2:
					System.out.println("...book by author...");
					System.out.println("enter author");
					String author = scanner.next();
					System.out.println(bookService.getByAuthor(author));
					break;
				case 3:
					System.out.println("...book by category...");
					System.out.println("enter category");
					String category = scanner.next();
					System.out.println(bookService.getByCategory(category));
					break;
				default:
					System.err.println("...WRONG OPTION...");
					break;

				}
			} else {
				System.err.println("....WRONG INPUT....");
			}
		} catch (BookNotFoundException | IdNotFoundException e) {
			e.printStackTrace();
		}
		scanner.close();

	}

}
