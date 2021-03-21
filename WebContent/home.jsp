<%@page import="com.jbk.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Servlet Project</title>
</head>
<body>
	<%String msg = (String)request.getAttribute("msg");%>
	<%ArrayList<User> userlist = (ArrayList<User>) request.getAttribute("list");%>
	<%if (msg !=null) {%>
	<h1>Welcome to home page</h1>
	<h2><%out.println(msg); %></h2>
	<%}%>
<%
String msg1=(String)request.getAttribute("msg1");
%><%if (msg1 !=null) {%>
	<h2><%out.println(msg1); %></h2>
	<%}%>
	<h2>User Detail's</h2>
	
	<table border="1">
		<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>User Email</th>
			<th>User Contact</th>
			<th>Delete</th>
			<th>update</th>
		</tr>
		<%  for(User user:userlist) {%>
		<tr>
		<td><%out.println(user.getUser_id()); %></td>
		<td><%out.println(user.getUser_name()); %></td>
		<td><%out.println(user.getUser_email()); %></td>
		<td><%out.println(user.getUser_contact()); %></td>
		<td><a href="delete?id=<%=user.getUser_id()%>">Delete</a></td>
		<td><a href="update?id=<%=user.getUser_id()%>">update</a></td>
		<td>
		</tr>
		<%}%>
</table>	
</body>
</html>