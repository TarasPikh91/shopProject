<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Producer</title>
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
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form id="update_form" class="form-horizontal" action="/updateProducer/${currentProducer.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.updateProducer"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name"><spring:message code="label.producerName"/></label>
                            <div class="col-md-5">
                                <input id="name" value="${currentProducer.name}" name="name" type="text" placeholder="Producer Name" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="email"><spring:message code="label.producerEmail"/></label>
                            <div class="col-md-5">
                                <input id="email" value="${currentProducer.email}" name="email" type="email" placeholder="Producer Email" class="form-control input-md">
                                <span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.producerPhone"/></label>
                            <div class="col-md-5">
                                <input id="phoneNumber" name="phoneNumber" value="${currentProducer.phoneNumber}" type="text" placeholder="Phone Number" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="shopId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <option value="${currentProducer.shop.id}">${currentProducer.shop.name}</option>
                                    <c:forEach var="shop" items="${shops}">
                                        <option value="${shop.id}">${shop.name}</option>
                                    </c:forEach>
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
                                    <option value="${currentProducer.address.id}">${currentProducer.address.city.name}${currentProducer.address.district}${currentProducer.address.street}${currentProducer.address.houseNumber}</option>
                                    <c:forEach var="address" items="${addresses}">
                                        <option value="${address.id}">${address.city.name}${address.district}${address.street}${address.houseNumber}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <%--input Image--%>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="image"><spring:message code="label.producerImage"/></label>
                            <div class="col-md-5">
                                <input id="image" name="image" type="file"
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

<!-- script references -->
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateProducer.js"></script>
</body>
</html>
