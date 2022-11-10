<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/login1.css" />
<script defer src="JS/login.js"></script>
<title>Login</title>
</head>
<body>

<% String error = (String)session.getAttribute("error"); %>
<% String user = (String)session.getAttribute("user"); %>


	<div class="main">
  <img src="media/logo/ava.jpg" style="width: 100%; height: 100%;"></div>
</div>

<div class="left">    
     <!--Ava-->
     <div class="ima">
      <img src="media/login.png" height="250px" width="250px" alt="Login" >
  </div>
  
  <div class="singin">
    <h3>LOGIN</h3>
  </div>
  <div class="dndk">
    <a href="login.jsp" target="_blank">Sign in</a>
    <p>  |  </p>
    <a href="register.jsp" target="_blank">Sign up</a>
  </div>


  
  <!--Nhập thông tin vào Form-->
  <form id="form" action="/PRJ321x_Assignment_3/LoginServlet" method="post">
  <input type="hidden" name="action" value="dologin"/>
  
  <div class="login">
         
      <p>Username</p> 
      <input id="username" type="text" placeholder="Enter Username" name="username" >
      <div id="errorUser"></div>
      <br/>
      <p>Password</p>
      <input id="password" type="password" placeholder="Enter Password" name="password" >
      <div id="errorPassword"></div>

  </div>
      <!-- Nút đăng nhập-->
        <button type="submit" id="btlogin" onclick="myFunction()">Login in</button>


</form>





  <!--Lỗi đăng nhập-->
  <div id="errorLogin">
<p class="login-error"><%= request.getAttribute("message") %></a>
  </div>



  <!--Cuối trang-->
  <div class="remem"> 
    <input type="checkbox" style="display: inline-block">
    <p style="display: inline-block">Remember me</p>
    <a href="#">Forgot password</a>     
  </div>



</body>
</html>