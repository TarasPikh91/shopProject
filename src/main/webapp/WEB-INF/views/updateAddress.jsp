<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link href="../../css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom Fonts -->
	<link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<!-- Custom CSS -->
	<link href="../../css/startmin.css" rel="stylesheet">
	<link href="../../css/allPagesMarginTop.css" rel="stylesheet">

        <title><spring:message code="label.updateAddress"/></title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
	<div class="container margin_top">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<form id="update_form" class="form-horizontal" action="/updateAddress/${currentAddress.id}" method="post">
						<fieldset>

							<!-- Form Name -->
							<legend style="text-align: center"><spring:message code="label.updateAddress"/></legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="streetName"><spring:message code="label.streetName"/></label>
								<div class="col-md-5">
									<input id="streetName" value="${currentAddress.street}" name="streetName" type="text" placeholder="Street Name" class="form-control input-md">
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="houseNumber"><spring:message code="label.houseNumber"/></label>
								<div class="col-md-5">
									<input id="houseNumber" value="${currentAddress.houseNumber}" name="houseNumber" type="text" placeholder="House Number" class="form-control input-md">

								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">

								<label class="col-md-4 control-label" for="districtName"><spring:message code="label.districtName"/></label>
								<div class="col-md-5">
									<input id="districtName" value="${currentAddress.district}" name="districtName" type="text" placeholder="District Name" class="form-control input-md">
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="dropdown col-md-5">
									<select class="form-control form-control input-md required" name="cityId" type="button"
											id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
										<option value="${currentAddress.city.id}">${currentAddress.city.name}</option>
										<c:forEach var="city" items="${cities}">
											<option value="${city.id}">${city.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="col-md-4">
									<button id="confirmation" name="confirmation" class="btn btn-primary"><spring:message code="label.submit"/> </button>
								</div>
							</div>

						</fieldset>
						<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
					</form>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateAddress.js"></script>
</body>
</html>