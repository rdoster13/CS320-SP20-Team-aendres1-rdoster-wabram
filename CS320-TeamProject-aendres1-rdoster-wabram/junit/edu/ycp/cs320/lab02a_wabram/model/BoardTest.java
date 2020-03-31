package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Board;;

public class BoardTest {
	private Board model;
	Position [][] squares;
	private int col = 1;
	private int row = 1;
	
	
	@Before
	public void setUp() {
		model = new Board();
		
	}
	
	@Test
	public void setPositionTest() throws Exception {
		model.setPosition(1, 1);
		assertEquals(squares[1][1], model.getPosition(col, row));
	}
	
}
