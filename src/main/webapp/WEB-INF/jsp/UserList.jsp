<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>ICIN Bank</title>
</head>
<body>

<jsp:include page="home.jsp"></jsp:include>
	<div class="container" style="width:70%">
		<h2>Users List</h2>
		<br>

		<table class="table table-bordered table-hover" style="width: 60%">
			<thead class="thead-dark">
				<tr>					
					<th>Account Number</th>
					<th>Account Holder Name</th>
					<th>Dob</th>
					<th>email</th>
					<th>Phone Number</th>				
					<th>Current balance</th>
					<!-- <th>Accept</th> -->
					<th>Reject</th>
				</tr>
			</thead>

			<tbody class="bg-warning">
				<c:forEach var="request" items="${users}">
					<tr>
						<td>${request.accountNumber }</td>
						<td>${request.name }</td>
						<td>${request.dob }</td>
						<td>${request.email }</td>
						<td>${request.phoneNumber }</td>
						<td>${request.balance }</td>
						<%-- <td><a href="request?id=${request.id}">Accept</a></td> --%>
						<td><a href="delete/${request.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>