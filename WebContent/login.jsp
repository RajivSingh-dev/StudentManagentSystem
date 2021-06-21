<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets\css\login.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Log in</title>
</head>
<body>
	
	<div class="frame">
		<div class="container">
			<div class="wrap">
				<form class="form" name="formlogin" action="Login" method="post">
		  			<div class="form-group">
		   				 <label class="labelsign" for="exampleInputUser">Name</label>
		    			 <input type="text" name="uname" class="form-control" placeholder="User name">   
		 			 </div>
		  			 <div class="form-group">
		   				 <label class="labelsign" for="exampleInputPassword1">Password</label>
		   				 <input type="password" name="pass" class="form-control" placeholder="Password">
		  			</div> 
		  			<button type="submit" class="btn btn-primary">Log in</button>		  			
		  			<p class="signup">Don't have an account?<a href="register.jsp">Sign Up</a></p>
		  		</form>
		  	</div>
	  	</div>
	  </div>
  
  	  
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>