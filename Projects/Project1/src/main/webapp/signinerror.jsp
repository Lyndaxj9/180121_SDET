<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">

<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
	
<!--  notes for project:
		1) Use a front controller (filter) for the authentication page. -->
<script src="javascript/Ajax.js"></script>
</head>
<title>RRose Inc</title>
<body style="background-color:#2C3A50">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Rich Inc</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Info<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">FAQ</a></li>
            <li><a href="#">Events</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="signup.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="signin.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container" style="width:500px">
  <h2 style="color:white">Wrong email/password! Try again.</h2>
  <form class="form-horizontal" method="POST" action="Login.do">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email" style="color:white">Email:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" placeholder="Enter email" name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password" style="color:white">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" placeholder="Enter password" name="password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Log in</button>
      </div>
    </div>
  </form>
</div>
<div style="width:500px" class="container-fluid" class ="float-right">
		<div class="well" style="background-color:#161D23; border-color:black">
			<h1 style="color:white">Don't have an account?</h1>
			<h2><a style="color:#A1BFDE" href="signup.html">Click here to create one!</a></h2>
		</div>
</div>
</body>
</html>