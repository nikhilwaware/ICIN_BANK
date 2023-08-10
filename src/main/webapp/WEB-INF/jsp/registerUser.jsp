<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<title>ICIN User Registration</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
	<div class="container">
		<h1>User Registration</h1>
		<h2>We provide account number of your choice</h2>
		<form action="add-user" method="post">

			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="Enter name"
					required="required">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input type="email"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" name="email" placeholder="Enter email"
					required="required">
			</div>
			<div class="form-group">
				<label for="dob">Date Of Birth</label> <input type="date"
					class="form-control" id="dob" name="dob" required="required">
			</div>
			<div class="form-group">
				<label for="phone-number">Phone Number</label> <input type="text"
					class="form-control" id="phone-number" name="phone-number"
					placeholder="Enter phone number" required="required" maxlength="10">
			</div>
			<div class="form-group">
				<label for="account-number">Account Number</label> <input
					type="text" class="form-control" id="account-number"
					name="account-number" maxlength="10"
					placeholder="Enter account number of your choice"
					required="required">
			</div>
			<div class="form-group">
				<label for="password">Password For Online Banking</label> <input
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