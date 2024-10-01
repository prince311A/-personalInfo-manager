<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Student's</title>
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
<div class = "container  p-3">
<div class ="card">
<div class = "card-body">
<p class = "text-center fs-1">All Student Details</p>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Full Name</th>
      <th scope="col">DOB</th>
      <th scope="col">Address</th>
      <th scope="col">Qualification</th>
       <th scope="col">Email</th>
         <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <%
  StudentDao dao = new StudentDao(DBConnect.getConn());
  List<Student> list =dao.getAllStudent();
  for(Student s:list){
	  %>
	   <tr>
      <th scope="row"><%=s.getFullname() %></th>
      <td><%=s.getDob() %></td>
      <td><%=s.getAddress() %></td>
      <td><%=s.getQualification() %></td>
       <td><%=s.getEmail() %></td>
         <td><a href ="edit_student.jsp?id=<%=s.getId()%>" class = "btn btn-sm btn-primary">Edit</a>
         <a href = "delete?id=<%=s.getId() %>" class = "btn btn-sm btn-danger ms-1">Delete</a>
         </td>
         
    </tr>
	  
 <% }
  
  
  %>
 
  </tbody>
</table>
</div>


</div>
</div>
</body>
</html>