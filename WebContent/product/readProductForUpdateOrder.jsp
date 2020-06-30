<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import = "it.contrader.dto.ProductDTO"
	import = "it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Product</title>
</head>
<body>

	<%@ include file="../css/header.jsp"%>
	<%UserDTO userDto = (UserDTO)session.getAttribute("user"); %>

	<div class="navbar">
		<a href="home<%=userDto.getUsertype()%>.jsp">Home</a>
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
		<th>Seleziona la quantit&agrave da inserire nell'ordine</th>
		<th> </th>
	</tr>
	<tr>
	<form action="ShoppingListServlet?mode=updateorder&id=<%=prodDto.getProdId()%>" method="post">
	           <td> <input type="hidden" value=<%=prodDto.getProdId()%> name="prodID" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getName()%> name="name" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getDescription()%> name="descrizione" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getAvailability()%> name="disponibilita" readonly="readonly"> </td>
		       <td> <input type="number" min="0.01" step="0.01" value=<%=prodDto.getPrice()%> name="prezzo" readonly="readonly"> </td>
		       <td> <input type="text" value=<%=prodDto.getCategory()%> name="categoria" readonly="readonly"> </td>
		       <td> <input type="number" min="1" step="1" max=<%=prodDto.getAvailability()%> id="quant" name="availability"> </td>
		       <td> <button type="submit">Modifica il tuo ordine</button> </td>
		        </form>
</tr>

</table>

<br>

	</div>

</body>
</html>
