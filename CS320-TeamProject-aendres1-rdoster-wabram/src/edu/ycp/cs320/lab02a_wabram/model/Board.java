package edu.ycp.cs320.lab02a_wabram.model;

public class Board { 
    Position [][] squares; 
     
    public Position getPosition(int col, int row) throws Exception { 
    	
    	// make sure the input location is in the bounds of the board
        if (col < 0 || col > 7 || row < 0 || row > 7) { 
            throw new Exception("Index out of bound"); 
        } 
        return squares[col][row]; 
    } 
    
    public void setPosition(int col, int row, Piece piece) {
		  this.squares[col][row] = squares[col][row];
    	
    }
      
} 
