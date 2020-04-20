package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Board;;

public class BoardTest {
	private Board model;
	Position[][] squares;

	@Before
	public void setUp() {
		model = new Board();

	}

	@Test
	public void setPositionTest() throws Exception {
		assertEquals(squares[1][0], model.getPosition(1, 0));
	}

}
