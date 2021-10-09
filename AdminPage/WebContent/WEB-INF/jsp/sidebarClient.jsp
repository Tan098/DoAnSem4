<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Sidebar ================================================== -->
<div id="sidebar" class="span3">
	<c:forEach items="${listc}" var="d">
		<ul id="sideManu" class="nav nav-tabs nav-stacked">

			<li><a class="active" href="products.html"><i
					class="icon-chevron-right"></i></a>${d.name}</li>

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