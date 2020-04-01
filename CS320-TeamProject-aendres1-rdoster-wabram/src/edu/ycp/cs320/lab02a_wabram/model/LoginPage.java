package edu.ycp.cs320.lab02a_wabram.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//****Used Prof Hake example****
public class LoginPage {
	
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	private Map<String, String> creds;
	
	// create model - test version 
	public LoginPage() {
		usernames = new ArrayList<String>();
		passwords = new ArrayList<String>();
		creds = new TreeMap<String, String>();
		
		usernames.add("Bill");
		usernames.add("Rob");
		usernames.add("Alina");
		
		passwords.add("Bill");
		passwords.add("Rob");
		passwords.add("Alina");
		
		for (int i = 0; i < usernames.size(); i++) {
			creds.put(usernames.get(i), passwords.get(i));
		}
	}		
	
	// login name - test version  *** got from Prof Hake***
		public boolean validUsername(String username) {
			return creds.containsKey(username);
		}
	
	public boolean validCreds(String username, String password) {
		if (creds.containsKey(username)) {
			if  (creds.get(username).equals(password)) {
				return true;
			}
		}			
		return false;
	}
}
