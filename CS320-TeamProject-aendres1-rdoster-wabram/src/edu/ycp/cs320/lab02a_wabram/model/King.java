package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class King extends Piece {
	/*
	 * validateCheck(): boolean validateCheckMate(): boolean verifyCastle(): boolean
	 */

	public King(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	public boolean validateCheck() {
		return false;
	}

	public boolean validateCheckMate() {
		return false;
	}

	public boolean validateCastle() {
		/*
		 * make sure there are no pieces between king and rook, and that neither piece
		 * has moved yet.
		 */
		return false;
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
		// Check that the king can only move one space in either direction. 
		// if either the X or Y coordinate is more that one from the current position, invalid. 
		if (point.x - position.x > 1 || point.y - position.y > 1) {
			return false;
		}
		return true;
	}
}
