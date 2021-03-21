<%@page import="com.jbk.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% User user=(User)request.getAttribute("User"); %>
<form action="edit" method="post" >
<table border="1">
<tr>
<td> Enter user name</td>
<td><input type="text" name="name" value="<%=user.getUser_name() %>"> </td>
</tr>
<tr>
<td> Enter user Email</td>
<td><input type="text" name="email" value="<%= user.getUser_email() %>"> </td>
<tr>
<td> Enter password</td>
<td><input type="password" name="password" value="<%=user.getUser_password() %>"> </td>
</tr>
<tr>
<td> Enter user contact</td>
<td><input type="text" name="contact" value="<%=user.getUser_contact() %>"> </td>
<tr>
<td><input type="text" value="<%=user.getUser_id()%>" readonly name="id"> </td>
<td><input type="submit" value="update"> </td>
</tr>
</table>
</form>
</body>
</html>