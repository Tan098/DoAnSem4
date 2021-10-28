<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="header">
	<div class="container">
		<div id="welcomeLine" class="row">
			<div class="span6">
				Xin chào! <strong>${sessionScope.client.name}</strong>
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
				<form class="form-inline navbar-search" method="post"
					action="products.html">
					<input class="srchTxt" type="text" /> <select class="srchTxt">
						<option>TẤT CẢ</option>
						<option>TÁC GIẢ</option>
						<option>TÊN SÁCH</option>
						<option>NHÀ XUẤT BẢN</option>
					</select>
					<button type="submit" id="submitButton" class="btn btn-primary">Tìm</button>
				</form>
				<ul id="topMenu" class="nav pull-right">
					<li class=""><a href="product" class="nav-link">Sản phẩm</a></li>
					<li class=""><a href="contact.html">Liên hệ</a></li>
					<li id="loginButton"><a href="loginClient" style="padding-right: 0"><span
							class="btn btn-large btn-success">Đăng nhập</span></a></li>
					<li id="logoutButton" hidden><a href="logoutClient" style="padding-right: 0"><span
							class="btn btn-large btn-danger">Đăng xuất</span></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Header End====================================================================== -->