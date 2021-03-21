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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	
		String id= request.getParameter("id");
		int user_id =Integer.parseInt(id);

		Connection connection;
		try {
			connection = ConnectionClass.getConnectionMethod();
			LoginService service = new LoginService();

			boolean flag = service.deleteUser(user_id, connection) ;
			if (flag) {
				
				ArrayList<User> userlist = service.userList(connection);
				request.setAttribute("list", userlist);
				request.setAttribute("msg1", "record Deleted Successfully..!!");
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg1", "Something went wrong..!!");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
