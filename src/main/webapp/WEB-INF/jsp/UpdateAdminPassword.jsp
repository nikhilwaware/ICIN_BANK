<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>ICIN Bank</title>
<script type="text/javascript">
var check = function(){
	if (document.getElementById('password').value ==
	    document.getElementById('confirm_password').value)
		{
		 document.getElementById('message').style.color = 'green';
		    document.getElementById('message').innerHTML = 'Password matching';
		}
	else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'Password not matching';
	  }
}
</script>
</head>
<body>
	<div class="container" style="padding: 50px;">
		<h3>Admin Change Password</h3>
		<form action="adminUpdatePassword" method="post">

			<div class="form-group">
				<label for="email">User Name</label> 
				<input type="text" class="form-control" id="email" name="email" required="required">
			</div>
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="text" class="form-control" id="password" name="password" min="6" maxlength="15" required="required">
			</div>
			<div class="form-group">
				<label for="confirm_password">Password</label> 
				<input type="text" class="form-control" id="confirm_password" name="confirm_password" min="6" maxlength="15" required="required" onkeyup='check();'>
			</div>
			<p id="message"></p>
			<button type="submit" class="btn btn-info">Change Password</button>
		</form>

		<%-- <p style="color: green; font-size: 18px">${message}</p> --%>
	</div>
</body>
</html>