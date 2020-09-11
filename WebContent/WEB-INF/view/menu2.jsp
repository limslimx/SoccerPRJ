<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header-navbar.jsp"%>

<!-- ////////////////////////////////////////////////////////////////////////////-->



<!-- main menu-->
<div data-scroll-to-active="true"
	class="main-menu menu-fixed menu-dark menu-accordion menu-shadow">
	<!-- main menu header-->
	<div class="main-menu-header">
		<input type="text" placeholder="Search"
			class="menu-search form-control round" />
	</div>
	<!-- / main menu header-->


	<!-- 대쉬보드 설정 -->
	<div class="main-menu-content">
		<ul id="main-menu-navigation" data-menu="menu-navigation"
			class="navigation navigation-main">
			<li class=" nav-item"><a href="/index.do"><i
					class="icon-home3"></i>홈</a></li>
			<li class=" nav-item"><a href="/notiList.do"><i
					class="icon-bullhorn"></i><span
					data-i18n="nav.bootstrap_tables.table_basic" class="menu-title">공지사항</span></a>
			</li>
			<li class="nav-item"><a href="#"><i class="icon-user"></i><span
					data-i18n="nav.page_layouts.main" class="menu-title">회원관리</span></a>
				</li>
			<li class=" nav-item"><a href="#"><i class="icon-paper"></i><span
					data-i18n="nav.project.main" class="menu-title">공지사항 관리</span></a>
				</li>
		</ul>
	</div>
</div>
<!-- /main menu content-->
<!-- main menu footer-->
<!-- include includes/menu-footer-->
<!-- main menu footer-->

