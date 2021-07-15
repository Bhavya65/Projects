<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Image Management Utility</title>
</head>
<body>
		<center>
			<h1 style="max-width: 380px; border: 2px solid #ccc;">Image Management Utility</h1>
		</center>
	<div align="center">
		<c:if test="${user != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>Edit file(Max 1 MB)</h2>
			</caption>
			<c:if test="${user != null}">
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
			</c:if>
			<tr>
				<th>File:</th>
				<td><input type="file" name="file" size="45"
					value="<c:out value='${user.file}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit" /> <input type="reset" value="Cancel" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>