<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;1,600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.15.4/css/all.css?fbclid=IwAR1YsW4Cd3uJltNc6k1kJ8R9VzNjmSXk9rjmW32BPoA6LWxNrZBCUY-D4i8">
    	<link rel="stylesheet" href="hbf.css">
    	
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<title>Header</title>
</head>
<body>

	<div class="header">
		<div class="h1">
			<h1>SUCCESS SHOP</h1>
		</div>
		<img src="media/logo/logo.png" style="width: 15%; height: auto;">
	</div>

	<div class="topnav">
		<div class="menu">
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="#">Products</a>
					<div class="dropnav">
						<ul>
							<li><a href='prsamsung.jsp'>Samsung</a></li>
							<li><a href='priphone.jsp'>IPhone</a></li>
							<li><a href='prphukien.jsp'>Phụ kiện</a></li>
						</ul>
					</div></li>
				<li><a href="aboutus.jsp">About us</a>
					<div class="dropnav">
						<ul>
							<li><a href='#'>Vision</a></li>
							<li><a href='#'>Mission</a></li>
							<li><a href='#'>Values</a></li>
							<li><a href='aboutus.jsp'>Contact</a></li>
						</ul>
					</div></li>
					

        			<li class="home-signup" style="margin-left: 0px;margin-right: -40px;float: right;margin-top: 0px"><a href="register.jsp">SignUp</a></li>
					<li class="home-login" style="margin-left: 30px;margin-right: -10px;margin-top: 0px;float: right;"><a href="login.jsp">SignIn</a></li>
          			<li style="width:10%; float: right; margin-right: -80px;margin-top: 10px;"><i class="fas fa-power-off"></i></li>
					
			</ul>
		</div>
		
	<form id="form" action="/PRJ321x_Assignment_3/searchServlet" method="post">
	<input type="hidden" name="action" value="dosearch"/>
		<div class="navsearch">
			<input style="float: right;" type="search" placeholder="  Enter to search . . . <c:out value="${placeholder}"/>" name="searchProduct" ></input>
		</div>
  		
  <% String message = (String)request.getAttribute("message"); %>
  <%
  if(request.getAttribute("message") != null){
  %>
  <p id="error-search" style="display: absolute;margin-top: 0px;margin-right:125px;color: black;background-color: red;width: 25%;float: right; 
  "> <%= request.getAttribute("message") %> </p>
  <% } %>
			
	</form>
	
	</div>



</body>
</html>