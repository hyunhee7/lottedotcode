<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form>
		  <div class="form-group">
		    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="프로젝트 명">
		  </div>
		  <div class="custom-file">
		 	<input type="file" class="custom-file-input" id="customFile">
			<label class="custom-file-label" for="customFile">Choose file</label>
		  </div>
		  <div class="form-group">
		    <textarea class="form-control" id="exampleFormControlTextarea1" rows="13" style="margin-top:17px;" placeholder="프로젝트 부가 설명"></textarea>
		  </div>		  
		</form>    
		<div style="text-align: center;">
      	<div style="display: table; margin-left: auto; margin-right: auto; display: inline-block;">
      		<button type="button" class="btn btn-b hvr-shadow" style="margin-right:10pxr" onclick="location.href='projectInsertform.do'">등록</button>
      		<button type="button" class="btn btn-b hvr-shadow" onclick="location.href='projectInsertform.do'">취소</button> 
      	</div>    
    	</div>
    </div>
</body>
</html>