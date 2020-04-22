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
		testKnight = new Knight(PieceType.KNIGHT, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(3, 6), 0));
		board.setPiece(new Knight(PieceType.KNIGHT, new Point(3, 1), 1));
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
		assertEquals(testKnight.getPosition(), new Point(4, 0));
	}

}
