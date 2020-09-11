<%@page import="poly.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@include file="../../user/session.jsp"%>
<%
	List<UserDTO> nList = (List<UserDTO>) request.getAttribute("uList");
	int pgNum = (int) request.getAttribute("pgNum");
	int total = (int) request.getAttribute("total");
	int totalpg = (total - 1) / 10 + 1;
	int jNum = ((pgNum - 1) / 5) * 5 + 1;
	int kNum = ((totalpg - 1) / 5) * 5 + 1;
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">


<head>

<%@include file="/WEB-INF/view/header.jsp"%>
<style>
.div_content_container {
	display: table;
	table-layout: fixed;
	width: 100%;
	border: 1px solid #dee2e6;
}

.div_content_box {
	display: table-cell;
	border: 1px solid #dee2e6;
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
	padding-top: 12px;
	padding-bottom: 12px;
}

.table_1st {
	width: 60px;
	text-align: center;
}

.table_2nd {
	text-align: center;
}

.table_3rd {
	width: 180px;
	text-align: center;
}

.table_4th {
	width: 180px;
	text-align: center;
}

.table_5th {
	width: 80px;
	text-align: center;
}

@media ( max-width :1210px) {
	.table_5th {
		display: none !important;
	}
}

@media ( max-width :1120px) {
	.table_4th {
		display: none !important;
	}
}
</style>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">

	<%
		if (session.getAttribute("authority").equals("0")) {
	%>
	<%@include file="/WEB-INF/view/menu.jsp"%>
	<%
		} else {
	%>
	<%@include file="/WEB-INF/view/menu2.jsp"%>
	<%
		}
	%>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-body">
				<h2>회원정보 리스트</h2>
				<div class="div_content_container"
					style="color: #666666; font-weight: bold;">
					<div style="display: table-row;">
						<div class="table_1st div_content_box">ID</div>
						<div class="table_2nd div_content_box">이메일</div>
					</div>
				</div>

				<div class="div_content_container">
					<%
						for (UserDTO uDTO : nList) {
					%>
					<div style="display: table-row;">
						<div class="table_1st div_content_box">
							<a href="/userInfoDetail.do?user_id=<%=uDTO.getId()%>"><%=uDTO.getId()%></a>
						</div>
						<div class="table_2nd div_content_box">
							<a href="/userInfoDetail.do?user_id=<%=uDTO.getId()%>"><%=uDTO.getEmail()%></a>
						</div>
					</div>
					<%
						}
					%>
				</div>
				<br>
				<%
					if (session.getAttribute("authority").equals("1")) {
				%>
				<div>
					<input type="button" onclick="location.href='/notiReg.do'"
						value="글 작성" class="btn btn-primary" id="submitBtn" />
				</div>
				<%
					}
				%>
			</div>
			<nav aria-label="Page navigation">
				<ul class="pagination">
					<%
						if (pgNum == 1) {
					%>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<%
						} else {
					%>
					<li class="page-item"><a class="page-link"
						href="/notiList.do?pgNum=<%=pgNum - 1%>" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
					</a></li>
					<%
						}
					%>


					<%
						if (jNum == kNum) {
					%>
					<%
						for (int i = jNum; i <= totalpg; i++) {
					%>
					<%
						if (pgNum == i) {
					%>
					<li class="page-item active"><a class="page-link" href="#"><%=i%></a></li>
					<%
						} else {
					%>
					<li class="page-item"><a class="page-link"
						href="/notiList.do?pgNum=<%=i%>"><%=i%></a></li>
					<%
						}
					%>
					<%
						}
					%>
					<%
						} else {
					%>
					<%
						for (int i = jNum; i <= jNum + 4; i++) {
					%>
					<%
						if (pgNum == i) {
					%>
					<li class="page-item active"><a class="page-link" href="#"><%=i%></a></li>
					<%
						} else {
					%>
					<li class="page-item"><a class="page-link"
						href="/notiList.do?pgNum=<%=i%>"><%=i%></a></li>
					<%
						}
					%>
					<%
						}
					%>
					<%
						}
					%>


					<%
						if (pgNum == totalpg) {
					%>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
					<%
						} else {
					%>
					<li class="page-item"><a class="page-link"
						href="/notiList.do?pgNum=<%=pgNum + 1%>" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
					<%
						}
					%>

				</ul>
			</nav>
		</div>
	</div>
	<%@include file="/WEB-INF/view/footer.jsp"%>

</body>
</html>