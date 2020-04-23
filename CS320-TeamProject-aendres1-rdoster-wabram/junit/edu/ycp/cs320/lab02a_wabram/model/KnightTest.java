package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.model.Board;
import edu.ycp.cs320.lab02a_wabram.model.Knight;
import edu.ycp.cs320.lab02a_wabram.model.PieceType;

public class KnightTest {

	private Board board = new Board();

	private Knight testKnight;

	@Before
	public void setUp() {
		testKnight = new Knight(PieceType.KNIGHT, new Point(1, 0), 0);
		board.newBoard();
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(2, 7), 0));
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(3, 4), 1));
	}

	@Test
	public void TestGetPieceType() {
		assertEquals(testKnight.getPieceType(), PieceType.KNIGHT);
	}

	@Test
	public void TestGetColor() {
		assertEquals(testKnight.getColor(), 0);
	}

	@Test
	public void TestGetLocation() {
		assertEquals(testKnight.getPosition(), new Point(1, 0));
	}

	@Test
	public void TestCheckMoves() {
		// Right 1, Up 2
		assertTrue(board.getPiece(3, 4).checkMove(new Point(2, 6), board));

		// Right 1, Down 2
		assertTrue(board.getPiece(2, 7).checkMove(new Point(3, 5), board));

		// Right 2, Up 1
		assertTrue(board.getPiece(3, 4).checkMove(new Point(5, 5), board));

		// Right 2, Down 1
		assertTrue(board.getPiece(2, 7).checkMove(new Point(4, 6), board));

		// Left 1, Up 2
		assertTrue(board.getPiece(3, 4).checkMove(new Point(2, 6), board));

		// Left 1, Down 2
		assertTrue(board.getPiece(2, 7).checkMove(new Point(1, 5), board));

		// Left 2, Up 1
		assertTrue(board.getPiece(3, 4).checkMove(new Point(1, 5), board));

		// Left 2, Down 1
		assertTrue(board.getPiece(2, 7).checkMove(new Point(0, 6), board));

		// Check Right 1, Up 2 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(4, 6), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 6), board));

		// remove the piece
		board.getPosition(4, 6).setPiece(null);
		
		// Check Right 1, Down 2 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(4, 2), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(4, 2), board));

		// remove the piece
		board.getPosition(4, 2).setPiece(null);
		
		// Check Right 2, Up 1 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(5, 5), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(5, 5), board));

		// remove the piece
		board.getPosition(5, 5).setPiece(null);
		
		// Check Right 2, Down 1 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(5, 3), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(5, 3), board));

		// remove the piece
		board.getPosition(5, 3).setPiece(null);
		
		// Check Left 1, Up 2 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(2, 6), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 6), board));

		// remove the piece
		board.getPosition(2, 6).setPiece(null);
		
		// Check Left 1, Down 2 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(2, 2), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(2, 2), board));

		// remove the piece
		board.getPosition(2, 2).setPiece(null);
		
		// Check Left 2, Up 1 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(1, 5), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(1, 5), board));

		// remove the piece
		board.getPosition(1, 5).setPiece(null);
		
		// Check Left 2, Down 1 w/ piece in way
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(1, 2), 1));
		assertFalse(board.getPiece(3, 4).checkMove(new Point(1, 2), board));

		// remove the piece
		board.getPosition(1, 2).setPiece(null);
		

	}

}
