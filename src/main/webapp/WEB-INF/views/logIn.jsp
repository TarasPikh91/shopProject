<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 6/6/2017
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <span class="col-md-7" style="color: red; text-align: right">${logInException}</span><br>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Log In</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div id="loginModal" class="modal show" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h1 class="text-center"><spring:message code="label.your_Account"/></h1>
            </div>
            <div class="modal-body">
                <form:form class="form col-md-12 center-block" action="/login" method="post">
                    <div class="form-group">
                        <input name="userLogin" type="text" class="form-control input-lg" placeholder="User Login"/>
                    </div>
                    <div class="form-group">
                        <input name="password" type="password" class="form-control input-lg" placeholder="Password"/>
                    </div>
                    <div class="form-group modal-footer">
                        <button class="btn btn-primary btn-lg btn-block" type="submit"><spring:message code="label.your_Account"/></button>
                        <span class="pull-left"><a href="/"><spring:message code="label.index"/></a></span>
                        <span class="pull-right"><a href="/userRegistration"><spring:message code="label.userRegistration"/></a></span>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
