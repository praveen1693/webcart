<%@page import="com.webcart.entity.Order"%>
<%@page import="java.util.List"%>
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
		String user = (String)session.getAttribute("USERNAME");
		List<Order> orders = (List<Order>) request.getAttribute("ORDERS");
		int i=1;
	%>
	
	<h1><%=user %>'s previous Order</h1><br/>
	
	
	<a href="LoginServlet">Home</a>	<br>
	<br>
	
	<table border="1">
			<thead>
				<tr>
					<td>Sl no.</td>
					<td>Order ID</td>
					<td>Order Date</td>
					<td>Delivery Date</td>
					<td>Sub Total</td>
					<td>Tax</td>
					<td>Grand Total</td>
					<td>Status</td>
				</tr>
			</thead>
	<%
		for(Order o : orders)
		{
	%>
		<tr>
			<td><%= i%></td>
			<td><%= o.getOrderId() %></td>
			<td><%= o.getOrderDate() %></td>
			<td><%= o.getDlvDate() %></td>
			<td><%= o.getSubtotal() %></td>
			<td><%= o.getTax() %></td>
			<td><%= o.getGrandtotal() %></td>
			<td><%= o.getStatus() %></td>
		</tr>
	
	<%
			i+=1;
		}
	%>
		</table><br/>
	
</body>
</html>