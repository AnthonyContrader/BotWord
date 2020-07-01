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
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Product</title>

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
		<a href="/user/getall">Users</a> <a
			href=/product/getall>Lista Prodotti</a> <a href="/user/logout"
			id="logout">Logout</a>
		<%
			break;
				case USER:
		%>
		<a href="/product/getall">Users</a> <a
			href="/user/logout" id="logout">Logout</a>
		<%
			break;
				}
		%>
	</div>
	<div class="main">
	
	<%
			ProductDTO dto = (ProductDTO) request.getSession().getAttribute("dto");
		%>

		<form id="floatleft" action="/product/update" method="post">
			<div class="row">
				<div class="col-25">
					<label for="product">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome" name="name" value="<%=dto.getName()%>"
						placeholder="inserisci il nuovo nome del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="descr" name="description" value="<%=dto.getDescription()%>"
						placeholder="inserisci la nuova descrizione del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Disponibilità</label>
				</div>
				<div class="col-75">
					<input type="number" min="1" step="1" id="quant" name="availability" value=<%=dto.getAvailability()%>
						placeholder="inserisci la nuova disponibilità del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Prezzo</label>
				</div>
				<div class="col-75">
					<input type="number" min="0.01" step="0.01" id="prezzo" value=<%=dto.getPrice()%>
						name="price" placeholder="inserisci il nuovo prezzo del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="categoria" name="category" value="<%=dto.getCategory()%>"
						placeholder="inserisci la nuova categoria del prodotto">
				</div>
			</div>
			<input type="hidden" name="id" value =<%=dto.getId() %>>
			<button type="submit">Update</button>
		</form>
	
	</div>
</body>
</html>