package edu.ycp.cs320.lab02a_wabram.model;

public class King extends Piece {
	/* validateCheck(): boolean
	 * validateCheckMate(): boolean 
	 * verifyCastle(): boolean
	 */
	
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
}
