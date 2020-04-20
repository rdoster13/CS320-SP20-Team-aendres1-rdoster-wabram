package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Position;

public class PositionTest {
	private Position model;
	private Piece pawn;
	private Piece bishop;
	
	@Before
	public void SetUp() {
		pawn = new Pawn(PieceType.KING, new Point(5, 0), 0);
		bishop = new Queen(PieceType.QUEEN, new Point (5,1), 1);
		model = new Position(pawn, bishop.getPosition());
	}
	
	@Test
	public void testSetPiece() {
		model.setPiece(pawn);
		assertEquals(pawn, model.getPiece());
	}
	
	@Test
	public void testSetLocation() {
		model.setPosition(pawn.getPosition());
		assertEquals(new Point(4,0), model.getPostition());
	}

}
