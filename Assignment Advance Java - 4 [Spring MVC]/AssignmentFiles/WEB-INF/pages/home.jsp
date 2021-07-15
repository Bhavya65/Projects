<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<title><c:out value="${page }"></c:out></title>
</head>
<body>

	<div>

		<form:form action="login" method="post" modelAttribute="login">
			<div class="form-group">
				<form:input path="uname" cssClass="form-control"
					placeholder="Enter UserName" />
			</div>
			<div class="form-group">
				<form:input path="password" cssClass="form-control"
					placeholder="Enter Password" />
			</div>
			<div class="container text-center">
				<button class="btn btn-outline-success">Login</button>
				<button class="btn btn-outline-danger" type="reset">Reset</button>
			</div>
		</form:form>
	</div>
	<c:if test="${page=='FAILURE'}">
	
	<h1>TRY AGAIN</h1>
	<br>
	
	<form:form action="login" method="post" modelAttribute="login">
			<div class="form-group">
				<form:input path="uname" cssClass="form-control"
					placeholder="Enter UserName" />
			</div>
			<div class="form-group">
				<form:input path="password" cssClass="form-control"
					placeholder="Enter Password" />
			</div>
			<div class="container text-center">
				<button class="btn btn-outline-success">Login</button>
				<button class="btn btn-outline-danger" type="reset">Reset</button>
			</div>
		</form:form>
	
	
	</c:if>

	

	<c:if test="${page=='SUCCESS'}">

		<div class="container mt-3">
			<div class="row mt-5">
				<div class="col-md-2">
					<div class="list-group">
						<button type="button"
							class="list-group-item list-group-item-action active">
							Menu</button>

						<a href='<c:url value='/add'></c:url>'
							class="list-group-item
						list-group-item-action">Search
							Flight</a>
					</div>
				</div>
				<div class="col-md-10">
					<c:if test="${page=='HOME'}">
						<h1 class="text-center">Flights</h1>

						<c:forEach items="${springs}" var="t">

							<div class="card mt-1">
								<div class="card-body">
									<h3>
										<c:out value="${t.flightNo}" />

										<c:out value="${t.arrLoc}" />
										-
										<c:out value="${t.delLoc}" />
									</h3>
									<p>
										INR
										<c:out value="${t.fare}" />
										|
										<c:out value="${t.flightDur}" />
										hr Duration<br> Class Available -
										<c:out value="${t.class1}" />
										<br> Seat Available -
										<c:out value="${t.seatAvail}" />
										<br>
									</p>
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${page=='add'}">
						<h1 class="text-center">Enter Information</h1>
						<div class="mt-4">
							<form:form action="add" method="post" modelAttribute="spring">
								<div class="form-group">
									<form:input path="delLoc" cssClass="form-control"
										placeholder="Enter Departure Location" />
								</div>
								<div class="form-group">
									<form:input path="arrLoc" cssClass="form-control"
										placeholder="Enter Arrival Location" />
								</div>
								<div class="form-group">
									<form:input path="validTill" cssClass="form-control"
										placeholder="Enter travel date" />
								</div>
								<div class="form-group">
									<form:input path="class1" cssClass="form-control"
										placeholder="Enter Flight Class" />
								</div>
								<div class="form-group">
									<form:input path="OutPref" cssClass="form-control"
										placeholder="Enter Output Preferance" />
								</div>
								<div class="container text-center">
									<button class="btn btn-outline-success">Check</button>
									<button class="btn btn-outline-danger" type="reset">Reset</button>
								</div>
							</form:form>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>