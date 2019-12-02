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
 <h2 class="display-2">Login or Register to start!</h2>
 </div>
   <div class="container">
 <div class="card border-primary mb-3">
  <h5 class="card-header text-white bg-primary mb-3">Login</h5>
  <div class="card-body">

 <form name="f" th:action="@{/welcome}" method="post">               
            <fieldset>
                <legend>Please Login</legend>
                <div th:if="${param.error}" class="alert alert-error">    
                    Invalid username and password.
                </div>
                <div th:if="${param.logout}" class="alert alert-success"> 
                    You have been logged out.
                </div>
                <div>
                  <input placeholder="Email" type="text" id="username" name="username"/>        
                </div>
              
              <div>
                <input placeholder="Password" type="password" id="password" name="password"/>    
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