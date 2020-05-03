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
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;

public class GameController {
	private Game model;

	// Set the model
	public GameController(Game model) {
		this.model = model;
	}

	public void movePiece(Position start, Position end) {
		/*
		 * First, set the piece in the end position to be equal to that start position
		 * so we can store / save the location then change the actual piece location
		 * finally change the starting position to an empty space
		 */
		int xStart = (int) start.getPostition().getX();
		int yStart = (int) start.getPostition().getY();
		int xEnd = (int) end.getPostition().getX();
		int yEnd = (int) end.getPostition().getY();

		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		db.updatePieceLocation(xStart, yStart, xEnd, yEnd);
		// db.updateTurn(String username, int thisTurn, int nextTurn);

		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).setPiece(start.getPiece());
		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).getPiece()
				.setPosition(end.getPostition());
		model.getBoard().getPosition(start.getPostition().x, start.getPostition().y).setPiece(null);
		db.updateTurn(db.loadTurn()+1);
	}

	public void getPieces() {
		// TODO pull pieces from DB
		// set the loop to iterate through the pieces and set the board at each
		// position.

		model.getBoard().newBoard();

		/*
		 * int typeEnum; int colX; int rowY; int color; Point position = new Point(colX,
		 * rowY);
		 */
		/*
		 * PieceType type = null; Pawn piece;
		 */
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		List<Piece> pieceList = db.loadPieces();
		for (Piece piece : pieceList) {
			int color = piece.getColor();
			PieceType type = piece.getPieceType();
			
			if (type == PieceType.PAWN) {
				piece = new Pawn(type, piece.getPosition(), color);
			} else if (type == PieceType.ROOK) {
				piece = new Rook(type, piece.getPosition(), color);
			} else if (type == PieceType.KNIGHT) {
				piece = new Knight(type, piece.getPosition(), color);
			} else if (type == PieceType.BISHOP) {
				piece = new Bishop(type, piece.getPosition(), color);
			} else if (type == PieceType.QUEEN) {
				piece = new Queen(type, piece.getPosition(), color);
			} else if (type == PieceType.KING) {
				piece = new King(type, piece.getPosition(), color);
			}

			System.out.println("\nPiece Type:" + piece.getPieceType().toString() + "\nPiece Position:"
					+ piece.getPosition() + "\nPiece Color:" + piece.getColor());

			//Position[][] space = new Position[piece.getX()][piece.getY()];
			//System.out.println("\nI got here!");
			//model.getBoard().setBoard(space);
			//System.out.println("\nI got here too!!!!!");
			model.getBoard().setPiece(piece);
			//System.out.println("\nI have finished the EPIC TREK");
		}

		// set each piece location. if location not in DB, then set to null
		// col = x
		// row = y
		// return results as an arrayList of tuple and iterate through results, setting
		// type, color and location (x, y)
		// set the pieces on the board
	}

	public int getTurn() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		IDatabase db = DatabaseProvider.getInstance();
		
		int turn= db.loadTurn();
		return turn;
	}

}