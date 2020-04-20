package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class RookTest {

	private Board board = new Board();

	private Rook testRook;
	
	@Before
	public void setUp() {
		testRook = new Rook(PieceType.ROOK, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 6), 0));
		board.setPiece(new Rook(PieceType.ROOK, new Point(3, 1), 1));
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
		assertEquals(testRook.getPosition(), new Point(4, 0));
	}

}
