package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Bishop extends Piece {

	public Bishop(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {
		
		// Check that the destination is not the same as the starting space
		if(position.x == point.x && position.y == point.y) { 
			return false;
		}
		
		// check that the move is diagonal. if not, return false
		// need to move same number of spaces vertically and horizontally
		if(Math.abs(position.y - point.y) != Math.abs(position.x - point.x)) {
			return false;
		}
		
		// make sure the space is either empty OR
		// is not occupied by the same color piece. 
		if(board.getPosition(point.x,  point.y).getPiece() != null) {
			if(board.getPosition(point.x, point.y).getPiece().getColor() == 
					board.getPosition(position.x, position.y).getPiece().getColor()) {
				return false;
			}
		}
		
		for(int i=1; i< Math.abs(position.x - point.x); i++) { 
			if(position.x < point.x
					&& position.y < point.y) { //prevents crash
				if(board.getPosition(position.x+i, position.y+i).getPiece() != null) {
				return false;
				}
			}
			if(position.x < point.x
					&& position.y > point.y) {
				if(board.getPosition(position.x+i, position.y-i).getPiece() != null) { //down, left
				return false;
				}
			}
			if(position.x > point.x
					&& position.y < point.y) {
				if(board.getPosition(position.x-i, position.y+i).getPiece() != null) { //up, right
				return false;
				}
			}
			if(position.x > point.x
					&& position.y > point.y) {
				if(board.getPosition(position.x-i, position.y-i).getPiece() != null) { //up, left
				return false;
				}
			}
		}
		
		
		return true;
	}
	
}
