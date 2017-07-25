<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update Data</title>

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
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form:form id="update_form" class="form-horizontal" action="/updateStaff/${currentStaff.id}?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" method="post">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.updateStaff"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="firstName"><spring:message code="label.firstName"/></label>
                            <div class="col-md-5">
                                <input id="firstName" value="${currentStaff.firstName}" name="firstName" type="text" placeholder="Your first name" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="lastName"><spring:message code="label.lastName"/></label>
                            <div class="col-md-5">
                                <input id="lastName" name="lastName" value="${currentStaff.lastName}" type="text" placeholder="Your Last name" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email"><spring:message code="label.email"/></label>
                            <div class="col-md-5">
                                <input id="email" name="email" value="${currentStaff.email}" type="text" placeholder="Your email here" class="form-control input-md">
                                <span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.phoneNumber"/></label>
                            <div class="col-md-5">
                                <input id="phoneNumber" value="${currentStaff.phoneNumber}" name="phoneNumber" type="text" placeholder="Your Phone Number" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="addressId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <option value="${currentStaff.address.id}">${currentStaff.address.city.name}${currentStaff.address.district}${currentStaff.address.street}${currentStaff.address.houseNumber}</option>
                                    <c:forEach var="address" items="${addresses}">
                                        <option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
                                    </c:forEach>
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
                                    <option value="${currentStaff.shop.id}">${currentStaff.shop.name}</option>
                                    <c:forEach var="shop" items="${shops}">
                                        <option value="${shop.id}">${shop.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="image"><spring:message code="label.image"/></label>
                            <div class="col-md-5">
                                <input id="image" name="image" value="${currentStaff.pathImage}" type="file" class="form-control input-md">
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
                </form:form>

            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateStaff.js"></script>
</body>
</html>
