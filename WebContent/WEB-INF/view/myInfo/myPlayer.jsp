<%@page import="poly.dto.PlayerDTO"%>
<%@page import="java.util.List"%>
<%@include file="/WEB-INF/view/user/session.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<PlayerDTO> nList = (List<PlayerDTO>) request.getAttribute("nList");
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">


<head>

<title>socsche</title>

<%@include file="/WEB-INF/view/header.jsp"%>
<link rel="stylesheet"
	href="/resources/datatable/css/dataTables.bootstrap4.min.css">
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<%if(session.getAttribute("authority").equals("0")){ %>
	<%@include file="/WEB-INF/view/menu.jsp"%>
	<%}else{ %>
	<%@include file="/WEB-INF/view/menu2.jsp"%>
	<%} %>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">
				<h2>내팀 선수</h2><br>
				<section id="minimal-statistics">
					<div class="row">
					<span class="tag tag-default">골키퍼</span>
						<hr>
						<%
							for (PlayerDTO pDTO : nList) {
								if (pDTO.getPosition().equals("골키퍼")) {
						%>
						<div class="col-xl-3 col-lg-6 col-xs-12">
							<div class="card">
								<div class="card-body">
									<div class="card-block">
										<div class="media">
											<div class="media-left media-middle">
												<img src="<%=pDTO.getImage()%>">
											</div>
											<div class="media-body text-xs-right">
												<h3><%=pDTO.getName()%></h3>
												<span><%=pDTO.getAge()%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
					<div class="row">
					<span class="tag tag-default">수비수</span>
						<hr>
						<%
							for (PlayerDTO pDTO : nList) {
								if (pDTO.getPosition().equals("수비수")) {
						%>
						<div class="col-xl-3 col-lg-6 col-xs-12">
							<div class="card">
								<div class="card-body">
									<div class="card-block">
										<div class="media">
											<div class="media-left media-middle">
												<img src="<%=pDTO.getImage()%>">
											</div>
											<div class="media-body text-xs-right">
												<h3><%=pDTO.getName()%></h3>
												<span><%=pDTO.getAge()%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
					<div class="row">
					<span class="tag tag-default">미드필더</span>
						<hr>
						<%
							for (PlayerDTO pDTO : nList) {
								if (pDTO.getPosition().equals("미드필더")) {
						%>
						<div class="col-xl-3 col-lg-6 col-xs-12">
							<div class="card">
								<div class="card-body">
									<div class="card-block">
										<div class="media">
											<div class="media-left media-middle">
												<img src="<%=pDTO.getImage()%>">
											</div>
											<div class="media-body text-xs-right">
												<h3><%=pDTO.getName()%></h3>
												<span><%=pDTO.getAge()%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
					<div class="row">
					<span class="tag tag-default">공격수</span>
						<hr>
						<%
							for (PlayerDTO pDTO : nList) {
								if (pDTO.getPosition().equals("공격수")) {
						%>
						<div class="col-xl-3 col-lg-6 col-xs-12">
							<div class="card">
								<div class="card-body">
									<div class="card-block">
										<div class="media">
											<div class="media-left media-middle">
												<img src="<%=pDTO.getImage()%>">
											</div>
											<div class="media-body text-xs-right">
												<h3><%=pDTO.getName()%></h3>
												<span><%=pDTO.getAge()%></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
				</section>
				<!-- Minimal statistics section end -->
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/view/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</body>
</html>