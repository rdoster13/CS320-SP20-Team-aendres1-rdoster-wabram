package edu.ycp.cs320.lab02a_wabram.controller;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.controller.LoginPageController;
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;


public class LoginPageControllerTest {
	
	private LoginPage model;
	private LoginPageController controller;

	@Before
	public void setUp() {
		
		model = new LoginPage();
		controller = new LoginPageController(model);		
	}
	/*
	@Test
	//public void testMultiply() {
	public void checkUsername() {
		assertTrue(controller.checkUserName("Bill"));
		assertTrue(controller.checkUserName("Rob"));
		assertFalse(controller.checkUserName("Flamingo"));
	}
	*/
	@Test
	public void checkValidCreds() throws SQLException {
		assertTrue(controller.validCreds("wabram", "wabram"));
		assertTrue(controller.validCreds("rdoster", "rdoster"));
		assertFalse(controller.validCreds("Alina", "Alina")); 
		assertFalse(controller.validCreds("Flamingo", "ProfHakeIsA"));
	}
	
}
