<%@page import="poly.dto.NewsDTO"%>
<%@include file="../user/session.jsp"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.NotiDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NewsDTO nDTO = (NewsDTO) request.getAttribute("nDTO");
%>


<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>
<%@include file="../header.jsp"%>
<title>socsche</title>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	<%if(session.getAttribute("authority").equals("0")){ %>
	<%@include file="/WEB-INF/view/menu.jsp"%>
	<%}else{ %>
	<%@include file="/WEB-INF/view/menu2.jsp"%>
	<%} %>


	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-1">
					<h2 class="content-header-title">축구 기사</h2>
				</div>

			</div>
			<div class="content-body">
				<!-- Basic Tables start -->
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title"></h4>
								<a class="heading-elements-toggle"><i
									class="icon-ellipsis font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="icon-minus4"></i></a></li>
										<li><a data-action="reload"><i class="icon-reload"></i></a></li>
										<li><a data-action="expand"><i class="icon-expand2"></i></a></li>
										<li><a data-action="close"><i class="icon-cross2"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block card-dashboard">

									<div class="table-responsive">
										<form>
											<input type="hidden" name="seq" value="<%=nDTO.getNewsNo()%>" />
											<div>
												<h3><%=nDTO.getTitleDetail()%></h3>
												<hr>
												<div>
													<p><%=nDTO.getContentDetail()%></p>
												</div>
												<div>
													<input type="button" onclick="location.href='/selectNews.do'" value="돌아가기" class="btn btn-primary" id="submitBtn" style="background-color:#48CFAD"/>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->

	<%@include file="../footer.jsp"%>

</body>