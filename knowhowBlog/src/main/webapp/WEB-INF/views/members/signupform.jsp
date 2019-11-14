<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta name="viewport" http-equiv="Content-Type"
          content="width=device-width, initial-scale=1 text/html; charset=utf-8">    
    <title>views/members/signup.jsp</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/basic.css" />            
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/member.css" />        
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hover-min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.css"/>    
    
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
    <!-- Angular.js -->
    <script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script> 
    <style>
        @media (max-width: 750px) {   
             .mobile-hidden{
                 display:none;!important;
             }
             .background-color{
                 background-color:#ffffff; !important;
             }
        }
        @media (min-width: 768px) {         
             .web-hidden{
                 display:none;!important;
             }
        }
   
    
    </style>
</head>
<body class="background-color">
    <div class="signup-wrapper">
        <div class="popup-container">
            <div class="popup-header">
                <div class="ic-back"><a href="loginform.do"><img src="${pageContext.request.contextPath }/resources/images/ic-back.png"></a></div>
               <div class="title">회원가입</div>
           </div>

           <form action="signup.do" method="post" class="form-signup" enctype="multipart/form-data">
               <div class="row">
                       <div class="mobile-hidden">
                       <div class="col-md-4">
                           <div class="photo-wrap">
                               <img alt="profile picture css" class="pic-circle-corner" id="profile-preview"
                                    src="${pageContext.request.contextPath }/resources/images/img-profile-empty.png"/>
                                <button class="main-line-button">사진등록</button>
                                <input type="file" id="image" accept="image/*" class="file_input_hidden" name="uploadImage">
                            </div>
                        </div>
                    </div>    
                    <div class="web-hidden">
                           <div class="col-md-4">
                           <div class="photo-wrap  ">
                               <img alt="profile picture css" class="pic-circle-corner" id="profile-preview"
                                    src="${pageContext.request.contextPath }/resources/images/logo.png"/>
                            </div>
                            </div>                          
                    </div>
              
                    
                    <div class="col-md-8">
                        <input id="id" name="id" type="text" class="line-input-main" placeholder="아이디"
                               autofocus>
                               <p class="help-block" style="display:none" ></p>
                        <input id="name" name="name" type="text" class="line-input-main" placeholder="닉네임">
                        <input id="pwd" name="pwd" type="password" class="line-input-main"
                               placeholder="비밀번호">
                        <input id="pwd2" name="pwd2" type="password" class="line-input-main"
                               placeholder="비밀번호 확인">
                        <p style="color:#999999; font-size:10px;">* 비밀번호는 4자리 이상 입력해주세요.</p>
                    </div>
                </div>
                <div id="login-link">
                    <input type="submit" value="회원가입" id="signupBtn" class="full-button-main hvr-shadow">
                </div>
            </form>
            
        </div>
    </div>
    <script>

    /* 유효성검사 */
    $("#id").on("keyup", function(){    
        var inputId=$("#id").val();
        if(inputId==""){
            $(".help-block").text("");
        }
        $.ajax({
            url:"checkid.do",
            method:"get",
            data:{inputId:inputId},
            
            success:function(data){
                
                if(data.canUse){
                    $("#id")
                    .parent()
                    .removeClass("has-error")
                    .addClass("has-success")                    
                    .find(".help-block")
                    .show()
                    .text("사용 가능합니다.");
                    $("#signupBtn").attr('disabled',false).css("background-color","#518ddd").addClass("hvr-shadow");
                }else{
                    $("#id")
                    .parent()
                    .removeClass("has-success")
                    .addClass("has-error")
                    .find(".help-block")
                    .show()
                    .text("이미 사용중인 아이디 입니다.");
                    $("#signupBtn").attr('disabled',true).css("background-color","#bababa").removeClass("hvr-shadow");
                }                    
            }
        });
    });    
    
    /* 예외처리  */
    $("form").submit(function () {
        if ( $('#id').val() == '' || $('#pwd').val() == '' || 
             $('#pwd2').val() == '' || $('#name').val() == '') {
                alert('모든 정보를 입력해주세요.');
            return false;
        }
        if ($("#pwd").val() != $("#pwd2").val()) {
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }
        if($("#pwd").val().length<4) {
            alert("비밀번호를 4자리 이상 입력해주세요.");
            return false;
        }
    });

    /* 첨부사진 미리보기 */
    var upload = document.getElementsByTagName('input')[0],
    holder = document.getElementById('profile-preview');

    upload.onchange = function (e) {
      e.preventDefault();
      var file = upload.files[0],
          reader = new FileReader();
      reader.onload = function (event) {
        $("#profile-preview").removeAttr("src");
        var img = new Image();
        img.src = event.target.result;
        // note: no onload required since we've got the dataurl...I think! :)
        if (img.width > 560) { // holder width
          img.width = 30;
        }
        $("#profile-preview").attr('src', img.src)
                             .css("width","100px")
                             .css("height","100px")
                             .css("border-radius", "50%")
                             .css("border","1px solid #e5e5e5");
      };
      reader.readAsDataURL(file);
      return false;
    };    
    
    </script>
</body>
</html>