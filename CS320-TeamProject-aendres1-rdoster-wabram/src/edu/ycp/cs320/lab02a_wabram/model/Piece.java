package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.List;

public class Piece {
    private Piece piece; 
    private PieceType type;
    private boolean color;
    private int[][] position;
    
	/* attributes:
	 * piece type: string
	 * player color: bool
	 * piece location: in (row, column)
	 * 	 * 
	 * methods:
	 * validateMove(): bool
	 * findMoves(): obj (int, int)
	 * updatePosition: (int, int)
	 */
	public Piece getPiece() 
    { 
        return this.piece; 
    } 
  
    public void setPiece(Piece p) 
    { 
        this.piece = p; 
    }
    
    public PieceType getPieceType() {
    	return type;
    }

	public boolean isWhite() {
		if (color == false) {
			return true;
		} else {
			return false;
		}
	}

	public void setWhite(boolean color) {
		this.color = color;
	}

	public int[][] getPosition() {
		return position;
	}

	public void setPosition(int[][] position) {
		this.position = position;
	}

}
