<%@page import="poly.dto.RankDTO"%>
<%@page import="java.util.List"%>
<%@include file="/WEB-INF/view/user/session.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<RankDTO> rList = (List<RankDTO>) request.getAttribute("rList");
%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">


<head>

<title>socsche</title>
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
   padding-left:20px;

}

.table_3rd {
   width: 80px;
   text-align: center;
}

.table_4th {
   width: 80px;
   text-align: center;
}

.table_5th {
  width: 80px;
   text-align: center;
}

.table_6th {
   width: 80px;
   text-align: center;
}

.table_7th {
   width: 80px;
   text-align: center;
}

.table_8th {
   width: 80px;
   text-align: center;
}
.table_9th {
  width: 80px;
   text-align: center;
}
.table_10th {
   width: 100px;
   text-align: center;
}
.table_11th {
   width: 200px;
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
				<h2>프리미어리그 팀 순위</h2>
				<div class="div_content_container"
					style="color: #666666; font-weight: bold;">
					<div style="display: table-row;">
						<div class="table_1st div_content_box">순위</div>
						<div class="table_2nd div_content_box" style="text-align: center;">팀</div>
						<div class="table_3rd div_content_box">P</div>
						<div class="table_4th div_content_box">W</div>
						<div class="table_5th div_content_box">D</div>
						<div class="table_6th div_content_box">L</div>
						<div class="table_7th div_content_box">득점</div>
						<div class="table_8th div_content_box">실점</div>
						<div class="table_9th div_content_box">득실</div>
						<div class="table_10th div_content_box">승점</div>
						<div class="table_11th div_content_box">최근 경기</div>
					</div>
				</div>
				
				<div class="div_content_container">
					<%
					for (RankDTO rDTO : rList) {
				%>
					<div style="display: table-row;">
						<div class="table_1st div_content_box"><%=rDTO.getRank()%></div>
						
						<div class="table_2nd div_content_box">
							<img data-srcset="<%=CmmUtil.nvl(rDTO.getImage())%>"
								srcset="<%=CmmUtil.nvl(rDTO.getImage())%>" data-loaded="true"><%=rDTO.getTeam()%></div>
						<div class="table_3rd div_content_box"><%=rDTO.getTotalMatch()%></div>
						<div class="table_4th div_content_box"><%=rDTO.getWonMatch()%></div>
						<div class="table_5th div_content_box"><%=rDTO.getDrawMatch()%></div>
						<div class="table_6th div_content_box"><%=rDTO.getLostMatch()%></div>
						<div class="table_7th div_content_box"><%=rDTO.getGoal()%></div>
						<div class="table_8th div_content_box"><%=rDTO.getLost()%></div>
						<div class="table_9th div_content_box"><%=rDTO.getDiff()%></div>
						<div class="table_10th div_content_box"><%=rDTO.getPoints()%></div>
						<div class="table_11th div_content_box"><%=rDTO.getGame()%></div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<br>
	<%@include file="/WEB-INF/view/footer.jsp"%>
</body>
</html>