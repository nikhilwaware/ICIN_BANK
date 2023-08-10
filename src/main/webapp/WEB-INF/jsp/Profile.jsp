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
<title>ICIN Bank</title>
</head>
<body>
<jsp:include page="home.jsp"></jsp:include>
<br><br>
	<div class="container">
		<table class="table table-striped" style="padding: 30px">
			<tr>
				<td>Name :-</td>
				<td>${profile.name }</td>
			</tr>
			<tr>
				<td>Account Number :-</td>
				<td>${profile.accountNumber }</td>
			</tr>
			<tr>
				<td>Account Balance :-</td>
				<td>${profile.balance }</td>
			</tr>
			<tr>
				<td>Email :-</td>
				<td>${profile.email }</td>
			</tr>
			<tr>
				<td>Mobile No. :-</td>
				<td>${profile.phoneNumber }</td>
			</tr>
			<tr>
				<td>DoB :-</td>
				<td>${profile.dob }</td>
			</tr>
		</table>
	</div>

</body>
</html>