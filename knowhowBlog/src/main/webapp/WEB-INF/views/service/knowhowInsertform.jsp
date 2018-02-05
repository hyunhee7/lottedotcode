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
	<!-- Editor --> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    <!-- tag -->
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/tagsinput.css">  
    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/custom.css" />
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
	<!-- Editor -->
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	
    <style>
    	.menu1 { font-weight : bold;}
    </style>
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">
    	<h1 class="my-4 col-xs-12">Post Write</h1>
		<form action="knowhowInsert.do" method="post" enctype="multipart/form-data" id="postForm">
		  <div class="form-group">
		    <input type="text" class="form-control" id="post_title" name="kh_title" placeholder="포스트 명">
		  </div>
		  <div class="custom-file">
		 	<input type="file" class="custom-file-input" id="post_file" name="uploadImage">
			<label class="custom-file-label" for="customFile">Choose file</label>
		  </div>
		  <br /><br />
		  <div class="form-group">
		    <textarea class="form-control" id="post_code_content" rows="13" style="margin-top:17px;" name="kh_content"
		    placeholder="포스트 내용" ></textarea>
		  </div>
          <div class="form-group bs-example">
            <input type="text" value="java,spring,javascript" data-role="tagsinput" name="tags" />
          </div>	
            	
	  	  <br /><br /> 
	  	           	  
		  <div style="text-align: center;">
	      <div style="display: table; margin-left: auto; margin-right: auto; display: inline-block;">
	      		<button type="submit" class="btn btn-b hvr-shadow" style="margin-right:10px" id="submitBtn">등록</button>
	      		<button type="button" class="btn btn-b hvr-shadow" onclick="location.href='knowhowList.do'">취소</button> 
	      </div>    
    	</div>
		</form> 
		<br />   
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/typeahead.js/0.11.1/typeahead.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.20/angular.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/dist/bootstrap-tagsinput.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/dist/bootstrap-tagsinput-angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/rainbow.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/generic.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/html.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/rainbow/1.2.0/js/language/javascript.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/app.js"></script>
    <script src="${pageContext.request.contextPath }/resources/assets/app_bs3.js"></script>    
    <script src="${pageContext.request.contextPath }/resources/js/tagsinput.js"></script>  
	<script>
		var simplemde = new SimpleMDE({
/* 			previewRender: function(plainText) {
				return customMarkdownParser(plainText); // Returns HTML from a custom parser
			}	 */		
		});
		simplemde.value("이곳에 `code`를 입력해보세요!");
	</script>
</body>
</html>