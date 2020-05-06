package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Rook extends Piece {

	public Rook(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point destination, Board board) {
		// Check that the destination is not the same as the starting space
		if (position.x == destination.x && position.y == destination.y) {
			return false;
		}

		// check if piece is off board after extending ( >7 in either X or Y)
		if (destination.x > 7 || destination.x < 0 || destination.y > 7 || destination.y < 0) {
			return false;
		}

		// check that the move is not diagonal. if it is, return false
		if (position.y != destination.y && position.x != destination.x) {
			return false;
		}

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		if (board.getPosition(destination.x, destination.y).getPiece() != null) {
			if (board.getPosition(destination.x, destination.y).getPiece().getColor() == board.getPosition(position.x, position.y)
					.getPiece().getColor()) {
				return false;
			}
		}

		// Check each of the directions using the loops
		// the rook can move any number of spaces (as long as it is not blocked)
		// Check Left
		if (position.x > destination.x) {
			for (int i = destination.x + 1; i < position.x; i++) {
				if (board.getPosition(i, destination.y).getPiece() != null) {
					return false;
				}
			}
		}

		// Check Right
		if (position.x < destination.x) {
			for (int i = position.x + 1; i < destination.x; i++) {
				if (board.getPosition(i, destination.y).getPiece() != null) {
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

		// Check Down
		if (position.y < destination.y) {
			for (int i = position.y + 1; i < destination.y; i++) {
				if (board.getPosition(destination.x, i).getPiece() != null) {
					return false;
				}
			}
		}

		return true;
	}

}
