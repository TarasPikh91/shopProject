<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%--<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <title>Update Country</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form id="update_form" class="form-horizontal" action="/updateCountry/${currentCountry.id}?${_csrf.parameterName}=${_csrf.token}" method="post">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.updateCountry"/></legend>

                        <%--Text input--%>
                        <div class="form-group">
                            ${exception}
                            <label class="col-md-4 control-label" for="countryName"><spring:message code="label.countryName"/></label>
                            <div class="col-md-5">
                                <input id="countryName" value="${currentCountry.name}" name="name" type="text" placeholder="Country Name" class="form-control input-md">
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
                    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>

    <!-- script references -->
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/updateCountry.js"></script>
</body>
</html>
