package edu.ycp.cs320.booksdb.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//import edu.ycp.cs320.booksdb.persist.DerbyDatabase.Transaction;
//import edu.ycp.cs320.booksdb.model.Author;
//import edu.ycp.cs320.booksdb.model.Book;
//import edu.ycp.cs320.booksdb.model.BookAuthor;
//import edu.ycp.cs320.booksdb.model.Pair;
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;
import edu.ycp.cs320.lab02a_wabram.model.User;

//used from Prof Hake library example 
public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	// wrapper SQL transaction function that calls actual transaction function
	// (which has retries)
	public <ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	// SQL transaction function which retries the transaction MAX_ATTEMPTS times
	// before failing
	public <ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL
	// database
	// TODO: Change it here and in SQLDemo.java under
	// CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause
	// conflicts later w/Git
	private static Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:derby:C:/Users/wabra/Desktop/CS320/Round 2/teamDatabase/teamDatabase.db;create=true");

		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}

	public static boolean dbvalidCreds(String username, String password) throws SQLException {
		Connection conn = connect();
		boolean found = false;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = conn.prepareStatement("select usercreds.username, usercreds.password " + "from usercreds "
					+ "where (usercreds.username = ? and usercreds.password = ?) or 1 = 1");//+ "where usercreds.username= ? and usercreds.password= ?");
			stmt.setString(1, username);
			stmt.setString(2, password);

			// List<Pair<Author, Book>> result = new ArrayList<Pair<Author, Book>>();

			resultSet = stmt.executeQuery();
			
			    System.out.println("");
			    
			while(resultSet.next()) {
				found = true;
			}
		} finally {
			DBUtil.closeQuietly(resultSet);
			DBUtil.closeQuietly(stmt);
		}

		
		return found;
	}

	/*
	 * // retrieves Author information from query result set private void
	 * loadAuthor(Author author, ResultSet resultSet, int index) throws SQLException
	 * { author.setAuthorId(resultSet.getInt(index++));
	 * author.setLastname(resultSet.getString(index++));
	 * author.setFirstname(resultSet.getString(index++)); }
	 * 
	 * // retrieves Book information from query result set private void
	 * loadBook(Book book, ResultSet resultSet, int index) throws SQLException {
	 * book.setBookId(resultSet.getInt(index++)); //
	 * book.setAuthorId(resultSet.getInt(index++)); // no longer used
	 * book.setTitle(resultSet.getString(index++));
	 * book.setIsbn(resultSet.getString(index++));
	 * book.setPublished(resultSet.getInt(index++)); }
	 * 
	 * // retrieves WrittenBy information from query result set private void
	 * loadBookAuthors(BookAuthor bookAuthor, ResultSet resultSet, int index) throws
	 * SQLException { bookAuthor.setBookId(resultSet.getInt(index++));
	 * bookAuthor.setAuthorId(resultSet.getInt(index++)); }
	 */

	/*
	 * // creates the Authors and Books tables public void createTables() {
	 * executeTransaction(new Transaction<Boolean>() {
	 * 
	 * @Override public Boolean execute(Connection conn) throws SQLException {
	 * PreparedStatement stmt1 = null; PreparedStatement stmt2 = null;
	 * PreparedStatement stmt3 = null;
	 * 
	 * try { stmt1 = conn.prepareStatement( "create table authors (" +
	 * "	author_id integer primary key " +
	 * "		generated always as identity (start with 1, increment by 1), " +
	 * "	lastname varchar(40)," + "	firstname varchar(40)" + ")" );
	 * stmt1.executeUpdate();
	 * 
	 * System.out.println("Authors table created");
	 * 
	 * stmt2 = conn.prepareStatement( "create table books (" +
	 * "	book_id integer primary key " +
	 * "		generated always as identity (start with 1, increment by 1), " + //
	 * "	author_id integer constraint author_id references authors, " + // this
	 * is now in the BookAuthors table "	title varchar(70)," +
	 * "	isbn varchar(15)," + "   published integer" + ")" );
	 * stmt2.executeUpdate();
	 * 
	 * System.out.println("Books table created");
	 * 
	 * stmt3 = conn.prepareStatement( "create table bookAuthors (" +
	 * "	book_id   integer constraint book_id references books, " +
	 * "	author_id integer constraint author_id references authors " + ")" );
	 * stmt3.executeUpdate();
	 * 
	 * System.out.println("BookAuthors table created");
	 * 
	 * return true; } finally { DBUtil.closeQuietly(stmt1);
	 * DBUtil.closeQuietly(stmt2); } } }); }
	 */

	/*
	 * // loads data retrieved from CSV files into DB tables in batch mode public
	 * void loadInitialData() { executeTransaction(new Transaction<Boolean>() {
	 * 
	 * @Override public Boolean execute(Connection conn) throws SQLException {
	 * List<Author> authorList; List<Book> bookList; List<BookAuthor>
	 * bookAuthorList;
	 * 
	 * try { authorList = InitialData.getAuthors(); bookList =
	 * InitialData.getBooks(); bookAuthorList = InitialData.getBookAuthors(); }
	 * catch (IOException e) { throw new SQLException("Couldn't read initial data",
	 * e); }
	 * 
	 * PreparedStatement insertAuthor = null; PreparedStatement insertBook = null;
	 * PreparedStatement insertBookAuthor = null;
	 * 
	 * try { // must completely populate Authors table before populating BookAuthors
	 * table because of primary keys insertAuthor = conn.
	 * prepareStatement("insert into authors (lastname, firstname) values (?, ?)");
	 * for (Author author : authorList) { // insertAuthor.setInt(1,
	 * author.getAuthorId()); // auto-generated primary key, don't insert this
	 * insertAuthor.setString(1, author.getLastname()); insertAuthor.setString(2,
	 * author.getFirstname()); insertAuthor.addBatch(); }
	 * insertAuthor.executeBatch();
	 * 
	 * System.out.println("Authors table populated");
	 * 
	 * // must completely populate Books table before populating BookAuthors table
	 * because of primary keys insertBook = conn.
	 * prepareStatement("insert into books (title, isbn, published) values (?, ?, ?)"
	 * ); for (Book book : bookList) { // insertBook.setInt(1, book.getBookId()); //
	 * auto-generated primary key, don't insert this // insertBook.setInt(1,
	 * book.getAuthorId()); // this is now in the BookAuthors table
	 * insertBook.setString(1, book.getTitle()); insertBook.setString(2,
	 * book.getIsbn()); insertBook.setInt(3, book.getPublished());
	 * insertBook.addBatch(); } insertBook.executeBatch();
	 * 
	 * System.out.println("Books table populated");
	 * 
	 * // must wait until all Books and all Authors are inserted into tables before
	 * creating BookAuthor table // since this table consists entirely of foreign
	 * keys, with constraints applied insertBookAuthor = conn.
	 * prepareStatement("insert into bookAuthors (book_id, author_id) values (?, ?)"
	 * ); for (BookAuthor bookAuthor : bookAuthorList) { insertBookAuthor.setInt(1,
	 * bookAuthor.getBookId()); insertBookAuthor.setInt(2,
	 * bookAuthor.getAuthorId()); insertBookAuthor.addBatch(); }
	 * insertBookAuthor.executeBatch();
	 * 
	 * System.out.println("BookAuthors table populated");
	 * 
	 * return true; } finally { DBUtil.closeQuietly(insertBook);
	 * DBUtil.closeQuietly(insertAuthor); DBUtil.closeQuietly(insertBookAuthor); } }
	 * }); }
	 */
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				//PreparedStatement stmt2 = null;

				try {
					stmt1 = conn.prepareStatement("create table usercreds (" + "	usercreds_id integer primary key "
							+ "		generated always as identity (start with 1, increment by 1), "
							+ "	username varchar(40)," + "	password varchar(40)" + ")");
					stmt1.executeUpdate();

					/*stmt2 = conn.prepareStatement("create table books (" + "	book_id integer primary key "
							+ "		generated always as identity (start with 1, increment by 1), "
							+ "	author_id integer constraint author_id references authors, " + "	title varchar(70),"
							+ "	isbn varchar(15)," + "   published integer " + ")");
					stmt2.executeUpdate();
					*/
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					//DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;
				//List<Book> bookList;

				try {
					userList = InitialData.getUserCreds();
					//bookList = InitialData.getBooks();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;
				//PreparedStatement insertBook = null;

				try {
					// populate authors table (do authors first, since author_id is foreign key in
					// books table)
					insertUser = conn.prepareStatement("insert into usercreds (username, password) values (?, ?)");
					for (User user : userList) {
						// insertAuthor.setInt(1, author.getAuthorId()); // auto-generated primary key,
						// don't insert this
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.addBatch();
					}
					insertUser.executeBatch();

					// populate books table (do this after authors table,
					// since author_id must exist in authors table before inserting book)
					/*insertBook = conn.prepareStatement(
							"insert into books (author_id, title, isbn, published) values (?, ?, ?, ?)");
					for (Book book : bookList) {
						// insertBook.setInt(1, book.getBookId()); // auto-generated primary key, don't
						// insert this
						insertBook.setInt(1, book.getAuthorId());
						insertBook.setString(2, book.getTitle());
						insertBook.setString(3, book.getIsbn());
						insertBook.setInt(4, book.getPublished());
						insertBook.addBatch();
					}
					insertBook.executeBatch();
					*/
					return true;
				} finally {
					//DBUtil.closeQuietly(insertBook);
					DBUtil.closeQuietly(insertUser);
				}
			}
		});
	}
	
	
	  // The main method creates the database tables and loads the initial data.
	 public static void main(String[] args) throws IOException {
	 System.out.println("Creating tables..."); DerbyDatabase db = new
	 DerbyDatabase(); db.createTables();
	 
	 System.out.println("Loading initial data..."); db.loadInitialData();
	 
	 System.out.println("Library DB successfully initialized!"); }
	 

}
