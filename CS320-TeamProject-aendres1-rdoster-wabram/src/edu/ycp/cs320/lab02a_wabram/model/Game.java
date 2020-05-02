package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Point;

public class Game {
	private String moves;
	private int turn;
	private int gameNum;
	private Board board;
	private Player player1;
	private Player player2;

	// new game constructor
	public Game(Player player1, Player player2) {
		board = new Board();
		board.newBoard();
		this.player1 = player1;
		this.player2 = player2;
		turn = 0;

		/*
		 * // 0 = white and 1 = black // create pawns for(int i = 0; i < 8; i++) {
		 * board.setPiece(new Pawn(PieceType.PAWN, new Point(i, 6), 0));
		 * board.setPiece(new Pawn(PieceType.PAWN, new Point(i, 1), 1)); }
		 * 
		 * // 0 = white and 1 = black //create Bishop, Knights, Rooks for(int i = 0; i <
		 * 2; i++) { board.setPiece(new Bishop(PieceType.BISHOP, new Point((i*3)+2, 0),
		 * 1)); board.setPiece(new Bishop(PieceType.BISHOP, new Point((i*3)+2, 7), 0));
		 * board.setPiece(new Knight(PieceType.KNIGHT, new Point((i*5)+1, 0), 1));
		 * board.setPiece(new Knight(PieceType.KNIGHT, new Point((i*5)+1, 7), 0));
		 * board.setPiece(new Rook(PieceType.ROOK, new Point((i*7), 0), 1));
		 * board.setPiece(new Rook(PieceType.ROOK, new Point((i*7), 7), 0)); }
		 * 
		 * // 0 = white and 1 = black // Create Queens board.setPiece(new
		 * Queen(PieceType.QUEEN, new Point(4, 0), 1)); board.setPiece(new
		 * Queen(PieceType.QUEEN, new Point(4, 7), 0));
		 * 
		 * // 0 = white and 1 = black // Create Kings board.setPiece(new
		 * King(PieceType.KING, new Point(3, 0), 1)); board.setPiece(new
		 * King(PieceType.KING, new Point(3, 7), 0));
		 */

	}

	public String getMoves() {
		return moves;
	}

	public void setMoves(Piece piece, int col, int row) {
		this.moves = piece + " to " + col + row + ". ";
	}

	public Board getBoard() {
		return board;
	}

	public void setGameNumber(int gameNum) {
		this.gameNum = gameNum;
	}

	public int getGameNumber() {
		return gameNum;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void newGame() {
		// 0 = white and 1 = black
		// create pawns
		for (int i = 0; i < 8; i++) {
			board.setPiece(new Pawn(PieceType.PAWN, new Point(i, 6), 0));
			board.setPiece(new Pawn(PieceType.PAWN, new Point(i, 1), 1));
		}

		// 0 = white and 1 = black
		// create Bishop, Knights, Rooks
		for (int i = 0; i < 2; i++) {
			board.setPiece(new Bishop(PieceType.BISHOP, new Point((i * 3) + 2, 0), 1));
			board.setPiece(new Bishop(PieceType.BISHOP, new Point((i * 3) + 2, 7), 0));
			board.setPiece(new Knight(PieceType.KNIGHT, new Point((i * 5) + 1, 0), 1));
			board.setPiece(new Knight(PieceType.KNIGHT, new Point((i * 5) + 1, 7), 0));
			board.setPiece(new Rook(PieceType.ROOK, new Point((i * 7), 0), 1));
			board.setPiece(new Rook(PieceType.ROOK, new Point((i * 7), 7), 0));
		}

		// 0 = white and 1 = black
		// Create Queens
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 0), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 7), 0));

		// 0 = white and 1 = black
		// Create Kings
		board.setPiece(new King(PieceType.KING, new Point(3, 0), 1));
		board.setPiece(new King(PieceType.KING, new Point(3, 7), 0));
	}
}
