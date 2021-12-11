<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Bootshop online Shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!--Less styles -->
<!-- Other Less css file //different less files has different color scheam
	<link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
	<link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
	-->
<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
	<script src="themes/js/less.js" type="text/javascript"></script> -->

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="<c:url value="/resources/themes/bootshop/bootstrap.min.css"/>"
	media="screen" />
<link href="<c:url value="/resources/themes/css/base.css"/>"
	rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link
	href="<c:url value="/resources/themes/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/themes/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->
<link
	href="<c:url value="/resources/themes/js/google-code-prettify/prettify.css"/>"
	rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon"
	href="<c:url value="/resources/themes/images/ico/favicon.ico"/>">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-57-precomposed.png"/>">
<style type="text/css" id="enject"></style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/headerClient.jsp" flush="false"></jsp:include>
	<div id="mainBody">
		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<div id="sidebar" class="span3">
					<c:forEach items="${listc}" var="d">
						<ul id="sideManu" class="nav nav-tabs nav-stacked">

							<li><a class="active" href="productByCate?id=${d.id}"><i
									class="icon-chevron-right"></i>${d.name}</a></li>

						</ul>
					</c:forEach>
					<br />

					<div class="thumbnail">
						<img
							src="<c:url value="/resources/themes/images/payment_methods.png"/>"
							title="Bootshop Payment Methods" alt="Payments Methods">
						<div class="caption">
							<h5>Phương thức thanh toán</h5>
						</div>
					</div>
				</div>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
						<li class="active">GIỎ HÀNG</li>
					</ul>
					<h3>
						GIỎ HÀNG <a href="homeClient" class="btn btn-large pull-right"><i
							class="icon-arrow-left"></i> Tiếp tục mua hàng </a>
					</h3>
					<hr class="soft" />
					<table class="table table-bordered">
						<tr>
							<th>THÔNG TIN GIỎ HÀNG</th>
						</tr>
						<c:if test="${empty client}">
							<tr>
								<td>
									<form class="form-horizontal">
										<div class="control-group">
											<div class="controls">
												<a href="loginClient" class="btn">Đăng nhập</a> HOẶC <a
													href="initRegisterCustomer" class="btn">Đăng ký ngay!</a>
											</div>
										</div>
									</form>
								</td>
							</tr>
						</c:if>

					</table>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Mã sách</th>
								<th>Tên sách</th>
								<th>Số lượng</th>
								<th>Giá</th>
								<td><strong>Tổng giá</strong></td>
								<td></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.cart}" var="entry">
								<tr>
									<td>${entry.value.book.id}</td>
									<td>${entry.value.book.name}</td>
									<td>${entry.value.quantity}</td>
									<td>${entry.value.price}</td>
									<td><strong> ${entry.value.quantity * entry.value.price}</strong></td>
									<td><a href="deletefromcart?key=${entry.value.book.id}"
										style="color: #ff0700;">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>


					<table class="table table-bordered">
						<tbody>
							<tr>
								<td>
									<form class="form-horizontal">
										<div class="control-group">
											<label class="control-label"><strong> MÃ
													KHUYẾN MÃI: </strong> </label>
											<div class="controls">
												<input type="text" class="input-medium"
													placeholder="xxx-xxxx-xxx-xx">
												<button type="submit" class="btn">Thêm</button>
											</div>
										</div>
									</form>
								</td>
							</tr>

						</tbody>
					</table>

					<a href="homeClient" class="btn btn-large"><i
						class="icon-arrow-left"></i> Tiệp tục mua hàng </a> <a
						href="pre-order" class="btn btn-large pull-right">Đặt hàng <i
						class="icon-arrow-right"></i></a>

				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>