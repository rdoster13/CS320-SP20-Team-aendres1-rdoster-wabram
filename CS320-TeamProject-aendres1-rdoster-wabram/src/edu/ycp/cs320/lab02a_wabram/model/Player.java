package edu.ycp.cs320.lab02a_wabram.model;

public class Player {
	//create a color param, 0 = white, 1 = black
	private Boolean color;
	private static final int WHITE = 0;
	private static final int BLACK = 1;
	

	public Boolean getColor() {
		return color;
	}

	public void setColor(Boolean color) {
		this.color = color;
	}
	
	public int checkColor(Boolean color) {
		if (color == true) {
			return WHITE;
		} else {
			return BLACK;
		}
	}
}
