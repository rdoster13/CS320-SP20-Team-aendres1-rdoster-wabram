package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.Rook;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;

public class RookTest {

	private Board board = new Board();

	private Rook testRook;

	@Before
	public void setUp() {
		testRook = new Rook(PieceType.ROOK, new Point(0, 0), 0);
		board.newBoard();
		board.setPiece(new Rook(PieceType.ROOK, new Point(2, 7), 0));
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 4), 1));
	}

	@Test
	public void TestGetPieceType() {
		assertEquals(testRook.getPieceType(), PieceType.ROOK);
	}

	@Test
	public void TestGetColor() {
		assertEquals(testRook.getColor(), 0);
	}

	@Test
	public void TestGetLocation() {
		assertEquals(testRook.getPosition(), new Point(0, 0));
	}

	@Test
	public void TestCheckMove() {
		// Check the movements 1 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 7), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 5), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 3), board));

		// Check the movements 2 space in each direction
		assertTrue(board.getPiece(2, 7).checkMove(new Point(0, 7), board));
		assertTrue(board.getPiece(2, 7).checkMove(new Point(4, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 6), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 2), board));

		// Check the movements 3 space in each direction
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 1), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(3, 7), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(6, 4), board));
		assertTrue(board.getPiece(3, 4).checkMove(new Point(0, 4), board));

		// Check 1 space move with Piece in the way for Black
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 7), 0));
		board.setPiece(new Rook(PieceType.ROOK, new Point(1, 7), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(3, 7), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(1, 7), board));

		// remove the pieces
		board.getPosition(3, 7).setPiece(null);
		board.getPosition(1, 7).setPiece(null);

		// Check 1 space move with Piece in the way for White
		board.setPiece(new Rook(PieceType.ROOK, new Point(4, 4), 1));
		board.setPiece(new Rook(PieceType.ROOK, new Point(2, 4), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 4), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 4), board));

		// remove the pieces
		board.getPosition(4, 4).setPiece(null);
		board.getPosition(2, 4).setPiece(null);

		// Check 2 space move with Piece in the way for Black
		board.setPiece(new Rook(PieceType.ROOK, new Point(4, 7), 0));
		board.setPiece(new Rook(PieceType.ROOK, new Point(0, 7), 0));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(4, 7), board));
		assertFalse(board.getPiece(2, 7).checkMove(new Point(0, 7), board));

		// remove the pieces
		board.getPosition(4, 7).setPiece(null);
		board.getPosition(0, 7).setPiece(null);

		// Check 2 space move with Piece in the way for White
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 2), 1));
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 6), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 2), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 6), board));

		// remove the pieces
		board.getPosition(3, 2).setPiece(null);
		board.getPosition(3, 6).setPiece(null);

		// Check 3 space move with Piece in the way for White
		board.setPiece(new Rook(PieceType.ROOK, new Point(6, 4), 1));
		board.setPiece(new Rook(PieceType.ROOK, new Point(0, 4), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(6, 4), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(0, 4), board));

		// remove the pieces
		board.getPosition(6, 4).setPiece(null);
		board.getPosition(0, 4).setPiece(null);

		// Check 3 space move with Piece in the way for White
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 7), 1));
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 1), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 7), board));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(3, 1), board));

		// remove the pieces
		board.getPosition(3, 7).setPiece(null);
		board.getPosition(3, 1).setPiece(null);
	}
}
