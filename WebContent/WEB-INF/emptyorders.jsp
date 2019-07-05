<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empty Orders</title>
</head>
<body>
		<%
		String user = (String) session.getAttribute("USERNAME");
	%>

	<h1><%=user%>'s Orders</h1><br>
	
	<a href="LoginServlet">Home</a><br>
	
	<b>NO ORDERS</b>
</body>
</html>