<%@page import="com.bean.CartProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bean.CartProductBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View carts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>

<%
	ArrayList<CartProductBean> carts = (ArrayList<CartProductBean>) request.getAttribute("carts");
	%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">eShop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="Dashboard.jsp">Home <span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="ListUserController">List Users</a></li>
				<li class="nav-item"><a class="nav-link"
				href="ListProductController">Products</a></li>
			
			<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">Disabld</a></li>
				<li class="nav-item"><a class="nav-link disabled" href="#"
				tabindex="-1" aria-disabled="true">List orders</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<!--  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">My Carts</button>-->
			<a href="ViewCartController" class="btn btn-outline-success my-2 my-sm-0">My Carts</a>
		</form>
	</div>
</nav>

	<div class=container>
		<div class="row">
			<div class="col-3"></div>
  		<div class="col-6">
  		<h1 class="text-center">Items in carts</h1>
	<table border="4" id="carts" class="display">
	<thead>
		<tr class="table table-dark" >
			<th  scope="col">ProductId</th>
			<th  scope="col">ProductName</th>
			<th  scope="col">Price</th>
			<th  scope="col">UserId</th>
			<th  scope="col">CartId</th>
			<th scope="col">Action</th>
		</tr>
		</thead>
		<tbody>
		
		<%
		int total=0;
		for (CartProductBean cart : carts) {
		total=total + cart.getProductPrice();%>
		<tr >
			<td><%=cart.getProductId()%></td>
			<td><%=cart.getProductName()%></td>
			<td><%=cart.getProductPrice()%></td>
			<td><%=cart.getUserId()%></td>
			<td><%=cart.getCartId()%></td>
			<td><a href="DeleteCartController?cartId=<%= cart.getCartId()%> ">Delete</a></td>
			
		<%}%>
		</tr>
		</tbody>
		</table>
		<h2>Total=<%=total %></h2>
		<a href="CheckOutController"class="btn btn-primary ">checkout</a>
		</div>
		<div class="col-3"></div>
		</div>
		
		</div>
 
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#carts').DataTable();
		});
	</script>
</body>
</html>