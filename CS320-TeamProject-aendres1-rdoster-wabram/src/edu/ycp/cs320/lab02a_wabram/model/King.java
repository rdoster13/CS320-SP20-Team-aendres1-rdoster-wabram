package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class King extends Piece {
	/* validateCheck(): boolean
	 * validateCheckMate(): boolean 
	 * verifyCastle(): boolean
	 */
	
	public King(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	public boolean validateCheck() {
		return false;
	}
	
	public boolean validateCheckMate() {
		return false;
	}
	
	public boolean validateCastle() {
		/* make sure there are no pieces between king and rook, 
		 * and that neither piece has moved yet. 
		 */
		return false;
	}

	@Override
	public boolean checkMove(Point point, Board board) {
		// TODO Auto-generated method stub
		return false;
	}
}
