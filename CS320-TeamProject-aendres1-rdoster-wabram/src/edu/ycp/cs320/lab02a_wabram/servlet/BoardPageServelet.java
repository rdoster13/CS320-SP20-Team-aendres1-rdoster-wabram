package edu.ycp.cs320.lab02a_wabram.servlet;

import java.awt.Point;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a_wabram.controller.GameController;
import edu.ycp.cs320.lab02a_wabram.model.*;

public class BoardPageServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Player p1;
	private Player p2;
	Game game = new Game(p1, p2);

	GameController controller = new GameController(game);

	Boolean pos1Recieved = false;
	int sourceX;
	int sourceY;
	int destX;
	int destY;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("model", game);
		System.out.println("GamePage Servlet: doGet");

		req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("GamePage Servlet: doPost");

		if (req.getParameter("x1") != null && pos1Recieved == false) {
			pos1Recieved = true;
			System.out.println("Recieved Source");

			sourceX = Integer.parseInt(req.getParameter("x1"));
			sourceY = Integer.parseInt(req.getParameter("y1"));

			System.err.println("TURN: " + game.getTurn() % 2);

			if (game.getBoard().getPosition(sourceX, sourceY).getPiece() != null) {
				if (game.getTurn() % 2 != game.getBoard().getPosition(sourceX, sourceY).getPiece().getColor()) {
					pos1Recieved = false;
				}
			} else {
				pos1Recieved = false;
			}

			req.setAttribute("model", game);

			req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
		}

		else if (req.getParameter("x1") != null && pos1Recieved == true) {
			pos1Recieved = false;
			System.out.println("Recieved Destination");

			destX = Integer.parseInt(req.getParameter("x1"));
			destY = Integer.parseInt(req.getParameter("y1"));

			if (game.getBoard().getPosition(sourceX, sourceY).getPiece() != null) {
				if (sourceX == destX && sourceY == destY) {
					System.out.println("NOT VALID");
				}

				if (game.getBoard().getPosition(sourceX, sourceY).getPiece().checkMove(new Point(destX, destY),
						game.getBoard()) == true) {
					controller.movePiece(game.getBoard().getPosition(sourceX, sourceY),
							game.getBoard().getPosition(destX, destY));
					game.setTurn(game.getTurn() + 1);
				} else {
					System.out.println("INVALID MOVE ");
				}
			}

			req.setAttribute("model", game);
			System.out.println("GamePage Servlet: doGet");
			req.getRequestDispatcher("/_view/chessPage.jsp").forward(req, resp);
		}
	}
}