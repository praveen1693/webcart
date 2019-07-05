<%@page import="com.webcart.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart with products</title>
<script type="text/javascript" >
	
		function setData(pid)
		{
			document.showcartform.hdnpid.value = pid;
			document.showcartform.ACTION.value = "DELETE";
		}
		
		function submitForm() {
			document.showcartform.submit();
		}
	
	</script>
</head>
<body>
	<%
		List<Product> cart = (List<Product>) request.getAttribute("PRODUCT_LIST");
		String user = (String)session.getAttribute("USERNAME");
	%>
	<h1><%=user %>'s Cart</h1><br/>
	
	<a href="LoginServlet">Home</a>	
	
	<form name="showcartform" action="ShowCartServlet" method="post">
		<input type="hidden" name="hdnpid"/>
		<input type="hidden" name="ACTION" value="CREATE"/>
	</form>
	
	<hr/>
		<table border="1">
			<thead>
				<tr>
					<td>Product ID</td>
					<td>Price</td>
					<td>Quantity</td>
				</tr>
			</thead>
	<%
		for(Product p : cart)
		{
	%>
		<tr>
			<td><%= p.getPid() %></td>
			<td><%= p.getPrice() %></td>
			<td><%= p.getQuantity() %>
			<td> <input type="checkbox" onclick="setData(<%= p.getPid()%>)"/> </td>
		</tr>
	
	<%
		}
	%>
		</table>
		
	
		<input type="button" onclick="submitForm()" value="Delete"/><br/><br/>
		
		<form action="OrderServlet" method = "post">
			<input type="submit" value="Place Order"/>
		</form>
	
</body>
</html>