package edu.ycp.cs320.lab02a_wabram.model;

public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private String accountType;
	private int wins;
	private int losses;
	private int draws;
	private int gameturn;
	
	public int getgameTurn() {
		return gameturn;
	}
	public void setgameTurn(Integer gameturn) {
		this.gameturn=gameturn;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId= userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public void setDraws(int draws) {
		this.draws = draws;
	}
	
	public void changePW() {
		
	}
	
	public void promoteUser() {
		
	}
	
	public void login() {
		
	}
	
	public void logout() {
		
	}
	
	public boolean verfiyCreds(String username, String password) {
		return false;
	}
	
	public void startGame() {
		
	}
	
	public void resumeGame() {
		
	}
}
