<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ProductDTO"
	import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Update product</title>
</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="homeadmin.jsp">Home</a> <a href="LogoutServlet" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			ProductDTO dto = (ProductDTO) request.getAttribute("dto");
		%>
		
		<form id="floatleft" action="ProductsServlet?mode=update&id=<%=dto.getProdId()%>"
			method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">Nome</label>
				</div>
				<div class="col-75">
					<input type="text" id="nome" name="name" value=<%=dto.getName()%>
						placeholder="inserisci il nuovo nome del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Descrizione</label>
				</div>
				<div class="col-75">
					<input type="text" id="descr" name="description" value=<%=dto.getDescription()%>
						placeholder="inserisci la nuova descrizione del prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label>Quantità</label>
				</div>
				<div class="col-75">
					<input type="number" min="1" step="1" id="quant" name="quantity" value=<%=dto.getQuantity()%>
						placeholder="inserisci la nuova quantità del prodotto">
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
					<input type="text" id="categoria" name="category" value=<%=dto.getCategory()%>
						placeholder="inserisci la nuova categoria del prodotto">
				</div>
			</div>
			<button type="submit">Update</button>
		</form>
		
	</div>
</body>
</html>