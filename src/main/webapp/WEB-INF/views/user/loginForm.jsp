<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="container">
	<!DOCTYPE html>
	<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="../layout/header.jsp"%>

	<div class="container">
		<form action="/auth/loginProc" method="post">

			<div class="form-group">
				<label for="username">Username:</label> 
				<input type="text" class="form-control" placeholder="Enter email" id="username" name ="username">
			</div>

			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" placeholder="Enter password" id="password" name ="password">
			</div>

<!-- 			<div class="form-group form-check"> -->
<!-- 				<label class="form-check-label">  -->
<!-- 				<input class="form-check-input" type="checkbox" name = "remember"> Remember me -->
<!-- 				</label> -->
<!-- 			</div> -->

			<button id="btn-login" class="btn btn-primary">로그인</button>
		</form>

	</div>
<!-- 	<script src="/js/user.js"></script> -->
	<%@ include file="../layout/footer.jsp"%>