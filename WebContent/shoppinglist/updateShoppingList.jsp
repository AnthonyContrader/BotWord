<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ShoppingListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit ShoppingList</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active" href="ShoppingListServlet?mode=shoppingListlist">ShoppingLists</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ShoppingListDTO u = (ShoppingListDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ShoppingListServlet?mode=update&id=<%=u.getShoppingListId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">User ID</label>
    </div>
    <div class="col-75">
      <input type="text" id="userid" name="userId" value=<%=u.getUserId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">ShoppingList</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="shopList" name="shoppingList" value=<%=u.getShoppingList()%>>
    </div>
  </div>
 <div class="row">
				<div class="col-25">
					<label>Prezzo totale</label>
				</div>
				<div class="col-75">
					<input type="number" min="0.01" step="0.01" id="prezzo" value=<%=u.getTotalPrice()%>
						name="totalPrice" placeholder="inserisci il nuovo prezzo totale dell'ordine">
				</div>
			</div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
