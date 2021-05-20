<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container">
	<!DOCTYPE html>
	<html lang="en">
<head>
<title>BE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

	<%@ include file="layout/header.jsp"%>
	<div class="container">
		<c:forEach var="board" items="${boards.content}">
		<script>console.log(boards.content)</script>
			<div class="card m-1"">
				<div class="card-body">
					<h4 class="card-title">${board.title}</h4>
					<a href="/blog/board/${board.id}" class="btn btn-prima ry">상세보기</a>
				</div>
			</div>
		</c:forEach>
		<ul class="pagination d-flex">
			<li class="page-item disabled"><a class="page-link" href="?page=1">Previous</a></li>
			<li class="page-item"><a class="page-link" href="?page=1">Next</a></li>
		</ul>
	</div>

</body>
	</html>

</div>

<%@ include file="layout/footer.jsp"%>


