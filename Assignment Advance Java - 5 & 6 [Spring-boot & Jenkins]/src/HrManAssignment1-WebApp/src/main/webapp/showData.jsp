<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

	<div align="right">
		<table border="1" cellpadding="5">
			<tr>
				<th>Welcome User!</th>
				<th><a href="logout">Logout</a></th>
			</tr>
		</table>
	</div>
	<br><br>

	<div class="container" align="center">
		<div align="center">
			<form>
				<table border="1" cellpadding="5">
					<tr>
						<th><a href="upload">Upload Employee Details</a></th>
						<th><a href="download">Download Employee Details</a></th>
					</tr>
				</table>
			</form>
		</div>

		<h1 class="text-center">Data</h1>
		<table border="1" cellpadding="5">
			<tr>
				<th>Employee Code</th>
				<th>Employee Name</th>
				<th>Location</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${login}">
				<tr>
					<td><c:out value="${user.employeeCode}" /></td>
					<td><c:out value="${user.employeeName}" /></td>
					<td><c:out value="${user.location}" /></td>
					<td><c:out value="${user.email}" /></td>
					<td><c:out value="${user.dateOfBirth}" /></td>
					<td><a
						href="edit?employeeCode=<c:out value='${user.employeeCode}'/>">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>