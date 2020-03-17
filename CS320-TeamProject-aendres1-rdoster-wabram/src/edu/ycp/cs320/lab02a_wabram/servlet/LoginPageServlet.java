package edu.ycp.cs320.lab02a_wabram.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import edu.ycp.cs320.lab02a_wabram.controller.NumbersController;
//import edu.ycp.cs320.lab02a_wabram.model.Numbers;
import edu.ycp.cs320.lab02a_wabram.model.LoginPage;
import edu.ycp.cs320.lab02a_wabram.controller.LoginPageController;

public class LoginPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("LoginPage Servlet: doGet");	
		
		// call JSP to generate empty form
		req.getRequestDispatcher("/_view/loginPage.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("LoginPage Servlet: doPost");
		

		// holds the error message text, if there is any
		String errorMessage = null;

		// result of calculation goes here
		//Double result = null;
		//Numbers model = new Numbers();
		
		LoginPage model = new LoginPage();
		//*** probably need something else here not sure what yet
		
		// decode POSTed form parameters and dispatch to controller
		try {
			//Double first = getDoubleFromParameter(req.getParameter("first"));
			//Double second = getDoubleFromParameter(req.getParameter("second"));
			//Double third=getDoubleFromParameter(req.getParameter("third"));
			
			String username= getStringFromParameter(req.getParameter("username"));
			String password= getStringFromParameter(req.getParameter("password"));
			
			// check for errors in the form data before using is in a calculation
			//if (first == null || second == null ) {
			if (username== null || password == null) {
				errorMessage = "Please enter a Username and Password";
			}
			// otherwise, data is good, do the calculation
			// must create the controller each time, since it doesn't persist between POSTs
			// the view does not alter data, only controller methods should be used for that
			// thus, always call a controller method to operate on the data
			else {
				//Numbers model = new Numbers();
				//NumbersController controller = new NumbersController();
				//controller.setModel(model);
				//result = controller.add(first, second, third);
				//LoginPage model = new Login();
				LoginPageController controller = new LoginPageController();
				controller.setModel(model);
				//*** need it to do something instead of result
				
			}
		} catch (NumberFormatException e) {
			//*** i dont think we want this catch but not sure what to put
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes
		// this creates attributes named "first" and "second for the response, and grabs the
		// values that were originally assigned to the request attributes, also named "first" and "second"
		// they don't have to be named the same, but in this case, since we are passing them back
		// and forth, it's a good idea
		//req.setAttribute("first", req.getParameter("first"));
		//req.setAttribute("second", req.getParameter("second"));
		//req.setAttribute("third", req.getParameter("third"));
		//req.setAttribute("first", model.getFirst());
		//req.setAttribute("second", model.getSecond());
		//req.setAttribute("third", model.getThird());
		
		// add result objects as attributes
		// this adds the errorMessage text and the result to the response
		req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("result", result);
		
		// set "game" attribute to the model reference
		// the JSP will reference the model elements through "game"
		
		//req.setAttribute("game", model);
		req.setAttribute("login", model);

		// Forward to view to render the result HTML document
		//req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
		req.getRequestDispatcher("/_view/loginPage.jsp").forward(req, resp);
	}

	// gets double from the request with attribute named s
	//*** not sure what this would be for our chess purposes
	//private Double getDoubleFromParameter(String s) {
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return (s);
		}
	}
}
