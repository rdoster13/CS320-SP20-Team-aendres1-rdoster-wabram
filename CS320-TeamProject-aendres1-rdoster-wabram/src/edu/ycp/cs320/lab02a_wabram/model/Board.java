package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Board {
	private Position[][] board;
	private int numBoard;

	public Board() {
	}

	public Board(int numBoard) {
		this.numBoard = numBoard;
	}

	// 2x2 array to generate an empty board.
	// null is empty spaces
	public void newBoard() {
		board = new Position[8][9];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = new Position(null, new Point(i, j));
			}
		}
	}

	// Allows us to update the board when we want / need to
	public void setBoard(Position[][] board) {
		this.board = board;
	}

	public Position getPosition(int x, int y) {
		return this.board[x][y];
	}

	// Returns the value of the piece occupying a specified space.
		public Piece getPiece(int x, int y) {
			return this.board[x][y].getPiece();
		}
		
	/* Every point on the board will have a matching Point coordinate (x,y) to represent the
	 * corresponding piece. 
	 */
	public void setPiece(Piece piece) {
		this.board[piece.getPosition().x][piece.getPosition().y].setPiece(piece);
	}

	

	public void setBoardNumber(int numBoard) {
		this.numBoard = numBoard;
	}

	public int getBoardNumber() {
		return numBoard;
	}

}
