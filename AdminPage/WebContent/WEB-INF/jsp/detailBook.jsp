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
	<ul class="breadcrumb">
		<li><a href="index.html">Home</a> <span class="divider">/</span></li>
		<li><a href="products.html">Products</a> <span class="divider">/</span></li>
		<li class="active">product Details</li>
	</ul>
	<jsp:include page="/WEB-INF/jsp/headerClient.jsp" flush="false"></jsp:include>


	<!-- Header End====================================================================== -->
	<div id="mainBody">

		<div class="container">
			<div class="row">
				<!-- Sidebar ================================================== -->
				<div id="sidebar" class="span3">
					<c:forEach items="${listc}" var="d">
						<ul id="sideManu" class="nav nav-tabs nav-stacked">

							<li><a class="active" href="products.html"><i
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
				<div class="row">
					<div id="gallery" class="span3">
						<c:forEach var="i" items="${b.sem_images}">
							<c:if test="${i.isdefault}">
								<a href="<c:url value="resources"/>/images/${i.path}"> <img
									src="<c:url value="resources"/>/images/${i.path}"
									style="width: 100%" /></a>
							</c:if>
						</c:forEach>

						<div id="differentview" class="moreOptopm carousel slide">
							<div class="carousel-inner">
								<c:forEach var="i" items="${b.sem_images}">
									<c:if test="${!i.isdefault}">
										<div class="item active">
											<a href="<c:url value="resources"/>/images/${i.path}"> <img
												style="width: 29%"
												src="<c:url value="resources"/>/images/${i.path}" alt="" /></a>
										</div>
										<div class="item">
											<a href="<c:url value="resources"/>/images/${i.path}"> <img
												style="width: 29%"
												src="<c:url value="resources"/>/images/${i.path}" alt="" /></a>
										</div>
									</c:if>
								</c:forEach>
							</div>
							<!--  
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
              <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a> 
			  -->
						</div>


					</div>
					<div class="span6">
						<h3>${b.name}</h3>
						<small>${b.alias }</small>
						<hr class="soft" />
						<form class="form-horizontal qtyFrm">
							<div class="control-group">
								<label class="control-label"><span>${b.price }</span></label>
								<div class="controls">
									<input type="number" class="span1" placeholder="0" /> <a
										href="add-to-cart?bookid=${b.id}">Thêm vào giỏ hàng<i
										class=" icon-shopping-cart"></i>
									</a>
								</div>
							</div>
						</form>

						<hr class="soft" />
						<h4>100 items in stock</h4>

						<hr class="soft clr" />
						<p>${b.descriptions }</p>
						<a class="btn btn-small pull-right" href="#detail">More
							Details</a> <br class="clr" />

						<hr class="soft" />
					</div>



				</div>
			</div>
			<div class="row">
				<div class="span3"></div>
				<div class="span9">
					<ul id="productDetail" class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">Product
								Details</a></li>

					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="home">
							<h4>Book Information</h4>
							<table class="table table-bordered">
								<tbody>
									<tr class="techSpecRow">
										<th colspan="2">Book Details</th>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Name:</td>
										<td class="techSpecTD2">${b.name }</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Status:</td>
										<td class="techSpecTD2">${b.status ? 'Còn hàng' : 'Hết hàng'}</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Publisher:</td>
										<td class="techSpecTD2">${b.publicsher.name}</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Author:</td>
										<td class="techSpecTD2"><c:forEach
												items="${b.sem_author_books}" var="a">
													${a.author.name},
												</c:forEach></td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Release date :</td>
										<td class="techSpecTD2">${b.yearofpublic}</td>
									</tr>
								</tbody>
							</table>


						</div>
						<div class="tab-pane fade" id="profile">
							<div id="myTab" class="pull-right">
								<a href="#listView" data-toggle="tab"><span
									class="btn btn-large"><i class="icon-list"></i></span></a> <a
									href="#blockView" data-toggle="tab"><span
									class="btn btn-large btn-primary"><i
										class="icon-th-large"></i></span></a>
							</div>
							<br class="clr" />

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
	<span id="themesBtn"></span>
</body>
</html>