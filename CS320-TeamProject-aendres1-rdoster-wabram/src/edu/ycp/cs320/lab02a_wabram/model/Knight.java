package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Knight extends Piece {

	public Knight(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point destination, Board board) {

		// make sure the space is either empty OR
		// is not occupied by the same color piece.
		if (board.getPosition(destination.x, destination.y).getPiece() != null) {
			if (board.getPosition(destination.x, destination.y).getPiece().getColor() == board.getPosition(position.x, position.y)
					.getPiece().getColor()) {
				return false;
			}
		}

		// check if piece is off board after extending ( >7 in either X or Y)
		if (destination.x > 7 || destination.x < 0 || destination.y > 7 || destination.y < 0) {
			return false;
		}

		// Right 1, Up 2
		if (destination.x == position.x + 1 && destination.y == position.y + 2) {
			return true;
		}

		// Right 1, Down 2
		if (destination.x == position.x + 1 && destination.y == position.y - 2) {
			return true;
		}

		// Right 2, Up 1
		if (destination.x == position.x + 2 && destination.y == position.y + 1) {
			return true;
		}

		// Right 2, Down 1
		if (destination.x == position.x + 2 && destination.y == position.y - 1) {
			return true;
		}

		// Left 1, Up 2
		if (destination.x == position.x - 1 && destination.y == position.y + 2) {
			return true;
		}

		// Left 1, Down 2
		if (destination.x == position.x - 1 && destination.y == position.y - 2) {
			return true;
		}

		// Left 2, Up 1
		if (destination.x == position.x - 2 && destination.y == position.y + 1) {
			return true;
		}

		// Left 2, Down 1
		if (destination.x == position.x - 2 && destination.y == position.y - 1) {
			return true;
		}

		return false;
	}

}
