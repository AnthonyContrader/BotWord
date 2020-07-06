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
	<%@ include file="../css/header.jsp"%>
	<%
		UserDTO userDto = (UserDTO) request.getSession().getAttribute("user");
	%>

	<div class="navbar">
		<a href="/home<%=userDto.getUsertype().toString().toLowerCase()%>.jsp">Home</a>
		<%
			switch (userDto.getUsertype()) {
		case ADMIN:
		%>
		<a href="/user/getall">Users</a> <a href=/product/getall>Lista
			Prodotti</a> <a href="/shoppinglist/getall"> Order List </a> <a
			href="/user/logout" id="logout">Logout</a>
		<%
			break;
				case USER:
		%>
		 <a href=/product/getall>Lista
			Prodotti</a> <a href="/user/logout" id="logout">Logout</a>
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
				<th></th>
				<th></th>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Disponibilità</th>
				<th>Prezzo</th>
				<th>Categoria</th>
				<th>Seleziona la quantità da aggiungere all'ordine</th>
				<th></th>
			</tr>
			<form action="/shoppinglist/insert" method="post">
				<td><input type="hidden" value=<%=userDto.getId()%>
					name="userId"></td>
				<td><input type="hidden" value=<%=dto.getId()%>
					name="productId"></td>
				<td><input type="text" value="<%=dto.getName()%>" name="name"
					readonly="readonly"></td>
				<td><input type="text" value="<%=dto.getDescription()%>"
					name="descrizione" readonly="readonly"></td>
				<td><input type="number" value=<%=dto.getAvailability()%>
					name="disponibilita" readonly="readonly"></td>
				<td><input type="number" value=<%=dto.getPrice()%>
					name="totalPrice" readonly="readonly"></td>
				<td><input type="text" value="<%=dto.getCategory()%>"
					name="categoria" readonly="readonly"></td>
				<td><input type="number" min="1" step="1"
					max=<%=dto.getAvailability()%> value=0 id="quant" name="quantity">
				</td>
				<td>
					<input type="submit" value="Aggiungi questo prodotto al tuo ordine">
				</td>
			</form>
			</tr>
		</table>
		<br>
	</div>
</body>
</html>