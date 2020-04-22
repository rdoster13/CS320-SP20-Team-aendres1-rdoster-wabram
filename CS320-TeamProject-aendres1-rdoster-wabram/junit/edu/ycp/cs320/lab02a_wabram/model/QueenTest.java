package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class QueenTest {

	private Board board = new Board();

	private Queen testQueen;

	@Before
	public void setUp() {
		testQueen = new Queen(PieceType.QUEEN, new Point(3, 0), 0);
		board.newBoard();
		board.setPiece(new Queen(PieceType.QUEEN, new Point(2, 7), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 4), 1));
	}

	@Test
	public void TestGetPieceType() {
		assertEquals(testQueen.getPieceType(), PieceType.QUEEN);
	}

	@Test
	public void TestGetColor() {
		assertEquals(testQueen.getColor(), 0);
	}

	@Test
	public void TestGetLocation() {
		assertEquals(testQueen.getPosition(), new Point(3, 0));
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

		// Check 1 space diagonal move with Piece in the way for Black
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 6), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(1, 6), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 6), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 6), board));

		// remove the pieces
		board.getPosition(3, 6).setPiece(null);
		board.getPosition(1, 6).setPiece(null);

		// Check 1 space Diagonal move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 5), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(2, 5), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 5), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 5), board));

		// remove the pieces
		board.getPosition(4, 5).setPiece(null);
		board.getPosition(2, 5).setPiece(null);

		// Check 2 space Diagonal move with Piece in the way for Black
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 5), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(0, 5), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(4, 5), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(0, 5), board));

		// remove the pieces
		board.getPosition(4, 5).setPiece(null);
		board.getPosition(0, 5).setPiece(null);

		// Check 2 space Diagonal move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(5, 2), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(1, 2), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(5, 2), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(1, 2), board));

		// remove the pieces
		board.getPosition(5, 2).setPiece(null);
		board.getPosition(1, 2).setPiece(null);

		// Check 3 space Diagonal move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(6, 1), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(0, 1), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 1), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 1), board));

		// remove the pieces
		board.getPosition(6, 1).setPiece(null);
		board.getPosition(0, 1).setPiece(null);

		// Check 3 space Diagonal move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(6, 7), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(0, 7), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 7), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 7), board));

		// remove the pieces
		board.getPosition(6, 7).setPiece(null);
		board.getPosition(0, 7).setPiece(null);

		// Check the lateral movements 1 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 7), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 3), board));

		// Check the lateral movements 2 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(0, 7), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(4, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 6), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 2), board));

		// Check the lateral movements 3 space in each direction
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 1), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(6, 4), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(0, 4), board));

		// Check 1 lateral space move with Piece in the way for Black
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 7), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(1, 7), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 7), board));

		// remove the pieces
		board.getPosition(3, 7).setPiece(null);
		board.getPosition(1, 7).setPiece(null);

		// Check 1 space lateral move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 4), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(2, 4), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 4), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 4), board));

		// remove the pieces
		board.getPosition(4, 4).setPiece(null);
		board.getPosition(2, 4).setPiece(null);

		// Check 2 space lateral move with Piece in the way for Black
		board.setPiece(new Queen(PieceType.QUEEN, new Point(4, 7), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(0, 7), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(4, 7), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(0, 7), board));

		// remove the pieces
		board.getPosition(4, 7).setPiece(null);
		board.getPosition(0, 7).setPiece(null);

		// Check 2 space lateral move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 2), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 6), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 2), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 6), board));

		// remove the pieces
		board.getPosition(3, 2).setPiece(null);
		board.getPosition(3, 6).setPiece(null);

		// Check 3 space lateral move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(6, 4), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(0, 4), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 4), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 4), board));

		// remove the pieces
		board.getPosition(6, 4).setPiece(null);
		board.getPosition(0, 4).setPiece(null);

		// Check 3 space lateral move with Piece in the way for White
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 7), 1));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 1), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 7), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 1), board));

		// remove the pieces
		board.getPosition(3, 7).setPiece(null);
		board.getPosition(3, 1).setPiece(null);
	}
}
