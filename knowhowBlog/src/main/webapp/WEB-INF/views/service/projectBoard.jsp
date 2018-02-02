<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>service/projectList.jsp</title>

    <!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/custom.css" />
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/modern-business.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/main-custom.css" rel="stylesheet">
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hover-min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.css"/>	
  
    <style>
    	.menu1 { font-weight : bold;}
    </style>
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">



     <!-- Portfolio Section -->
	 <h1 class="my-4 col-xs-12">Project Board</h1>

      <div class="row">
      	<div class="mobile-hidden write col-lg-12">
      		<button type="button" class="btn btn-primary" style="float:right; margin-bottom:10px" onclick="location.href='projectInsertform.do'">글쓰기</button> 
      	</div>
      	<br />
      	
      	<!-- card1 -->
      	<c:forEach var="tmp" items="${list }">
	        <div class="col-lg-4 col-sm-6 portfolio-item">
	          <div class="card h-100">
	          	<c:if test="${empty tmp.proj_imagePath}">
	            	<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
	            </c:if>
	          	<c:if test="${!empty tmp.proj_imagePath}"> 
	            	<a href="#" class="imgSize"><img class="card-img-top" src="${pageContext.request.contextPath }/upload/${tmp.proj_imagePath}" alt="" style="height:100%;"></a>
	            </c:if>	            
	            <div class="card-body">
	              <h4 class="card-title">
	                <a href="projectTimeline.do?num=${tmp.proj_num }">${tmp.proj_title }</a>
	              </h4>
	              <p class="card-text">${tmp.proj_content }</p>
	            </div>
	          </div>
	        </div>
        </c:forEach>
        <!-- card1 fin. -->
        
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Six</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
            </div>
          </div>
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

</body>
</html>