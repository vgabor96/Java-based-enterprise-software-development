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
          <a class="dropdown-item" href="#">English</a>
          <a class="dropdown-item" href="#">Magyar</a>
        </div>
      </li>
    </ul>
  </div>
    <button type="button" class="btn btn-outline-light" style="float: right;">Logout</button>
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
   <input type="submit" value="Send">
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
	${wagers}
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