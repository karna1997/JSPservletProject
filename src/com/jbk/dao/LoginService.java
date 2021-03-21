package com.jbk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jbk.connection.ConnectionClass;
import com.jbk.entity.User;

public class LoginService {

	public boolean checkUser(String username, String password, Connection connection) {
		boolean flag = false;

		try {
			connection = ConnectionClass.getConnectionMethod();
			Statement stmt = connection.createStatement();

			String query = "Select * from user where user_email='" + username + "' AND  user_password='" + password
					+ "'";

			@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
			ArrayList<User> userlist = new ArrayList();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return flag;

	}

	public ArrayList<User> userList(Connection connection) throws SQLException {
		Statement stmt1;

		stmt1 = connection.createStatement();

		String Query1 = "Select * from user ";
		ResultSet rs1 = stmt1.executeQuery(Query1);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<User> userlist = new ArrayList();
		while (rs1.next()) {
			User user = new User();
			user.setUser_id(rs1.getInt("user_id"));
			user.setUser_name(rs1.getString("user_name"));
			user.setUser_email(rs1.getString("user_email"));
			user.setUser_password(rs1.getString("user_password"));
			user.setUser_contact(rs1.getString("user_contact"));

			userlist.add(user);
		}
		return userlist;

	}

	public boolean deleteUser(int user_id, Connection connection) throws SQLException {
		Statement stmt=connection.createStatement();
		String query="delete from user where user_id="+user_id;
	    int i=stmt.executeUpdate(query);
	    if(i>0){
	    	return true;
	    }else{
	    	return false;
	    }
	    
		
		
	}

	public User getData(int user_id, Connection connection) throws SQLException {
		Statement stmt=connection.createStatement();
		String query="select * from user where user_id="+user_id;
	ResultSet rs=stmt.executeQuery(query);
	User user= new User();
	if(rs.next()){
		user.setUser_name(rs.getString("user_name"));
		user.setUser_email(rs.getString("user_email"));
		user.setUser_password(rs.getString("user_password"));
		user.setUser_contact(rs.getString("user_contact"));
		
		
	}
		user.setUser_id(user_id);
		return user;
	}

	public boolean updateData(User user, Connection connection) throws SQLException {
	  System.out.println(user.getUser_id());	
		PreparedStatement psmt=connection.prepareStatement("update user set user_name=?,user_email=?,user_password=?,user_contact=? where  user_id =?");
		psmt.setString(1, user.getUser_name());
		psmt.setString(2, user.getUser_email());
		psmt.setString(3, user.getUser_password());
		psmt.setString(4, user.getUser_contact());
		psmt.setInt(5, user.getUser_id());
		
		int i=psmt.executeUpdate();
		if(i>0){
			return true;
		}else
		return false;
	}

	
	public boolean insert(User user,Connection connection) throws ClassNotFoundException, SQLException{
		
		
		String query="insert into User(user_name,user_email,user_password,user_contact) values(?,?,?,?)";
		PreparedStatement psmt=connection.prepareStatement(query);
		
		System.out.println(user.getUser_name());//null
		System.out.println(user.getUser_email());//null
		System.out.println(user.getUser_password());//null
		System.out.println(user.getUser_contact());//null
		
		
		psmt.setString(1, user.getUser_name());
		psmt.setString(2, user.getUser_email());
		psmt.setString(3, user.getUser_password());
		psmt.setString(4, user.getUser_contact());
		
		
       int i=psmt.executeUpdate();
       if(i>0){
    	   return true;
       }else{
    	   return false;
       }
		
	}
}
