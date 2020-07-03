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
<meta name="description" content="Product Management">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Product Manager</title>
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
		<a href="/user/getall">Users</a> <a
			href=/product/getall>Lista Prodotti</a> <a href="/user/logout"
			id="logout">Logout</a>
		<%
			break;
				case USER:
		%>
		<a href="/product/getall">Lista Prodotti</a> <a
			href="/user/logout" id="logout">Logout</a>
		<%
			break;
				}
		%>
	</div>

	<div class="main">
		<%
			List<ProductDTO> listDto = (List<ProductDTO>) request.getSession().getAttribute("listdto");
		%>
		<br>
		<%
			switch (userDto.getUsertype()) {
		case ADMIN:
		%>
		<table>
			<tr>
				<th>Nome</th>
				<th>Disponibilità</th>
				<th>Prezzo</th>
				<th>Categoria</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ProductDTO dto : listDto) {
			%>
			<tr>
				<td><a href="/product/read?id=<%=dto.getId()%>"> <%=dto.getName()%>
				</a></td>
				<td><%=dto.getAvailability()%></td>
				<td><%=dto.getPrice()%></td>
				<td><%=dto.getCategory()%></td>

				<td><a href="/product/preupdate?id=<%=dto.getId()%>">Edit</a></td>

				<td><a href="/product/delete?id=<%=dto.getId()%>">Delete</a></td>
			</tr>

			<%
				}
			%>
		</table>

		<form id="floatright" action="/product/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome" name="name" required
						placeholder="inserisci il nome del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="descr" name="description" required
						placeholder="inserisci la descrizione del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Disponibilità</label>
				</div>
				<div class="col-75">
					<input type="number" min="1" step="1" id="quant"
						name="availability" required
						placeholder="inserisci la disponibilià del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Prezzo</label>
				</div>
				<div class="col-75">
					<input type="number" min="0.01" step="0.01" id="prezzo" required
						name="price" placeholder="inserisci il prezzo del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="categoria" name="category" required
						placeholder="inserisci la categoria del prodotto">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>
		<%
			break;
			case USER:
		%>
		<table>
			<tr>
				<th>Nome</th>
				<th>Disponibilità</th>
				<th>Prezzo</th>
				<th>Categoria</th>
			</tr>
			<%
				for (ProductDTO dto : listDto) {
			%>
			<tr>
				<td><a href="/product/read?id=<%=dto.getId()%>"> <%=dto.getName()%>
				</a></td>
				<td><%=dto.getAvailability()%></td>
				<td><%=dto.getPrice()%></td>
				<td> <%=dto.getCategory()%> </td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			break;
			}
		%>

	</div>

	<br>

</body>
</html>