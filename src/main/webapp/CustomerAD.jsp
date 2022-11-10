<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;1,600&display=swap" rel="stylesheet">

<title>Customer Admin</title>

	<style>
      .left {
        margin-top: 100px;
        margin-bottom: 50px;
        width: 25%;
        height: 350px;
        margin-left: 30px;
        float: left;
        border-right: 2px solid rgb(15, 1, 1);
      }
      .right {
        margin-top: 100px;
        margin-bottom: 50px;
        width: 70%;
        float: right;
      }
      table {
        width: 100%;
        margin-bottom: 25px;
      }
      th, td {
        border-bottom: 1px solid #ddd;
        text-align: center;
      }
      #update-result, #delete-result {
      	float: left;
        margin-right:50px;
      }

    </style>

</head>
<body>


<%@ include file = "header.jsp" %>




<div class="left">
<h2>Customer Admin</h2>
        <p style="font-weight: bold;"><c:out value="${message}"/></p>
      <form id="formLeft" action="/PRJ321x_Assignment_3/CustomerAdminServlet" method="post">
  <input type="hidden" name="action" value="dosubmit"/>

        <p>Your Name:</p>
        <input type="text" name="cus_name" placeholder="Enter your name" />
        <p>Your Phone number:</p>
        <input  type="text"  name="cus_phone" placeholder="Enter your phone number" />
        <br /> <br />
        <button class="submit">Display my cart</button>
        

        
      </form>
    </div>

    <!--Display information-->
    <div class="right">
      <table>
        <tr>
          <th>Your Name</th>
          <th>Your Phone number</th>
          <th>Your product</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Amount</th>
        </tr>

        <tr>
          <td><c:out value="${cus_name}"/></td>
          <td><c:out value="${cus_phone}"/></td>
          <td><c:out value="${product_name}"/></td>
          <td><fmt:formatNumber value="${product_price}" maxFractionDigits="1" /></td>
          <td><fmt:formatNumber value="${quantity}" maxFractionDigits="1" /></td>
          <td><fmt:formatNumber value="${amount_product}" maxFractionDigits="1" /></td>
        </tr>

        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td style="font-weight: bold">Total</td>
          <td style="font-weight: bold"><fmt:formatNumber value="${total}" maxFractionDigits="1" /></td>
        </tr>
      </table>



            <!--Update-->
        <form id="update-result" action="/PRJ321x_Assignment_3/CustomerAdminServlet" method="get">
  		<input type="hidden" name="action2" value="doupdate"/>
  		
         <h3>Update Cart</h3>
        <p>Enter your product</p>
        <input type="text"  name="product_name"  placeholder="Enter your product name"  />
        <p>Enter quantity</p>
        <input type="text" name="quantity" placeholder="Enter quantity" />
        <br /> <br />
        <button>Change my cart</button>
          
                  <p style="color:red;"><c:out value="${messageUpdate}"/></p>
          
        </form>





      <!--delete-->
        <form id="delete-result" action="/PRJ321x_Assignment_3/CustomerAdminServlet" method="get">
  		<input type="hidden" name="action2" value="dodelete"/>
  		
          <h3>Delete Cart</h3>
          <p>Enter your product</p>
          <input type="text"  name="product_name"  placeholder="Enter your product name"  />
          <br /> <br />
          <button>Delete my cart</button>
          
                  <p style="color:red;"><c:out value="${messageDelete}"/></p>
          
        </form>

<p style="color:red;"><c:out value="${messageAction}"/></p>
      
      
      
      
    </div>

<%@ include file = "footer.jsp" %>

</body>
</html>