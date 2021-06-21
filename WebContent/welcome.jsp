<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets\css\welcome.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<form action="Logout">
		<div class="navbar navbar-expand-lg navbar-light bg-light">	
			<h5 class="font-italic">Hello ${username} </h5>	
			<button type="submit" value="Logout" class="btn btn-primary ml-auto">Log out</button>	
		</div>
	</form>
	
	 <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); /// HTTP 1.1
		response.setHeader("Pragma", "no-cache"); /// HTTP 1.0
		response.setHeader("Expires", "0"); /// proxies
		
		if(session.getAttribute("username") == null){
			response.sendRedirect("login.jsp");
		}	
	%> 

		
	<table class="table table-dark" id="tablelist">
  		<thead>
		    <tr>      
		      <th scope="col">Student Name</th>
		      <th scope="col">address</th>
		      <th scope="col">class</th>
		    </tr>
  		</thead>
		<tbody>
			<c:forEach var="student" items="${studentList}">
		    <tr>
		      <td><c:out value='${student.studentName}' /> </td>
		      <td><c:out value='${student.address}' /></td>
		      <td><a href ="${pageContext.request.contextPath}/BookController?action=EDIT&id=${student.id}">Edit</a> /
		      	  <a href ="${pageContext.request.contextPath}/BookController?action=DELETE&id=${student.id}">Delete</a></td>
		    </tr>		      
		    </c:forEach>
  	    </tbody>  	    
	</table>	
	<a href="add.jsp" class="btn btn-info" role="button" id="addbutton">Add new student</a></p>
	<a href="${pageContext.request.contextPath}/StudentController?action=LIST" class="btn btn-info" role="button" id="showbutton">Show records</a></p>
</body>
</html>