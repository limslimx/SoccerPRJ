<%@page import="poly.dto.ScheduleDTO"%>
<%@page import="java.util.List"%>
<%@page import="poly.util.CmmUtil"%>
<%@include file="/WEB-INF/view/user/session.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ScheduleDTO> sList = (List<ScheduleDTO>) request.getAttribute("sList");
	String date = CmmUtil.nvl((String)request.getAttribute("date"));
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">


<head>

<title>socsche</title>

<%@include file="/WEB-INF/view/header.jsp"%>
<link rel="stylesheet"
	href="/resources/datatable/css/dataTables.bootstrap4.min.css">
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
   width: 100px;
   text-align: center;
}

.table_2nd {
	width: 80px;
   text-align: center;
}

.table_3rd {
   width: 300px;
   text-align: center;
}

.table_4th {
   width: 50px;
   text-align: center;
}

.table_5th {
  width: 50px;
   text-align: center;
}

.table_6th {
   width: 300px;
   text-align: center;
}

@media ( max-width :630px) {
   .table_6th {
      display: none!important;
   }
   .table_5th {
      display: none!important;
   }
   .table_4th {
      display: none!important;
   }
}

@media ( max-width :800px) {
   .table_3rd {
      display: none!important;
   }
}

@media ( max-width :1050px) {
   .table_7th {
      display: none!important;
   }
}

@media ( max-width :1130px) {
   .table_8th {
      display: none!important;
   }
}

@media ( max-width :1210px) {
   .table_9th {
      display: none!important;
   }
}

@media ( max-width :1430px) {
   .table_11th {
      display: none!important;
   }
}
</style>
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
				<h2>프리미어리그 일정</h2>
				<input type="date" name="date" id="date" onchange="schedule()">
				<div class="div_content_container"
					style="color: #666666; font-weight: bold;">
					<div style="display: table-row;">
						<div class="table_1st div_content_box">날짜</div>
						<div class="table_2nd div_content_box">시간</div>
						<div class="table_3rd div_content_box">홈팀</div>
						<div class="table_4th div_content_box">점수</div>
						<div class="table_5th div_content_box">점수</div>
						<div class="table_6th div_content_box">어웨이팀</div>
					</div>
				</div>

				<div class="div_content_container">
				<!-- <script>
					var d=new Date();
					var day=d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate();
				</script> -->
					<%
						for (ScheduleDTO rDTO : sList) {
					%>
					<div style="display: table-row;">
						<div class="table_1st div_content_box"><%=date%></div>
						<div class="table_2nd div_content_box"><%=rDTO.getTime()%></div>
						<div class="table_3rd div_content_box"><%=rDTO.getTeamHome()%><img data-srcset="<%=CmmUtil.nvl(rDTO.getImageHome())%>"
								srcset="<%=CmmUtil.nvl(rDTO.getImageHome())%>" data-loaded="true"></div>
						<div class="table_4th div_content_box"><%=rDTO.getScoreHome()%></div>
						<div class="table_5th div_content_box"><%=rDTO.getScoreAway()%></div>
						<div class="table_6th div_content_box"><img data-srcset="<%=CmmUtil.nvl(rDTO.getImageAway())%>"
								srcset="<%=CmmUtil.nvl(rDTO.getImageAway())%>" data-loaded="true"><%=rDTO.getTeamAway()%></div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<%@include file="/WEB-INF/view/footer.jsp"%>
		<script>
			function schedule(){
				document.location.href="/updateSchedule.do?date="+$("#date").val();
			}
		</script>
</body>
</html>