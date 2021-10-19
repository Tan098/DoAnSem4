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

	<!-- Header End====================================================================== -->
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
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a> <span class="divider">/</span></li>
						<li class="active">Products Name</li>
					</ul>
					<h3>
						Products Name <small class="pull-right"> 40 products are
							available </small>
					</h3>
					<hr class="soft" />
					<p>Nowadays the lingerie industry is one of the most successful
						business spheres.We always stay in touch with the latest fashion
						tendencies - that is why our goods are so popular and we have a
						great number of faithful customers all over the country.</p>
					<hr class="soft" />
					<form class="form-horizontal span6">
						<div class="control-group">
							<label class="control-label alignL">Sort By </label> <select>
								<option>Priduct name A - Z</option>
								<option>Priduct name Z - A</option>
								<option>Priduct Stoke</option>
								<option>Price Lowest first</option>
							</select>
						</div>
					</form>


					<br class="clr" />
					<div class="tab-content">


						<div class="tab-pane  active" id="blockView">
							<div class="thumbnail">
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
														href="add-to-cart?bookid=${b.id}">Thêm vào giỏ hàng<i
														class="icon-shopping-cart"></i>
													</a>
													<div class="btn btn-primary">${b.price}</div>
												</h4>
											</div>

										</div>
									</li>
								</c:forEach>
							</div>
							<hr class="soft" />
						</div>
					</div>

					<a href="compair.html" class="btn btn-large pull-right">Compair
						Product</a>
					<div class="pagination">
						<ul>
							<li><a href="#">&lsaquo;</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">...</a></li>
							<li><a href="#">&rsaquo;</a></li>
						</ul>
					</div>
					<br class="clr" />
				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>