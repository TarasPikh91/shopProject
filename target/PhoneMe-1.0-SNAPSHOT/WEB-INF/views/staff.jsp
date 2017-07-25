<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
	<link href="../../css/startmin.css" rel="stylesheet">
	<link href="../../css/allPagesMarginTop.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Staff</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
	<div class="container margin_top">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<form class="form-horizontal" action="/staff?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
						<fieldset>

							<!-- Form Name -->
							<legend style="text-align: center"><spring:message code="label.staffData"/></legend>

							<!-- Text input-->
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${emptyStaffFirstNameException}</span><br>
								<label class="col-md-4 control-label" for="firstName"><spring:message code="label.firstName"/></label>
								<div class="col-md-5">
									<input id="firstName" name="firstName" type="text" value="${staff.firstName}" placeholder="Your first name" class="form-control input-md">
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<span class="col-md-8" style="text-align: right; color: red">${emptyStaffLastNameException}</span><br>
								<label class="col-md-4 control-label" for="lastName"><spring:message code="label.lastName"/></label>
								<div class="col-md-5">
									<input id="lastName" name="lastName" type="text" value="${staff.lastName}" placeholder="Your Last name" class="form-control input-md">

								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${emptyStaffEmailException}</span><br>
								<label class="col-md-4 control-label" for="email"><spring:message code="label.email"/></label>
								<div class="col-md-5">
									<input id="email" name="email" type="text" value="${staff.email}" placeholder="Your email here" class="form-control input-md">
									<span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
								</div>
							</div>
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${emptyStaffPhoneException}</span><br>
								<label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.phoneNumber"/></label>
								<div class="col-md-5">
									<input id="phoneNumber" name="phoneNumber" value="${staff.phoneNumber}" type="text" placeholder="Your Phone Number" class="form-control input-md">
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="dropdown col-md-5">
									<select class="form-control form-control input-md" name="addressId" type="button"
											id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false" required arial-required="true">
										<c:choose>
											<c:when test="${empty staff.address.district}">
												<option value=""><spring:message code="label.address"/></option>
												<c:forEach var="address" items="${addresses}">
													<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="${staff.address.id}">${staff.address.city.name}${staff.address.district}${staff.address.street}${staff.address.houseNumber}</option>
												<c:forEach var="address" items="${addresses}">
													<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="dropdown col-md-5">
									<select class="form-control form-control input-md" name="shopId" type="button"
											id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false" required arial-required="true">
										<c:choose>
											<c:when test="${empty staff.shop.name}">
												<option value=""><spring:message code="label.shop"/></option>
												<c:forEach var="shop" items="${shops}">
													<option value="${shop.id}">${shop.name}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="${staff.shop.id}">${staff.shop.name}</option>
												<c:forEach var="shop" items="${shops}">
													<option value="${shop.id}">${shop.name}</option>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="image"><spring:message code="label.image"/></label>
								<div class="col-md-5">
									<input id="image" name="image" type="file" class="form-control input-md">
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="col-md-4">
									<button id="confirmation" name="confirmation" class="btn btn-primary"><spring:message code="label.submit"/></button>
								</div>
							</div>

						</fieldset>
						<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					</form>

				</div>
			</div>
		</div>
	</div>



<div class="container">
	<table class="table table-bordered">
		<thead>
		<tr>
			<td>ID</td>
			<td><spring:message code="label.firstName"/></td>
			<td><spring:message code="label.lastName"/></td>
			<td><spring:message code="label.email"/></td>
			<td><spring:message code="label.phoneNumber"/></td>
			<td><spring:message code="label.image"/></td>
			<td><spring:message code="label.address"/></td>
			<td><spring:message code="label.shop"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="staff" items="${staffs}">
			<tr>
				<td>${staff.id}</td>
				<td>${staff.firstName}</td>
				<td>${staff.lastName}</td>
				<td>${staff.email}</td>
				<td>${staff.phoneNumber}</td>
				<td><img src="${staff.pathImage}" alt="" width="50px" height="50px"></td>
				<td>${staff.address.city.name}${staff.address.district}${staff.address.street}${staff.address.houseNumber}</td>
				<td>${staff.shop.name}</td>
				<td><a href="/deleteStaff/${staff.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateStaff/${staff.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
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