<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Summernote</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<div class="container">
				<label for="title">Title:</label> <input type="text"
					class="form-control" placeholder="Enter title" id="title">


				<label for="content">Content:</label> 
				<textarea class="summernote" rows="50" id="content"></textarea>

		<button id="btn-save" class="btn btn-primary">save</button>
	</div>
	<br>
  <script>
    $(document).ready(function() {
        $('.summernote').summernote({
        	placeholder:"hello",
        	tabsize:2,
        	height:300
        });
    });
  </script>
	<!-- src "/" : static폴더를 기본으로 찾아감. -->
	<script src="/js/border.js"></script>
</body>


<%@ include file="../layout/footer.jsp"%>