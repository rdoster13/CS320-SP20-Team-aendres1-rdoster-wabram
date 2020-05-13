package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Board;;

public class BoardTest {
	private Board model;
	private Piece king = null;

	@Before
	public void setUp() {
		model = new Board();
		model.newBoard();

	}

	@Test
	public void testNewBoard() {
		model.newBoard();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {
				// test that each square is null when set
				assertTrue(model.getPiece(i, j) == null);
			}
		}
	}

	@Test
	public void testSetPiece() {
		king = new King(PieceType.KING, (new Point(0, 1)), 0);
		model.setPiece(king);
		assertEquals(king, model.getPiece(0, 1));
	}

}
