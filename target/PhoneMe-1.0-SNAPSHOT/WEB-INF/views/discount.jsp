<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Discount</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
	<div class="container margin_top">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<form:form class="form-horizontal" action="/discount" method="post">
						<fieldset>

							<!-- Form Name -->
							<legend style="text-align: center"><spring:message code="label.newDiscount"/></legend>

							<!-- Text input-->
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${discountNameException}</span><br>
								<label class="col-md-4 control-label" for="name"><spring:message code="label.discountName"/></label>
								<div class="col-md-5">
									<input id="name" name="name" type="text" value="${discount.name}" placeholder="Discount Name" class="form-control input-md">
								</div>
							</div>
							<%--Text input--%>
							<div class="form-group">
								<span class="col-md-8" style="text-align: right; color: red">${discountPercentException}</span><br>
								<label class="col-md-4 control-label" for="percent"><spring:message code="label.discountPercent"/></label>
								<div class="col-md-5">
									<input id="percent" name="percent" type="text" value="${discount.percent}" placeholder="Discount Percent" class="form-control input-md">
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
	<table class="table table-bordered">
		<thead>
		<tr>
			<td>ID</td>
			<td><spring:message code="label.discountName"/></td>
			<td><spring:message code="label.discountPercent"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<d:forEach var="discount" items="${discounts}">
			<tr>
				<td>${discount.id}</td>
				<td>${discount.name}</td>
				<td>${discount.percent}</td>
				<td><a href="/deleteDiscount/${discount.id}"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateDiscount/${discount.id}"><spring:message code="label.update"/></a></td>
			</tr>
		</d:forEach>
		</tbody>
	</table>
</div>

	<!-- script references -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>