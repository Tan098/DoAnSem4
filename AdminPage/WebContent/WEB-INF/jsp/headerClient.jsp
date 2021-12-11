<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="header">
	<div class="container">
		<div id="welcomeLine" class="row">
			<div class="span6">
				<c:if test="${not empty client }">
					<b>Xin chào!</b>
					<strong>${sessionScope.client.name}</strong>
					<a href="updateProfile?id=${sessionScope.cusid}"> <span
						class="btn btn-mini">Cập nhật thông tin</span></a>
				</c:if>
			</div>
			<div class="span6">
				<div class="pull-right">
					<a href="cart"><span class="btn btn-mini btn-primary"><i
							class="icon-shopping-cart icon-white"></i>Giỏ hàng của bạn </span> </a>
				</div>
			</div>
		</div>
		<!-- Navbar ================================================== -->
		<div id="logoArea" class="navbar">
			<a id="smallScreen" data-target="#topMenu" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="navbar-inner">
				<a class="brand" href="homeClient"><img
					src="<c:url value="/resources/themes/images/logo.png"/>"
					alt="Bootsshop" /></a>
				<form:form class="form-inline navbar-search" role="search" action="searchBook">
						<input class="srchTxt" type="text" placeholder="Search ..." name = "name"/> 
						<input type="submit" class="btn btn-primary" />
					</form:form>
				<ul id="topMenu" class="nav pull-right">
					<li class=""><a href="product" class="nav-link">Sản phẩm</a></li>
					<li class=""><a href="contact.html">Liên hệ</a></li>
					<c:if test="${empty client }">
						<li id="loginButton"><a href="loginClient"
							style="padding-right: 0"><span
								class="btn btn-large btn-success">Đăng nhập</span></a></li>
					</c:if>
					<c:if test="${not empty client }">
						<li id="logoutButton"><a href="logoutClient"
							style="padding-right: 0"><span
								class="btn btn-large btn-danger">Đăng xuất</span></a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Header End====================================================================== -->