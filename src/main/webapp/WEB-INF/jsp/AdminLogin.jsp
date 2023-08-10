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

		<h3>Admin Login</h3>

		<form action="Login" method="post"
			style="width: 400px; height: 220px;">
			<div class="form-group">
				<label for="an">Email<sup>*</sup></label> <input type="text"
					class="form-control" id="an" name="email" placeholder="Enter email" required="required">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password<sup>*</sup></label> <input
					type="password" class="form-control" id="password"
					name="password" placeholder="Enter Password" required="required">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
			<p style="color: red;">${errmsg}</p>
		</form>

		<a href="AdminRegistration" style="font-size: 25; color: red;">Create
			Account</a><br>
		<a href="AdminUpdatePassword" style="font-size: 25; color: red;">Change Password</a>
		
	</div>
</body>
</html>