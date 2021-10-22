<%-- 
    Document   : mainsidebarcontent
    Created on : Jul 22, 2021, 4:11:46 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="home" class="brand-link"> <img
		src="<c:url value="/resources/dist/img/AdminLTELogo.png" />"
		alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
		style="opacity: .8"> <span class="brand-text font-weight-light">AdminLTE
			3</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="<c:url value="/resources/dist/img/user2-160x160.jpg" />"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="home" class="d-block">${sessionScope.username}</a>
			</div>
		</div>

		<!-- SidebarSearch Form -->
		<div class="form-inline">
			<div class="input-group" data-widget="sidebar-search">
				<input class="form-control form-control-sidebar" type="search"
					placeholder="Search" aria-label="Search">
				<div class="input-group-append">
					<button class="btn btn-sidebar">
						<i class="fas fa-search fa-fw"></i>
					</button>
				</div>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
				<li class="nav-item menu-open"><a class="nav-link"> <i
						class="nav-icon fas fa-edit"></i>
						<p>Quản lý</p> <i class="right fas fa-angle-left"></i>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="listCategories"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Danh mục</p>
						</a></li>
						<li class="nav-item"><a href="listBooks" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Sách</p>
						</a></li>
						<li class="nav-item"><a href="listAuthors" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Tác giả</p>
						</a></li>
						<li class="nav-item"><a href="listPublishers"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Nhà Xuất bản</p>
						</a></li>
					</ul></li>
				<!-- Control Detail Book -->
				<li class="nav-item menu-open"><a class="nav-link"> <i
						class="nav-icon fas fa-edit"></i>
						<p>Quản lý chi tiết sách</p> <i class="right fas fa-angle-left"></i>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="listCategoryBooks"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Danh mục</p>
						</a></li>
						<li class="nav-item"><a href="listAuthorBooks"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Tác giả</p>
						</a></li>
						<li class="nav-item"><a href="listImages" class="nav-link">
								<i class="far fa-circle nav-icon"></i>
								<p>Ảnh</p>
						</a></li>
					</ul></li>
				<li class="nav-item"><a href="loginAdmin" class="nav-link">
						<i class="nav-icon fas fa-sign-out-alt"></i>
						<p>Đăng xuất</p>
				</a></li>
				<li class="nav-item"><a href="homeClient" class="nav-link">
						<i class="nav-icon fas fa-sign-out-alt"></i>
						<p>Client</p>
				</a></li>

			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>
