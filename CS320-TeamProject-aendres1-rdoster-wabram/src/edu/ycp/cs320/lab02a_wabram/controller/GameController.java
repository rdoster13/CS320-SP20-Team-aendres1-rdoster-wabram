package edu.ycp.cs320.lab02a_wabram.controller;

import edu.ycp.cs320.booksdb.persist.IDatabase;
import edu.ycp.cs320.lab02a_wabram.model.Game;
import edu.ycp.cs320.lab02a_wabram.model.Position;


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
		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).setPiece(start.getPiece());	 
		model.getBoard().getPosition(end.getPostition().x, end.getPostition().y).getPiece().setPosition(end.getPostition());
		model.getBoard().getPosition(start.getPostition().x, start.getPostition().y).setPiece(null);
	}


	/*public void updatePieceLocation(int startX, int startY, int endX, int endY) {
		IDatabase.updatePieceLocation(startX, startY, endX, endY);
		System.out.println("Piece Location updated in piece table");
	}
	*/

	
	

}