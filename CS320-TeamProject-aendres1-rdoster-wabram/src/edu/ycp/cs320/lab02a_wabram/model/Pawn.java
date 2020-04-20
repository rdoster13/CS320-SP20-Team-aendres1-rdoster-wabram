package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Pawn extends Piece {

  /*
	 * Methods need added: verifyPromo(): boolean promo(): obj (promote into another
	 * piece)
	 */

	public Pawn(PieceType type, Point position, int color) {
		super(type, position, color);
	}
	
	// TODO: implement after fixing board
	
	/*public boolean verifyPromo(int row, int color) {
		if (row == 7 && color == 0) {
			return true;
		} else if (row == 0 && color == 1) {
			return true;
		} else {
			return false;
		}
	}
	*/

	// needs to return the appropriate piece selected by user
	/*
	 * public Piece promo(Piece piece) {
	 * //set the pawn to whatever piece is requested, then return it
	 * piece.setPieceType(piece);
	 * return piece.getPiece();
	}
	*/
}
