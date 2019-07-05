<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	
	<div align="center">
	<h2>Create Account</h2>
	<form action="RegisterServlet" method="post">
		<label>Username</label> <br/>
		<input type="text" name="userName" /> <br/>
		<label>Profile name</label> <br/>
		<input type="text" name="name" /> <br/>
		<label>Mobile number</label> <br/>
		<label>+91-</label><input type="text" name="phNo" /> <br/>
		<label>Email</label> <br/>
		<input type="text" name="mailId" /> <br/>
		<label>Password</label> <br/>
		<input type="password" name="password" /> <br/>
		
	
		<input type="submit" value="Create"/>
		<hr/> <br/>
		<p>Alread have an account? <a href="LoginServlet">Sign in</a></p>
		
	</form>
		
	
</body>
</html>