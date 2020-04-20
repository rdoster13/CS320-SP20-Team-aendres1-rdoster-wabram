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
		testQueen = new Queen(PieceType.QUEEN, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 6), 0));
		board.setPiece(new Queen(PieceType.QUEEN, new Point(3, 1), 1));
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
		assertEquals(testQueen.getPosition(), new Point(4, 0));
	}

}
