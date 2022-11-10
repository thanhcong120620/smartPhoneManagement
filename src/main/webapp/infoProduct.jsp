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

<title>Product Description</title>


<style>
.body {
    padding: 10px;
}

.left {
    float: left;
    width: 30%;
    margin-left: 50px;
    margin-top: -325px;
}
.right {
    float: right;
    width: 70%;
    margin-top: 120px;

}
.right h2 {
    color: red;
}

.phoneName {
	text-align: center;
	position: absolute;
	margin-top: 70px;
	margin-left:220px;
	font-size: 30px;
}

</style>


</head>
<body>


<%@ include file = "header.jsp" %>


<%--Khai báo một DataSource ds với câu truy vấn theo id của hình, truyền vào tham số URL image --%>
<sql:setDataSource var="ds" dataSource="jdbc/webapp" />

<sql:query dataSource="${ds}" sql="select * from product_des where product_id=?" var="resultsdes">
 <sql:param>${param.product}</sql:param>
</sql:query>

<sql:query dataSource="${ds}" sql="select * from products where product_id=?" var="resultspro">
 <sql:param>${param.product}</sql:param>
</sql:query>




<%--Sau khi có kết quả truy vấn, chúng ta lấy giá trị và cho hiển thị lên màn hình: --%>
<c:set scope="page" var="productdes" value="${resultsdes.rows[0]}"></c:set>

<c:set scope="page" var="products" value="${resultspro.rows[0]}"></c:set>
<c:set scope="page" var="imgname" value="${products.product_img_source}"></c:set>





<h2 class="phoneName"><c:out value="${products.product_name}" /></h2>
<!-- Product description -->
<div class="right">


        <h2 class="price"><fmt:formatNumber value="${products.product_price}" maxFractionDigits="1" /></h2>

        <p><b>Màn hình: </b><c:out value="${productdes.manHinh}" /></p>
        <p><b>Hệ điều hành: </b><c:out value="${productdes.heDieuHanh}" /></p>
        <p><b>Camera sau: </b><c:out value="${productdes.camSau}" /></p>
        <p><b>Camera trước: </b><c:out value="${productdes.camTruoc}" /></p>
        <p><b>Chip: </b><c:out value="${productdes.chip}" /></p>
        <p><b>RAM: </b><c:out value="${productdes.ram}" /></p>
        <p><b>Bộ nhớ trong: </b><c:out value="${productdes.boNhoTrong}" /></p>
        <p><b>SIM: </b><c:out value="${productdes.sim_4G}" /></p>
        <p><b>Pin, Sạc: </b><c:out value="${productdes.pin}" /></p>


  <form id="form" action="/PRJ321x_Assignment_3/addToCartServlet" method="post">
  <input type="hidden" name="action" value="doaddtocart"/>
        <button class="cart" name="productname" value="${products.product_name}">Add to cart</button>

 </form>
</div>
 


<!-- Products -->
<div class="left">
<img style="width: 260px; height: 260px;" src="${pageContext.request.contextPath}/media/phone/${imgname}" />

</div>






<%@ include file = "footer.jsp" %>

</body>
</html>