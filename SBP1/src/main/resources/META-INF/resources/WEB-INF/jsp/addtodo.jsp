<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
<title>Spring Boot MVC</title>
</head>
<body>

<div class="container">
<h1>Enter ToDo Details</h1>
  <form:form action="add-todo" method="post" modelAttribute="t1">
  	<div class="id"><form:input type="hidden" path="id"/></div>
    Description:<form:input type="text" placeholder="Enter ToDo Desc..." path="description" required="required"/>
    			<form:errors path="description" cssClass="text-warning	"/>	<br><br>	
    Target Date:<form:input type="text" path="targetdate"/>
    Done:<form:input type="text" path="done"/><br><br>	
  	<input type="submit" class="btn btn-success">
  </form:form>
</div>
<script src="webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
</body>
</html>