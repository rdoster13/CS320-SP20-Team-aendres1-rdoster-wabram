package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public abstract class Piece {
	protected PieceType type;
	
	// 0 for white and 1 for black
	protected int color;
	protected Point position;
	private int movesMade;
	private int typeInt;
	private int x;
	private int y;
	private int piece_id;
	
	
	public Piece(PieceType type, Point point, int color) {
		this.type = type;
		this.position = point;
		this.color = color;
	}
	
	public int getPiece_ID() {
		return piece_id;
	}
	
	public void setPiece_ID(int piece_id) {
		this.piece_id=piece_id;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x=x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	public int getType() {
        return typeInt;
    }

    public void setType(int typeInt) {
        this.typeInt = type.getPieceType();
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
	
	public int getMovesMade() {
		return movesMade;
	}
	
	public void setMovesMade(int movesMade) {
		this.movesMade= movesMade;
	}
	
	// each piece checks its own moves
	public abstract boolean checkMove(Point point, Board board);
		
}
	
	



