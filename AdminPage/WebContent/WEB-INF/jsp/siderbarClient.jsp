<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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