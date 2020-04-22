package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.King;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;

public class KingTest {

	private Board board = new Board();

	private King testKing;

	@Before
	public void setUp() {
		testKing = new King(PieceType.KING, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new King(PieceType.KING, new Point(2, 7), 0));
		board.setPiece(new King(PieceType.KING, new Point(3, 4), 1));
	}

	@Test
	public void TestGetPieceType() {
		assertEquals(testKing.getPieceType(), PieceType.KING);
	}

	@Test
	public void TestGetColor() {
		assertEquals(testKing.getColor(), 0);
	}

	@Test
	public void TestGetLocation() {
		assertEquals(testKing.getPosition(), new Point(4, 0));
	}

	@Test
	public void TestCheckMove() {
		// Check the diagonal movements 1 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 6), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 6), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(4, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(2, 5), board));

		// Check lateral movements
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 7), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 3), board));

		// Check 1 space diagonal move with Piece in the way for Black
		board.setPiece(new King(PieceType.KING, new Point(3, 6), 0));
		board.setPiece(new King(PieceType.KING, new Point(1, 6), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 6), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 6), board));

		// remove the pieces
		board.getPosition(3, 6).setPiece(null);
		board.getPosition(1, 6).setPiece(null);

		// Check 1 space diagonal move with Piece in the way for White
		board.setPiece(new King(PieceType.KING, new Point(4, 5), 1));
		board.setPiece(new King(PieceType.KING, new Point(2, 5), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 5), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 5), board));

		// remove the pieces
		board.getPosition(4, 5).setPiece(null);
		board.getPosition(2, 5).setPiece(null);

		// Check 1 lateral space move with Piece in the way for Black
		board.setPiece(new King(PieceType.KING, new Point(3, 7), 0));
		board.setPiece(new King(PieceType.KING, new Point(1, 7), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 7), board));

		// remove the pieces
		board.getPosition(3, 7).setPiece(null);
		board.getPosition(1, 7).setPiece(null);

		// Check 1 lateral space move with Piece in the way for White
		board.setPiece(new King(PieceType.KING, new Point(4, 4), 1));
		board.setPiece(new King(PieceType.KING, new Point(2, 4), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 4), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 4), board));

		// remove the pieces
		board.getPosition(4, 4).setPiece(null);
		board.getPosition(2, 4).setPiece(null);
	}
}
