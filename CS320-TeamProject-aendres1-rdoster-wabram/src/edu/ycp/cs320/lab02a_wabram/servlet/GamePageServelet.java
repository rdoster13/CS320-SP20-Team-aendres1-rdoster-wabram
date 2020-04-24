package edu.ycp.cs320.lab02a_wabram.servlet;

import java.awt.Point;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a_wabram.controller.GameController;
import edu.ycp.cs320.lab02a_wabram.model.*;

public class GamePageServelet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Add players to initiate the game
	private Player p1;
	private Player p2;
	Game game = new Game(p1, p2);

	GameController controller = new GameController(game);

	// Variables to store move states
	Boolean turnStart = false;
	
	// Starting X and Y coordinates
	int startX;
	int startY;
	int endX;
	int endY;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("model", game);
		System.out.println(" \nGamePage Servlet: doGet");

		req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Error Message Printing
		String errorMessage = null;
							
		System.out.println("GamePage Servlet: doPost");

		// Fetching the starting X value from the Model / JSP for when a piece / position on board is selected
		if (req.getParameter("x1") != null && turnStart == false) {
			turnStart = true;
			System.out.println("\n Selected Start Square");

			// set the starting X and y to the parameters passed in
			startX = Integer.parseInt(req.getParameter("x1"));
			startY = Integer.parseInt(req.getParameter("y1"));

			// check that the space selected has a piece in it AND
			// that the piece belongs to the correct player based on he turn counter
			// if not, then do not allow the piece selection
			if (game.getBoard().getPosition(startX, startY).getPiece() != null) {
				if (game.getTurn() % 2 != game.getBoard().getPosition(startX, startY).getPiece().getColor()) {
					turnStart = false;
				}
			} else {
				turnStart = false;
			}
		
			req.setAttribute("model", game);
			req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
		}

		// if the turn has already been started AND
		// the starting location for X has a piece, then choose the destination for the piece move
		else if (req.getParameter("x1") != null && turnStart == true) {
			turnStart = false;
			System.out.println("Move Destination Chosen");

			// Passing in the move destination from the Model / JSP
			endX = Integer.parseInt(req.getParameter("x1"));
			endY = Integer.parseInt(req.getParameter("y1"));

			// verify that the position selected is not the same as the beginning position
			if (game.getBoard().getPosition(startX, startY).getPiece() != null) {
				if (startX == endX && startY == endY) {
					System.out.println("\n INVALID MOVE");
					errorMessage = "Invalid Move!";
				}

				// if the move check passes, then update the board
				if (game.getBoard().getPosition(startX, startY).getPiece().checkMove(new Point(endX, endY),
						game.getBoard()) == true) {
					controller.movePiece(game.getBoard().getPosition(startX, startY),
							game.getBoard().getPosition(endX, endY));
					game.setTurn(game.getTurn() + 1);
					
				} else {
					System.out.println("\n INVALID MOVE ");
					errorMessage = "Invalid Move!";
				}
			}

			req.setAttribute("model", game);
			req.setAttribute("errorMessage", errorMessage);
			System.out.println("GamePage Servlet: doGet");
			req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
		}
	}
}