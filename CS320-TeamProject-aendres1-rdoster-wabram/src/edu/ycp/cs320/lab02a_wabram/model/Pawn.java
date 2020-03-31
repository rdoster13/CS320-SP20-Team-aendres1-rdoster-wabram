package edu.ycp.cs320.lab02a_wabram.model;

public class Pawn extends Piece {

	/*
	 * Methods need added: verifyPromo(): boolean promo(): obj (promote into another
	 * piece)
	 */

	public boolean verifyPromo(int row, boolean color) {
		if (row == 7 && color == false) {
			return true;
		} else if (row == 0 && color == true) {
			return true;
		} else {
			return false;
		}
	}

	// needs to return the appropriate piece selected by user
	public Piece promo(Piece piece) {

		// set the pawn to whatever piece is requested, then return it
		piece.setPiece(piece);
		return piece.getPiece();
	}
}
