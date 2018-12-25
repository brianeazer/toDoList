<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Home</title>
</head>
<body>
	<div class="container">
    	<h1>Create A Task</h1>
    	<div class="form-inline form-group mb-2">
    		<label for="date" class="sr-only">Date</label>
    		<input type="date" class="form-control" id="date" placeholder="date">
			<label for="description" class="sr-only">Description</label>
    		<input type="text" class="form-control" id="description" placeholder="description">
    		<button id="button1">create task</button>
    	</div>
    	<table class="table">
   				<c:forEach items="${tasksMap }" var="date">
   				<tbody class="accordion">
   				<tr> <th> ${date.key } </th> <th colspan="1"><button type="button" class="btn btn-dark btn-sm">view</button></th></tr>
   				</tbody>
   				<tbody style="display:none">
   					<c:forEach items="${date.value }" var="task">
   						<tr class="finishButton">
   							<td>${task.description }</td>
   							<td><button>${task.completed ? 'Done!' : 'Not completed'}</button></td>
   						</tr>
   					</c:forEach>
   					</tbody>
   				</c:forEach>
    	</table>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="/product-ajax.js"></script>
	<script src="/accordion.js"></script>
	<script src="/finishButton.js"></script>
</body>
</html>