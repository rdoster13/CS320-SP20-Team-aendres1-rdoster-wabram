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
	User u1 = new User();
	User u2 = new User();

	Player p1 = new Player(u1, 0);
	Player p2 = new Player(u2, 1);

	Game game = new Game(p1, p2);

	GameController controller = new GameController(game);

	// Variables to store move states
	Boolean turnStart = false;

	// Starting X and Y coordinates
	int startX;
	int startY;
	int endX;
	int endY;

	private boolean check = false;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// load the pieces from the DB
		controller.getPieces();

		// set them on the board
		game.getBoard();

		req.setAttribute("model", game);
		System.out.println(" \nGamePage Servlet: doGet");

		req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("newgame") != null) {
			System.out.println("CHessPage Servlet: creating new game");
			// We have to write the method to load the new game here.
			controller.newGame();

			// load the pieces from the DB
			controller.getPieces();

			// set them on the board
			game.getBoard();

			req.setAttribute("model", game);
			System.out.println(" \nGamePage Servlet: doGet");

			req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
		} else {
			// Error Message Printing
			String errorMessage = null;

			System.out.println("GamePage Servlet: doPost");

			// Fetching the starting X value from the Model / JSP for when a piece /
			// position on board is selected
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
					if (controller.getTurn() % 2 != game.getBoard().getPosition(startX, startY).getPiece().getColor()) {
						turnStart = false;
					}
				} else {
					turnStart = false;
				}

				req.setAttribute("model", game);
				req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
			}

			// if the turn has already been started AND
			// the starting location for X has a piece, then choose the destination for the
			// piece move
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

						// not sure what is going on here, but when you take an oppenent's piece with
						// your king
						// it replaces the king with the original piece of the same color that was on
						// the board.
						// Issue is either with the placement of this method or something in the
						// Self-Check method itself. not sure.

						/*
						 * // check that move does not put you in check if
						 * (controller.evaluateSelfCheck( game.getBoard().getPosition(startX,
						 * startY).getPiece().getColor(), game.getBoard().getPosition(startX, startY),
						 * game.getBoard().getPosition(endX, endY)) == false) { check = false; }
						 * 
						 */
						
						//if (check == false) {
// check if move
							if (controller.evaluateOppCheck(
									game.getBoard().getPosition(startX, startY).getPiece().getColor(),
									game.getBoard().getPosition(startX, startY),
									game.getBoard().getPosition(endX, endY)) == true) {
								/*
								 * System.out.print("\n**********************************************");
								 * System.out.print("\nYou are in check!");
								 * System.out.print("\n**********************************************");
								 * System.out.print("\n");
								 */

								// add message / status to say check
								// check = true;
							}
							// if statement to check on color of piece / move off of board
							if (game.getBoard().getPosition(endX, endY).getPiece() != null
									&& game.getBoard().getPosition(startX, startY).getPiece().getColor() != game
											.getBoard().getPosition(endX, endY).getPiece().getColor()) {

								// Call method to move piece off board if taken
								controller.takePiece(game.getBoard().getPosition(endX, endY),
										game.getBoard().getPosition(0, 8));
							}

							
							// controller.updatePieceLocation(startX, startY, endX, endY);
							controller.movePiece(game.getBoard().getPosition(startX, startY),
									game.getBoard().getPosition(endX, endY));
						/*
						 * } else {
							*/// check that move does not put you in check
							if (controller.evaluateSelfCheck(
									game.getBoard().getPosition(startX, startY).getPiece().getColor(),
									game.getBoard().getPosition(startX, startY),
									game.getBoard().getPosition(endX, endY)) == false) {
								check = false;
								
								// if statement to check on color of piece / move off of board
								if (game.getBoard().getPosition(endX, endY).getPiece() != null
										&& game.getBoard().getPosition(startX, startY).getPiece().getColor() != game
												.getBoard().getPosition(endX, endY).getPiece().getColor()) {

									// Call method to move piece off board if taken
									controller.takePiece(game.getBoard().getPosition(endX, endY),
											game.getBoard().getPosition(0, 8));
								}

								// controller.updatePieceLocation(startX, startY, endX, endY);
								controller.movePiece(game.getBoard().getPosition(startX, startY),
										game.getBoard().getPosition(endX, endY));
							}
						}
						
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