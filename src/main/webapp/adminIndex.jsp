<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;1,600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.15.4/css/all.css?fbclid=IwAR1YsW4Cd3uJltNc6k1kJ8R9VzNjmSXk9rjmW32BPoA6LWxNrZBCUY-D4i8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/adminIndex.css" />
<title>Sucess Admin</title>
</head>
<body>


<% String user = (String)request.getAttribute("user"); %>
<script>alert("Welcome "+<%=user%>+" to Success Admin");</script>


<div class="main"><img src="media/logo/imgdes.jpg" alt="adminIndex" /></div>

<div class="left">
    <h3>Success Admin</h3>
<div class="lefttop">
    <!--Left top-->
    <div class="menu">
        <ul>
            <li><i class="far fa-address-card"></i><a href="home.jsp">Dashboard</a></li>
            <li><i class="fas fa-user-alt"></i><a href="StaffAD.jsp">Staff Admin</a></li>
            <li><i class="fas fa-shopping-cart"></i><a href="CustomerAD.jsp">Customer Admin</a></li>
        </ul>
    </div>
  
</div>



  <%
  if(request.getAttribute("user") != null){
  %>
  <br/>
  <p>Welcome user: <br/><%=user%></p>
  <% } %>



<!--Left bottom-->
<div class="leftbottom">
<form id="logout" action="/PRJ321x_Assignment_3/logoutServlet" method="post">
    <ul>
        <li><i class="fas fa-power-off"></i><br/><button href="#">Logout</button></li>
    </ul>
</div>  
</form>

</div> <!-- left -->




<div class="right">

<h3>Members</h3>
<div class="content">
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>MemberID</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>1</td>
        <td>Thành Công</td>
        <td>congntfx1509</td>
        <td>Chứng chỉ doanh nghiệp</td>
    </tr>
    <tr>
        <td>1</td>
        <td>Thành Công</td>
        <td>congntfx1509</td>
        <td>Chứng chỉ doanh nghiệp</td>
    </tr>


</table>
</div>

</div> 

</body>
</html>