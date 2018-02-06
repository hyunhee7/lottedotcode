<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String regr_id = (String)session.getAttribute("id");
	System.out.println(regr_id);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>service/index.jsp</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" />

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/modern-business.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/main-custom.css" rel="stylesheet">
    
    <!-- Editor -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    
    <!-- Editor -->
    <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>    
    <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>
    
    <style>
    	.menu2 { font-weight : bold;}
    </style>    
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>


    <!-- Page Content -->
    <div class="container">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">${dto.kh_title }
        <small style="font-size:25px;"> by
          <a href="#" >${dto.kh_regr_id}</a>
        </small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/service/knowhowList.do?num=${dto.kh_num}">Knowhow List</a>
        </li>
        <li class="breadcrumb-item active">${dto.kh_title }</li>
      </ol>

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

<!--           Preview Image
          <img class="img-fluid rounded" src="http://placehold.it/900x300" alt=""> -->
	
          <hr>
          <c:set value="${dto.kh_regr_id }" var="kh_regr_id"/>
          <% String kh_reg = (String)pageContext.getAttribute("kh_regr_id"); %>

		  <% if (kh_reg.equals(regr_id) ){ %>
		  <!-- Post Insert Btn -->
      	  <button type="button" class="btn btn-primary" style="float:right; margin-bottom:15px; font-size:10px;" onclick="location.href='knowhowUpdateform.do?kh_num=${dto.kh_num}'">수정</button>
      	  <button type="button" class="btn btn-primary" style="float:right; margin-bottom:15px; margin-right:2px;font-size:10px;" onclick="location.href='knowhowDelete.do?kh_num=${dto.kh_num}'">삭제</button>  
		  <%} %>
          <!-- Date/Time -->
          <p>Posted on ${dto.kh_reg_dtime }</p>

          <hr>
          <c:choose>
	          <c:when test="${!empty dto.kh_filePath}">
					<div style="border:1px solid #e9e9e9">
						<p style="margin:2px 3px 0 3px "><i class="fas fa-file" style="margin-right:3px"></i> <a href="khFileDownload.do?kh_num=${dto.kh_num}">${dto.kh_filePath}</a></p>
					</div> 
					<br />         
	          </c:when> 
	          
	          <c:when test="${empty dto.kh_filePath}">
					<div style="display:none">
						<p style="margin:2px 3px 0 3px "><i class="fas fa-file" style="margin-right:3px"></i> ${dto.kh_filePath}</p>
					</div>          
	          </c:when> 		                             
          </c:choose>
          <!-- Post Content -->
          <textarea class="form-control CodeMirror CodeMirror-scroll post_code_content" rows="3" style="margin-top:17px;" name="post_content"
			 >${dto.kh_content }</textarea>

          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">Leave a Comment:</h5>
            <div class="card-body">
              <form action="commentInsert.do" method="post">
                <div class="form-group">
                  <textarea class="form-control" name="cmt_content" rows="3"></textarea>
                </div>
			    <div class="form-group">
			  		<input type=hidden name="cmt_kh_num" value="${dto.kh_num }"> 
			    </div>                
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
          </div>

          <!-- Single Comment -->
          <c:forEach items="${dto.cmts}" var="cmtList">
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" id="profile-preview" src="${pageContext.request.contextPath }/upload/${cmtList.cmt_imgPath}" style="width:50px;height:50px;">
            <div class="media-body">
              <h5 class="mt-0">${cmtList.cmt_regr_id}</h5>
              ${cmtList.cmt_content}
            </div>
          </div>
          </c:forEach>
          
<!-- 
          Comment with nested comments
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">김현희</h5>
				안녕하세요! 이번 발생 오류가 저번과 유사하여 큰 도움이 되었습니다! 감사합니다^^
            </div>
          </div>
          Comment Fin. -->

        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

          <!-- Categories Widget -->
          <div class="card my-4">
            <h5 class="card-header">Related Tag</h5>
            <div class="card-body">
              <div class="row">
                <div class="col-lg-6">
                  <ul class="list-unstyled mb-0">
					<c:forEach items="${dto.post_tag}" var="TagList">
		                    <li>
		                      <a href="#">${TagList.tag_name}</a>
		                    </li>
					</c:forEach>   
                  </ul>
                </div>
              </div>
            </div>
          </div>

<!--           Side Widget
          <div class="card my-4">
            <h5 class="card-header">Side Widget</h5>
            <div class="card-body">
              You can put anything you want inside of these side widgets. They are easy to use, and feature the new Bootstrap 4 card containers!
            </div>
          </div> -->

        </div>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script>
	    var simplemde = new SimpleMDE({
	        toolbar: false
	    });
	    simplemde.togglePreview();
	    
		$("#profile-preview")
		 .css("width","50px")
		 .css("height","50px")
		 .css("border-radius", "50%")
		 .css("border","1px solid #e5e5e5");
			    
	</script>
</body>
</html>