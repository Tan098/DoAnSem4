<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bookshop online Shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

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
	href="<c:url value="/resources/themes/ages/ico/apple-touch-icon-114-precomposed.png"/>">
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

							<li><a class="active" href="product?id=${d.id }"><i
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
						<li><a href="homeClient">Trang chủ</a> <span class="divider">/</span></li>
						<li class="active">Đặt hàng</li>
					</ul>
					<h3>Đăng ký</h3>
					<div class="well">
						<form:form class="form-horizontal" action="pre-order"
							modelAttribute="c" method="post">
							<h4>Thông tin người dùng</h4>
							<div class="control-group">
								<label class="control-label">Họ và tên <sup
									style="color: #ff0700;">* ${errorName }</sup>
								</label>
								<div class="controls">
									<form:input type="text" path="name" name="name"
										placeholder="${sessionScope.client.name}" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Địa chỉ<sup
									style="color: #ff0700;">* ${errorAddress}</sup></label>
								<div class="controls">
									<form:input type="text" path="address" name="address"
										placeholder="${sessionScope.client.address}" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Điện thoại<sup
									style="color: #ff0700;">* ${errorPhonenumbers}</sup></label>
								<div class="controls">
									<form:input type="text" path="phonenumbers" name="phonenumbers"
										placeholder="${sessionScope.client.phonenumbers}" />
									<span>* Số điện thoại gồm 10 chữ số</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tổng giá đơn hàng<sup
									style="color: #ff0700;"></sup></label>
								<div class="controls">
									<form:input type="text" path="totalprice" name="totalprice"
										placeholder="100000" />
									<span>* Đây là tổng tiền bạn sẽ phải thanh toán cho đơn
										hàng</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Mã khách hàng<sup
									style="color: #ff0700;"></sup></label>
								<div class="controls">
									<form:input type="text" path="totalprice" name="totalprice"
										placeholder="${sessionScope.cusid}" />
									<span>* Lưu ý không được chia sẻ mã này cho người khác</span>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn">Đặt hàng</button>
								</div>
							</div>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>