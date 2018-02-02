<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String proj_num = (String)request.getParameter("num"); 
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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
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

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Project Timeline
        <!-- <small>PC</small> -->
      </h1>
 	  
 	  <!-- Current location -->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="projectBoard.do">Project Board</a>
        </li>
        
        <c:forEach var="tmp" items="${list }">
		   <li class="breadcrumb-item active">${tmp.post_num }</li>
		   <c:set var="count" value="${count+1}" /> 
        </c:forEach>
      </ol>

      <!-- Post Insert Btn -->
      <div class="mobile-hidden write col-lg-12" style="margin-left:15px;margin-top:5px;">
      		<button type="button" class="btn btn-primary" style="float:right; margin-bottom:10px" onclick="location.href='projPostInsertform.do?num=<%=proj_num%>&post_num=${count+1 }'">글쓰기</button> 
      </div>	 
      
      <br />
      <br />
      
      <!-- Blog Post1 -->
      <c:forEach var="tmp" items="${list }">
	      <div class="card mb-4">
	        <div class="card-body">
	          <div class="row">
	
	            <div class="col-lg-12">
	              <h2 class="card-title">${tmp.post_title }</h2>
	              <p class="card-text" id="post_content">${tmp.post_content }</p>
	              <a href="projectDetail.do" class="btn btn-primary">Read More &rarr;</a>
	            </div>
	          </div>
	        </div>
	        <div class="card-footer text-muted">
	          Posted on ${tmp.post_reg_dtime } by
	          <a href="#">${tmp.post_regr_id }</a>
	        </div>
	      </div>
      </c:forEach>
      <!-- Blog Post1 fin. -->
      
      
      <!-- Default Post -->
      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12">
              <h2 class="card-title">Post Title</h2>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!</p>
              <a href="#" class="btn btn-primary">Read More &rarr;</a>
            </div>
          </div>
        </div>
        <div class="card-footer text-muted">
          Posted on January 1, 2017 by
          <a href="#">Start Bootstrap</a>
        </div>
      </div>


      <!-- Pagination -->
      <ul class="pagination justify-content-center mb-4">
        <li class="page-item">
          <a class="page-link" href="#">&larr; Older</a>
        </li>
        <li class="page-item disabled">
          <a class="page-link" href="#">Newer &rarr;</a>
        </li>
      </ul>

    </div>

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
		});
		
		simplemde.codemirror.ondoc.markText();
	</script>
</body>
</html>