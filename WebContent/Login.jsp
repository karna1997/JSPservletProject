<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
%>
<%if(msg!=null){ %>
<%out.println(msg); %>
<%} %>
<h1>Hello This Is a Login Page</h1>

<form action="Login" method="post" >
<table border="1">
<tr>
<td> Enter user name</td>
<td><input type="text" name="username"> </td>
</tr>
<tr>
<td> Enter password</td>
<td><input type="password" name="password"> </td>
</tr>
<tr>
<td> </td>
<td><input type="submit" value="Login"> </td>
</tr>
</table>
</form>
</body>
</html>