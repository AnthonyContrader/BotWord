<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ShoppingListDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Shopping List Edit page">
<meta name="author" content="A M">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Shopping List</title>

</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/user/getall">Users</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ShoppingListDTO sl = (ShoppingListDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/shoppinglist/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="user">UserId</label>
    </div>
    <div class="col-75">
      <input type="text" id="user" name="userId" value=<%=sl.getUserId()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">ProductId</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="prod" name="productId" value=<%=sl.getProductId()%>>
    </div>
  </div>

   <div class="col-25">
      <label for="user">Quantity</label>
    </div>
    <div class="col-75">
      <input type="text" id="quantity" name="quantity" value=<%=sl.getQuantity()%>>
    </div>

   <div class="col-25">
      <label for="user">Total Price</label>
    </div>
    <div class="col-75">
      <input type="text" id="totalPrice" name="totalPrice" value=<%=sl.getTotalPrice()%>>
    </div>

    <div class="col-25">
      <label for="user">Date</label>
    </div>
    <div class="col-75">
      <input type="text" id="date" name="date" value=<%=sl.getDate()%>>
    </div>

      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>
