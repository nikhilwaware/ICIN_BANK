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
	<div style="padding: 50px;">
		<h2>Cheque Book Requests</h2>
		<br>

		<table class="table table-bordered table-hover" style="width: 60%">
			<thead class="thead-dark">
				<tr>					
					<th>Account Number</th>
					<th>Leaf Size</th>
					<th>Status</th>
					<th>Date</th>					
				<!--<th>Edit</th> -->
					<th>Reject</th>
				</tr>
			</thead>

			<tbody class="bg-warning">
				<c:forEach var="cheque" items="${rcb}">
					<tr>
						<td>${cheque.accountNumber }</td>
						<td>${cheque.leafSize }</td>
						<td>${cheque.status }</td>
						<td>${cheque.date }</td>						
						<%-- <td><a href="cheque/${cheque.id}">Edit</a></td> --%>
						<td><a href="deleteCheque/${cheque.id}">Reject</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>