<%@page import="com.webcart.entity.Product"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
	<%	DateFormat  df =new SimpleDateFormat("dd/MM/yyyy");
		String user = (String)session.getAttribute("USERNAME");
		List<Product> cart = (List<Product>) request.getAttribute("CART");
		String orderid = (String)request.getAttribute("ORDERID");
		float subtotal = (float)request.getAttribute("SUBTOTAL");
		String orderDate = df.format(request.getAttribute("ORDERDATE"));
		String dlvDate = df.format(request.getAttribute("DLVDATE"));
		float tax = (float)request.getAttribute("TAX");
		float grandtotal = (float)request.getAttribute("GRANDTOTAL");
	%>
	
	<h1><%=user %>'s Order</h1><br/>
	
	<a href="LoginServlet">Home</a>	<br>
	<br>
	
	<b>Order ID = <%=orderid %></b>
		
	<hr/>
		<table border="1">
			<thead>
				<tr>
					<td>Product ID</td>
					<td>Price</td>
					<td>Quantity</td>
					<td>Sub total</td>
				</tr>
			</thead>
	<%
		for(Product p : cart)
		{
	%>
		<tr>
			<td><%= p.getPid() %></td>
			<td><%= p.getPrice() %></td>
			<td><%= p.getQuantity() %></td>
			<td><%= p.getQuantity()*Integer.parseInt(p.getPrice()) %>
		</tr>
	
	<%
		}
	%>
		</table><br/>
		<br/>
		<b>Total = <%=subtotal %></b><br>
		<b>Tax = <%=tax %></b><br>
		<h2>Grand Total = <%=grandtotal %></h2><br>
		<b>Order Date = <%=orderDate %></b><br>
		<b>Delivery Date = <%= dlvDate %></b>
	
</body>
</html>