<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 5/23/2017
  Time: 1:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>Update Commodity</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form id="update_form" class="form-horizontal" action="/updateCommodity/${currentCommodity.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.updateCommodity"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="commodityName"><spring:message code="label.commodityName"/></label>
                            <div class="col-md-5">
                                <input id="commodityName" name="commodityName" value="${currentCommodity.name}" type="text" placeholder="Commodity Name" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="commodityPrice"><spring:message code="label.commodityPrice"/></label>
                            <div class="col-md-5">
                                <input id="commodityPrice" value="${currentCommodity.price}" name="commodityPrice" type="text" placeholder="Commodity Price" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="commodityDescription"><spring:message code="label.commodityDescription"/></label>
                            <div class="col-md-5">
                                <input id="commodityDescription" value="${currentCommodity.description}" name="commodityDescription" type="text" placeholder="Commodity Description" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="discountsId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <c:forEach var="commodityDiscounts" items="${commmodityWithDiscount.discounts}">
                                        <option value="${commodityDiscounts.id}">${commodityDiscounts.name}</option>
                                    </c:forEach>
                                    <c:forEach var="discount" items="${discounts}">
                                        <option value="${discount.id}">${discount.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <%--Text input--%>
                        <div class="form-group">
                            <label class="col-md-4 control-lable" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="guaranteeId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required aria-required="true">
                                    <option value="${currentCommodity.guarantee.id}">${currentCommodity.guarantee.guaranteeTime}</option>
                                    <c:forEach var="guarantee" items="${guaranties}">
                                        <option value="${guarantee.id}">${guarantee.guaranteeTime}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="producerId" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <option value="${currentCommodity.producer.id}">${currentCommodity.producer.name}</option>
                                    <c:forEach var="producer" items="${producers}">
                                        <option value="${producer.id}">${producer.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="categoriesId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <c:forEach var="commodityCategories" items="${commodityWithCategory.categories}">
                                        <option value="${commodityCategories.id}">${commodityCategories.name}</option>
                                    </c:forEach>
                                    <c:forEach var="category" items="${categories}">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <%--image--%>
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="image"><spring:message code="label.image"/></label>
                            <div class="col-md-5">
                                <input id="image" name="image" type="file" class="form-control input-md">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/updateCommodity.js"></script>
</body>
</html>
