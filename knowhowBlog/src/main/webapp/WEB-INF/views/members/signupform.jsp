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

           <form action="signup.do" method="post" class="form-signup">
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
                        <input id="id" name="id" type="text" class="line-input-main" placeholder="아이디"
                               autofocus>
                        <input id="name" name="name" type="text" class="line-input-main" placeholder="닉네임">
                        <input id="pwd" name="pwd" type="password" class="line-input-main"
                               placeholder="비밀번호">
                        <input id="pwd2" name="pwd2" type="password" class="line-input-main"
                               placeholder="비밀번호 확인">
                    </div>
                </div>
                <div id="login-link">
                    <input type="submit" value="회원가입" class="full-button-main hvr-shadow">
                </div>
            </form>
			
		</div>
	</div>
	<script>
	$("#id").on("keyup", function(){	
		var inputId=$("#id").val();
		$.ajax({
			url:"checkid.do",
			method:"get",
			data:{inputId:inputId},
			
			success:function(data){
				console.log(data);
				$("#id").parent()
				.removeClass("has-success has-error");
				if(data.canUse){
					$("#id")
					.parent()
					.addClass("has-success")
					.find(".help-block")
					.hide()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-remove")
					.addClass("glyphicon-ok");
				}else{
					$("#id")
					.parent()
					.addClass("has-error")
					
					.find(".help-block")
					.show()
					.parent()
					.find(".glyphicon")
					.removeClass("glyphicon-ok")
					.addClass("glyphicon-remove");
				}					
			}
		});
	});	
	</script>
</body>
</html>