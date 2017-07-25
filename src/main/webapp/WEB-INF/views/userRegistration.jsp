<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<title>Registration</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
	<div class="modal-dialog">
		<div class="modal-content">
	<div class="row">
		<form:form class="form-horizontal" action="/userRegistration?${_csrf.parameterName}=${_csrf.token}"
				   modelAttribute="user" method="post" enctype="multipart/form-data">
			<fieldset>
				<sec:authorize access="!isAuthenticated()">
				<!-- Form Name -->
				<legend style="text-align: center"><spring:message code="label.userRegistration"/></legend>

				<!-- Text input-->
				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userFirstNameException}</span><br>
					<label class="col-md-4 control-label" for="userFirstName"><spring:message code="label.firstName"/></label>
					<div class="col-md-5">
						<form:input path="firstName" id="userFirstName" value="${user.firstName}" type="text" placeholder="Your first name" class="form-control input-md"/>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<span class="col-md-8" style="text-align: right; color: red">${userLastNameException}</span><br>
					<label class="col-md-4 control-label" for="userLastName"><spring:message code="label.lastName"/></label>
					<div class="col-md-5">
						<form:input path="lastName" id="userLastName" value="${user.lastName}" type="text" placeholder="Your Last name" class="form-control input-md"/>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userEmailException}</span><br>
					<label class="col-md-4 control-label" for="userEmail"><spring:message code="label.email"/></label>
					<div class="col-md-5">
						<form:input id="userEmail" path="email" value="${user.email}" type="text" placeholder="Your email here" class="form-control input-md"/>
						<span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userLoginException}</span><br>
					<label class="col-md-4 control-label" for="userLogin"><spring:message code="label.userLogin"/></label>
					<div class="col-md-5">
						<form:input id="userLogin" path="userLogin" value="${user.userLogin}" type="text" placeholder="Your username" class="form-control input-md"/>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userPasswordException}</span><br>
					<label class="col-md-4 control-label" for="userPassword"><spring:message code="label.password"/></label>
					<div class="col-md-5">
						<form:input path="password" id="userPassword" value="${user.password}" type="password" placeholder="Password" class="form-control input-md"/>
					</div>
				</div>
				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userPhoneException}</span><br>
					<label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.phoneNumber"/></label>
					<div class="col-md-5">
						<form:input path="phoneNumber" id="phoneNumber" value="${user.phoneNumber}" type="text" placeholder="Your Phone Number" class="form-control input-md"/>
					</div>
				</div>

				<div class="form-group">
					<span class="col-md-8" style="color: red; text-align: right">${userAgeException}</span><br>
					<label class="col-md-4 control-label" for="userAge"><spring:message code="label.userAge"/></label>
					<div class="col-md-5">
						<form:input path="age" id="userAge" type="text" value="${user.age}" placeholder="Your Age" class="form-control input-md"/>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="image"><spring:message code="label.image"/></label>
					<div class="col-md-5">
						<input name="image" id="image" type="file" class="form-control input-md" required arial-required="true" value=""/>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="confirmation"></label>
					<div class="col-md-4">
						<button id="confirmation" name="confirmation" class="btn btn-primary"><spring:message code="label.submit"/></button>
					</div>
				</div>
				</sec:authorize>
			</fieldset>
		</form:form>

	</div>
</div>
	</div>
</div>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div class="container">
	<table class="table table-bordered">
		<thead>
		<tr>
			<th><spring:message code="label.firstName"/></th>
			<th><spring:message code="label.lastName"/></th>
			<th><spring:message code="label.userLogin"/></th>
			<th><spring:message code="label.email"/></th>
			<th><spring:message code="label.password"/></th>
			<th><spring:message code="label.phoneNumber"/></th>
			<th><spring:message code="label.userAge"/></th>
			<th><spring:message code="label.image"/></th>
			<th><spring:message code="label.delete"/> </th>
			<th><spring:message code="label.update"/></th>
		</tr>
		</thead>
		<tbody>
		<u:forEach var="userRegistration" items="${users}">
		<tr>
			<td>${userRegistration.firstName}</td>
			<td>${userRegistration.lastName}</td>
			<td>${userRegistration.userLogin}</td>
				<td>${userRegistration.email}</td>
				<td>${userRegistration.password}</td>
				<td>${userRegistration.phoneNumber}</td>
				<td>${userRegistration.age}</td>
				<td><img src="${userRegistration.pathImage}" alt="" width="50px" height="50px"></td>
				<td><a href="/deleteUserRegistration/${userRegistration.id}"><spring:message code="label.delete"/></a></td>
			<td><a href="/updateUserRegistration/${userRegistration.id}"><spring:message code="label.update"/></a></td>
		</tr>
		</u:forEach>
	</table>
</div>
</sec:authorize>
<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>