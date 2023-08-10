<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>ICIN Bank</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
	<div class="container">
		<form action="RequestChequeBook" method="post">
		<div class="form-group">
				<label for="name">Name on ChequeBook</label> <input
					type="text" class="form-control" id="name"
					name="name">
			</div>
			<div class="form-group">
				<label for="accountNumber">Account Number</label> <input
					type="text" class="form-control" id="accountNumber"
					name="accountNumber">
			</div>
			<div class="form-group">
			<label for="accountNumber">Leaf Size</label>
				<select class="form-select" name="leafSize" aria-label="Default select example">
					<option selected>Choose Leaf Size</option>
					<option value="10">10</option>
					<option value="25">25</option>
					<option value="50">50</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Request</button>
		</form>
		
		<p style="color: green; font-size: 18px">${message}</p>
	</div>
</body>
</html>