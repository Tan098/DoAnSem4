<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div id="carouselBlk">
		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">
				<div class="item active">
					<div class="container">
						<a href="register.html"><img style="width: 100%"
							src="<c:url value="/resources/themes/images/carousel/1.png"/>"
							alt="special offers" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="container">
						<a href="register.html"><img style="width: 100%"
							src="<c:url value="/resources/themes/images/carousel/2.png"/>"
							alt="" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="container">
						<a href="register.html"><img
							src="<c:url value="/resources/themes/images/carousel/3.png"/>"
							alt="" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>

					</div>
				</div>
				<div class="item">
					<div class="container">
						<a href="register.html"><img
							src="<c:url value="/resources/themes/images/carousel/4.png"/>"
							alt="" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>

					</div>
				</div>
				<div class="item">
					<div class="container">
						<a href="register.html"><img
							src="<c:url value="/resources/themes/images/carousel/5.png"/>"
							alt="" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="container">
						<a href="register.html"><img
							src="<c:url value="/resources/themes/images/carousel/6.png"/>"
							alt="" /></a>
						<div class="carousel-caption">
							<h4>Second Thumbnail label</h4>
							<p>Cras justo odio, dapibus ac facilisis in, egestas eget
								quam. Donec id elit non mi porta gravida at eget metus. Nullam
								id dolor id nibh ultricies vehicula ut id elit.</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
	</div>
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
							<h5>Payment Methods</h5>
						</div>
					</div>
				</div>
				<!-- Sidebar end=============================================== -->
				<div class="span9">
					<div class="well well-small">
						<h4>
							Đặc sắc <small class="pull-right"></small>
						</h4>
						<div class="row-fluid">
							<div id="featured">
								<div class="carousel-inner">
									<div class="item active">

										<ul class="thumbnails">
											<c:forEach items="${list}" var="b">
												<li class="span3">
													<div class="thumbnail">
														<i class="tag"></i>
														<c:forEach var="i" items="${b.sem_images}">
															<c:if test="${i.isdefault}">
																<img src="<c:url value="resources"/>/images/${i.path}"
																	width="100px" height="70px" />
															</c:if>
														</c:forEach>
														<div class="caption">
															<h5 style="height: 40px">${b.name}</h5>
															<h4>
																<a class="btn" href="detailBook?id=${b.id}">Chi tiết</a>
																<span class="pull-right">${b.price}</span>
															</h4>
														</div>

													</div>

												</li>
											</c:forEach>
										</ul>


									</div>

								</div>
								<a class="left carousel-control" href="#featured"
									data-slide="prev">‹</a> <a class="right carousel-control"
									href="#featured" data-slide="next">›</a>
							</div>
						</div>
					</div>
					<h4>Sách mới nhất</h4>
					<ul class="thumbnails">
						<c:forEach var="b" items="${list}">
							<li class="span3">
								<div class="thumbnail">
									<c:forEach var="i" items="${b.sem_images}">
										<c:if test="${i.isdefault}">
											<img src="<c:url value="resources"/>/images/${i.path}"
												width="100px" height="70px" />
										</c:if>
									</c:forEach>
									<div class="caption">
										<h5>${b.name}</h5>
										<p>${b.descriptions}</p>

										<h4 style="text-align: center">
											<a class="btn" href="detailBook?id=${b.id}"> <i
												class="icon-zoom-in"></i></a> <a class="btn"
												href="addtocart?bookId=${b.id}">Thêm vào giỏ hàng<i
												class="icon-shopping-cart"></i>
											</a>
											<div class="btn btn-primary">${b.price}</div>
										</h4>
									</div>

								</div>
							</li>
						</c:forEach>
					</ul>

				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>