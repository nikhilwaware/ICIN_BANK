<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>ICIN Bank</title>
<style type="text/css">
#username {
font-size: 20px;
font-family: monospace;
}
a{
font-size: 20px;

}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
	
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
	      <li class="nav-item active">
	        <a class="nav-link" href="/" >Home <span class="sr-only">(current)</span></a>
	      </li>
	     </ul>
	    <% 
	    if(request.getAttribute("user")!=null){
	    %>
	    <span id="username" style="align-content: right;padding-right: 10px;">Welcome ${user.name}</span>
	    <ul class="navbar-nav mr-auto mt-2 mt-lg-0" style="align-content: right">
	      <li class="nav-item">
	        <a class="nav-link" href="/">Logout</a>
	      </li>
	    </ul>
	    <% 
	    }
	    else{
	    %>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0" style="align-content: right">
	      <li class="nav-item">
	        <a class="nav-link" href="UserLogin">User Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="AdminLogin">Admin Login</a>
	      </li>
	    </ul>
	   	<%
	    }
	   	%>    
	  </div>
	</nav>
</body>
</html>