<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ShoppingListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>ShoppingList Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="ShoppingListServlet?mode=shoppingListlist">ShoppingLists</a>
  <a class="active" href="ProductsServlet?mode=productslist">Lista Prodotti</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ShoppingListDTO> list = (List<ShoppingListDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>UserId</th>
			<th>ShoppingList</th>
			<th>TotalPrice</th>
			<th>Data ordine </th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ShoppingListDTO u : list) {
		%>
		<tr>
			<td><a href=ShoppingListServlet?mode=read&id=<%=u.getShoppingListId()%>>
					<%=u.getUserId()%>
			</a></td>
			<td><%=u.getShoppingList()%></td>
			<td><%=u.getTotalPrice().toString()%></td>
			<td> <%=u.getData().toString() %>
			<td><a href=ShoppingListServlet?mode=read&update=true&id=<%=u.getShoppingListId()%>>Edit</a>
			</td>
			<td><a href=ShoppingListServlet?mode=delete&id=<%=u.getShoppingListId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>

<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
