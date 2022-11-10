<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/register.css" />
<script defer src="JS/login.js"></script>
	<title>Register</title>
</head>
<body>
     <div class="main">
      <img src="media/logo/ava.jpg" style="width: 100%; height: 100%;"></div>
    </div>
   
    <div class="right">
    <!--Ava-->
    <div class="ima">
        <img src="media/login.png" height="250px" width="250px" alt="Login" >
    </div>
    
    <div class="singin">
      <h3>REGISTER</h3>
    </div>
    <div class="dndk">
      <a href="login.jsp" target="_blank">Sign in</a>
      <p>  |  </p>
      <a href="register.jsp" target="_blank">Sign up</a>
    </div>

  </div> <!--right-->


    <div class="left">
    <!--Nhập thông tin vào Form-->
    <form id="form" action="/PRJ321x_Assignment_3/LoginServlet" method="post">
    <input type="hidden" name="action" value="docreateaccount"/>
    
    <div class="login">
      <br/>
      <p>Full name</p> 
      <input id="fullName" type="text" placeholder="Enter your name" name="fullName" >
      <div id="errorFullName"></div>
      <p>Account Role</p> 
      <input id="age" type="text" placeholder="Enter account role" name="age" >
      <div id="errorAge"></div>
      <p>Phone Number</p> 
      <input id="phone" type="text" placeholder="Enter Phone Number" name="phone" >
      <div id="errorPhone"></div>
      <p>Address</p> 
      <input id="email" type="text" placeholder="Enter address" name="mail" >
      <div id="errorEmail"></div>
           
        <p>Username</p> 
        <input id="username" type="text" placeholder="Enter Username" name="username" >
        <div id="errorUser"></div>
        <p>Password</p>
        <input type="password" placeholder="Enter Password" name="password" id="password">
        <div id="errorPassword"></div>
        <p>Password again</p>
        <input type="password" placeholder="Enter Password" name="password2" id="password2">
        <div id="errorPassword2"></div>
    </div>
        <!-- Nút đăng nhập-->
          <button type="submit" id="btlogin">Register</button>
          </br>
			<p class="create-error" style="margin-left: 12px; margin-top: 20px; color: red;"><%= request.getAttribute("message") %></p>
        
  </form>



    <!--Cuối trang-->
    <div class="remem"> 
      <input type="checkbox" style="display: inline-block">
      <p style="display: inline-block">Remember me</p>
      <a href="#">Forgot password</a>     
    </div>

  </div> <!--left-->
</body>
</html>