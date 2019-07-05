<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shopping Menu</title>
<style>
table, th, td {
  border: 0px solid black;
  border-collapse: collapse;
}
body{
	background-color:powderblue;
}
th, td {
  padding: 5px;
}
td {
  text-align: center;
}
</style>

</head>
<body>

		<div><h1>Welcome to Webcart</h1></div>
		<%
			String userName = (String) session.getAttribute("USERNAME");
	
		%>
			<h3>Welcome <%= userName %></h3><br/>
	
		<a href="OrderServlet">My Orders</a>
	
		<a href="ShowCartServlet">Cart</a><br/>
		
		<table text-align="center" align="center">
			<tr>		
				<td><img class="rounded" alt="pocof1" src="pics/poco-f1.png" width="200" height="200"/></td>
				<td><img alt="lgq7" src="pics/lg-q7.jpg" width="200" height="200"/></td>
				<td><img alt="vivox20" src="pics/poco-f1.png" width="200" height="200"/></td>
				<td><img alt="oneplus6t" src="pics/poco-f1.png" width="200" height="200"/></td>
			</tr>
			<tr>
				<td><label>Poco f1</label></td>
				<td><label>LG Q7</label></td>
				<td><label>VIVO X20</label></td>
				<td><label>OnePlus 6t</label></td>
			</tr>
			<tr>
				<td><label>Price : &#8360;20000</label></td>
				<td><label>Price : &#8360;18000</label></td>
				<td><label>Price : &#8360;19000</label></td>
				<td><label>Price : &#8360;25000</label></td>
			</tr>
			<tr>
				<td><a href="CartServlet?pid=pocof1&price=20000">Add to cart</a></td>
				<td><a href="CartServlet?pid=lgq7&price=18000">Add to cart</a></td> 
				<td><a href="CartServlet?pid=vivox20&price=19000">Add to cart</a></td> 
				<td><a href="CartServlet?pid=oneplus6t&price=25000">Add to cart</a></td>
			</tr>
				 
		</table>
</body>
</html>