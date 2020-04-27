package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Rook extends Piece {

	public Rook(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	public boolean checkMove(Point point, Board board) {
		// Check that the destination is not the same as the starting space
		if (position.x == point.x && position.y == point.y) {
			return false;
		}

		// check if piece is off board after extending ( >7 in either X or Y)
		if (point.x > 7 || point.x < 0 || point.y > 7 || point.y < 0) {
			return false;
		}

		// check that the move is not diagonal. if it is, return false
		if (position.y != point.y && position.x != point.x) {
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

		// Check each of the directions using the loops
		// the rook can move any number of spaces (as long as it is not blocked)
		// Check Left
		if (position.x > point.x) {
			for (int i = point.x + 1; i < position.x; i++) {
				if (board.getPosition(i, point.y).getPiece() != null) {
					return false;
				}
			}
		}

		// Check Right
		if (position.x < point.x) {
			for (int i = position.x + 1; i < point.x; i++) {
				if (board.getPosition(i, point.y).getPiece() != null) {
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

		// Check Down
		if (position.y < point.y) {
			for (int i = position.y + 1; i < point.y; i++) {
				if (board.getPosition(point.x, i).getPiece() != null) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public boolean checkOppCheck(Point kingSpace, Board board) {
		// TODO Auto-generated method stub
		return false;
	}

}
