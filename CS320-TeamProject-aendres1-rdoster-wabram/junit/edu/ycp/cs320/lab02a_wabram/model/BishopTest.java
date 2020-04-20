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
		testBish = new Bishop(PieceType.BISHOP, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(3, 6), 0));
		board.setPiece(new Bishop(PieceType.BISHOP, new Point(3, 1), 1));
	}
	
	@Test
	public void TestGetPieceType() {
		assertEquals(testBish.getPieceType(), PieceType.BISHOP);
	}
	
	@Test
	public void TestGetColor() {
		assertEquals(testBish.getColor(), 0);
	}
	
	@Test
	public void TestGetLocation() {
		assertEquals(testBish.getPosition(), new Point(4, 0));
	}

}
