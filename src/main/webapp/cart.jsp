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
<link rel="stylesheet" href="css/cart.css" />
<title>My cart</title>
</head>
<body>
<%@ include file = "header.jsp" %>
</br>



    <div id="cart1">
<table>
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Amount</th>
    </tr>
    <tr>
        <td><c:out value="${productname}"/></td>
        <td><fmt:formatNumber value="${product_price}" maxFractionDigits="1" /></td>
        <td><c:out value="${quantity}"/></td>
        <td><fmt:formatNumber value="${amount_product}" maxFractionDigits="1" /></td>
    </tr>
    <tr>
        <td style="font-weight: bold;">Total</td>
        <td></td>
        <td></td>
        <td style="font-weight: bold;"><c:out value="${Total}"/></td>
    </tr>
</table>
</div>


<form id="cart2" action="/PRJ321x_Assignment_3/addToCartServlet" method="get">
  <input type="hidden" name="action2" value="dosubmit"/>
  
    <div class="item"><p>Your name:    </p><input id="cus_name" type="text" placeholder="Enter your name" name="cus_name"/></br></div>
    <div class="item"><p>Your age:     </p><input id="cus_age" type="text" placeholder="Enter your age" name="cus_age"/></br></div>
    <div class="item"><p>Your phone:   </p><input id="cus_phone" type="text" placeholder="Enter your phone" name="cus_phone"/></br></div>
    <div class="item"><p>Your mail:    </p><input id="cus_mail" type="text" placeholder="Enter your mail" name="cus_mail"/></br></div>
    <div class="item"><p>Your address: </p><input id="cus_address" type="text" placeholder="Enter your address" name="cus_address"/></br></div>
    <div class="item"><p>Discount code: </p><input id="order_discount" type="text" placeholder="Enter your discount code" name="order_discount"/></br></div>
    <div class="item"><p>Date: </p><input type="text" placeholder="Enter your date" name="order_date"/></br></div>
    
    <div class="btn">
    
        <button>Submit</button>
        
    </div>
    
       

</form>




<%@ include file = "footer.jsp" %>

</body>
</html>