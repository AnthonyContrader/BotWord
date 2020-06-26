<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ShoppingListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Shopping List</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="ShoppingListServlet?mode=shoppingListlist">shoppingLists</a>
  <a class="active" href="ProductsServlet?mode=productslist">Lista Prodotti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ShoppingListDTO sl = (ShoppingListDTO) request.getAttribute("dto");%>


<table>
	<tr>
		<th>ShoppingListUserId</th>
		<th>ShoppingList</th>
		<th>ShoppingListTotalPrice</th>
	</tr>
	<tr>
		<td><%=sl.getUserId()%></td>
		<td> <%=sl.getShoppingList()%></td>
		<td> <%=sl.getTotalPrice().toString()%></td>
	</tr>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>
