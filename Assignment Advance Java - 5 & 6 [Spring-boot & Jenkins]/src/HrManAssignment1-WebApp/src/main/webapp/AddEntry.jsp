<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h3>Enter Details</h3>
		<form action="add">
			<table border="1" cellpadding="5">
				<tr>
					<th>Enter Employee Code</th>
					<th><input type="text" name="employeeCode" /></th>
				</tr>
				<tr>
					<th>Enter Employee Name</th>
					<th><input type="text" name="employeeName" /></th>
				</tr>
				<tr>
					<th>Enter Email</th>
					<th><input type="text" name="email" /></th>
				</tr>
				<tr>
					<th>Enter Location</th>
					<th><input type="text" name="location" /></th>
				<tr>
					<th>Enter Date of Birth</th>
					<th><input type="text" name="dateOfBirth" /></th>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /> <input type="reset" value="Cancel" /></td>
			</table>
		</form>
	</div>
</body>
</html>