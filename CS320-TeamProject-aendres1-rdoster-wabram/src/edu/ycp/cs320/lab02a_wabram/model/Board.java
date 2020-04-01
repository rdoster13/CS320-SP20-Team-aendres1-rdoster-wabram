package edu.ycp.cs320.lab02a_wabram.model;

public class Board {
	Position[][] squares;

	public Position getPosition(int col, int row) throws Exception {

		// make sure the input location is in the bounds of the board
		if (col < 0 || col > 7 || row < 0 || row > 7) {
			throw new Exception("Index out of bound");
		}
		return squares[col][row];
	}

	public void setPosition(int col, int row, Piece piece) {
		this.squares[col][row] = squares[col][row];

	}

	public void initBoard() {
		// initialize white pieces
		squares[0][0] = new Position(0, 0, new Rook());
		squares[0][7] = new Position(0, 7, new Rook());
		squares[0][1] = new Position(0, 1, new Knight());
		squares[0][6] = new Position(0, 6, new Knight());
		squares[0][2] = new Position(0, 2, new Bishop());
		squares[0][5] = new Position(0, 5, new Bishop());
		squares[0][3] = new Position(0, 3, new Queen());
		squares[0][4] = new Position(0, 4, new King());

		// initialize white pawns
		squares[1][0] = new Position(1, 0, new Pawn());
		squares[1][1] = new Position(1, 1, new Pawn());
		squares[1][2] = new Position(1, 2, new Pawn());
		squares[1][3] = new Position(1, 3, new Pawn());
		squares[1][4] = new Position(1, 4, new Pawn());
		squares[1][5] = new Position(1, 5, new Pawn());
		squares[1][6] = new Position(1, 6, new Pawn());
		squares[1][7] = new Position(1, 7, new Pawn());

		// initialize black pieces
		squares[7][0] = new Position(7, 0, new Rook());
		squares[7][7] = new Position(7, 7, new Rook());
		squares[7][1] = new Position(7, 1, new Knight());
		squares[7][6] = new Position(7, 6, new Knight());
		squares[7][2] = new Position(7, 2, new Bishop());
		squares[7][5] = new Position(7, 5, new Bishop());
		squares[7][3] = new Position(7, 3, new Queen());
		squares[7][4] = new Position(7, 4, new King());

		// initialize black pawns
		squares[6][0] = new Position(6, 0, new Pawn());
		squares[6][1] = new Position(6, 1, new Pawn());
		squares[6][2] = new Position(6, 2, new Pawn());
		squares[6][3] = new Position(6, 3, new Pawn());
		squares[6][4] = new Position(6, 4, new Pawn());
		squares[6][5] = new Position(6, 5, new Pawn());
		squares[6][6] = new Position(6, 6, new Pawn());
		squares[6][7] = new Position(6, 7, new Pawn());

		// initialize empty squares
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				squares[i][j] = new Position(i, j, null);
			}
		}
	}
	
	

}
