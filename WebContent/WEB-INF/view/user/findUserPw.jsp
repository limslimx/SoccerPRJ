<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html lang="zxx" class="no-js">
		<%@ include file="../head/head_user.jsp" %>
		<body style="background-color: #666666;">
			
			<div class="limiter">
				<div class="container-login100">
					<div class="wrap-login100">
						
						<form class="login100-form validate-form" autocomplete="off" method="post" action="/FindUserPwProc.do">
							<span class="login100-form-title p-b-43">
								Pw 찾기
							</span>
							
							
							<div class="wrap-input100 validate-input">
								<input class="input100" type="text" name="id">
								<span class="focus-input100"></span>
								<span class="label-input100">Id를 입력하세요</span>
							</div>
							
							<div class="flex-sb-m w-full p-t-3 p-b-32">
								<div>
									<a href="/login.do" class="txt1">
										로그인하기
									</a>
									<a class="txt1">
										/
									</a>
									<a href="/FindUserID.do" class="txt1">
										아이디 찾기
									</a>
								</div>
							</div>
					
		
							<div class="container-login100-form-btn">
								<button type="submit" class="login100-form-btn">
									Pw 찾기
								</button>
							</div>
							
						</form>
		
						<div class="login100-more" style="background-image: url('/resources2/images/soccer.jpg');">
						</div>
					</div>
				</div>
			</div>
		<%@ include file="../js/js_user.jsp" %>
		</body>
	</html>