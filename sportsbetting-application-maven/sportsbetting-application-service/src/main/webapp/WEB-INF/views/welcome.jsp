<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.example.sportsbetting.domain.*" %>
<html>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
	Example</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>
</head>
<body>
<div class="input-group mb-3">

</div>

<div class="container">
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
  </div>
  <input id="inputname" value="${name}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Date of Birth</span>
  </div>
  <input value ="${birth}" id="inputbirth" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Account number</span>
  </div>
  <input value ="${accountnumber}" id="inputaccountnumber" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Currency</span>
</div>
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-default">Balance</span>
  </div>
  <input id="inputbalance" value ="${balance}" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
</div>
</div>

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
<!-- 

-->
<script src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/bootstrap.min.css"></script>
</body>
</html>