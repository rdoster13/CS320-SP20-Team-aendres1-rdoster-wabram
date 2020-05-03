package edu.ycp.cs320.booksdb.persist;

import java.util.List;

import edu.ycp.cs320.lab02a_wabram.model.Piece;

//from prof hake example
public interface IDatabase {
	//public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title);
	//public List<Pair<Author, Book>> findAuthorAndBookByAuthorLastName(String lastName);
	//public Integer insertBookIntoBooksTable(String title, String isbn, int published, String lastName, String firstName);
	//public List<Pair<Author, Book>> findAllBooksWithAuthors();
	//public List<Author> findAllAuthors();
	//public List<Author> removeBookByTitle(String title);
	
	public boolean dbvalidCreds(String username, String password);
	public void updatePieceLocation(int xStart, int yStart, int xEnd, int yEnd);
	
	// needs corrected
	public void updateTurn(int nextTurn);
	public List<Piece> loadPieces();
	public int loadTurn();
}
