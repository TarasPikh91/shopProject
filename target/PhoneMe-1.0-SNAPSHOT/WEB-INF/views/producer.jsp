<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Producer</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="row">
				<form class="form-horizontal" action="/producer?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
					<fieldset>

						<!-- Form Name -->
						<legend style="text-align: center"><spring:message code="label.newProducer"/> </legend>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${producerNameException}</span><br>
							<label class="col-md-4 control-label" for="name"><spring:message code="label.producerName"/></label>
							<div class="col-md-5">
								<input id="name" name="name" value="${producer.name}" type="text" placeholder="Producer Name" class="form-control input-md">
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="text-align: right; color: red">${producerEmailException}</span><br>
							<label class="col-md-4 control-label" for="email"><spring:message code="label.producerEmail"/></label>
							<div class="col-md-5">
								<input id="email" name="email" value="${producer.email}" type="email" placeholder="Producer Email" class="form-control input-md">
								<span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${producerPhoneNumberException}</span><br>
							<label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.producerPhone"/></label>
							<div class="col-md-5">
								<input id="phoneNumber" name="phoneNumber" value="${producer.phoneNumber}" type="text" placeholder="Phone Number" class="form-control input-md">
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
										<c:when test="${empty producer.shop.name}">
											<option value=""><spring:message code="label.shop"/></option>
											<c:forEach var="shop" items="${shops}">
												<option value="${shop.id}">${shop.name}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="${producer.shop.id}">${producer.shop.name}</option>
											<c:forEach var="shop" items="${shops}">
												<option value="${shop.id}">${shop.name}</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<%--Text input--%>
						<div class="form-group">
							<label class="col-md-4 control-lable" for="confirmation"></label>
							<div class="dropdown col-md-5">
								<select class="form-control form-control input-md" name="addressId" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false" required aria-required="true">
									<c:choose>
										<c:when test="${empty producer.address.district}">
											<option value=""><spring:message code="label.address"/></option>
											<c:forEach var="address" items="${addresses}">
												<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<option value="${producer.address.id}">${producer.address.city.name}${producer.address.district}${producer.address.street}${producer.address.houseNumber}</option>
											<c:forEach var="address" items="${addresses}">
												<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<%--image Input--%>
						<div class="form-group">
							<label class="col-md-4 control-label" for="image"><spring:message code="label.producerImage"/></label>
							<div class="col-md-5">
								<input id="image" name="image" type="file" value="${producer.pathImage}"
									   class="form-control input-md">
							</div>
						</div>
						<%--Button--%>
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
			<td><spring:message code="label.producerName"/></td>
			<td><spring:message code="label.producerEmail"/></td>
			<td><spring:message code="label.producerPhone"/></td>
			<td><spring:message code="label.shop"/></td>
			<td><spring:message code="label.address"/></td>
			<td><spring:message code="label.producerImage"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="producer" items="${producers}">
			<tr>
				<td>${producer.id}</td>
				<td>${producer.name}</td>
				<td>${producer.email}</td>
				<td>${producer.phoneNumber}</td>
				<td>${producer.shop.name}</td>
				<td>${producer.address.city.name}${producer.address.district}${producer.address.street}${producer.address.houseNumber}</td>
				<td><img src="${producer.pathImage}" alt="" width="100px" height="50px"></td>
				<td><a href="/deleteProducer/${producer.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateProducer/${producer.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
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