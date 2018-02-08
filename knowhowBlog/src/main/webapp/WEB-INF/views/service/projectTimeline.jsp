<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String proj_num = (String)request.getParameter("num"); 
	String id = (String)session.getAttribute("id");
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/marked/0.3.12/marked.min.js"></script>
    <style>
    	.menu1 { font-weight : bold;}
    	.CodeMirror, .CodeMirror-scroll {
			min-height: 50px;
		}
    	@media (max-width: 750px) {   
			 .mobile-hidden{
			 	display:none;!important;
			 }
		}
		@media (min-width: 768px) {         
			 .web-hidden{
			 	display:none;!important;
			 }
		}  		
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

		     <li class="breadcrumb-item active">${pdto.proj_title }</li>  
        </ol>
 		<div  style="border:1px solid #e9e9e9;width:100%;height: auto;padding:10px;margin-bottom:5px;">
 			<li>프로젝트 명: ${pdto.proj_title }</li>
 			<li>내용 : ${pdto.proj_content }</li>
 		</div>
 		
 		
      <!-- Post Insert Btn -->
      <% if (id!=null ){ %>    
      <div class="mobile-hidden write col-lg-12" style="margin-left:15px;">
      		<button type="button" class="btn btn-primary mobile-hidden" style="font-size:13px;float:right;" onclick="location.href='projPostInsertform.do?num=<%=proj_num%>'">Post쓰기</button> 
      </div>    	 
      <% } %>

       <c:set value="${pdto.proj_writer }" var="proj_writer"/>
       <% String proj_writer = (String)pageContext.getAttribute("proj_writer"); %>
 
 	   <% if (proj_writer.equals(id) ){ %>
	      <div class="mobile-hidden write col-lg-12" style="margin-left:15px;">
	      		<button type="button" class="btn btn-primary mobile-hidden" style="font-size:13px;float:right; margin-right:2px" onclick="location.href='projectUpdateform.do?num=<%=proj_num%>'">프로젝트 수정</button> 
	      </div>      
	      <div class="mobile-hidden write col-lg-12" style="margin-left:15px;">
	      		<button type="button" class="btn btn-primary mobile-hidden" style="font-size:13px;float:right; margin-right:2px" onclick="location.href='projectDelete.do?num=<%=proj_num%>'">프로젝트 삭제</button> 
	      </div>    
	    <%} %>

      <br />
      <br />
      
        <c:choose>
        	<c:when test="${empty list}">
        		<div class="default-img" style="border:1px solid #e9e9e9;width:100%;height:250px;">
        			<p style="text-align: center;line-height: 250px;">등록된 포스트가 없습니다.</p>
        		</div>
        		<br /><br />
        	</c:when> 
        	<c:when test="${list ne null }">     
			      <!-- Blog Post1 -->
			      <c:forEach var="tmp" items="${list }">
				      <div class="card mb-4">
				        <div class="card-body">
				          <div class="row">
				
				            <div class="col-lg-12">
				              <h2 class="card-title">${tmp.post_title }</h2>
			
			
				              <div class="">
				              <textarea class="form-control CodeMirror CodeMirror-scroll post_code_content" rows="3" style="margin-top:17px;" name="post_content"
					   			 >${tmp.post_content }</textarea>
				              </div>
				              <br />
				              
				              <a href="projPostDetail.do?proj_num=${tmp.post_proj_num }&post_num=${tmp.post_num}" class="btn btn-primary">Read More &rarr;</a>
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
			   </c:when>
		</c:choose>
      


<!--       Pagination
      <ul class="pagination justify-content-center mb-4">
        <li class="page-item">
          <a class="page-link" href="#">&larr; Older</a>
        </li>
        <li class="page-item disabled">
          <a class="page-link" href="#">Newer &rarr;</a>
        </li>
      </ul> -->

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
<!-- 	<script>
		document.getElementById('post_content').innerHTML = marked($("#post_content").val());
	</script> -->
	<script>

	
	$('textarea').each(function() {
	    var simplemde = new SimpleMDE({
	        element: this,
	        toolbar: false,
			tabSize: 1,
			status: false
	    });
	    simplemde.togglePreview();
	})
	
	</script>
</body>
</html>