<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<!DOCTYPE html>
	<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<%@ include file="../layout/header.jsp"%>
<div class="container">
	<form>

		<div class="form-group">
			<label for="title">Title:</label> 
			<h3>${board.title}</h3>
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<div>${board.content}</div>
		</div>

	</form>
	<!-- <button id="btn-save" class="btn btn-primary">save</button> -->
</div>
<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
<!-- src "/" : static폴더를 기본으로 찾아감. -->
<script src="/blog/js/border.js"></script>

<%@ include file="../layout/footer.jsp"%>