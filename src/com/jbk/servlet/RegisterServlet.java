package com.jbk.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.connection.ConnectionClass;
import com.jbk.dao.LoginService;
import com.jbk.entity.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
		Connection	connection = ConnectionClass.getConnectionMethod();
			System.out.println("name accessed by req ");
			System.out.println( request.getParameter("user_name"));
			System.out.println( request.getParameter("user_email"));
			System.out.println( request.getParameter("user_password"));
			System.out.println( request.getParameter("user_contact"));
			
			
			String name = request.getParameter("user_name");
			String email = request.getParameter("user_email");
			String password = request.getParameter("user_password");
			String contact = request.getParameter("user_contact");

		
			User user = new User( name, email, password, contact);

			LoginService service = new LoginService();
			boolean flag = service.insert(user, connection);
			if (flag) {

				ArrayList<User> userlist = service.userList(connection);
				request.setAttribute("list", userlist);
				request.setAttribute("msg1", "Data inserted Successfully..!!");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg1", "Something went wrong..!!");
				RequestDispatcher rd = request.getRequestDispatcher("UserRegistration.jsp");
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
