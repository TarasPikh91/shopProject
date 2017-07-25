<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 6/27/2017
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="display: flex; justify-content: center; margin-left: 10%">

    <div class="col-md-12 col-xs-12">
        <div class="row">
            <div class="col-md-2 col-xs-6">
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort<span
                            class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <custom:sort innerHtml="name asc" paramValue="name"/>
                        <custom:sort innerHtml="name desc" paramValue="name,desc"/>
                    </ul>
                </div>
            </div>
            <div id="pageSize" class="col-md-6 col-xs-12 text-center">
                <custom:pageable page="${commodities}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
            </div>
            <div id="idCommodity" class="col-md-2 col-xs-6">
                <custom:size posibleSizes="1,2,5,10" title="size" size="${commodities.size}"/>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</body>
</html>
