<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
td {
	text-align: center;
}

tr {
	text-align: center;
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

	<table class="table table-dark table-hover">
		<thead>
			<tr>
				<th>beacon Name</th>
				<th>section</th>
				<th>status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="beacon" items="${beacons}">
				<tr>
					<td id = "${beacon.id}beacon">${beacon.name}</td>
					<td id = "${beacon.id}section">${beacon.section}</td>
					<td id = "${beacon.id}status">${beacon.status}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
<img id="wea" src="" alt="My Image">
</body>

<script src="/blog/js/user.js"></script>