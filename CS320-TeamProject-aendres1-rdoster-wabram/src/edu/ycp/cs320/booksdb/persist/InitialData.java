package edu.ycp.cs320.booksdb.persist;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.ycp.cs320.lab02a_wabram.model.Bishop;
import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.King;
import edu.ycp.cs320.lab02a_wabram.model.Knight;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;
import edu.ycp.cs320.lab02a_wabram.model.Piece;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;
import edu.ycp.cs320.lab02a_wabram.model.Position;
import edu.ycp.cs320.lab02a_wabram.model.Queen;
import edu.ycp.cs320.lab02a_wabram.model.Rook;
//import edu.ycp.cs320.booksdb.model.Author;
//import edu.ycp.cs320.booksdb.model.Book;
//import edu.ycp.cs320.booksdb.model.BookAuthor;
import edu.ycp.cs320.lab02a_wabram.model.User;

//from prof hake example
public class InitialData {

	// reads initial Author data from CSV file and returns a List of Authors
	// public static List<Author> getAuthors() throws IOException {
	public static List<User> getUserCreds() throws IOException {

		// List<Author> authorList = new ArrayList<Author>();
		List<User> userList = new ArrayList<User>();
		// ReadCSV readAuthors = new ReadCSV("authors.csv");
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
				// Author author = new Author();
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

	public static List<Piece> getPieces() throws IOException {

		// List<Author> authorList = new ArrayList<Author>();
		List<Piece> piecesList = new ArrayList<Piece>();
		// ReadCSV readAuthors = new ReadCSV("authors.csv");
		ReadCSV readPieces = new ReadCSV("pieces.csv");
		try {
			// auto-generated primary key for authors table
			Integer userId = 1;
			while (true) {
				List<String> tuple = readPieces.next();
				System.out.println(tuple);
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				int piece_ID = Integer.parseInt(i.next());
				int color= Integer.parseInt(i.next()) ;
				int typeEnum = Integer.parseInt(i.next());
				//PieceType type= ;
				int y= Integer.parseInt(i.next());
				int x= Integer.parseInt(i.next());
				Point position = new Point(x, y) ;
				Piece piece = null;
				
				PieceType type = null;
				if (typeEnum == 0) {
					type = PieceType.PAWN;
					piece= new Pawn(type, position, color);
				} else if (typeEnum == 1) {
					type = PieceType.ROOK;
					piece= new Rook(type, position, color);
				} else if (typeEnum == 2) {
					type = PieceType.KNIGHT;
					piece= new Knight(type, position, color);
				} else if (typeEnum == 3) {
					type = PieceType.BISHOP;
					piece= new Bishop(type, position, color);
				} else if (typeEnum == 4) {
					type = PieceType.QUEEN;
					piece= new Queen(type, position, color);
				} else if (typeEnum == 5) {
					type = PieceType.KING;
					piece= new King(type, position, color);
				}

				// read author ID from CSV file, but don't use it
				// it's there for reference purposes, just make sure that it is correct
				// when setting up the BookAuthors CSV file
				// auto-generate author ID, instead
				
				piece.setPiece_ID(piece_ID++);
				piece.setColor(color);
				piece.setType(type.getPieceType());
				piece.setY(y);
				piece.setX(x);
				System.out.println(" PIECE_ID: " + piece.getPiece_ID() + " COLOR: " + piece.getColor() + " TYPE (ENUM_INT): " + piece.getType() + " ROW: " + piece.getY() + " COLUMN: " + piece.getX());
				piecesList.add(piece);
			}
			System.out.println("Pieces loaded from CSV file");
			return piecesList;
		} finally {
			readPieces.close();
		}
	}


	public static List<User> getInitPieceLocations() throws IOException {

		// List<Author> authorList = new ArrayList<Author>();
		List<User> userList = new ArrayList<User>();
		// ReadCSV readAuthors = new ReadCSV("authors.csv");
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
				// Author author = new Author();
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
	/*
	 * public static List<Book> getBooks() throws IOException { List<Book> bookList
	 * = new ArrayList<Book>(); ReadCSV readBooks = new ReadCSV("books.csv"); try {
	 * // auto-generated primary key for table books Integer bookId = 1; while
	 * (true) { List<String> tuple = readBooks.next(); if (tuple == null) { break; }
	 * Iterator<String> i = tuple.iterator(); Book book = new Book();
	 * 
	 * // read book ID from CSV file, but don't use it // it's there for reference
	 * purposes, just make sure that it is correct // when setting up the
	 * BookAuthors CSV file Integer.parseInt(i.next()); // auto-generate book ID,
	 * instead book.setBookId(bookId++); //
	 * book.setAuthorId(Integer.parseInt(i.next())); // no longer in books table
	 * book.setTitle(i.next()); book.setIsbn(i.next());
	 * book.setPublished(Integer.parseInt(i.next()));
	 * 
	 * bookList.add(book); } System.out.println("bookList loaded from CSV file");
	 * return bookList; } finally { readBooks.close(); } }
	 * 
	 * // reads initial BookAuthor data from CSV file and returns a List of
	 * BookAuthors public static List<BookAuthor> getBookAuthors() throws
	 * IOException { List<BookAuthor> bookAuthorList = new ArrayList<BookAuthor>();
	 * ReadCSV readBookAuthors = new ReadCSV("book_authors.csv"); try { while (true)
	 * { List<String> tuple = readBookAuthors.next(); if (tuple == null) { break; }
	 * Iterator<String> i = tuple.iterator(); BookAuthor bookAuthor = new
	 * BookAuthor(); bookAuthor.setBookId(Integer.parseInt(i.next()));
	 * bookAuthor.setAuthorId(Integer.parseInt(i.next()));
	 * bookAuthorList.add(bookAuthor); }
	 * System.out.println("bookAuthorList loaded from CSV file"); return
	 * bookAuthorList; } finally { readBookAuthors.close(); } }
	 */
}