<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
						<li><a href="home">Trang chủ</a> <span class="divider">/</span></li>
						<li><a href="product">Sản phẩm</a> <span class="divider">/</span></li>
						<li class="active">Chi tiết sản phẩm</li>
					</ul>

				</div>
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
						</div>
					</div>
					<div class="span6">
						<h3>${b.name}</h3>
						<small>Tên khác :${b.alias }</small>
						<hr class="soft" />
						<form class="form-horizontal qtyFrm">
							<div class="control-group">
								<label class="control-label"><span>${b.price }</span></label>
								<div class="controls">
									<a href="addtocart?bookId=${b.id}">Thêm vào giỏ hàng<i
										class=" icon-shopping-cart"></i>
									</a>
								</div>
							</div>
						</form>

						<hr class="soft" />
						<h4>Còn ${b.quantity} sản phẩm</h4>

						<hr class="soft clr" />
						<p>
							<b>Mô tả</b> : ${b.descriptions }
						</p>

						<hr class="soft" />
					</div>



				</div>
			</div>
			<div class="row">
				<div class="span3"></div>
				<div class="span9">
					<ul id="productDetail" class="nav nav-tabs">
						<li class="active"><a href="#home" data-toggle="tab">Chi
								tiết sản phẩm</a></li>

					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="home">
							<h4>Thông tin chi tiết</h4>
							<table class="table table-bordered">
								<tbody>
									<tr class="techSpecRow">
										<th colspan="2">Thông tin sách</th>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Tên sách:</td>
										<td class="techSpecTD2">${b.name }</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Danh mục:</td>
										<td class="techSpecTD2"><c:forEach
												items="${b.sem_category_books}" var="a">
													${a.category.name},
												</c:forEach></td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Trạng thái:</td>
										<td class="techSpecTD2">${b.status?"Còn hàng" :"Hết hàng"}</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Nhà xuất bản:</td>
										<td class="techSpecTD2">${b.publicsher.name}</td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Tác giả:</td>
										<td class="techSpecTD2"><c:forEach
												items="${b.sem_author_books}" var="a">
													${a.author.name},
												</c:forEach></td>
									</tr>
									<tr class="techSpecRow">
										<td class="techSpecTD1">Ngày xuất bản :</td>
										<td class="techSpecTD2"><fmt:formatDate
												value="${b.yearofpublic}" pattern="dd-MM-yyyy" /></td>
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