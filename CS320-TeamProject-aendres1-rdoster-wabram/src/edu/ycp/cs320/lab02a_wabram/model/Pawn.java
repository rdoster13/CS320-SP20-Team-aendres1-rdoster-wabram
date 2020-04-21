package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Pawn extends Piece {

	/*
	 * Methods need added: verifyPromo(): boolean promo(): obj (promote into another
	 * piece)
	 */

	public Pawn(PieceType type, Point position, int color) {
		super(type, position, color);
	}

	@Override
	boolean checkMove(Point point, Board board) {
		// Black pieces move down, White pieces move up
		// Black == 1, White == 0
		// Check / validate moves for 1 or 2 spaces
		// Check for taking piece, but only diagonally

		if (color == 1 && 
				// check that the destination position is empty
				// need int Cast as point is a type double
				board.getPosition((int) point.getX(), (int) point.getY()).getPiece() == null
				
				// Check that the x coordinate has not changed, but y has increased by 1
				&& point.getY() == position.getY() + 1 && point.x == position.x) {
			return true;
		} else if (color == 0 
				
				// check that the destination position is empty
				// need int Cast as point is a type double
				&& board.getPosition((int) point.getX(), (int) point.getY()).getPiece() == null
				
				// Check that the x coordinate has not changed, but y has increased by 1
				&& point.getY() == position.getY() - 1 && point.x == position.x) {
			return true;
		} else if (color == 1 && 
				// check that the destination position is empty
				// need int Cast as point is a type double
				board.getPosition((int) point.getX(), (int) point.getY()).getPiece() == null
				
				// Check that the x coordinate has not changed, but y has increased by 2
				// Also make sure it is in the starting position (only time a move of 2Y is allowed
				&& point.getY() == position.getY() + 2 && position.getY() == 1
				
				// Make sure that the space being skipped over is empty as well 
				&& board.getPosition((int) point.getX(), (int) point.getY() - 1).getPiece() == null) {
			return true;
		} else if (color == 0 && 
				// check that the destination position is empty
				// need int Cast as point is a type double
				board.getPosition((int) point.getX(), (int) point.getY()).getPiece() == null
				
				// Check that the x coordinate has not changed, but y has increased by 2
				// Also make sure it is in the starting position (only time a move of 2Y is allowed
				&& point.getY() == position.getY() - 2 && position.getY() == 6
				
				// Make sure that the space being skipped over is empty as well 
				&& board.getPosition((int) point.getX(), (int) point.getY() + 1).getPiece() == null) {
			return true;
		} else if (color == 1 
				
				// Make sure that the position the pawn is going to is diagonally upward 
				// +1 y and +/- 1  x on either side
				&& (point.x == position.x + 1 || point.x == position.x - 1) && point.y == position.y + 1
				
				// make sure there is a piece in the location that the pawn is moving so the piece can be taken.
				&& board.getPosition((int) point.getX(), (int) point.getY()).getPiece() != null) {
			if (board.getPosition(point.x, point.y).getPiece().getColor() != color) {
				return true;
			}
		} else if (color == 0 
				
				// Make sure that the position the pawn is going to is diagonally upward 
				// +1 y and +/- 1  x on either side
				&& (point.x == position.x + 1 || point.x == position.x - 1) && point.y == position.y - 1
				
				// make sure there is a piece in the location that the pawn is moving so the piece can be taken. 
				&& board.getPosition((int) point.getX(), (int) point.getY()).getPiece() != null) {
			if (board.getPosition(point.x, point.y).getPiece().getColor() != color) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	// TODO: implement as stretch goal

	/*
	 * public boolean verifyPromo(int row, int color) { if (row == 7 && color == 0)
	 * { return true; } else if (row == 0 && color == 1) { return true; } else {
	 * return false; } }
	 */

	// needs to return the appropriate piece selected by user
	/*
	 * public Piece promo(Piece piece) { //set the pawn to whatever piece is
	 * requested, then return it piece.setPieceType(piece); return piece.getPiece();
	 * }
	 */
}
