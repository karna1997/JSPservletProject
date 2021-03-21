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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit" )
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String id = request.getParameter("id");
		int user_id=Integer.parseInt(id);
		try {
			Connection connection= ConnectionClass.getConnectionMethod();

			User user=new User(user_id, name, email, password,contact);
			LoginService service=new LoginService();
	      boolean flag=service.updateData(user,connection);
	      
	      if(flag){
	    	  ArrayList<User> userlist=service.userList(connection);
	    	  request.setAttribute("list", userlist);
	    	  request.setAttribute("msg1", "Record updated successfully..!!!");
	    	  RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
	    	  rd.forward(request, response);
	    	  }else{
	    		  User user1=service.getData(user_id, connection);
	    		  request.setAttribute("user", user1);
	    		  RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
	    		  rd.forward(request, response);
	    		  	  
	    	  }
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
