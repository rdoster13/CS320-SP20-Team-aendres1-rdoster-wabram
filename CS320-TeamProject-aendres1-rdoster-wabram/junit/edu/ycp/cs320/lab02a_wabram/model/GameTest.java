package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	private int turn;
	private Player p1;
	private Player p2;

	@Before
	public void SetUp() {
		game = new Game(p1, p2);
		turn = 0;
	}

	@Test
	public void testSetTurn() {
		game.setTurn(turn);
		assertTrue(game.getTurn() == turn);
	}

}
