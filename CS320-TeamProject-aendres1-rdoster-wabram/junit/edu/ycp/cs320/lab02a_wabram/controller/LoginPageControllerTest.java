package edu.ycp.cs320.lab02a_wabram.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//import edu.ycp.cs320.lab02a_wabram.controller.NumbersController;
//import edu.ycp.cs320.lab02a_wabram.model.Numbers;
import edu.ycp.cs320.lab02a_wabram.controller.LoginPageController;
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;


public class LoginPageControllerTest {
	//private Numbers model;
	//private NumbersController controller;
	private LoginPage model;
	private LoginPageController controller;

	@Before
	public void setUp() {
		//model = new Numbers();
		//controller = new NumbersController();
		model = new LoginPage();
		controller = new LoginPageController();		
		
		//model.setFirst(1.0);
		//model.setSecond(5.0);
		//model.setThird(10.0);
		//model.setAddResult();
		//model.setMultResult();
		
		model.setUsername("bill");
		model.setPassword("dumbass");
		
		controller.setModel(model);
	}
	
	@Test
	//public void testMultiply() {
	public void testGetUsername() {
		assertTrue("bill"==model.getUsername());
		//assertTrue(1.0==model.getFirst());
		//assertTrue(5.0==model.getSecond());
		//assertTrue(5.0==model.getMultResult());
	}
	
	@Test
	public void testGetPassword() {
		assertTrue("dumbass"==model.getPassword());
	}
	/*@Test
	public void testAdd() {
		assertTrue(1.0==model.getFirst());
		assertTrue(5.0==model.getSecond());
		assertTrue(10.0==model.getThird());
		assertTrue(16.0==model.getAddResult());
	}*/
}
