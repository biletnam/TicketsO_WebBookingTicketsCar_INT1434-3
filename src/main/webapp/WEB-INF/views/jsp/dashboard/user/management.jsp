<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap User Management Data Table</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/custom-style.css"
	rel="stylesheet">
<style type="text/css">
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});

	function func_nextPage() {
		var next_element = document.getElementById("");
	}
</script>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h2>
							User <b>Management</b>
						</h2>
					</div>
					<div class="col-sm-7">
						<a href="#" class="btn btn-primary"><i class="material-icons">&#xE147;</i>
							<span>Add New User</span></a> <a href="#" class="btn btn-primary"><i
							class="material-icons">&#xE24D;</i> <span>Export to Excel</span></a>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>User Name</th>
						<th>Password</th>
						<th>Date Created</th>
						<th>Role</th>
						<th>Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listUser}" var="element">
						<tr>
							<td>1</td>
							<td><a href="#"><img src="/examples/images/avatar/1.jpg" class="avatar" alt="Avatar">${element.name}</a></td>
							<td>${element.password}</td>
							<td>null</td>
							<td></td>
							<td><span class="status text-success">&bull;</span> Active</td>
							<td><a href="#" class="settings" title="Settings"
								data-toggle="tooltip"><i class="material-icons">&#xE8B8;</i></a>
								<a href="#" class="delete" title="Delete" data-toggle="tooltip"><i
									class="material-icons">&#xE5C9;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">
					Showing <b>${num_per_page}</b> out of <b>${quantity}</b> entries
				</div>
				<ul class="pagination">
					<li id="page-previous" class="page-item disabled"><a href="#">Previous</a></li>
					<li class="page-item active"><a href="#" class="page-link">1</a></li>
					<li class="page-item"><a href="#" class="page-link">2</a></li>
					<li class="page-item"><a href="#" class="page-link">3</a></li>
					<li class="page-item"><a href="#" class="page-link">4</a></li>
					<li class="page-item"><a href="#" class="page-link">5</a></li>
					<li if="page-next" class="page-item"><a
						href="func_nextPage();" class="page-link">Next</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
