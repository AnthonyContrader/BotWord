<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "it.contrader.dto.ProductDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Product</title>
</head>
<body>

	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
	    <a href="homeuser.jsp">Home</a>
		<a href="ProductsServlet?mode=productslist">Prodotti</a>
		<a href="LogoutServlet" id="logout">Logout</a>

	</div>

	<div class="main">
	<%ProductDTO prodDto = (ProductDTO) request.getAttribute("dto");%>

	<table>
	<tr>
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Quantit&agrave</th>
		<th>Prezzo</th>
		<th>Categoria</th>
	</tr>
	<tr>
		<td><%=prodDto.getName()%></td>
		<td> <%=prodDto.getDescription()%></td>
		<td> <%=prodDto.getAvailability()%></td>
		<td> <%=prodDto.getPrice()%></td>
		<td> <%=prodDto.getCategory()%></td>
	</tr>
</table>

<br>

	</div>

</body>
</html>
