<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <style type="text/css">
 
   .error {color:red}
 
 </style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


<br>
<div class = "container">


<form:form method="GET" action="savenewcustomer" modelAttribute="custom" >


<-- <div class="form-group">
    <label for="firstName">First Name</label>
    <form:input type="text" class="form-control" path="firstName" placeholder="First Name"/>
    <form:errors path="firstName"  cssClass="error"/>
  </div>
  <div class="form-group">
    <label for="lastName">Last Name</label>
    <form:input type="text" class="form-control" path="lastName" placeholder="Last Name"/>
    <form:errors path="lastName"  cssClass="error"/>
  </div>
  <div class="form-group">
    <label for="age">Age</label>
    <form:input type="text" class="form-control" path="age" placeholder="Age"/>
    <form:errors path="age"  cssClass="error"/>
  </div>
  <div class="form-group">
    <label for="email">Email</label>
    <form:input type="text" class="form-control" path="email" placeholder="Email"/>
    <form:errors path="email"  cssClass="error"/>
  </div>
  
  
   <div class="form-group">
    <label for="email">Address</label>
    <form:input type="text" class="form-control" path="detailcustomer.address" placeholder="Address"/>
    <form:errors path="detailcustomer.address"  cssClass="error"/>
  </div>
  
  
  
   <div class="form-group">
    <label for="facebook">FacebookAcount</label>
    <form:input type="text" class="form-control" path="detailcustomer.facebook" placeholder="FacebookAcount"/>
    <form:errors path="detailcustomer.facebook"  cssClass="error"/>
  </div>
  
  
  
  
  
  
  <div class="form-row">
    
    <div class="form-group col-md-4">
      <label for="gender">Gender</label>
      <form:select path="gender" class="form-control">
        <form:options items="${custom.genderlist}" />
      </form:select>
    </div>
    
  </div>
 


  <button type="submit" class="btn btn-primary">Sign in</button>
</form:form>


</div>

</body>
</html>