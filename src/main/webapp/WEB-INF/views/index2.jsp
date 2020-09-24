<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
.logo {
	color: #eeeeee;
}

td {
	text-align: center;
	color: #000000;
}

tr {
	text-align: center;
	color: #000000;
}

table {
	vertical-align: middle;
}
</style>


<!DOCTYPE html>
<html lang="en">
<head>
<title>ex</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

	<br>
	<div class="container">
	<button type="button" class="btn btn-primary" id = "addRows">add Rows</button>
		<h2>Bordered Table</h2>
		<p>The .table-bordered class adds borders on all sides of the
			table and the cells:</p>
		<table class="table table-bordered table table-inverse">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody id="my-tbody">
				<c:forEach var="board" items="${boards}">
					<tr>
						<td>${board.title}</td>
						<td>test</td>
						<td>john@testgg.com</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>

<script src="/blog/js/appendTest.js"></script>

<%@ include file="layout/footer.jsp"%>


