<%--
  Created by IntelliJ IDEA.
  User: taras
  Date: 6/15/2017
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/startmin.css" rel="stylesheet">
    <link href="../../css/allPagesMarginTop.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="../../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
</head>
<body>
<jsp:include page="adminPanel.jsp"/>
<div class="container margin_top">
    <%--<c:forEach var="commodity" items="${user.commodities}">--%>
    <div class="row">
        <div class="col-sm-12 col-md-10 col-md-offset-1">
            <table class="table table-hover">
                <c:forEach var="commodity" items="${user.commodities}">
                <thead>
                <tr>
                    <th><spring:message code="label.commodity"/></th>
                    <%--<th><spring:message code="label.quantity"/></th>--%>
                    <th class="text-center"><spring:message code="label.price"/></th>
                    <%--<th class="text-center"><spring:message code="label.total"/></th>--%>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="${commodity.pathImage}" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">${commodity.name}</a></h4>
                                <%--<h5 class="media-heading"> by <a href="#">Brand name</a></h5>--%>
                                <span><spring:message code="label.status"/></span><span class="text-success"><strong><spring:message code="label.inStock"/></strong></span>
                            </div>
                        </div></td>
                    <%--<td class="col-sm-1 col-md-1" style="text-align: center">--%>
                        <%--<select id="quantity">--%>
                            <%--<option value="1">1</option>--%>
                            <%--<option value="2">2</option>--%>
                            <%--<option value="3">3</option>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                    <td class="col-sm-1 col-md-1 text-center" id="commodityPrice">${commodity.price}</td>
                    <%--<td class="col-sm-1 col-md-1 text-center" id="totalPrice"></td>--%>
                    <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-default">
                            <a href="/deleteFromCart/${user.id}/${commodity.id}" style="text-decoration: none">
                                 <span class="glyphicon glyphicon-remove"></span><spring:message code="label.delete"/>
                            </a>
                        </button>

                    </td>
                </tr>
                </tbody>
                </c:forEach>
                <tbody>
                <%--<tr>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <%--<td></td>--%>
                    <%--<td><h3><spring:message code="label.total"/></h3></td>--%>
                    <%--<td class="text-right"><h3><strong id="totalPrice"></strong></h3></td>--%>
                <%--</tr>--%>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span><a href="/"><spring:message code="label.ContinueShopping"/></a>
                        </button>
                    </td>
                    <td>
                        <form:form action="/buy/${user.id}">
                        <button type="submit" class="btn btn-success">
                            <spring:message code="label.buy"/>
                        </button>
                        </form:form>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--<script>--%>
    <%--$(document).ready(function () {--%>
        <%--$('#commodityPrice').on('change', function () {--%>
            <%--$('#totalPrice').val(valueFunction());--%>
        <%--});--%>
        <%--$('#quantity').on('change', function () {--%>
            <%--$('#totalPrice').val(valueFunction());--%>
        <%--});--%>
    <%--});--%>
    <%--function valueFunction(quan) {--%>
        <%--var $selection = $('#commodityPrice').getAttribute().val();--%>
        <%--var quantity = $('#quantity').val();--%>
        <%--var total = 0;--%>
        <%--$selection.each(function () {--%>
            <%--total +=$(this).data('price')*quantity;--%>
        <%--});--%>
        <%--return total;--%>
    <%--}--%>
    <%--console.log('sdf');--%>
<%--</script>--%>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/cart.js"></script>

</body>
</html>
