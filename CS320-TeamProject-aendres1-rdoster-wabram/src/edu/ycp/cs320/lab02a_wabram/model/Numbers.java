package edu.ycp.cs320.lab02a_wabram.model;

// model class for GuessingGame
// only the controller should be allowed to call the set methods
// the JSP will call the "get" and "is" methods implicitly
// when the JSP specifies game.min, that gets converted to
//    a call to model.getMin()
// when the JSP specifies if(game.done), that gets converted to
//    a call to model.isDone()
public class Numbers {
	private double first, second, third, multResult, addResult;
	
	public Numbers() {
	}
	
	public void setFirst(Double first) {
		this.first = first;
	}
	
	public double getFirst() {
		return first;
	}
	
	public void setSecond(Double second) {
		this.second = second;
	}
	
	public double getSecond() {
		return second;
	}
	
	public void setThird(Double third) {
		this.third = third;
	}
	
	public double getThird() {
		return third;
	}
	
	public void setMultResult() {
		this.multResult = first*second;
	}
	
	public void setAddResult() {
		this.addResult=first+second+third;
	}
	
	public double getMultResult() {
		return multResult;
	}
	
	public double getAddResult(){
		return addResult;
	}
}
