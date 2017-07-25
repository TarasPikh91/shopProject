<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"   %>
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
<title>Category</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="row">
				<form:form class="form-horizontal" action="/category" method="post">
					<fieldset>

						<!-- Form Name -->
						<legend style="text-align: center"><spring:message code="label.newCategory"/></legend>

						<!-- Text input-->
						<div class="form-group">
							<span class="col-md-8" style="color: red; text-align: right">${categoryNameException}</span><br>
							<label class="col-md-4 control-label" for="categoryName"><spring:message code="label.categoryName"/></label>
							<div class="col-md-5">
								<input id="categoryName" name="categoryName" value="${category.name}" type="text" placeholder="Category Name" class="form-control input-md">
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="confirmation"></label>
							<div class="dropdown col-md-5">
								<select class="form-control form-control input-md" name="shopId" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required arial-required="true">
								<c:choose>
									<c:when test="${empty category.shop.name}">
										<option value=""><spring:message code="label.shop"/></option>
										<c:forEach var="shop" items="${shops}">
											<option value="${shop.id}">${shop.name}</option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option value="${category.shop.id}">${category.shop.name}</option>
										<c:forEach var="shop" items="${shops}">
											<option value="${shop.id}">${shop.name}</option>
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
	<table class="table table-bordered">
		<thead>
		<tr>
			<td><spring:message code="label.categoryName"/></td>
			<td><spring:message code="label.shop"/></td>
			<td><spring:message code="label.delete"/></td>
			<td><spring:message code="label.update"/></td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td>${category.shop.name}</td>
				<td><a href="/deleteCategory/${category.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				<td><a href="/updateCategory/${category.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
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