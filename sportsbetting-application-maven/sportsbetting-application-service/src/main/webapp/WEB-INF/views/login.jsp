<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.sportsbetting.domain.*" %>

<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<link href="${pageContext.request.contextPath}/resources/main.css" rel="stylesheet">
<title>Sportsbetting App</title>
</head>
<body>
<div class="container-fluid">
<div class="jumbotron text-white" id="jumbotronwlecome">
<div class=container4>
<div>
 <h1 class="display-3 text-white  horizontal-center"> <b>Welcome to SportsBet!</b></h1>
  <p class="lead text-white  horizontal-center">Sports betting is the activity of predicting sports result and placing a wager on the outcome.</p>
</div>
 
</div>
</div> 
</div>

<div class="container">
 <h3 class=""><b id="pLoginorRegister">Login</b> or <b id="pLoginorRegister">Register</b> to start!</h3>
 </div>
   <div class="container">
 <div class="card border-primary mb-3" id="carborderLogin">
  <h4 class="card-header text-white bg-primary mb-3">Login</h4>
  <div class="card-body">

 <form name="f" th:action="@{/welcome}" method="post">               
            <fieldset>
            <div th:if="${param.error}" class="alert alert-error">    
                    Invalid username and password.
                </div>
		  <div class="input-group mb-3">
  			<input  placeholder="Email" type="text" id="username" name="username" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
			</div>
              
               <div class="input-group mb-3">
  			
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