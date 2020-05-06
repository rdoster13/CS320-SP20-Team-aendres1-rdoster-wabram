package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Bishop extends Piece {

	public Bishop(PieceType type, Point position, int color) {
		super(type, position, color);
	}
	
	//TODO: need to add if piece is off board after extending ( >7 in either X or Y)
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

		// check that the move is diagonal. if not, return false
		// need to move same number of spaces vertically and horizontally
		if (Math.abs(position.y - destination.y) != Math.abs(position.x - destination.x)) {
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
		

		// Check each of the directions using the loop because
		// the bishop can move any number of spaces (as long as it is not blocked)
		for (int i = 1; i < Math.abs(position.x - destination.x); i++) {

			// check going down and to the left
			if (position.x < destination.x && position.y > destination.y) {
				if (board.getPosition(position.x + i, position.y - i).getPiece() != null) {
					return false;
				}
			}

			// check going down and to the right
			if (position.x < destination.x && position.y < destination.y) {
				if (board.getPosition(position.x + i, position.y + i).getPiece() != null) {
					return false;
				}
			}
			
			// check going up and to the left
			if (position.x > destination.x && position.y > destination.y) {
				if (board.getPosition(position.x - i, position.y - i).getPiece() != null) {
					return false;
				}
			}

			// check going up and to the right
			if (position.x > destination.x && position.y < destination.y) {
				if (board.getPosition(position.x - i, position.y + i).getPiece() != null) {
					return false;
				}
			}
			
			// checks that it does not expose the king
			// Calls checkOppCheck to make sure your king isn't in check
			// if your king is in check, return false
		}
		return true;
	}

}
