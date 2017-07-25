<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Country</title>
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
                <form:form id="update_form" class="form-horizontal" action="/country?${_csrf.parameterName}=${_csrf.token}" method="post">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.newCountry"/></legend>

                        <%--Text input--%>
                        <div class="form-group">
                            <span class="col-md-8" style="color: red; text-align: right">${countryNameException}</span><br>
                            <label class="col-md-4 control-label" for="countryName"><spring:message code="label.countryName"/></label>
                            <div class="col-md-5">
                                <input id="countryName" name="name" value="${country.name}" type="text" placeholder="Country Name" class="form-control input-md">
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
                <td><spring:message code="label.countryName"/></td>
                <td><spring:message code="label.delete"/></td>
                <td><spring:message code="label.update"/></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="country" items="${countries}">
                <tr>
                    <td>${country.name}</td>
                    <td><a href="/deleteCountry/${country.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
                    <td><a href="/updateCountry/${country.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- script references -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>



    <%--<input type="hidden" name="csrf_name"--%>
           <%--value="${_csrf.parameterName}" />--%>
    <%--<input type="hidden" name="csrf_value"--%>
           <%--value="${_csrf.token}" />--%>

    <%--<script>--%>
        <%--$('#saveCountry').click(function () {--%>
            <%--var country = {--%>
                <%--name : $('#countryName').val()--%>
            <%--};--%>

            <%--$.ajax({--%>
                <%--url : '/country?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),--%>
                <%--method : 'POST',--%>
                <%--contentType: 'application/json; charset=UTF-8',--%>
                <%--dataType: 'json',--%>
                <%--data: JSON.stringify(country),--%>
                <%--success: function (res) {--%>
                    <%--console.log(res);--%>
                <%--}--%>
            <%--})--%>
        <%--});--%>
    <%--</script>--%>
</body>
</html>