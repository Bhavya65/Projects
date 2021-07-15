<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>

<%@page import="java.math.BigInteger"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.awt.image.BufferedImage"%>

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
				<h2>Please select an image file to upload(Max 1 MB)</h2>
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

	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Uploaded Images</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Preview</th>
				<th>Size</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.file}" /></td>
					<%--                     <td><c:out value="${user.image}" /></td> --%>
					<%
					//write image
					try {
					    String imgName = "C:\\Users\\bhavyachhabra\\Pictures\\Camera Roll\\Tiger.jpg";
					    BufferedImage bImage = ImageIO.read(new File(imgName));//give the path of an image
					    ByteArrayOutputStream baos = new ByteArrayOutputStream();
					    ImageIO.write(bImage, "jpg", baos);
					    baos.flush();
					    byte[] imageInByteArray = baos.toByteArray();
					    baos.close();
					    String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
					%>
					<td><img class="img-responsive" height="50" width="50"
						src="data:image/jpg;base64, <%=b64%>" /></td>
					<%
					} catch (IOException e) {
					System.out.println("Error: " + e);
					}
					%>
					<td><c:out value="${user.size}" /></td>
					<td><a href="edit?id=<c:out value='${user.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>