<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String msg1=(String)request.getAttribute("msg1"); %>
<%if (msg1 !=null) {%>
	<h2><%out.println(msg1); %></h2>
	<%}%>
	<form action="Register" method="post">
		<table border="1">
		<tr>
				<td>Enter name</td>
				<td><input type="text" name="user_name"></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="user_email"></td>
			</tr>
			<tr>
				<td>Enter password</td>
				<td><input type="password" name="user_password"></td>
			</tr>
			<tr>
				<td>Enter contact</td>
				<td><input type="text" name="user_contact"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>

		</table>
	</form>

</body>
</html>