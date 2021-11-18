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
						<li><a href="homeClient">Trang chủ</a> <span class="divider">/</span></li>
						<li class="active">Đặt hàng</li>
					</ul>
					<h3>Đặt hàng</h3>
					<div class="well">
						<tr>
							<h4>THÔNG TIN GIỎ HÀNG</h4>
						</tr>

						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã sách</th>
									<th>Tên sách</th>
									<th>Số lượng</th>
									<th>Giá</th>
									<td><strong>Tổng giá</strong></td>
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
													id="appendedInputButtons" size="16" type="text"
													readonly="true">
											</div>
										</td>
										<td>${entry.value.price}</td>
										<td><strong> ${entry.value.quantity * entry.value.price}</strong></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<form:form class="form-horizontal" action="pre-order"
							modelAttribute="order" method="post">
							<h4>Thông tin đơn hàng</h4>

							<div class="control-group">
								<label class="control-label">Mã khác hàng <sup>*</sup>
								</label>
								<div class="controls">
									<form:input path="customer.id" readonly="true"
										value="${sessionScope.cusid}" />
									<span>* lưu ý không được để lộ mã khách hàng của bạn cho
										người khác biết</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tên khách hàng <sup
									style="color: #ff0700;">* ${sessionScope.errName} </sup>
								</label>
								<div class="controls">
									<form:input name="name" path="name"
										placeholder="Tên khách hàng" value="${sessionScope.client.name}" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Địa chỉ <sup
									style="color: #ff0700;">* ${sessionScope.errAddress}</sup>
								</label>
								<div class="controls">
									<form:input name="address" path="address" placeholder="Địa chỉ" value="${sessionScope.client.address}" />
									<span>* Số nhà, tên đường, phường/xã, quận/huyện,
										tỉnh/thành phố</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Điện thoại <sup
									style="color: #ff0700;">* ${sessionScope.errPhonenumbers}</sup>
								</label>
								<div class="controls">
									<form:input name="phonenumbers" path="phonenumbers"
										placeholder="Điện thoại" value="${sessionScope.client.phonenumbers}"/>
									<span>* gồm 10 chữ số</span>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">Tổng tiền <sup>*</sup>
								</label>
								<div class="controls">
									<form:input path="totalprice" readonly="true"
										value="${sessionScope.customerCartTotalPrice}" />
									<span>* đây là số tiền mà bạn phải thanh toán</span>
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<form:button type="submit" class="btn">Đặt hàng</form:button>
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