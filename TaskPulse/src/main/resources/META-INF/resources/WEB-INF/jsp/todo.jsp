<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/5.2.2/css/bootstrap.min.css" rel="stylesheet">
<title>Your ToDo's</title>
</head>
<body>

	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="welcome">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="todolist">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="login">Logout</a></li>
	</ul>	
</nav>
<div class="container">
	<h1>Your ToDos</h1>
	<hr size="5" color="blue">
	<table>
		<thead>
			<tr>
				<th>Description &emsp;&emsp;&emsp;&emsp;&emsp;</th>
				<th>TargetDate &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</th>
				<th>Done &emsp;&emsp;&emsp;&emsp;&emsp;</th>
				<th>Delete &emsp;&emsp;&emsp;&emsp;&emsp;</th>
				<th>Update </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ltd}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetdate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add-ToDo</a>
</div>
 <script src="webjars/bootstrap/5.2.2/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.5.1/dist/jquery.min.js"></script>
</body>
</html>