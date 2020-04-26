package edu.ycp.cs320.lab02a_wabram.model;

public enum PieceType {

	/* Listing all of the pieces on the board. will set the EMPTY_SPACES as null empty spaces 
	 * as null to make it easier to check for blank space. 
	 */
	
	//EMPTY_SPACE(null),
	
	PAWN(0),

	ROOK(1),

	KNIGHT(2),

	BISHOP(3),

	QUEEN(4),

	KING(5);
	
	private int type;

	private PieceType(int type) {
		this.type = type;
	}
	public void setPieceType( int type) {
		this.type=type;
	}
	public int getPieceType() {
		return this.type;
	}
			
}
