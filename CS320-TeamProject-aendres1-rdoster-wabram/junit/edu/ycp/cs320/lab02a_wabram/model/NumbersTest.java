package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.model.Numbers;

public class NumbersTest {
	private Numbers model;
	
	@Before
	public void setUp() {
		model = new Numbers();
		
	}
	
	@Test
	public void testSetFirst() {
		model.setFirst(1.0);
		assertTrue(1.0==model.getFirst());
	}
	
	@Test
	public void testSetSecond() {
		model.setSecond(5.0);
		assertTrue(5.0==model.getSecond());
	}
	
	@Test
	public void testSetThird() {
		model.setThird(10.0);
		assertTrue(10.0==model.getThird());
	}
	
	@Test
	public void testGetFirst() {
		model.setFirst(15.0);
		assertTrue(15.0==model.getFirst());
	}
	
	@Test
	public void testGetSecond() {
		model.setSecond(50.0);
		assertTrue(50.0==model.getSecond());
	}
	
	@Test
	public void testGetThird() {
		model.setThird(101.0);
		assertTrue(101.0==model.getThird());
	}
	
	@Test
	public void testSetAddResult() {
		model.setThird(10.0);
		model.setFirst(11.0);
		model.setSecond(15.0);
		model.setAddResult();
		assertTrue(36.0==model.getAddResult());
	}
	
	@Test
	public void testSetMultResult() {
		model.setFirst(4.0);
		model.setSecond(6.0);
		model.setMultResult();
		assertTrue(24.0==model.getMultResult());	
	}
	
	@Test
	public void testGetAddResult() {
		model.setThird(1.0);
		model.setFirst(7.0);
		model.setSecond(6.0);
		model.setAddResult();
		assertTrue(14.0==model.getAddResult());
	}
	
	@Test
	public void testGetMultResult() {
		model.setFirst(7.0);
		model.setSecond(3.0);
		model.setMultResult();
		assertTrue(21.0==model.getMultResult());
	}
}
