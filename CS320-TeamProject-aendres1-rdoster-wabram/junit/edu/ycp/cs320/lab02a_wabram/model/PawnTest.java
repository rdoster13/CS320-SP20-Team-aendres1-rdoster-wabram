package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;

public class PawnTest {
	private Board board = new Board();

	private Pawn testPawn;
	
	@Before
	public void setUp() {
		testPawn = new Pawn(PieceType.PAWN, new Point(4, 0), 0);
		board.newBoard();
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 6), 0));
		board.setPiece(new Pawn(PieceType.PAWN, new Point(3, 1), 1));
	}
	
	@Test
	public void TestGetPieceType() {
		assertEquals(testPawn.getPieceType(), PieceType.PAWN);
	}
	
	@Test
	public void TestGetColor() {
		assertEquals(testPawn.getColor(), 0);
	}
	
	@Test
	public void TestGetLocation() {
		assertEquals(testPawn.getPosition(), new Point(4, 0));
	}

	@Test
	public void testVerifyPromo() {
			
	}

}
