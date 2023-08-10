<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>User Login</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
	<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo01"
			aria-controls="navbarTogglerDemo01" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="/">Home</a>
				</li>
			</ul>
		</div>
	</nav> -->

	<div class="container" style="padding-left: 10px">

		<h3>User Login</h3>

		<form action="UserPage" method="post"
			style="width: 400px; height: 220px;">
			<div class="form-group">
				<label for="an">Account Number<sup>*</sup></label> <input type="text"
					class="form-control" id="an" name="account-number" placeholder="Enter Accounr Number" required="required">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password<sup>*</sup></label> <input
					type="password" class="form-control" id="exampleInputPassword1"
					name="password" placeholder="Enter Password" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<p style="color: yellow;">${message}</p>
		</form>

		<a href="UserRegistration" style="font-size: 25; color: red;">Create Account</a><br>
		<a href="UserUpdatePassword" style="font-size: 25; color: red;">Change Password</a>	
		
	</div>


</body>
</html>