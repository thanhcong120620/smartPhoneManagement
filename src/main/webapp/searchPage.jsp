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
<title>Kết quả tìm kiếm</title>
</head>
<body>
<%@ include file = "header.jsp" %>



</br>
<h2>Kết quả tìm kiếm</h2>



<c:set scope="page" var="sqlHT" value="${searchProductHienThi}" />
<c:out value="${searchProductHienThi}"/>


<sql:setDataSource var="ds" dataSource="jdbc/webapp" />
<sql:query dataSource="${ds}" sql="sqlHT" var="resultProducts" />

<c:forEach var="sptk" items="${resultProducts.rows}" varStatus="row">
 		

<div class="general" class="ss1" name="ss1">
			
			<div class="image">			
    			<c:set scope="page" var="imgname" value="${sptk.product_img_source}"></c:set>
 				<a href="<c:url value="/infoProduct.jsp?action=product&product=${sptk.product_id}" />">
 					<img style="height: 225px; width:200px" src="${pageContext.request.contextPath}/media/phone/${imgname}" />
 				</a>   			
  			</div>
  
  			<div class="name">
    			<h3><c:out value="${sptk.product_name }"/></h3>
  			</div> 
  
  			<div class="price">
    			<h4><c:out value="${sptk.product_price }"/></h4>
  			</div> 
  
  			<div class="btn">
   				 <button type="button" name="ss1">Buy</button>
  			</div>
 		
</div>
 
	</c:forEach>















<%@ include file = "footer.jsp" %>
</body>
</html>