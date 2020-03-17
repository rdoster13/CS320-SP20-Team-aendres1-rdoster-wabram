package edu.ycp.cs320.lab02a_wabram.controller;

import edu.ycp.cs320.lab02a_wabram.model.GuessingGame;

/**
 * Controller for the guessing game.
 */
public class GuessingGameController {
	private GuessingGame model;

	/**
	 * Set the model.
	 * 
	 * @param model the model to set
	 */
	public void setModel(GuessingGame model) {
		this.model = model;
	}

	/**
	 * Start a new guessing game by setting the minimum to 1 and the maximum to 100.
	 */
	public void startGame() {
		//throw new UnsupportedOperationException("TODO - implement");
		model.setMin(1);
		model.setMax(100);		
	}

	/**
	 * Called to indicate that the current guess is correct.
	 * Set the min and max to the current guess.
	 */
	public void setNumberFound() {
		//throw new UnsupportedOperationException("TODO - implement");
		int guess=model.getGuess();
		model.setMin(guess);
		model.setMax(guess);
	}

	/**
	 * Called to indicate that the user is thinking of a number that
	 * is less than the current guess.
	 */
	public void setNumberIsLessThanGuess() {
		//throw new UnsupportedOperationException("TODO - implement");
		
		//System.out.println("no, that's too big");
		int guess=model.getGuess();
		int max=model.getMax();
		int min=model.getMin();
		if(max-min==1) {
			model.setMax(min);
		}
		else {
			model.setIsLessThan(guess);
		}
		//System.out.println("guess is: "+ guess +", min is: "+model.getMin()+ ", and max is: "+model.getMax());
	}

	/**
	 * Called to indicate that the user is thinking of a number that
	 * is greater than the current guess.
	 */
	public void setNumberIsGreaterThanGuess() {
		//throw new UnsupportedOperationException("TODO - implement");
		
		//System.out.println("no, that's too small");
		int guess=model.getGuess();
		model.setIsGreaterThan(guess);
		
		//System.out.println("guess is: "+ guess +", min is: "+model.getMin()+ ", and max is: "+model.getMax());
	}
}
