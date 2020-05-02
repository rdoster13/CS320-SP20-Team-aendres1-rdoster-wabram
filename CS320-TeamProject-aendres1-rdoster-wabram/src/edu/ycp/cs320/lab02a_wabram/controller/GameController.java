package edu.ycp.cs320.lab02a_wabram.controller;

import java.awt.Point;
import java.util.List;

import edu.ycp.cs320.booksdb.persist.DatabaseProvider;
import edu.ycp.cs320.booksdb.persist.DerbyDatabase;
import edu.ycp.cs320.booksdb.persist.IDatabase;
import edu.ycp.cs320.lab02a_wabram.model.Bishop;
import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.Game;
import edu.ycp.cs320.lab02a_wabram.model.King;
import edu.ycp.cs320.lab02a_wabram.model.Knight;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;
import edu.ycp.cs320.lab02a_wabram.model.Piece;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;
import edu.ycp.cs320.lab02a_wabram.model.Position;
import edu.ycp.cs320.lab02a_wabram.model.Queen;
import edu.ycp.cs320.lab02a_wabram.model.Rook;


public class GameController {
	private Game model;

	// Set the model
	public GameController(Game model) {
		this.model = model;
	}
	

	public void movePiece(Position start, Position end) {
		/* First, set the piece in the end position to be equal to that start position so we can store  / save the location
		 * then change the actual piece location
		 * finally change the starting position to an empty space
		 */
		int xStart = (int) start.getPostition().getX();
		int yStart = (int) start.getPostition().getY();
		int xEnd = (int) end.getPostition().getX();
		int yEnd = (int) end.getPostition().getY();
		
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		db.updatePieceLocation(xStart, yStart, xEnd, yEnd);
		//db.updateTurn(String username, int thisTurn, int nextTurn);
		
		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).setPiece(start.getPiece());	 
		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).getPiece().setPosition(end.getPostition());
		model.getBoard().getPosition(start.getPostition().x, start.getPostition().y).setPiece(null);
	}


	public void getPieces() {
		// TODO pull pieces from DB
		// set the loop to iterate through the pieces and set the board at each position. 
		/*for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				model.getBoard().newBoard();
			}
		}
		*/
				/*int typeEnum;
				int colX;
				int rowY;
				int color;
				Point position = new Point(colX, rowY);
				*/
				/*PieceType type = null;
				Pawn piece;
				*/
				DatabaseProvider.setInstance(new DerbyDatabase());
				IDatabase db = DatabaseProvider.getInstance();
				List<Piece> pieceList = db.loadPieces();
				for (Piece piece : pieceList) {
					/*int typeEnum = piece.getType();
					int colX = piece.getX();
					int rowY = piece.getY();
					int color = piece.getColor();
					PieceType type;
					Point position = new Position;
					if (typeEnum == 0) {
						type = PieceType.PAWN;
						piece= new Pawn(type, position , color);
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
					*/
					System.out.println("\nPiece Type:" + piece.getType() + "\nPiece Position:" + piece.getPosition() + "\nPiece Color:" + piece.getColor());
					model.getBoard().getPosition(piece.getX(), piece.getY()).setPiece(piece);	 
					Position[][] space = new Position[piece.getX()][piece.getY()];
					model.getBoard().setBoard(space);
				}
				
				// set each piece location. if location not in DB, then set to null
				// col = x
				// row = y
				// return results as an arrayList of tuple and iterate through results, setting type, color and location (x, y)
				// set the pieces on the board
	}


	/*public void updatePieceLocation(int startX, int startY, int endX, int endY) {
		IDatabase.updatePieceLocation(startX, startY, endX, endY);
		System.out.println("Piece Location updated in piece table");
	}
	*/

	
	

}