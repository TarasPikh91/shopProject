<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>City</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
	<link href="../../css/startmin.css" rel="stylesheet">
	<link href="../../css/allPagesMarginTop.css" rel="stylesheet">
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="row">
				<form:form class="form-horizontal" action="/city" method="post">
					<fieldset>

						<!-- Form Name -->
						<legend style="text-align: center"><spring:message code="label.newCity"/></legend>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${cityException}</span><br>
							<label class="col-md-4 control-label" for="cityName"><spring:message code="label.cityName"/></label>
							<div class="col-md-5">
								<input id="cityName" name="cityName" value="${city.name}" type="text" placeholder="City Name" class="form-control input-md">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirmation"></label>
							<div class="dropdown col-md-5">
								<select class="form-control form-control input-md required" name="countryId" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required arial-required="true">
									<c:choose>
										<c:when test="${empty city.country.name}">
											<option value=""><spring:message code="label.countryName"/></option>
											<c:forEach var="country" items="${countries}">
												<option value="${country.id}">${country.name}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="${city.country.id}">${city.country.name}</option>
											<c:forEach var="country" items="${countries}">
												<option value="${country.id}">${country.name}</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>

								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirmation"></label>
							<div class="col-md-4">
								<button id="confirmation" name="confirmation" class="btn btn-primary"><spring:message code="label.submit"/></button>
							</div>
						</div>

					</fieldset>
				</form:form>

			</div>
		</div>
	</div>
</div>

<div class="container">
	<table class="table table-bordered control-label">
		<thead>
		<tr>
			<td><spring:message code="label.cityName"/></td>
			<td><spring:message code="label.country"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="city" items="${cities}">
			<tr>
				<td>${city.name}</td>
				<td>${city.country.name}</td>
				<td><a href="/deleteCity/${city.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateCity/${city.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>