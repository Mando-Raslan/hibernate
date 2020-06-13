<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>



 <style type="text/css">
 
   .error {color:red}
 
 </style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<title>Requests</title>
</head>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<br>
<br>
<div class = "container">


<div class="list-group-item active">
   
   <h2> CRM - Customer Relationship Manger </h2>
    
  </div>
  <br>
  
    <a href="home" class="btn btn-secondary btn-lg">Back to Home</a>


  <br><br>
  




 
 
<form:form method="GET" action="reqadded" modelAttribute="CustomReqToShop">

  <div class="form-group">
   
    <form:hidden  path="reqId" />
    
  </div>


 <div class="form-group">
    <label for="req">الطلب</label>
    <form:input type="text" class="form-control" path="req" placeholder="الطلب"/>
    <form:errors path="req"  cssClass="error"/>
  </div>
 
  <div class="form-group">
    <label for="req">السعر</label>
    <form:input type="text" class="form-control" path="price" placeholder="السعر"/>
    <form:errors path="price"  cssClass="error"/>
  </div>
  
   <div class="form-group">
    <label for="req">تاريخ الطلب</label>
    <form:input type="date" class="form-control" path="date"  />
    <form:errors path="date"  cssClass="error"/>
  </div>
 
  <button type="submit" class="btn btn-primary">ِاضافه طلب</button>
</form:form>



</div>

</body>
</html>