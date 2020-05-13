package edu.ycp.cs320.lab02a_wabram.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.lab02a_wabram.controller.LoginPageController;

public class UserTest {
	
	private User user;
	private String username;
	private String password;

	@Before
	public void setUp() {
		
		user= new User();
		user.setUsername("wabram");
		user.setPassword("wabram");
		
	}
	
	@Test
	public void userTest() {	
		assertTrue(user.getUsername()== "wabram");
		assertTrue(user.getPassword()== "wabram");
		assertFalse(user.getUsername()== "flamingo"); 
		assertFalse(user.getPassword()== "flamingo");
	}

}
