<%@page import="poly.dto.TeamNewsDTO"%>
<%@page import="java.util.List"%>
<%@include file="/WEB-INF/view/user/session.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TeamNewsDTO> nList=(List<TeamNewsDTO>)request.getAttribute("nList");
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">


  <head>

    <title>socsche</title>

	<%@include file="/WEB-INF/view/header.jsp" %>
  </head>
  <body data-open="click" data-menu="vertical-menu" data-col="2-columns" class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<%if(session.getAttribute("authority").equals("0")){ %>
	<%@include file="/WEB-INF/view/menu.jsp"%>
	<%}else{ %>
	<%@include file="/WEB-INF/view/menu2.jsp"%>
	<%} %>

    <!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">
			<h2>축구 기사</h2>
			<!-- Media List start -->
				<section id="linked-media-list">
					<div class="row">
						<div class="col-xs-12 mt-1">
							<hr>
						</div>
					</div>
					<div class="row match-height">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title">내팀 축구 기사</h4>
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
									<div class="card-block">
										<div class="media-list media-bordered">
											<%
												for (TeamNewsDTO nDTO : nList) {
											%>
											<div class="media">
												<span class="media-left"> <img class="media-object"
													src="<%=nDTO.getImage() %>"
													alt="Generic placeholder image"
													style="width: 100px; height: 70px;" />
												</span>
												<div class="media-body">
													<h5 class="media-heading"><a href="/selectMyNewsDetail.do?seq=<%=nDTO.getNewsNo()%>"><%=nDTO.getTitle()%></a></h5>
													<a href="/selectMyNewsDetail.do?seq=<%=nDTO.getNewsNo()%>"></a>
												</div>
											</div>
											<%
												}
											%>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- Media List end -->
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/view/footer.jsp" %>
  </body>
</html>