package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	private int color;
	private User user;
	private Player p1;
	
	@Before
	public void SetUp() {
		user = new User();
		p1 = new Player(user, color);
		color = 0;
	}
	
	@Test
	public void setColor() {
		p1.setColor(color);
		assertTrue(p1.getColor() == 0);
	}
}
