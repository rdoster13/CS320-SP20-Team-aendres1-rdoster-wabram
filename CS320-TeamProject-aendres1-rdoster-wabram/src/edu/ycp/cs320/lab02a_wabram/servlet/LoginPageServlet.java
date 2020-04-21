package edu.ycp.cs320.lab02a_wabram.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.lab02a_wabram.controller.LoginPageController;
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;


public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginPage model;
	private LoginPageController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginPageServlet: doGet");

		req.getRequestDispatcher("/_view/loginPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginPageServlet: doPost");

		String errorMessage = null;
		String username = null;
		String password = null;
		boolean validLogin = false;
		
		//for testing
		//System.out.println("Test: I reach this spot in the code.");
		
		// Decode form parameters and dispatch to controller
		username = req.getParameter("username");
		password = req.getParameter("password");

		System.out.println("Name: " + username + "Password: " + password);			

		if (username == null || password == null || username.equals("") || password.equals("")) {
			errorMessage = "Please enter a username and a password";
		} else {
			model      = new LoginPage();
			controller = new LoginPageController(model);
			try {
				validLogin = controller.validCreds(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!validLogin) {
				errorMessage = "Username and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login", validLogin);

		// if login is valid, start a session
		if (validLogin) {
			System.out.println("   Valid login - starting session, redirecting to /homepage");

			// store user object in session
			req.getSession().setAttribute("username", username);

			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/chessPage");

			return;
		}

		System.out.println("Invalid login - returning to /loginPage");

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/loginPage.jsp").forward(req, resp);
	}
}