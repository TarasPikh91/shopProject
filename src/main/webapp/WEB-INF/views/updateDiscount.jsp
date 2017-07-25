<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update Discount</title>
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
                <form id="update_form" class="form-horizontal" action="/updateDiscount/${currentDiscount.id}" method="post">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.updateDiscount"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="name"><spring:message code="label.discountName"/></label>
                            <div class="col-md-5">
                                <input id="name" value="${currentDiscount.name}" name="name" type="text" placeholder="Discount Name" class="form-control input-md">
                            </div>
                        </div>
                        <%--Text input--%>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="percent"><spring:message code="label.discountPercent"/></label>
                            <div class="col-md-5">
                                <input id="percent" value="${currentDiscount.percent}" name="percent" type="text" placeholder="Discount Percent" class="form-control input-md">
                            </div>
                        </div>

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
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateDiscount.js"></script>
</body>
</html>
