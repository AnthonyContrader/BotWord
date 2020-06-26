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
		<a href="homeuser.jsp">Home</a> 
		<a class="active" href="ProductsServlet?mode=productslist">Prodotti</a>
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>

	<div class="main">

		<%
			List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Nome</th>
				<th>Disponibilit&agrave;</th>
				<th>Prezzo</th>
				<th>Categoria</th>
			</tr>
			<%
				for (ProductDTO prodDto : list) {
			%>
			<tr>
				<td><a
					href="ProductsServlet?mode=read&id=<%=prodDto.getProdId()%>"> <%=prodDto.getName()%></a>
				</td>
				<td><%=prodDto.getQuantity()%></td>
				<td><%=prodDto.getPrice()%></td>
				<td><%=prodDto.getCategory()%></td>
			</tr>
			<%
				}
			%>

		</table>
	</div>

</body>
</html>