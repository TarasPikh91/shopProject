<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="security"%>
<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 6/19/2017
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <!-- Top Navigation: Left Menu -->
        <ul class="nav navbar-nav navbar-left navbar-top-links">
            <li><a href="/"><i class="glyphicon glyphicon-home"></i><security:message code="label.index"/></a></li>
        </ul>

        <!-- Top Navigation: Right Menu -->
        <sec:authorize access="isAuthenticated()">
        <ul class="nav navbar-right navbar-top-links">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <span class="glyphicon glyphicon-menu-hamburger"></span> <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><form:form action="/logout" method="post">
                        <button class="btn btn-default btn-sm col-md-12">
                            <span class="glyphicon glyphicon-log-out"></span><security:message code="label.logOut"/>
                        </button></form:form></li>
                </ul>
            </li>
        </ul>
        </sec:authorize>
    </nav>
</div>
</body>
</html>
