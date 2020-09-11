
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="session.jsp"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>

<meta charset="UTF-8">
<title>페이지 타이틀</title>
<%@ include file="../header.jsp"%>
</head>
<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns  fixed-navbar">
	<%@ include file="../menu.jsp"%>
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-1">
					<h2 class="content-header-title">회원정보 수정</h2>
				</div>
			</div>
			<div class="content-body">
				<!-- Basic form layout section start -->
				<section id="basic-form-layouts">

					<div class="row">
						<div class="col-md-6 offset-md-3">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="basic-layout-card-center">회원정보
										수정</h4>
								</div>
								<div class="card-body collapse in">
									<div class="card-block">
										<div class="card-text">
											<p></p>
										</div>
										<form action="/checkPwProc.do" method="post">

											<fieldset
												class="form-group position-relative has-icon-left mb-1">
												<input type="password"
													class="form-control form-control-lg input-lg" id="pw"
													name="passwd" placeholder="비밀번호 입력" required
													style="margin-bottom: 5%">
												<div class="form-control-position">
													<i class="icon-key3"></i>
												</div>
												<div style="height: 1.6em"></div>
											</fieldset>

											<input type="submit" id="submitBtn"
												class="btn btn-primary btn-lg btn-block">
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- // Basic form layout section end -->
			</div>
		</div>
	</div>

	<%@include file="../footer.jsp"%>
</body>
</html>