package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.List;

public class Piece {
    private Piece piece; 
    private boolean color;
    private int[][] location;
    
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

	public boolean isWhite() {
		return color;
	}

	public void setWhite(boolean color) {
		this.color = color;
	}

	public int[][] getLocation() {
		return location;
	}

	public void setLocation(int[][] location) {
		this.location = location;
	}

	public boolean validateMove() {
		return false;
	} 
	
	// Have to store the find moves as ArrayList of pairs of ints?
	public List findMoves() {
		return null;
	}
	
	// Same return type as position: [][]
	public Position updatePosition() {
		return null;
	}
}
