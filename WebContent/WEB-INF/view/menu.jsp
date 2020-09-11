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
					data-i18n="nav.page_layouts.main" class="menu-title">내 정보</span></a>
				<ul class="menu-content">
					<li><a href="#" class="menu-item">내 팀</a>
						<ul class="menu-content">
							<li><a href="/selectMyNews.do"
								data-i18n="nav.error_pages.error_400" class="menu-item">뉴스 보기</a></li>
							<li><a href="/myPlayerSelect.do" data-i18n="nav.error_pages.error_401"
								class="menu-item">선수단 보기</a></li>
							<li><a href="/myRankSelect.do" data-i18n="nav.error_pages.error_401"
								class="menu-item">순위 보기</a></li>
						</ul>
					</li>
					<li><a href="layout-static.html"
						data-i18n="nav.page_layouts.static_layout" class="menu-item">개인
							정보</a>
						<ul class="menu-content">
							<li><a href="/checkPw.do"
								data-i18n="nav.error_pages.error_400" class="menu-item">개인정보
									수정</a></li>
							<li><a href="#" data-i18n="nav.error_pages.error_401"
								class="menu-item">회원 탈퇴</a></li>
						</ul></li>
				</ul></li>
			<li class=" nav-item"><a href="#"><i class="icon-paper"></i><span
					data-i18n="nav.project.main" class="menu-title">축구 정보</span></a>
				<ul class="menu-content">
					<li><a href="/selectNews.do"
						data-i18n="nav.invoice.invoice_template" class="menu-item">기사
							보기</a></li>
					<li><a href="/selectRank.do"
						data-i18n="nav.gallery_pages.gallery_grid" class="menu-item">순위
							보기</a></li>
					<li><a href="/selectSchedule.do"
						data-i18n="nav.login_register_pages.login_simple"
						class="menu-item">일정 보기</a></li>
				</ul></li>
		</ul>
	</div>
</div>
<!-- /main menu content-->
<!-- main menu footer-->
<!-- include includes/menu-footer-->
<!-- main menu footer-->

