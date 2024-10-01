<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    			
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Detail's</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
 rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class = "bg-light">
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Student Management System</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add_student.jsp">Add Student</a>
        </li>
      </ul>
      
    </div>
  </div>
</nav>

 <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="
sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" 
integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<div class = "container p-4">
<div class = "row">
<div class = "col-md-6 offset-md-3">
<div class ="card">
<div class = "card-body">
<p class = "fs-3 text-center">Edit Student</p>

<%
int id = Integer.parseInt(request.getParameter("id"));
StudentDao dao = new StudentDao(DBConnect.getConn());
Student s = dao.getStudent(id);

%>

<form action = "update" method = "post">
  <div class="mb-3">
    <label  class="form-label">Full Name</label>
    <input type="text" value= "<%=s.getFullname() %>" class="form-control" name = "name" >
  </div>
  <div class="mb-3">
    <label  class="form-label">Date Of Birth</label>
    <input value="<%=s.getDob() %>" type="date" class="form-control" name = "dob" >
  </div>
  <div class="mb-3">
    <label  class="form-label">Address</label>
    <input value="<%=s.getAddress() %>" type="text" class="form-control" name = "address" >
  </div>
  <div class="mb-3">
    <label  class="form-label">Qualification</label>
    <input value="<%=s.getQualification() %>" type="text" class="form-control" name = "qualification" >
  </div>
  <div class="mb-3">
    <label  class="form-label">Email address</label>
    <input value="<%=s.getEmail() %>" type="text" class="form-control" name = "email" >
  </div>
  <input type="hidden" name = "id" value = "<%=s.getId()%>">
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>
</div>
</div>
</div>
</div>
 </div>

</body>
</html>















