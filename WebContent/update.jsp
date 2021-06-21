<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets\css\add.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Update student</title>
</head>
<body>
	<div class="frame">
		<div class="container">	
			<div class="wrap">
				<form class="form" action="StudentController" method="POST">
				  <div class="form-group">
			    	<label class="labeladd" for="exampleInputUser">Name</label>
			    	<input type="text" name="bname" class="form-control" id="inputadd" placeholder="Book name" value="${student.stuedntName}" required/>
			  	  </div>
			  	  <div class="form-group">
			    	<label class="labeladd" for="exampleInputPassword1">address</label>
			    	<input type="text" name="bauthor" class="form-control" id="inputadd" placeholder="Author" value="${student.address}" required/>
			  	  </div>
			  	    <input type = "hidden" name = "id" value = "${student.id}"/>
			  		<button type="submit" class="btn btn-primary" id="buttonadd">Save record</button>
			  	</form>
			 </div>	
		</div>  
	</div>
</body>
</html>