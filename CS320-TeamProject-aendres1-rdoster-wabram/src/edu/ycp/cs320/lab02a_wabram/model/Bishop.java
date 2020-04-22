package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Bishop extends Piece {

	public Bishop(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
