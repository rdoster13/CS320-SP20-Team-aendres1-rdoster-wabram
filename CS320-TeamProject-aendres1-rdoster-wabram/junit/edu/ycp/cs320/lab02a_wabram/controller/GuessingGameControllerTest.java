package edu.ycp.cs320.lab02a_wabram.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.controller.GuessingGameController;
import edu.ycp.cs320.lab02a_wabram.model.GuessingGame;

public class GuessingGameControllerTest {
	private GuessingGame model;
	private GuessingGameController controller;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
		controller = new GuessingGameController();
		
		model.setMin(1);
		model.setMax(100);
		
		controller.setModel(model);
	}
	
	@Test
	public void testStartGame() {
		assertTrue(1==model.getMin());
		assertTrue(100==model.getMax());
	}
	@Test
	public void testGetMin() {
		assertTrue(1==model.getMin());
	}
	
	@Test
	public void testGetMax() {
		assertTrue(100==model.getMax());
	}
	@Test
	public void testNumberIsGreater() {
		int currentGuess = model.getGuess();
		controller.setNumberIsGreaterThanGuess();
		assertTrue(model.getGuess() > currentGuess);
	}
	
	@Test
	public void testIsDone() {
		assertEquals(false, model.isDone());
	}
	
	@Test
	public void testGetGuess() {
		assertTrue(50==model.getGuess());
	}
	
	//having trouble implementing this test revisit
	@Test
	public void testSetIsLessThan() {
		int guess=50;
		model.setIsLessThan(guess);
		assertTrue(49==model.getMax());
	}
	
	@Test
	public void testSetIsGreaterThan() {
		int guess=50;
		model.setIsGreaterThan(guess);
		assertTrue(51==model.getMin());
	}
	
	@Test
	public void testSetNumberFound() {
		int guess=model.getGuess();
		model.setMin(guess);
		model.setMax(guess);
		assertTrue(model.getMin()==model.getMax());
	}
	
	@Test
	public void testSetNumberIsLessThanGuess() {
		{
		int guess=model.getGuess();
		int max=model.getMax();
		int min=model.getMin();
		if(max-min==1) {
			model.setMax(min);
		}
		else {
			model.setIsLessThan(guess);
		}
		assertTrue(49==model.getMax());
		}
		{
		int guess=99;
		model.setMax(100);
		model.setMin(98);
		if(model.getMax()-model.getMin()==1) {
			model.setMax(model.getMin());
		}
		else {
			model.setIsLessThan(guess);
		}
		assertTrue(98==model.getMax());
		}
	}
	
	/*public void testSetNumberIsLessThanGuess() {
		int guess=99;
		int max=100;
		int min=98;
		if(max-min==1) {
			model.setMax(min);
		}
		else {
			model.setIsLessThan(guess);
		}
		assertTrue(49==model.getMax());
	}*/
	
	
	@Test
	public void testSetNumberIsGreaterThanGuess() {
		int guess=model.getGuess();
		model.setIsGreaterThan(guess);
		assertTrue(51==model.getMin());
	}
}
