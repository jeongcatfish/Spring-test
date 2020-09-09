<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
	<!DOCTYPE html>
	<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

	<%@ include file="layout/header.jsp"%>
	<div class="container">
		<h2>Card Image</h2>
		<div class="card m-1"">
			<div class="card-body">
				<h4 class="card-title">제목</h4>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<div class="card m-1"">
			<div class="card-body">
				<h4 class="card-title">제목</h4>
				<p class="card-text">내용 부분</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
		<div class="card m-1"">
			<div class="card-body">
				<h4 class="card-title">제목</h4>
				<p class="card-text">내용 부분</p>
				<a href="#" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</div>

</body>
	</html>

</div>

<%@ include file="layout/footer.jsp"%>


