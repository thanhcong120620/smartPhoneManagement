<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;1,600&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.15.4/css/all.css?fbclid=IwAR1YsW4Cd3uJltNc6k1kJ8R9VzNjmSXk9rjmW32BPoA6LWxNrZBCUY-D4i8">
    	<link rel="stylesheet" href="hbf.css">

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
					<li class="home-login"><i class="fas fa-power-off"></i><a href="login.jsp">SignIn</a></li>
					<li class="home-signup"><a href="register.jsp">SignUp</a></li>
			</ul>
		</div>

		<div class="navsearch">
			<input style="float: right" type="search"
				placeholder="  Enter to search..." />
		</div>
	</div>

</body>
</html>