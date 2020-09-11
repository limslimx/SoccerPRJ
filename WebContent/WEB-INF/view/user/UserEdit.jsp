<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="session.jsp"%>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">
<head>

<meta charset="UTF-8">
<title>페이지 타이틀</title>
<%@ include file="../header.jsp"%>
<script src="/resources2/vendor/jquery/jquery-3.2.1.min.js"></script>
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
										<form class="form" onsubmit="return validity['email'];"
											action="updateEmail.do">
											<div class="form-body">
												<!-- 이메일 -->
												<div class="form-group">
													<label for="email">이메일</label> <input type="email"
														id="email" class="form-control" placeholder="이메일 입력"
														name="email">
													<div id="emailMsg" style="height: 1.6em"></div>
												</div>
											</div>
											<div class="form-group">
												<label for="team">좋아하는 팀</label> <select id="team"
													class="form-control" name="team">
													<optgroup label="EPL">
														<option value="리버풀">리버풀</option>
														<option value="맨시티">맨시티</option>
														<option value="토트넘">토트넘</option>
														<option value="첼시">첼시</option>
														<option value="맨유">맨유</option>
														<option value="아스널">아스널</option>
													</optgroup>
													<optgroup label="LaLiga">
														<option value="바르셀로나">바르셀로나</option>
														<option value="레알마드리드">레알마드리드</option>
													</optgroup>
													<optgroup label="BundesLiga">
														<option value="바이에른뮌헨">바이에른뮌헨</option>
													</optgroup>
												</select>
											</div>
											<div class="form-actions center">
												<button type="submit" class="btn btn-primary" id="submitBtn"
													disabled="disabled">
													<i class="icon-check2"></i> 저장
												</button>
											</div>
										</form>
									</div>
								</div>
								<div class="card-body collapse in">
									<div class="card-block">
										<div class="card-text">
											<p></p>
										</div>
										<form class="form" onsubmit="return validity['pwConfirm'];"
											action="updatePw.do">
											<div class="form-body">
												<!-- 암호 -->
												<div class="form-group">
													<label for="pw">암호</label> <input type="password" id="pw"
														class="form-control" name="passwd" placeholder="암호 입력">
												</div>

												<div class="form-group">
													<label for="pwConfirm">암호 확인</label> <input type="password"
														id="pwConfirm" class="form-control" placeholder="암호 재입력">
												</div>
											</div>
											<div id="pwConfirmMsg" style="height: 1.6em"></div>


											<div class="form-actions center">
												<button type="submit" class="btn btn-primary"
													id="submitBtn2" disabled="disabled">
													<i class="icon-check2"></i> 저장
												</button>
											</div>
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
	<script>
	// input validation script
	
	// ID validation
	// 세 값이 모두 참이어야 '가입하기' 버튼이 활성화됨
	var validity = {
		"pwConfirm":false,
		"email":false
	};
	
	// enables Submit button when all three inputs are valid
	// 위의 세 값이 참인지 확인하는 함수
	function validCheckEmail(){
		if(validity["email"]){
			$("#submitBtn").removeAttr("disabled");
		}else{
			$("#submitBtn").attr("disabled", "disabled");
		}
	}
	function validCheckPw(){
		if(validity["pwConfirm"]){
			$("#submitBtn2").removeAttr("disabled");
		}else{
			$("#submitBtn2").attr("disabled", "disabled");
		}
	}
	
	// applies the result of validity check
	// 유효성 확인 결과를 위에서 정의한 validity에 적용하고, 정해진 메시지를 출력함
	// id : 입력 항목의 아이디
	// msg : 해당 항목 옆에 표시될 메시지 내용
	// valid : 유효성 검사 결과
	// focus : 해당 항목으로 커서가 돌아갈 지 지정함. 기본값은 false
	function validResult(id, msg, valid, focus=false){
		// 입력 항목 옆에 메시지를 출력함. 메시지가 표시되는 곳의 아이디는 입력항목의 아이디+Msg임.
		// 예) email 유효성 검사 메시시가 표시될 공간의 아이디는 emailMsg
		$("#"+id+"Msg").text(msg);
		
		// 값이 유효할 경우 포록색, 아닐 경우 빨간색으로 글씨색 표시
		$("#"+id+"Msg").attr("style", "color:"+(valid? "green":"red"));
		
		// 유효성 검사 결과를 위에서 정의한 validity 객체에 저장
		validity[id] = valid;
		
		// focus가 참일 경우 해당 입력항목으로 커서가 가게 한다
		if(focus){
			$("#"+id).focus();
		}
		
		// 입력 항목이 모두 유효한지 확인
		validCheckEmail();
		validCheckPw();
	}

	
	function validateEmail(){

		var valid = false;
		var msg = '';
		var query = {email : $("#email").val()};
		$.ajax({
			url:"${pageContext.request.contextPath}/emailCheck.do",
			type:"post",
			data:query,
			success:function(data){
				
				if(data==1){
					msg = "이미 등록된 이메일입니다.";
					$("#email").focus();
				}else{
					msg="사용 가능한 이메일입니다.";
					valid = true;
				}
				validResult("email", msg, valid, !valid);
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				alert('status:' + XMLHttpRequest.status + ', status text: ' +
					XMLHttpRequest.statusText);
			}
		});
	}
	// Password Validation function
	function validatePw(){
		var passwd = $("#pw").val();
		var pwdChk = $("#pwConfirm").val();
		var valid = false;
		var msg = '';
		if (passwd != pwdChk) {
			msg = "암호가 일치하지 않습니다."; 
			
		}else if (passwd == "") {
			msg = "암호를 입력해주세요.";
			
		}else{
			msg = "암호가 일치합니다.";
			valid = true;
			
		}
		validResult("pwConfirm", msg, valid);
	}
	
	// Email validation function

	
	
	$("#email").on('input', function() {
		var email = $("#email").val();
		var mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		var msg = "";
		if(email == ""){
			msg = "이메일을 입력해주세요."
			$("#emailCheck").attr("disabled", "disabled");
		}else if(!mailFormat.test(email)){
			msg = "유효하지 않은 이메일형식입니다."; 
			$("#emailCheck").attr("disabled", "disabled");
		}else{
			validateEmail();
			$("#emailCheck").removeAttr("disabled");
		}
		validResult("email", msg, false);
	});
	
	$("#pw").on('input', function(){
		validatePw();
	});
	$("#pwConfirm").on('input', function(){
		validatePw();
	});
	
</script>
	<%@include file="../footer.jsp"%>
</body>
</html>