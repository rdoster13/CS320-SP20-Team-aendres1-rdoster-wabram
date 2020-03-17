package edu.ycp.cs320.lab02a_wabram.controller;

import edu.ycp.cs320.lab02a_wabram.model.Numbers;

public class NumbersController {
	private Numbers model;
	public void setModel(Numbers model) {
		this.model = model;
	}
	public Double multiply(Double first, Double second) {
		
		model.setFirst(first);
		model.setSecond(second);
		model.setMultResult();
		return model.getMultResult();
	}
	public Double add(Double first, Double second, Double third) {
		
		model.setFirst(first);
		model.setSecond(second);
		model.setThird(third);
		model.setAddResult();
		return model.getAddResult();
	}
}
