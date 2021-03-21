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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id=	request.getParameter("id");
    int user_id=Integer.parseInt(id);
    try {
		Connection connection=ConnectionClass.getConnectionMethod();
		
		LoginService service=new LoginService();
		User user=service.getData(user_id,connection);
		if(user!=null){
			request.setAttribute("User", user);
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			
			
		}
		else{
			ArrayList<User> userlist=service.userList(connection);
			request.setAttribute("list", userlist);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
	}

}
