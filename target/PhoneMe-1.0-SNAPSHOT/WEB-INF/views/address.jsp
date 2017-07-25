<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
	<link href="../../css/startmin.css" rel="stylesheet">
	<link href="../../css/allPagesMarginTop.css" rel="stylesheet">
<title><spring:message code="label.address"/></title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="row">
				<form:form class="form-horizontal" action="/address" method="post">
					<fieldset>

						<!-- Form Name -->
						<legend style="text-align: center"><spring:message code="label.inputAddress"/></legend>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${streetEmptyException}</span><br>
							<label class="col-md-4 control-label" for="streetName"><spring:message code="label.streetName"/></label>
							<div class="col-md-5">
								<input id="streetName" name="streetName" value="${address.street}" type="text" placeholder="Street Name" class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="text-align: right; color: red">${houseNumberException}</span><br>
							<label class="col-md-4 control-label" for="houseNumber"><spring:message code="label.houseNumber"/></label>
							<div class="col-md-5">
								<input id="houseNumber" name="houseNumber" value="${address.houseNumber}" type="text" placeholder="House Number" class="form-control input-md">

							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${districtEmptyException}</span><br>
							<label class="col-md-4 control-label" for="districtName"><spring:message code="label.districtName"/></label>
							<div class="col-md-5">
								<input id="districtName" name="districtName" value="${address.district}" type="text" placeholder="District Name" class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirmation"></label>
							<div class="dropdown col-md-5">
								<select class="form-control form-control input-md required" name="cityId" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false" required arial-required="true">
									<c:choose>
										<c:when test="${empty address.city.name}">
											<option value=""><spring:message code="label.cityName"/></option>
											<c:forEach var="city" items="${cities}">
												<option value="${city.id}">${city.name}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="${address.city.id}">${address.city.name}</option>
											<c:forEach var="city" items="${cities}">
												<option value="${city.id}">${city.name}</option>
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
	<table id="table" class="table table-bordered">
		<thead>
		<tr>
			<th>ID</th>
			<th><spring:message code="label.streetName"/></th>
			<th><spring:message code="label.houseNumber"/></th>
			<th><spring:message code="label.districtName"/></th>
			<th><spring:message code="label.city"/></th>
			<th><spring:message code="label.delete"/></th>
			<th><spring:message code="label.update"/></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="address" items="${addresses}">
			<tr>
				<td>${address.id}</td>
				<td>${address.street}</td>
				<td>${address.houseNumber}</td>
				<td>${address.district}</td>
				<td>${address.city.name}</td>
				<td><a href="/deleteAddress/${address.id}"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateAddress/${address.id}"><spring:message code="label.update"/></a></td>
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