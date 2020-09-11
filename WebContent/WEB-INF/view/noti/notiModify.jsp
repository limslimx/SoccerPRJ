<%@include file="../user/session.jsp"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.NotiDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<NotiDTO> nList = (List<NotiDTO>) request.getAttribute("nList");
	NotiDTO nDTO = (NotiDTO) request.getAttribute("nDTO");
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>
<%@include file="../header.jsp"%>
<!-- include libraries(jQuery, bootstrap) -->

<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
<!-- include summernote css/js-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<script>
	$(document).ready(function() {
		document.querySelector('#summernote').value='<%=nDTO.getContent()%>';
		$('#summernote').summernote({
			placeholder : '내용',
			minHeight : 370,
			maxHeight : null,
			focus : true,
			lang : 'ko-KR'
		});
	});
</script>
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
					<h2 class="content-header-title">공지사항 게시판</h2>
				</div>

			</div>
			<div class="content-body">
				<!-- Basic Tables start -->
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">글 수정</h4>
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
										<div style="width: 100%; margin: auto;">
											<form method="post" action="/notiModifyProc.do">
												<input type="hidden" name="seq"
													value="<%=nDTO.getNotiNo()%>" /> <input type="text"
													name="title" style="width: 40%;"
													value='<%=nDTO.getTitle()%>'> <br> <br>
												<textarea id="summernote" name="content"></textarea>
												<input class="btn btn-primary" type="button" value="글 수정"
													style="float: left;" onclick="goWrite(this.form)" />
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
	</div>
	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<footer class="footer footer-static footer-light navbar-border">
		<p class="clearfix text-muted text-sm-center mb-0 px-2">
			<span class="float-md-left d-xs-block d-md-inline-block">Copyright
				&copy; 2019 <a
				href="https://themeforest.net/user/pixinvent/portfolio?ref=pixinvent"
				target="_blank" class="text-bold-800 grey darken-2">SocSche</a>, All
				rights reserved.
			</span><span class="float-md-right d-xs-block d-md-inline-block">Hand-crafted
				& Made with <i class="icon-heart5 pink"></i>
			</span>
		</p>
	</footer>
	<script>
		function goWrite(frm) {
			var title = frm.title.value;
			var content = frm.content.value;

			if (title.trim() == '') {
				alert("제목을 입력해주세요");
				return false;
			}
			if (content.trim() == '') {
				alert("내용을 입력해주세요");
				return false;
			}
			frm.submit();
		}
	</script>
</body>
</html>