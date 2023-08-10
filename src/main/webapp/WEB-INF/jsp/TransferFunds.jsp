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
<div class="container" style="padding: 20px; width: 500px">
		<h2>Transfer Money</h2>
		<br>
		<form action="transferFunds" method="post">
			<div class="form-group">
				<label for="account-number1">From Account Number</label> <input
					type="text" class="form-control" id="account-number1"
					name="account-number1" placeholder="Enter Your Account Number" required="required">
			</div>
			<div class="form-group">
				<label for="account-number2">To Account Number</label> <input
					type="text" class="form-control" id="account-number2"
					name="account-number2" placeholder="Enter Beneficary Account Number" required="required">
			</div>
			<div class="form-group">
				<label for="amount">Amount</label> <input type="text"
					class="form-control" id="amount"
					placeholder="Enter Amount To Be Withdrawal" name="amount"
					required="required">
			</div>
			<button type="submit" class="btn btn-primary">Transfer</button>
		</form>
		
		<p style="color: green; font-size: 18px">${message}</p>
	</div>
</body>
</html>