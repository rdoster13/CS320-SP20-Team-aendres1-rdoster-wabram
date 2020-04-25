package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import edu.ycp.cs320.booksdb.model.Author;
//import edu.ycp.cs320.booksdb.model.Book;
//import edu.ycp.cs320.booksdb.model.BookAuthor;
import edu.ycp.cs320.lab02a_wabram.model.User;

//from prof hake example
public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	//public static List<Author> getAuthors() throws IOException {
	public static List<User> getUserCreds() throws IOException{
		
		//List<Author> authorList = new ArrayList<Author>();
		List<User> userList = new ArrayList<User>();
		//ReadCSV readAuthors = new ReadCSV("authors.csv");
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				System.out.println(tuple);
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				//Author author = new Author();
				User user = new User();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				user.setUserId(userId++);				
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setgameTurn(Integer.parseInt(i.next()));
				System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getgameTurn());
				userList.add(user);
			}
			System.out.println("userList loaded from CSV file");
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
public static List<User> getInitPieceLocations() throws IOException{
		
		//List<Author> authorList = new ArrayList<Author>();
		List<User> userList = new ArrayList<User>();
		//ReadCSV readAuthors = new ReadCSV("authors.csv");
		ReadCSV readUsers = new ReadCSV("users.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readUsers.next();
				System.out.println(tuple);
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				//Author author = new Author();
				User user = new User();

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file				
				Integer.parseInt(i.next());
				// auto-generate author ID, instead
				user.setUserId(userId++);				
				user.setUsername(i.next());
				user.setPassword(i.next());
				System.out.println(user.getUsername() + " " + user.getPassword());
				userList.add(user);
			}
			System.out.println("userList loaded from CSV file");
			return userList;
		} finally {
			readUsers.close();
		}
	}
	
	// reads initial Book data from CSV file and returns a List of Books
	/*public static List<Book> getBooks() throws IOException {
		List<Book> bookList = new ArrayList<Book>();
		ReadCSV readBooks = new ReadCSV("books.csv");
		try {
			// auto-generated primary key for table books
			Integer bookId = 1;
			while (true) {
				List<String> tuple = readBooks.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Book book = new Book();
				
				// read book ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				Integer.parseInt(i.next());
				// auto-generate book ID, instead
				book.setBookId(bookId++);				
//				book.setAuthorId(Integer.parseInt(i.next()));  // no longer in books table
				book.setTitle(i.next());
				book.setIsbn(i.next());
				book.setPublished(Integer.parseInt(i.next()));
				
				bookList.add(book);
			}
			System.out.println("bookList loaded from CSV file");			
			return bookList;
		} finally {
			readBooks.close();
		}
	}
	
	// reads initial BookAuthor data from CSV file and returns a List of BookAuthors
	public static List<BookAuthor> getBookAuthors() throws IOException {
		List<BookAuthor> bookAuthorList = new ArrayList<BookAuthor>();
		ReadCSV readBookAuthors = new ReadCSV("book_authors.csv");
		try {
			while (true) {
				List<String> tuple = readBookAuthors.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				BookAuthor bookAuthor = new BookAuthor();
				bookAuthor.setBookId(Integer.parseInt(i.next()));				
				bookAuthor.setAuthorId(Integer.parseInt(i.next()));
				bookAuthorList.add(bookAuthor);
			}
			System.out.println("bookAuthorList loaded from CSV file");			
			return bookAuthorList;
		} finally {
			readBookAuthors.close();
		}
	}*/
}