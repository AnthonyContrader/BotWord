<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Product List User</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>


	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a href="LogoutServlet" id="logout">Logout</a>
	</div>

	<div class="main">

		<%
			List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Nome</th>
				<th>Quantit&agrave</th>
				<th>Prezzo</th>
				<th>Categoria</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ProductDTO prodDto : list) {
			%>
			<tr>
				<td><a
					href="ProductsServlet?mode=read&id=<%=prodDto.getProdId()%>"> <%=prodDto.getName()%></a>
				</td>
				<td><%=prodDto.getAvailability()%></td>
				<td><%=prodDto.getPrice().toString()%></td>
				<td><%=prodDto.getCategory()%></td>
				<td><a href=ProductsServlet?mode=read&update=true&id=<%=prodDto.getProdId()%>>Edit</a></td>
				<td><a href=ProductsServlet?mode=delete&id=<%=prodDto.getProdId()%>>Delete</a>
				</td>
			</tr>
			<%
				}
			%>

		</table>
		<form id="floatright" action="ProductsServlet?mode=insert"
			method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome" name="name"
						placeholder="inserisci il nome del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="descr" name="description"
						placeholder="inserisci la descrizione del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Quantit&agrave</label>
				</div>
				<div class="col-75">
					<input type="number" min="1" step="1" id="quant" name="availability"
						placeholder="inserisci la quantit� del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Prezzo</label>
				</div>
				<div class="col-75">
					<input type="number" min="0.01" step="0.01" id="prezzo"
						name="price" placeholder="inserisci il prezzo del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="user">Categoria</label>
				</div>
				<div class="col-75">
					<input type="text" id="categoria" name="category"
						placeholder="inserisci la categoria del prodotto">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>

</body>
</html>
