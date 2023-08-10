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
  <h2>Hi ${userName }</h2>
  <!-- <p>Use the .flex-column class to create a vertical nav:</p> -->
  <ul class="nav flex-column">
    <li class="nav-item">
      <a class="nav-link" href="UserProfile/${user.accountNumber }">Profile</a>
    </li>
      <li class="nav-item">
      <a class="nav-link" href="UserBalance/${user.accountNumber }">Bank Balance</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="DepositMoney">Deposit</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="WithdrawMoney">Withdrawal</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="TransferFunds">Fund Transfer</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="RequestChequeBook">Cheque Book</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="UserTransactions/${user.accountNumber }">Statement</a>
    </li>
  </ul>
</div>
</body>
</html>