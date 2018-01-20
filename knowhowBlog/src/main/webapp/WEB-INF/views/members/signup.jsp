<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
  	<meta name="viewport" http-equiv="Content-Type"
          content="width=device-width, initial-scale=1 text/html; charset=utf-8">	
	<title>views/members/signup.jsp</title>
	
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
	<div class="signup-wrapper">
		<div class="popup-container">
            <div class="popup-header">
                <div class="ic-back"><a href="login.do"><img src="${pageContext.request.contextPath }/resources/images/ic-back.png"></a></div>
               <div class="title">회원가입</div>
           </div>

           <form class="form-signup">
               <div class="row">
                   <div class="col-md-4">
                       <div class="photo-wrap">
                           <img alt="profile picture css" class="pic-circle-corner" id="profile-preview"
                                src="${pageContext.request.contextPath }/resources/images/img-profile-empty.png"/>
                            <button class="main-line-button">사진등록</button>
                            <input type="file" id="photo" accept="image/*" class="file_input_hidden" name="profile_img">
                        </div>
                    </div>
                    <div class="col-md-8">
                        <input id="email" name="user_email" type="email" class="line-input-main" placeholder="이메일"
                               autofocus>
                        <input id="name" name="user_name" type="text" class="line-input-main" placeholder="닉네임">
                        <input id="password1" name="user_password1" type="password" class="line-input-main"
                               placeholder="비밀번호">
                        <input id="password2" name="user_password2" type="password" class="line-input-main"
                               placeholder="비밀번호 확인">
                    </div>
                </div>
                <div id="login-link">
                    <input type="submit" value="회원가입" class="full-button-main hvr-shadow">
                </div>
            </form>
			
		</div>
	</div>
</body>
</html>