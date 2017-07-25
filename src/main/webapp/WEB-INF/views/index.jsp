<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/index.css">
</head>
<body>
<div class="slider-area">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="../../css/img/brand1.png" alt="" width="150" height="100">
			</div>
			<div class="item">
				<img src="../../css/img/brand3.png" alt="" width="150" height="100">
			</div>

			<div class="item">
				<img src="../../css/img/brand4.png" alt="" width="150" height="100">
			</div>

			<div class="item">
				<img src="../../css/img/brand6.png" alt="" width="150" height="100">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>
<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">

			<span class="sr-only">Toggle navigation</span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>

			<span class="icon-bar"></span>

		</button>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/"><spring:message code="label.index"/></a></li>
					<%--<sec:authorize access="!isAuthenticated()">--%>
				<li><a href="/userRegistration"><spring:message code="label.userRegistration"/></a></li>
				<%--</sec:authorize>--%>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="/address"><spring:message code="label.address"/> </a></li>
				<li><a href="/city"><spring:message code="label.city"/></a></li>
				<li><a href="/country"><spring:message code="label.country"/></a></li>
				<li><a href="/shop"><spring:message code="label.shop"/> </a></li>
				<li><a href="/staff"><spring:message code="label.staff"/></a></li>
				<li><a href="/producer"><spring:message code="label.producer"/></a></li>
				<li><a href="/category"><spring:message code="label.category"/></a></li>
				<li><a href="/commodity"><spring:message code="label.commodity"/></a></li>
				<li><a href="/discount"><spring:message code="label.discount"/></a></li>
				<li><a href="/guarantee"><spring:message code="label.guarantee"/></a></li>
				</sec:authorize>
			</ul>
			<ul class="nav navbar-nav navbar-right">
					<li><a href="/?lang=ua">укр</a></li>
					<li><a href="/?lang=en">eng</a></li>
				<sec:authorize access="!isAuthenticated()">
					<li><a href="/logIn"><span class="glyphicon glyphicon-user"></span><spring:message code="label.your_Account"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li id="cart"><a href="/cart"><span class="glyphicon glyphicon-shopping-cart"></span><spring:message code="label.cart"/></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><form:form action="/logout" method="post">
						<button class="btn btn-default btn-sm" style="text-align: center; margin-top: 10px;">
							<span class="glyphicon glyphicon-log-out"></span><spring:message code="label.logOut"/>
					</button></form:form></li>
				</sec:authorize>
			</ul>
		</div>
</div>
</nav>
<main id="portfolio">
<div class="single-product-area">
	<div class="container">
		<c:forEach var="commodityWithCategory" items="${commodityCategory.content}">
			<c:set var = "string1" value = "${commodityWithCategory.categories}"/>
			<c:set var = "string2" value="${fn:replace(string1, ']' , '' )}"/>
			<c:set var = "string3" value="${fn:replace(string2, '[' , '' )}"/>
		<div class="row row-commodity">
			<div id="commodity" class="col-md-3 col-sm-6  ${string3}">
				<div class="single-product">
					<div class="product-f-image">
						<img src="${commodityWithCategory.pathImage}" alt="" width="200px" height="300px">
					</div>
					<h2>${commodityWithCategory.name}</h2>
					<div class="product-carousel-price">
						<ins>${commodityWithCategory.price}</ins>
					</div>
					<sec:authorize access="hasRole('ROLE_USER')">
						<div class="product-hover">
								<%--<a href="/like/${commodityWithCategory.id}" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i><spring:message code="label.like"/></a><br>--%>
								<a href="/addToCart/${commodityWithCategory.id}"  class="view-details-link"><i class="fa fa-link"></i><spring:message code="label.cart"/></a>
						</div>
					</sec:authorize>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</div>
</main>
<br>
<jsp:include page="sortPanel.jsp"/>
<footer>
	<div class="footer-top-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6">
					<div class="footer-about-us">
						<c:forEach var="shop" items="${shops}">
						<h2><span>${shop.name}</span></h2>
						<p>${shop.description}</p>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4 col-sm-6">
					<div class="footer-menu">
						<h2 class="footer-wid-title"><spring:message code="label.categories"/></h2>

							<ul id="filter">
								<li class="current"><a href="#"><spring:message code="label.all"/></a></li>
							<c:forEach var="category" items="${categories}">
								<li><a href="#">${category.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="col-md-4 col-sm-6">
					<div class="footer-newsletter">
						<h2 class="footer-wid-title"><spring:message code="label.newsLetter"/></h2>
						<p><spring:message code="label.newsLetterText"/></p>
						<div class="newsletter-form">
							<form:form class="form-horizontal" action="/email" method="post">
								<div class="form-inline"><spring:message code="label.getDetails"/>
									<input name="name" type="email" class="form-control input-md" placeholder="Email Address"/>
									<button id="confirmation" name="confirmation" class="btn btn-primary"><spring:message code="label.submit"/></button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> <!-- End footer top area -->

	<div class="footer-bottom-area">
	</div>
	</footer>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>
<script src="${pageContext.request.contextPath}/js/index.js"/>
<script src="${pageContext.request.contextPath}/js/angular.min.js"></script>
</body>
</html>


