package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Bishop extends Piece {

	public Bishop(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {

		// Check that the destination is not the same as the starting space
		if (position.x == point.x && position.y == point.y) {
			return false;
		}

		// check that the move is diagonal. if not, return false
		// need to move same number of spaces vertically and horizontally
		if (Math.abs(position.y - point.y) != Math.abs(position.x - point.x)) {
			return false;
		}

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		if (board.getPosition(point.x, point.y).getPiece() != null) {
			if (board.getPosition(point.x, point.y).getPiece().getColor() == board.getPosition(position.x, position.y)
					.getPiece().getColor()) {
				return false;
			}
		}

		// Check each of the directions using the loop because
		// the bishop can move any number of spaces (as long as it is not blocked)
		for (int i = 1; i < Math.abs(position.x - point.x); i++) {

			// check going down and to the left
			if (position.x < point.x && position.y > point.y) {
				if (board.getPosition(position.x + i, position.y - i).getPiece() != null) {
					return false;
				}
			}

			// check going down and to the right
			if (position.x < point.x && position.y < point.y) {
				if (board.getPosition(position.x + i, position.y + i).getPiece() != null) {
					return false;
				}
			}
			
			// check going up and to the left
			if (position.x > point.x && position.y > point.y) {
				if (board.getPosition(position.x - i, position.y - i).getPiece() != null) {
					return false;
				}
			}

			// check going up and to the right
			if (position.x > point.x && position.y < point.y) {
				if (board.getPosition(position.x - i, position.y + i).getPiece() != null) {
					return false;
				}
			}
		}
		return true;
	}

}
