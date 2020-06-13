<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
  
    <a href="customer/add" class="btn btn-secondary btn-lg">Add Customer</a>


  <br><br>
  
  
  <table class="table table-dark">
  <thead>
    <tr>
     
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">Gender</th>
      <th scope="col">Age</th>
      <th scope="col">Details</th>
      <th scope="col">Deleting</th>
      <th scope="col">Updating</th>
      <th scope="col">Adding Req</th>
      <th scope="col">All Requests</th>
      
      
    </tr>
  </thead>
  
  <c:forEach var="cus" items="${customers}">
  
   <tbody>
    <tr>
     
      <td>${cus.firstName}</td>
      <td>${cus.lastName}</td>
      <td>${cus.email}</td>
      <td>${cus.gender}</td>
      <td>${cus.age}</td>
      <td scope="col"><a href="customer/getDetails?id=${cus.id}"> More Details </a></td>
      <td scope="col"><a href="customer/delete?id=${cus.id}"> Delete Customer </a></td>
      <td scope="col"><a href="customer/update?id=${cus.id}"> Update Customer </a></td>
      
      <td scope="col"><a href="customer/addReq?id=${cus.id}"> Add Request </a></td>
      <td scope="col"><a href="customer/getRequests?id=${cus.id}"> Show All Request </a></td>
      
    </tr>
    
  </tbody>
  
  </c:forEach>
  
 
</table>



</div>







</body>
</html>