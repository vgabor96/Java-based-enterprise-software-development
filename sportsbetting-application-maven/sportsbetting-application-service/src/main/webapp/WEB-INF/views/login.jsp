<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.sportsbetting.domain.*" %>

<html>
<head>
<script src="webjars/popper.js/1.16.0//dist/popper.min.js"></script>
 <script src="webjars/jquery/3.4.1/dist/jquery.min.js"></script>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> 
<script src="webjars/bootstrap/4.3.1/bootstrap.min.js"></script>
<title>Sportsbetting App</title>
</head>
<body>
<div class="container">
<div class="jumbotron" style="background:dark !important">
  <h1 class="display-2">Welcome to SportsBet!</h1>
  <p class="lead">Sports betting is the activity of predicting sports result and placing a wager on the outcome.</p>
  <hr class="my-4">
</div> 
</div>

<div class="container">
 <h4 class="display-3">Login or Register to start!</h4>
 </div>
   <div class="container">
 <div class="card border-primary mb-3">
  <h4 class="card-header text-white bg-primary mb-3">Login</h4>
  <div class="card-body">

 <form name="f" th:action="@{/welcome}" method="post">               
            <fieldset>
              
               
                    <div class="input-group mb-3">
  					<div class="input-group-prepend">
  
  			</div>
  			<input  placeholder="Email" type="text" id="username" name="username" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
              
               <div class="input-group mb-3">
  					<div class="input-group-prepend">
  			</div>
  			<input placeholder="Password" type="password" id="password" name="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
             
              
                <div class="form-actions">
                    <button  type="submit" class="btn btn-primary">Log in</button>
                </div>
            </fieldset>
        </form>
  </div>
</div>
</div> 

       



</body>
</html>