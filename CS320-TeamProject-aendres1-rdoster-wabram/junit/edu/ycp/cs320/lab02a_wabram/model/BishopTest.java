package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {

	private Board board = new Board();

	private Bishop testBish;

	@Before
	public void setUp() {
		testBish = new Bishop(PieceType.BISHOP, new Point(2, 0), 0);
		board.newBoard();
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(2, 7), 0));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(3, 4), 1));
	}

	@Test
	public void TestGetPieceType() {
		assertEquals(testBish.getPieceType(), PieceType.BISHOP);
	}

	@Test
	public void TestGetColor() {
		// 0 = white, 1 = black
		assertEquals(testBish.getColor(), 0);
	}

	@Test
	public void TestGetLocation() {
		assertEquals(testBish.getPosition(), new Point(2, 0));
	}

	@Test
	public void TestCheckMove() {

		// Check the diagonal movements 1 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 6), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 6), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(4, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(2, 5), board));

		// Check the diagonal movements 2 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(4, 5), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(0, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(5, 6), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(1, 6), board));

		// Check the diagonal movements 3 space in each direction
		assertTrue(board.getPiece(3, 4).checkMove(new Point(6, 1), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(0, 1), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(6, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(0, 7), board));

		// Check 1 space move with Piece in the way for Black
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(3, 6), 0));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(1, 6), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 6), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 6), board));

		// remove the pieces
		board.getPosition(3, 6).setPiece(null);
		board.getPosition(1, 6).setPiece(null);

		// Check 1 space move with Piece in the way for White
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(4, 5), 1));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(2, 5), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 5), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 5), board));

		// remove the pieces
		board.getPosition(4, 5).setPiece(null);
		board.getPosition(2, 5).setPiece(null);

		// Check 2 space move with Piece in the way for Black
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(4, 5), 0));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(0, 5), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(4, 5), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(0, 5), board));

		// remove the pieces
		board.getPosition(4, 5).setPiece(null);
		board.getPosition(0, 5).setPiece(null);

		// Check 2 space move with Piece in the way for White
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(5, 2), 1));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(1, 2), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(5, 2), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(1, 2), board));

		// remove the pieces
		board.getPosition(5, 2).setPiece(null);
		board.getPosition(1, 2).setPiece(null);

		// Check 3 space move with Piece in the way for White
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(6, 1), 1));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(0, 1), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 1), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 1), board));

		// remove the pieces
		board.getPosition(6, 1).setPiece(null);
		board.getPosition(0, 1).setPiece(null);

		// Check 3 space move with Piece in the way for White
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(6, 7), 1));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(0, 7), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 7), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 7), board));

		// remove the pieces
		board.getPosition(6, 7).setPiece(null);
		board.getPosition(0, 7).setPiece(null);

	}

}
