package edu.ycp.cs320.lab02a_wabram.model;

public class Position { 
    private int col; 
    private int row; 
    private Piece piece;
  
    public Position(int col, int row, Piece piece) {  
        this.setCol(col); 
        this.setRow(row); 
    } 
  
    public int getCol() { 
        return this.col; 
    } 
  
    public void setCol(int col) { 
        this.col = col; 
    } 
  
    public int getRow() 
    { 
        return this.row; 
    } 
  
    public void setRow(int row) 
    { 
        this.row = row; 
    }

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	} 
} 