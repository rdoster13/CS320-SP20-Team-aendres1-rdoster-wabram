package edu.ycp.cs320.lab02a_wabram.model;

public class Game {
	private String moves;
	private boolean turn;

	public String getMoves() {
		return moves;
	}

	public void setMoves(Piece piece, int col, int row) {
		this.moves = piece + " to " + col + row + ". ";
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}
}
