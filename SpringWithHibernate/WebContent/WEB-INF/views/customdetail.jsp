<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<title>Details</title>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<br>

<div class = "container">

  <div class="list-group-item active">
   
   <h2> CRM - Customer Details </h2>
    
  </div>
 

  <br><br>
  
  
  <table class="table table-dark">
  <thead>
    <tr>
     
      <th scope="col">Address</th>
      <th scope="col">Facbook Account</th>
      
    </tr>
  </thead>
  
  
  
   <tbody>
    <tr>
     
      <td>${detail.address}</td>
      <td>${detail.facebook}</td>
     
    </tr>
    
  </tbody>
  
  
</table>

<br><br>


    <a href="home" class="btn btn-secondary btn-lg">Back to Home</a>


</div>







</body>
</html>