package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Queen extends Piece {

	public Queen(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point destination, Board board) {

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		// the Queen can move any number of spaces (as long as it is not blocked)
		if (board.getPosition(destination.x, destination.y).getPiece() != null) {
			if (board.getPosition(destination.x, destination.y).getPiece().getColor() == color) {
				return false;
			}
		}

		// check if piece is off board after extending ( >7 in either X or Y)
		if (destination.x > 7 || destination.x < 0 || destination.y > 7 || destination.y < 0) {
			return false;
		}

		// Check Lateral Movement
		if (position.y == destination.y) {

			// Check Right
			if (position.x < destination.x) {
				for (int i = position.x + 1; i < destination.x; i++) {
					if (board.getPosition(i, destination.y).getPiece() != null) {
						return false;
					}
				}
			}

			// Check Left
			if (position.x > destination.x) {
				for (int i = destination.x + 1; i < position.x; i++) {
					if (board.getPosition(i, destination.y).getPiece() != null) {
						return false;
					}
				}
			}
			return true;

			// Check Vertical Movement
		} else if (position.x == destination.x) {

			// Check Down
			if (position.y < destination.y) {
				for (int i = position.y + 1; i < destination.y; i++) {
					if (board.getPosition(destination.x, i).getPiece() != null) {
						return false;
					}
				}
			}

			// Check Up
			if (position.y > destination.y) {
				for (int i = destination.y + 1; i < position.y; i++) {
					if (board.getPosition(destination.x, i).getPiece() != null) {
						return false;
					}
				}
			}
			return true;
		}

		// Check Diagonal Moves
		// the Queen can move any number of spaces (as long as it is not blocked)
		if (Math.abs(position.x - destination.x) != Math.abs(position.y - destination.y)) {
			return false;
		}

		for (int i = 1; i < Math.abs(position.x - destination.x); i++) {

			// check going down and to the left
			if (position.x < destination.x && position.y > destination.y) {
				if (board.getPosition(position.x + i, position.y - i).getPiece() != null) { // down, left
					return false;
				}
			}

			// check going down and to the right
			if (position.x < destination.x && position.y < destination.y) {
				if (board.getPosition(position.x + i, position.y + i).getPiece() != null) { // down, right
					return false;
				}
			}

			// check going up and to the left
			if (position.x > destination.x && position.y > destination.y) {
				if (board.getPosition(position.x - i, position.y - i).getPiece() != null) { // up, left
					return false;
				}
			}

			// check going up and to the right
			if (position.x > destination.x && position.y < destination.y) {
				if (board.getPosition(position.x - i, position.y + i).getPiece() != null) { // up, right
					return false;
				}
			}
		}
		return true;
	}

}
