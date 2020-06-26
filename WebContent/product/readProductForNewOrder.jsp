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
		<a href="homeadmin.jsp">Home</a> 
		<a href="LogoutServlet" id="logout">Logout</a>
	</div>

	<div class="main">
	<%ProductDTO prodDto = (ProductDTO) request.getAttribute("dto");%>
	
	<table>
	<tr> 
		<th>Nome</th>
		<th>Descrizione</th>
		<th>Quantità</th>
		<th>Prezzo</th>
		<th>Categoria</th>
		<th>Seleziona la quantità da inserire nell'ordine</th>
		<th> </th>
	</tr>
	<tr>
	<form action="ShoppingListServlet?mode=insert" method="post">
	           <td> <input type="hidden" value=<%=prodDto.getProdId()%> name="prodID" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getName()%> name="name" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getDescription()%> name="descrizione" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getQuantity()%> name="disponibilita" readonly="readonly"> </td>
		       <td> <input type="number" min="0.01" step="0.01" value=<%=prodDto.getPrice()%> name="prezzo" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getCategory()%> name="categoria" readonly="readonly"> </td>
		       <td> <input type="number" min="1" step="1" max=<%=prodDto.getQuantity()%> id="quant" name="quantity"> </td>
		       <td> <button type="submit">Crea un nuovo ordine</button> </td>
		        </form> 
</tr>
			
</table>

<br>
	
	</div>

</body>
</html>