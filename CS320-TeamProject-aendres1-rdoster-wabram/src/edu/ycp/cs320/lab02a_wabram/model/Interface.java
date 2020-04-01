package edu.ycp.cs320.lab02a_wabram.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import edu.ycp.cs320.lab02a_wabram.model.Bishop;
import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.King;
import edu.ycp.cs320.lab02a_wabram.model.Knight;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;
import edu.ycp.cs320.lab02a_wabram.model.Piece;
import edu.ycp.cs320.lab02a_wabram.model.Position;
import edu.ycp.cs320.lab02a_wabram.model.Queen;
import edu.ycp.cs320.lab02a_wabram.model.Rook;

public class Interface {

	final static int boardHeight = 500;

	final static int WIDTH = 1000;
	final static int HEIGHT = 1000;

	public void implementInterface(Board board, User user, Game game) throws Exception {
		BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufferedImage.getGraphics();

		// Top box: username
		g.setColor(Color.BLUE);
		g.drawString("Username" + user.getUsername(), 10, 10);

		// Draw board
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						g.setColor(Color.WHITE);
					} else {
						g.setColor(Color.BLACK);
					}
				} else {
					if (j % 2 == 0) {
						g.setColor(Color.BLACK);
					} else {
						g.setColor(Color.WHITE);
					}
				}

				g.drawRect(i + 100, j + 100, boardHeight / 8, boardHeight / 8);

				if (board.getPosition(j, i).hasPiece()) {
					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.BISHOP) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. Bishop", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. Bishop", i + 102, j + 102);
						}
					}

					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.KING) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. King", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. King", i + 102, j + 102);
						}
					}

					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.KNIGHT) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. Knight", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. Knight", i + 102, j + 102);
						}
					}

					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.PAWN) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. Pawn", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. Pawn", i + 102, j + 102);
						}
					}

					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.QUEEN) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. Queen", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. Queen", i + 102, j + 102);
						}
					}

					if (board.getPosition(j, i).getPiece().getPieceType() == PieceType.ROOK) {
						if (board.getPosition(j, i).getPiece().isWhite()) {
							g.setColor(Color.RED);
							g.drawString("W. Rook", i + 102, j + 102);
						} else {
							g.setColor(Color.RED);
							g.drawString("Bl. Rook", i + 102, j + 102);
						}
					}
				}
			}

		}

		g.dispose();

	}
}