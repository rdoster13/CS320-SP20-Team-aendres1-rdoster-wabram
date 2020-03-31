package edu.ycp.cs320.lab02a_wabram.controller;

import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.Piece;

public class BoardController {
	private Board model;

	public void initBoardEmpty() {
		model.initBoard();
	}

	public void setModel(Board model) {
		this.model = model;
	}

	public void updateBoard(int col, int row, Piece piece) {
		model.setPosition(col, row, piece);
	}

	public void displayPieceMoves() {

	}

}
