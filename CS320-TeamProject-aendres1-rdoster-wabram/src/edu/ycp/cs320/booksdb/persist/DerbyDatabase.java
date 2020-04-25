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
				"jdbc:derby:G:/Shared drives/CS320-Sp20-Team-aendres1-rdoster-wabram/teamDatabase.db;create=true");

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
	
	// TODO: implement update pieces method
	public void updatePiecePositions() {
		
	}

	
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;

				try {
					stmt1 = conn.prepareStatement("create table usercreds (" 
							+ "	usercreds_id integer primary key "
							+ "		generated always as identity (start with 1, increment by 1), "
							+ "	username varchar(40)," 
							+ "	password varchar(40)," 
							+ " gameturn integer" 
							+ ")"
					);
					stmt1.executeUpdate();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
				}
			}
		});
	}
	
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<User> userList;

				try {
					userList = InitialData.getUserCreds();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertUser = null;

				try {
					
					insertUser = conn.prepareStatement("insert into usercreds (username, password, gameturn) values (?, ?, ?)");
					for (User user : userList) {
						
						insertUser.setString(1, user.getUsername());
						insertUser.setString(2, user.getPassword());
						insertUser.setInt(3, user.getgameTurn());
						insertUser.addBatch();
					}
					insertUser.executeBatch();
					
					return true;
				} finally {
					
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
