<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
</head>
<body>
	<div align="center">
	<h3>Error while login, try again...</h3>
		<form action="login">
			<table border="1" cellpadding="5">
				<tr>
					<th>User Name</th>
					<th><input type="text" name="uname" /></th>
				</tr>
				<tr>
					<th>Password</th>
					<th><input type="password" name="pass" /></th>
				</tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /> <input type="reset" value="Cancel" />
				</td>
				</tr>
				<br>
			</table>
		</form>
	</div>
</body>
</html>