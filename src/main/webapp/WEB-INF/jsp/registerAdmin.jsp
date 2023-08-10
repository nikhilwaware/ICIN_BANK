<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>ICIN Bank</title>
<style>
sup{
color:red;
}
</style>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
<div class="container">
		<h1>Admin Registration</h1>
		<!-- <h2>We provide account number of your choice</h2> -->
		<form action="save-admin" method="post">

			<div class="form-group">
				<label for="name">Name<sup>*</sup></label> <input type="text"
					class="form-control" id="name" name="name" placeholder="Enter name"
					required="required">
			</div>
			<div class="form-group">
				<label for="phoneNo">Phone Number<sup>*</sup></label> <input type="text"
					class="form-control" id="phoneNo" name="phoneNo"
					placeholder="Enter phone number" required="required" maxlength="10">
			</div>
			<div class="form-group">
				<label for="email">Email<sup>*</sup></label> <input type="email"
					class="form-control" id="email"
					aria-describedby="emailHelp" name="email" placeholder="Enter email"
					required="required">
			</div>
			
			<div class="form-group">
				<label for="password">Password For Online Banking<sup>*</sup></label> <input
					type="password" class="form-control" id="password" name="password"
					placeholder="Enter password" required="required" minlength="6"
					maxlength="15">
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
			<%-- <div class="alert alert-success" role="alert">
			${message }</div> --%>
		</form>
	</div>
</body>
</html>