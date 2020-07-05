<%@ page import="it.contrader.dto.ShoppingListDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Shopping List Management">
<meta name="author" content="A M">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Shopping List Manager</title>

</head>
<body>
	<%@ include file="../css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		<a href="/user/getall">Users</a>
		<a href="/product/getall">Lista Prodotti</a>
		<a class="active" href="/shoppinglist/getall">Order List</a>
		<a href="/shoppinglist/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<ShoppingListDTO> list = (List<ShoppingListDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>User Id</th>
				<th>Product Id</th>
				<th>Quantity</th>
				<th>Total Price</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (ShoppingListDTO sl : list) {
			%>
			<tr>
				<td><a href="/shoppinglist/read?id=<%=sl.getId()%>"> <%=sl.getUserId()%>
				</a></td>
				<td><%=sl.getProductId()%></td>
				<td><%=sl.getQuantity()%></td>
				<td><%=sl.getTotalPrice()%></td>

				<td><a href="/shoppinglist/preupdate?id=<%=sl.getId()%>">Edit</a></td>

				<td><a href="/shoppinglist/delete?id=<%=sl.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>

		<form id="floatright" action="/shoppinglist/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="user">UserId</label>
				</div>
				<div class="col-75">
					<input type="text" id="shoppinglist" name="userId"
						placeholder="inserisci user id">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="prod">Product</label>
				</div>
				<div class="col-75">
					<input type="text" id="prod" name="productId"
						placeholder="inserisci id prodotto">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="name">Quantity</label>
				</div>
				<div class="col-75">
					<input type="text" id="quantity" name="quantity"
						placeholder="inserisci la quantità">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="surname">Total Price</label>
				</div>
				<div class="col-75">
					<input type="text" id="totalPrice" name="totalPrice"
						placeholder="inserisci prezzo totale">
				</div>
			</div>

			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="../css/footer.jsp"%>
</body>
</html>
