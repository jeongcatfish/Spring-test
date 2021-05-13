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
		<form>
			<div class="form-group">
				<label for="username">User name:</label> <input type="text"
					class="form-control" placeholder="Enter Username" id="username">
			</div>

			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="password">
			</div>

			<div class="form-group">
				<label for="email">Email address:</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email">
			</div>

		</form>
		<button id="btn-save" class="btn btn-primary">회원가입</button>
	</div>
	<!-- src "/" : static폴더를 기본으로 찾아감. -->
	<script src="/js/user.js"></script>
	<%@ include file="../layout/footer.jsp"%>