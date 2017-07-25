<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g" %>
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
<title>Guarantee</title>

</head>
<body>
<jsp:include page="adminPanel.jsp"/>
	<div class="container margin_top">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="row">
					<form:form class="form-horizontal" action="/guarantee" method="post">
						<fieldset>
							<%--Form Name--%>
							<legend style="text-align: center"><spring:message code="label.newGuarantee"/></legend>

							<%--Text Input--%>
							<div class="form-group">
								<span class="col-md-8" style="color: red; text-align: right">${guaranteeTimeException}</span><br>
								<label class="col-md-4 control-label" for="guaranteeTime"><spring:message code="label.guaranteeTime"/></label>
								<div class="col-md-5">
									<input id="guaranteeTime" name="guaranteeTime" value="${guarantee.guaranteeTime}" type="text" placeholder="Guarantee Time" class="form-control input-md radio">
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
			 <td><spring:message code="label.guaranteeTime"/></td>
			 <td><spring:message code="label.delete"/></td>
			 <td><spring:message code="label.update"/></td>
		 </tr>
		 </thead>
		 <tbody>
		 <g:forEach var="guarantee" items="${guaranties}">
			 <tr>
				 <td>${guarantee.id}</td>
				 <td>${guarantee.guaranteeTime}</td>
				 <td><a href="/deleteGuarantee/${guarantee.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
				 <td><a href="/updateGuarantee/${guarantee.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
			 </tr>
		 </g:forEach>
		 </tbody>
	 </table>
 </div>


 <!-- script references -->
 <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
</body>
</html>