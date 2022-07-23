<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<jsp:include page="AdminMenu.jsp"></jsp:include>
	<div class="container-fluid">


		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<h2>New Product</h2>

				<form method="post" action="AddProductController">

					<div class="form-group">
						Name : <input type="text" name="name" class="form-control" />
					</div>

					<div class="form-group">
						Price : <input type="text" name="price" class="form-control" />
					</div>
					<div class="form-group">
						Qty : <input type="text" name="qty" class="form-control" />
					</div>


					<input type="submit" class="btn btn-primary" value="Save Product" />
					<button type="reset" class="btn btn-danger">Reset</button>

				</form>

			</div>

		</div>

	</div>

</body>
</html>