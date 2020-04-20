package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Position {
	private Piece piece;
	private Point position;

	// This will be for the position and the type of the pieces. 
	
	public Position(Piece piece, Point position) {
		this.piece = piece;
		this.position = position;
	}
	

	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece newPiece) {
		this.piece = newPiece;
	}
	
	public Point getPostition() {
		return position;
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
}