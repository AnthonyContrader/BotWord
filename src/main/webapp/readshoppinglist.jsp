<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ShoppingListDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Shopping List Read">
<meta name="author" content="A M">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Shopping List</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			ShoppingListDTO sl = (ShoppingListDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>UserId</th>
				<th>ProductId</th>
        <th>Quantity</th>
				<th>TotalPrice</th>
				<th>DAte</th>
			</tr>
			<tr>
				<td><%=sl.getId()%></td>
				<td><%=sl.getUserId()%></td>
				<td><%=sl.getProductId()%></td>
        <td><%=sl.getQuantity()%></td>
				<td><%=sl.getTotalPrice()%></td>
				<td><%=sl.getDAte()%></td>
			</tr>
		</table>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>
