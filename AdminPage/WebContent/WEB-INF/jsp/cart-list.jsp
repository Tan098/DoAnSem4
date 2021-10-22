<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<jsp:include page="/WEB-INF/jsp/siderbarClient.jsp" flush="true"></jsp:include>
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
						<tr>
							<td>
								<form class="form-horizontal">
									<div class="control-group">
										<label class="control-label" for="inputUsername">Tài
											khoản</label>
										<div class="controls">
											<input type="text" id="inputUsername" placeholder="Tài khoản">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputPassword1">Mật
											khẩu</label>
										<div class="controls">
											<input type="password" id="inputPassword1"
												placeholder="Mật khẩu">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Đăng nhập</button>
											HOẶC <a href="register.html" class="btn">Đăng ký ngay!</a>
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<a href="forgetpass.html" style="text-decoration: underline">Quên
												mật khẩu ?</a>
										</div>
									</div>
								</form>
							</td>
						</tr>
					</table>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Mã sách</th>
								<th>Tên sách</th>
								<th>Số lượng/Cập nhập</th>
								<th>Giá</th>
								<td><strong>Tổng giá</strong></td>
								<td>Lựa chọn</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${sessionScope.cart}" var="entry">
								<tr>
									<td>${entry.value.book.id}</td>
									<td>${entry.value.book.name}</td>
									<td>
										<div class="input-append">
											<input class="span1" style="max-width: 34px"
												placeholder="${entry.value.quantity}"
												id="appendedInputButtons" size="16" type="text">
											<button class="btn" type="button">
												<i class="icon-minus"></i>
											</button>
											<button class="btn" type="button">
												<i class="icon-plus"></i>
											</button>
										</div>
									</td>
									<td>${entry.value.price}</td>
									<td><strong> ${entry.value.quantity * entry.value.price}</strong></td>
									<td><a
										href="/finalweb10/delete-from-cart?key=${entry.value.book.id}">Xóa</a></td>
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
						href="login.html" class="btn btn-large pull-right">Tiếp <i
						class="icon-arrow-right"></i></a>

				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>