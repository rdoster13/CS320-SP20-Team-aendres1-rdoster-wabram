package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public abstract class Piece {
	protected PieceType type;
	
	// 0 for white and 1 for black
	protected int color;
	
	protected Point position;

	public Piece(PieceType type, Point point, int i) {
		this.type = type;
		this.position = point;
		this.color = i;
	}

	public PieceType getPieceType() {
		return type;
	}

	public void setPieceType(PieceType type) {
		this.type = type;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	// each piece checks its own moves
	public abstract boolean checkMove(Point point, Board board);


}
