package edu.ycp.cs320.lab02a_wabram.controller;

import java.sql.SQLException;

import edu.ycp.cs320.lab02a_wabram.model.LoginPage;

public class LoginPageController {
	private LoginPage model = null;
	
	public LoginPageController(LoginPage model) {
		this.model = model;
	}
	
	/*public boolean checkUserName(String username) {
		return model.validUsername(username);
	}
	*/
	public boolean validCreds(String username, String password) throws SQLException {
		return model.validCreds(username, password);
	}
	
}
