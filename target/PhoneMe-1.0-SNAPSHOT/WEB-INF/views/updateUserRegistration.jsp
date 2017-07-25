<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

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
    <title>Update User Data</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form id="update_form" class="form-horizontal" action="/updateUserRegistration/${currentRegistration.id}?${_csrf.parameterName}=${_csrf.token}"
                      method="post" enctype="multipart/form-data">
                    <fieldset>
                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.update"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userFirstName"><spring:message code="label.firstName"/></label>
                            <div class="col-md-5">
                                <input id="userFirstName" value="${currentRegistration.firstName}" name="userFirstName" type="text" placeholder="Your first name" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userLastName"><spring:message code="label.lastName"/></label>
                            <div class="col-md-5">
                                <input id="userLastName" value="${currentRegistration.lastName}" name="userLastName" type="text" placeholder="Your Last name" class="form-control input-md">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userEmail"><spring:message code="label.email"/></label>
                            <div class="col-md-5">
                                <input id="userEmail" value="${currentRegistration.email}" name="userEmail" type="text" placeholder="Your email here" class="form-control input-md">
                                <span class="help-block">xxxxxxxxx@xxxxx.xxx</span>
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userLogin"><spring:message code="label.userLogin"/></label>
                            <div class="col-md-5">
                                <input id="userLogin" value="${currentRegistration.userLogin}" name="userLogin" type="text" placeholder="Your username"class="form-control input-md">
                            </div>
                        </div>

                        <!-- Password input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userPassword"><spring:message code="label.password"/></label>
                            <div class="col-md-5">
                                <input id="userPassword" value="${currentRegistration.password}" name="userPassword" type="password" placeholder="Password" class="form-control input-md">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="phoneNumber"><spring:message code="label.phoneNumber"/></label>
                            <div class="col-md-5">
                                <input id="phoneNumber" value="${currentRegistration.phoneNumber}" name="phoneNumber" type="text" placeholder="Your Phone Number" class="form-control input-md">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="userAge"><spring:message code="label.userAge"/></label>
                            <div class="col-md-5">
                                <input id="userAge" name="userAge" value="${currentRegistration.age}" type="text" placeholder="Your Age" class="form-control input-md">

                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-4 control-label" for="image"><spring:message code="label.image"/></label>
                            <div class="col-md-5">
                                <input id="image" name="image" type="file" class="form-control input-md">
                            </div>
                        </div>

                        <%--<!-- Password input-->--%>
                        <%--<div class="form-group">--%>
                        <%--<label class="col-md-4 control-label" for="confirmasipassword">Konfirma Password</label>--%>
                        <%--<div class="col-md-5">--%>
                        <%--<input id="confirmasipassword" name="confirmasipassword" type="password" placeholder="Confirmation password" class="form-control input-md" required="">--%>
                        <%--<span class="help-block">Type again your password</span>--%>
                        <%--</div>--%>
                        <%--</div>--%>
                        <!-- Button -->
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateUserRegistration.js"></script>
</body>
</html>
