<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String proj_num = (String)request.getParameter("proj_num"); %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" http-equiv="Content-Type"
          content="width=device-width, initial-scale=1 text/html; charset=utf-8">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>service/projectList.jsp</title>

    
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/modern-business.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/main-custom.css"/>
      <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hover-min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.css"/>        
    
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/custom.css" />
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
    <!-- Angular.js -->
    <script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script> 
  
    <style>
        .menu1 { font-weight : bold;}
    </style>
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">
        <h1 class="my-4 col-xs-12">Project Write</h1>
        <form action="projectInsert.do" method="post" enctype="multipart/form-data" id="projForm">
          <div class="form-group">
            <input type="text" class="form-control" id="proj_title" name="proj_title" placeholder="프로젝트 명">
          </div>
          <div class="custom-file">
             
            <input type="file" class="form-control-file" id="exampleInputFile"  name="uploadImage" aria-describedby="fileHelp">
          </div>
          <div class="form-group">
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="13" style="margin-top:17px;" name="proj_content"
            placeholder="프로젝트 부가 설명" ></textarea>
          </div>          
          <div style="text-align: center;">
          <div style="display: table; margin-left: auto; margin-right: auto; display: inline-block;">
                  <button type="submit" class="btn btn-b hvr-shadow" style="margin-right:10px" >등록</button>
                  <button type="button" class="btn btn-b hvr-shadow" onclick="location.href='projectBoard.do'">취소</button> 
          </div>    
        </div>
        </form>    

    </div>
    <script>
        $("#projForm").submit(function(){
            var proj_title = $('#proj_title').val();
            if(proj_title==""){
                 alert( "프로젝트 제목을 써주세요!" );
                 event.preventDefault();
            }
       });    
    </script>
</body>
</html>