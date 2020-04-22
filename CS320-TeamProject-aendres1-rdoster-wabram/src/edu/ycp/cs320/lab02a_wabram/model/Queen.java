package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Queen extends Piece {

	public Queen(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		// the Queen can move any number of spaces (as long as it is not blocked)
		if (board.getPosition(point.x, point.y).getPiece() != null) {
			if (board.getPosition(point.x, point.y).getPiece().getColor() == color) {
				return false;
			}
		}

		// Check Lateral Movement
		if (position.y == point.y) {
			
			// Check Right
			if (position.x < point.x) {
				for (int i = position.x + 1; i < point.x; i++) {
					if (board.getPosition(i, point.y).getPiece() != null) {
						return false;
					}
				}
			}
			
			// Check Left
			if(position.x > point.x) { 
				for(int i = point.x+1; i < position.x; i++) {
					if(board.getPosition(i, point.y).getPiece() != null) {
						return false;
					}
				}
			}
			return true;

		// Check Vertical Movement
		} else if (position.x == point.x) { 
			
			// Check Down
			if (position.y < point.y) {
				for (int i = position.y + 1; i < point.y; i++) {
					if (board.getPosition(point.x, i).getPiece() != null) {
						return false;
					}
				}
			}
			
			// Check Up
			if (position.y > point.y) {
				for (int i = point.y + 1; i < position.y; i++) {
					if (board.getPosition(point.x, i).getPiece() != null) {
						return false;
					}
				}
			}
			return true;
		}
		
		// Check Diagonal Moves
		// the Queen can move any number of spaces (as long as it is not blocked)
		if (Math.abs(position.x - point.x) != Math.abs(position.y - point.y)) {
			return false;
		}

		for (int i = 1; i < Math.abs(position.x - point.x); i++) {
			
			// check going down and to the left
			if (position.x < point.x && position.y > point.y) {
				if (board.getPosition(position.x + i, position.y - i).getPiece() != null) { // down, left
					return false;
				}
			}
			
			// check going down and to the right
			if (position.x < point.x && position.y < point.y) {
				if (board.getPosition(position.x + i, position.y + i).getPiece() != null) { // down, right
					return false;
				}
			}
			
			// check going up and to the left
			if (position.x > point.x && position.y > point.y) {
				if (board.getPosition(position.x - i, position.y - i).getPiece() != null) { // up, left
					return false;
				}
			}
			
			// check going up and to the right
			if (position.x > point.x && position.y < point.y) {
				if (board.getPosition(position.x - i, position.y + i).getPiece() != null) { // up, right
					return false;
				}
			}
		}
		return true;
	}
}
