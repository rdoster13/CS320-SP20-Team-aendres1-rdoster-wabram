package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.lab02a_wabram.model.Pawn;

public class PawnTest {
	private Pawn model;
	
	@Before
	public void setUp() {
		model = new Pawn();
	}

	@Test
	public void testVerifyPromo() {
		model.setLocation(location);;
		model.getLocation();	
	}

}
