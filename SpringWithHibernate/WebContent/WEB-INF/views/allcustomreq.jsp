<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Requests</title>
</head>
<body>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<br>
<hr>





<div class = "container">

  <div class="list-group-item active">
   
   <h2> CRM - Customer Relationship Manger </h2>
    
  </div>
  <br>
  
    <a href="home" class="btn btn-secondary btn-lg">الرجوع الي القائمه</a>


  <br><br>
  
  
  <table class="table table-dark">
  <thead>
    <tr>
     
      <th scope="col">الطلب </th>
      <th scope="col">تاريخ الشراء</th>
      <th scope="col">السعر</th>
      <th scope="col">الحذف</th>
     
    </tr>
  </thead>
  
  <c:forEach var="databind" items="${data}">
  
   <tbody>
    <tr>
     
      <td>${databind.req}</td>
      <td>${databind.date}</td>
      <td>${databind.price}</td>
      <td scope="col"><a href="deleteReq/${databind.reqId}/${databind.custom.id}"> حذف هذا الطلب </a></td>

     
    </tr>
    
  </tbody>
  
  </c:forEach>
  
 
</table>



</div>







</body>
</html>