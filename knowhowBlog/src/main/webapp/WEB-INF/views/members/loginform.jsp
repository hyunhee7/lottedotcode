<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cPath = request.getContextPath();
	String url = request.getParameter("url");
	if(url==null){ //만일 없으면
		//인덱스 페이지로 이동 될 수 있도록 
		url=request.getContextPath();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
	  	<meta name="viewport" http-equiv="Content-Type"
          content="width=device-width, initial-scale=1 text/html; charset=utf-8">
	<title>views/members/login.jsp</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/basic.css" />			
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/member.css" />	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/home.css" />	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hover-min.css" />	
	
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
    <!-- Angular.js -->
    <script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script> 
</head>
<body class="background-color">
	<div class="login-wrapper">
		<div class="container">
			<div class="col-md-4 col-xs-12 col-md-offset-4 width-center">
				<div class="img-mockup">
					<img src="${pageContext.request.contextPath }/resources/images/logo.png">
				</div>
				<div class="logo">LOTTE.CODE</div>
				<p class="login-sublogo" style="font-size:13px">LOTTE.COM의 CODE를 공유하는 공간</p>
				
				<form action="login.do">
					<div class="form-login">
						<div class="form-group">
							<input name="id" type="text" class="line-input-white" id="login-id" placeholder="아이디">
						</div>
						<div class="form-group">
							<input name="pwd" type="password" class="line-input-white" id="login-password" placeholder="비밀번호">
						</div>
						<a href="main.do"><input type="submit" class="full-button-white hvr-shadow" value="로그인"></a>
					</div>
				</form>
				<div class="login-bottom">
				<p>아직도 가입을 안하셨나요? &nbsp;&nbsp; <a class="signup-hover" href="signupform.do">회원가입 하기</a>
				</p>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		
	</script>
</body>
</html>