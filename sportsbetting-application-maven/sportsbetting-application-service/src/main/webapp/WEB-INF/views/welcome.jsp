<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.sportsbetting.domain.*" %>

<html>
<head>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/custom.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<title>Sportsbetting App</title>
</head>
<body>



<div class="container-fluid">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >

  <a class="navbar-brand" href="#">SportsBetting</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Events</a>
      </li>

  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Language
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#lang=EN">English</a>
          <a class="dropdown-item" href="#lang=HU">Magyar</a>
        
        </div>
      </li>

 
    </ul>
  </div>
   <form action="/sportsbetting-application-service/logout" method="post">
   <button type="submit" class="btn btn-outline-light" style="float: right;">Logout</button>
	</form>
   
</nav>


<div class="container-fluid" style="padding-top:20px;">
<div class="card border-primary mb-3">
  <div class="card-header text-white bg-primary mb-3">
    Account details
  </div>
  <form action="/sportsbetting-application-service/add" method="post">
  <div class="card-body">
    <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
  </div>
  <input name="inputname" value="${player.getName()}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Date of Birth</span>
  </div>
  <input value ="${player.getBirth()}" name="inputbirth" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Account number</span>
  </div>
  <input value ="${player.getAccountNumber()}" name="inputaccountnumber" type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Currency</span>
</div>
<select class="custom-select" id="inputGroupSelect01"  name="inputcurrency">
<option selected value="${player.getCurrency()}" style="display:none">${player.getCurrency()}</option>
    <c:forEach items="${currencies}" var="curr">
        <option value="${curr}">${curr}</option>
    </c:forEach>
    
  </select>
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Balance</span>
  </div>
  <input name="inputbalance" value ="${player.getBalance()}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>
<input value ="${player.getId()}" type="hidden" id="inputid" name="inputid">
   <input name="Save" class="btn btn-primary" type="submit" value="Save">
  </div>
  </form>
</div>


<div class="card border-primary mb-3">
  <div class="card-header text-white bg-primary mb-3">
    Account details
  </div>
  <div class="card-body">
<table class="table">
  <thead>
    <tr>
     <th scope="col"> </th>
      <th scope="col">#</th>
      <th scope="col">Event title</th>
      <th scope="col">Event type</th>
      <th scope="col">Bet type</th>
      <th scope="col">Outcome value</th>
      <th scope="col">Outcome odd</th>
      <th scope="col">Wager amount</th>
      <th scope="col">Winner</th>
      <th scope="col">Processed</th>
    </tr>
  </thead>
  <tbody>
  <form action="/sportsbetting-application-service/delete" method="post">
  ${wagers}

	</form>
  </tbody>
</table>
</div>
</div>
</div>
</div>
<!-- 

-->

</body>
</html>