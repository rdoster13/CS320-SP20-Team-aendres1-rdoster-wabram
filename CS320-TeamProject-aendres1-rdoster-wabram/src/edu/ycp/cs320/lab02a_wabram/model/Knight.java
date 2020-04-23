package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Knight extends Piece {

	public Knight(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		if (board.getPosition(point.x, point.y).getPiece() != null) {
			if (board.getPosition(point.x, point.y).getPiece().getColor() == board.getPosition(position.x, position.y)
					.getPiece().getColor()) {
				return false;
			}
		}

		// Right 1, Up 2
		if (point.x == position.x + 1 && point.y == position.y + 2) {
			return true;
		}

		// Right 1, Down 2
		if (point.x == position.x + 1 && point.y == position.y - 2) {
			return true;
		}

		// Right 2, Up 1
		if (point.x == position.x + 2 && point.y == position.y + 1) {
			return true;
		}

		// Right 2, Down 1
		if (point.x == position.x + 2 && point.y == position.y - 1) {
			return true;
		}

		// Left 1, Up 2
		if (point.x == position.x - 1 && point.y == position.y + 2) {
			return true;
		}

		// Left 1, Down 2
		if (point.x == position.x - 1 && point.y == position.y - 2) {
			return true;
		}

		// Left 2, Up 1
		if (point.x == position.x - 2 && point.y == position.y + 1) {
			return true;
		}

		// Left 2, Down 1
		if (point.x == position.x - 2 && point.y == position.y - 1) {
			return true;
		}

		return false;
	}

}
