package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Position;

public class PositionTest {
	private Position model;
	private Piece pawn;
	
	@Before
	public void setUp() {
		model = new Position();
	}
	
	@Test
	public void setColTest() {
		model.setCol(0);
		assertEquals(0, model.getCol());
	}
	
	@Test
	public void setRowTest() {
		model.setCol(0);
		assertEquals(0, model.getRow());
	}
	
	@Test
	public void setPiece() {
		model.setPiece(pawn);
		assertEquals(pawn, model.getPiece());
	}

}
