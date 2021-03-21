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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginService loginservice=new LoginService();
		
		try {
			Connection 	connection = ConnectionClass.getConnectionMethod();
			  boolean flag=loginservice.checkUser(username,password,connection);

			  if(flag)
			  {
				  ArrayList<User> userlist=loginservice.userList(connection);
				 
			      request.setAttribute("msg", "Login Successfull...!!!");
			      request.setAttribute("list", userlist);
				  RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				  rd.forward(request, response);

			  }else{
				  request.setAttribute("msg", "Check Your Credentials");
				  RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				  rd.forward(request, response);
			  }
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		doGet(request, response);
	}
				
		
		
	 
	
			
			

}
