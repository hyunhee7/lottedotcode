<%@page import="com.mycompany.myapp.dto.MembersDto"%>
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
    	.CodeMirror, .CodeMirror-scroll {
			min-height: 50px;
		}	
	</style>    
    
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">



      <!-- Portfolio Section -->
      <h1 class="my-4">Recent Project</h1>

      <div class="row">
      
        <c:choose>
        	<c:when test="${empty projList}">
        		<div class="default-img" style="border:1px solid #e9e9e9;width:100%;height:250px;">
        			<p style="text-align: center;line-height: 250px;">등록된 포스트가 없습니다.</p>
        		</div>
        		<br /><br />
        	</c:when>
        	<c:when test="${projList ne null }">
		      	<!-- card1 -->
		      	<c:forEach var="tmp" items="${projList }">
			        <div class="col-lg-4 col-sm-6 portfolio-item">
			          <div class="card h-100">
			          	<c:if test="${empty tmp.proj_imagePath}">
			            	<a style="border-bottom:1px solid #e9e9e9;" href="projectTimeline.do?num=${tmp.proj_num }"><img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/defaultImg.png" alt=""></a>
			            </c:if>
			          	<c:if test="${!empty tmp.proj_imagePath}"> 
			            	<a style="border-bottom:1px solid #e9e9e9;" href="projectTimeline.do?num=${tmp.proj_num }" class="imgSize"><img class="card-img-top" src="${pageContext.request.contextPath }/upload/${tmp.proj_imagePath}" alt="" style="width:348px;height:200px;"></a>
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
        	
        	</c:when>        
        </c:choose>

      </div>
      <!-- /.row -->
		<br />
      <h1>Recent Knowhow</h1>
      
      <br />
      <!-- Marketing Icons Section -->
      <div class="row">

      	<!-- 카드1 -->
      	<c:choose>
      		<c:when test="${empty KhList}">
        		<div class="default-img" style="border:1px solid #e9e9e9;width:100%;height:250px;">
        			<p style="text-align: center;line-height: 250px;">등록된 포스트가 없습니다.</p>
        		</div>
        		<br /><br />      		
      		</c:when>
      		<c:when test="${KhList ne null }">
      			<!-- 카드1  -->
		       	<c:forEach var="tmp" items="${KhList }">
			        <div class="col-lg-4 mb-4">
			          <div class="card h-100">
			            <h4 class="card-header">${tmp.kh_title }</h4>
			          	<c:if test="${empty tmp.kh_filePath}">
			            	<a style="border-bottom:1px solid #e9e9e9;" href="knowhowDetail.do"><img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/defaultImg.png" alt=""></a>
			            </c:if>
			          	<c:if test="${!empty tmp.kh_filePath}"> 
			            	<a href="knowhowDetail.do"><img class="card-img-top" src="${pageContext.request.contextPath }/upload/${tmp.kh_filePath}" alt="" style="width:348px;height:200px;"></a>
			            </c:if>	            
			            <div class="">
			              <textarea class="form-control CodeMirror CodeMirror-scroll post_code_content" rows="3" style="margin-top:17px;" name="post_content"
				   			 >${tmp.kh_content }</textarea>
			            </div>	            
			            <div class="card-footer">
			              <a href="knowhowDetail.do?kh_num=${tmp.kh_num }" class="btn btn-primary">Learn More</a>
			            </div>
			          </div>
			        </div>
		        </c:forEach>
		        <!-- 카드1 fin. -->     		
      		</c:when>
      	</c:choose>
		<br />
      </div>
      <!-- /.row -->
      <br /><br />
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
		$('textarea').each(function() {
		    var simplemde = new SimpleMDE({
		        element: this,
		        toolbar: false,
				tabSize: 1,
				status: false
		    });
		    simplemde.togglePreview();
		});	
	</script>
</body>
</html>