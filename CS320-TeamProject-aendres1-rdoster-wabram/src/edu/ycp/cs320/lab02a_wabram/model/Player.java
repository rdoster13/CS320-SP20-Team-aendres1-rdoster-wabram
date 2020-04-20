package edu.ycp.cs320.lab02a_wabram.model;

public class Player {
	
	//create a color 
	// @param, 0 = white, 1 = black
	private int color;
	private User user;
	private int player;

	

	public Player(User user, int color) {
		this.user = user;
		this.color = color;
	}
	
	public Player(int player) {
		this.player = player;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public User getUser() {
		return user;
	}
	
	public int getPlayer() {
		return player;
	}
	
}
