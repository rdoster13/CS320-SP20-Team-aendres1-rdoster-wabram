package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class KingTest {

	private Board board = new Board();

	private King testKing;
	
	@Before
	public void setUp() {
		testKing = new King(PieceType.KING, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new King(PieceType.KING, new Point(3, 6), 0));
		board.setPiece(new King(PieceType.KING, new Point(3, 1), 1));
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

}
