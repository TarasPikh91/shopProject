
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="../../css/startmin.css" rel="stylesheet">
    <link href="../../css/allPagesMarginTop.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Commodity</title>
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="row">
                <form:form class="form-horizontal" action="/commodity?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
                    <fieldset>

                        <!-- Form Name -->
                        <legend style="text-align: center"><spring:message code="label.inputCommodity"/></legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <span class="col-md-8" style="color: red; text-align: right">${commodityNameException}</span><br>
                            <label class="col-md-4 control-label" for="commodityName"><spring:message code="label.commodityName"/></label>
                            <div class="col-md-5">
                                <input id="commodityName" name="commodityName" value="${Commodity.name}" type="text" placeholder="Commodity Name" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <span class="col-md-8" style="text-align: right; color: red">${commodityPriceException}</span><br>
                            <label class="col-md-4 control-label" for="commodityPrice"><spring:message code="label.commodityPrice"/></label>
                            <div class="col-md-5">
                                <input id="commodityPrice" name="commodityPrice" value="${Commodity.price}"  type="text" placeholder="Commodity Price" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <span class="col-md-8" style="color: red; text-align: right">${commodityDescriptionException}</span><br>
                            <label class="col-md-4 control-label" for="commodityDescription"><spring:message code="label.commodityDescription"/></label>
                            <div class="col-md-5">
                                <input id="commodityDescription" name="commodityDescription" value="${Commodity.description}" type="text" placeholder="Commodity Description" class="form-control input-md">
                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="discountsId" type="button"
                                        id="dropdownMenuButton" data-toggle="dropdown"
                                        aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                  <c:choose>
                                      <c:when test="${empty Commodity.discounts}">
                                          <option value=""><spring:message code="label.discount"/></option>
                                          <c:forEach var="discount" items="${discounts}">
                                              <option value="${discount.id}">${discount.name}</option>
                                          </c:forEach>
                                      </c:when>
                                      <c:otherwise>
                                          <c:forEach var="commodityDiscount" items="${Commodity.discounts}">
                                              <option value="${commodityDiscount.id}">${commodityDiscount.name}</option>
                                          </c:forEach>
                                          <c:forEach var="discount" items="${discounts}">
                                              <option value="${discount.id}">${discount.name}</option>
                                          </c:forEach>
                                      </c:otherwise>
                                  </c:choose>
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

                                    <c:choose>
                                        <c:when test="${empty Commodity.guarantee.guaranteeTime}">
                                            <option value=""><spring:message code="label.guarantee"/></option>
                                            <c:forEach var="guarantee" items="${guarantees}">
                                                <option value="${guarantee.id}">${guarantee.guaranteeTime}</option>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${Commodity.guarantee.id}">${Commodity.guarantee.guaranteeTime}</option>
                                            <c:forEach var="guarantee" items="${guarantees}">
                                                <option value="${guarantee.id}">${guarantee.guaranteeTime}</option>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </select>
                            </div>
                        </div>
                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="confirmation"></label>
                            <div class="dropdown col-md-5">
                                <select class="form-control form-control input-md" name="producerId" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                                    <c:choose>
                                        <c:when test="${empty Commodity.producer.name}">
                                            <option value=""><spring:message code="label.producer"/></option>
                                            <c:forEach var="producer" items="${producers}">
                                                <option value="${producer.id}">${producer.name}</option>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${Commodity.producer.id}">${Commodity.producer.name}</option>
                                            <c:forEach var="producer" items="${producers}">
                                                <option value="${producer.id}">${producer.name}</option>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
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


                                    <c:choose>
                                        <c:when test="${empty Commodity.categories}">
                                            <option value=""><spring:message code="label.category"/></option>
                                            <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach var="commodityCategory" items="${Commodity.categories}">
                                                <option  value="${commodityCategory.id}">${commodityCategory.name}</option>
                                            </c:forEach>
                                            <c:forEach var="category" items="${categories}">
                                                <option value="${category.id}">${category.name}</option>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
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
                </form:form>

            </div>
        </div>
    </div>
</div>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <td>ID</td>
            <td><spring:message code="label.commodityName"/></td>
            <td><spring:message code="label.commodityPrice"/></td>
            <td><spring:message code="label.commodityDescription"/></td>
            <td><spring:message code="label.image"/></td>
            <td><spring:message code="label.delete"/></td>
            <td><spring:message code="label.update"/></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="commodity" items="${commodities.content}">
            <tr>
                <td>${commodity.id}</td>
                <td>${commodity.name}</td>
                <td>${commodity.price}</td>
                <td>${commodity.description}</td>
                <td><img src="${commodity.pathImage}" alt="" width="50px" height="50px"></td>
                <td><a href="/deleteCommodity/${commodity.id}" style="text-decoration: none"><spring:message code="label.delete"/></a></td>
                <td><a href="/updateCommodity/${commodity.id}" style="text-decoration: none"><spring:message code="label.update"/></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="sortPanel.jsp"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>



