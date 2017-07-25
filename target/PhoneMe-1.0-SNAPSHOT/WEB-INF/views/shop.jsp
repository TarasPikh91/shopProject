<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Shop</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
	<div class="container margin_top">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<form:form class="form-horizontal" action="/shop" method="post">
						<fieldset>

							<!-- Form Name -->
							<legend style="text-align: center"><spring:message code="label.inputShop"/></legend>

							<%--Text input--%>
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${shopNameException}</span><br>
								<label class="col-md-4 control-label" for="name"><spring:message code="label.shopName"/></label>
								<div class="col-md-5">
									<input id="name" name="name" type="text" value="${shop.name}" placeholder="Shop Name" class="form-control input-md">
								</div>
							</div>
							<%--Text input	--%>
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${shopDescriptionException}</span><br>
								<label class="col-md-4 control-label" for="description"><spring:message code="label.shopDescription"/></label>
								<div class="col-md-5">
									<input id="description" name="description" value="${shop.description}" type="text" placeholder="Shop Description" class="form-control input-md">
								</div>
							</div>
							<%--Text input--%>
							<div class="form-group">
								<label class="col-md-4 control-label" for="confirmation"></label>
								<div class="dropdown col-md-5">
									<select class="form-control input-md" name="addressId" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required airal-required="true">
										<c:choose>
											<c:when test="${empty shop.address.district}">
												<option value=""><spring:message code="label.address"/></option>
												<c:forEach var="address" items="${addresses}">
													<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option value="${shop.address.id}">${shop.address.city.name}${shop.address.district}${shop.address.street}${address.houseNumber}</option>
												<c:forEach var="address" items="${addresses}">
													<option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
												</c:forEach>
											</c:otherwise>
										</c:choose>
									</select>
								</div>
							</div>
						<%--button --%>
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
	<table class="table table-bordered">
		<thead>
		<tr>
			<td>ID</td>
			<td><spring:message code="label.shopName"/></td>
			<td><spring:message code="label.shopDescription"/></td>
			<td><spring:message code="label.address"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="shop" items="${shops}">
			<tr>
				<td>${shop.id}</td>
				<td>${shop.name}</td>
				<td>${shop.description}</td>
				<td>${shop.address.city.name}${shop.address.district}${shop.address.street}${shop.address.houseNumber}</td>
				<td><a href="/deleteShop/${shop.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateShop/${shop.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
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