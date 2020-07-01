<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="javax.servlet.http.HttpServletRequest" import="java.util.*"
	import="it.contrader.dto.UserDTO" import="it.contrader.dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Product</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<%
		UserDTO userDto = (UserDTO) request.getSession().getAttribute("user");
	%>

	<div class="navbar">
		<a href="/home<%=userDto.getUsertype().toString().toLowerCase()%>.jsp">Home</a>
		<%
			switch (userDto.getUsertype()) {
		case ADMIN:
		%>
		<a href="/user/getall">Users</a> 
		<a href=/product/getall>Lista Prodotti</a> 
		<a href="/user/logout" id="logout">Logout</a>
		<%
			break;
				case USER:
		%>
		<a href="/product/getall">Users</a>
		<a href=/product/getall>Lista Prodotti</a> 
		<a	href="/user/logout" id="logout">Logout</a>
		<%
			break;
				}
		%>
		</div>
		<br>
		<div class="main">
			<%
				ProductDTO dto = (ProductDTO) request.getSession().getAttribute("dto");
			%>
			<table>
				<tr>
					<th>Nome</th>
					<th>Descrizione</th>
					<th>Disponibilità</th>
					<th>Prezzo</th>
					<th>Categoria</th>
				</tr>
				<tr>
					<td><%=dto.getName()%></td>
					<td><%=dto.getDescription()%></td>
					<td><%=dto.getAvailability()%></td>
					<td><%=dto.getPrice()%></td>
					<td><%=dto.getCategory()%></td>
				</tr>
			</table>
			<br>
		</div>
</body>
</html>