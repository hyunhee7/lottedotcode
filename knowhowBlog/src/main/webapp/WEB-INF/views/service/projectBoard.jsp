<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String id = (String)session.getAttribute("id");
%>
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
        a {text-decoration:none;}
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
        <% if (id!=null ){ %>      
              <div class="mobile-hidden write col-lg-12">
                  <button type="button" class="btn btn-primary" style="float:right; margin-bottom:10px" onclick="location.href='projectInsertform.do'">프로젝트 생성</button> 
              </div>
          <%} %>
          <br />
          
          <c:choose>
              <c:when test="${empty list}">
                <div class="default-img" style="border:1px solid #e9e9e9;width:100%;height:250px;">
                    <p style="text-align: center;line-height: 250px;">등록된 포스트가 없습니다.</p>
                </div>
                <br /><br />              
              </c:when>
              <c:when test="${list ne null }">          
                  <!-- card1 -->
                  <c:forEach var="tmp" items="${list }">
                    <div class="col-lg-4 col-sm-6 portfolio-item">
                      <div class="card h-100">
                          <c:if test="${empty tmp.proj_imagePath}">
                            <a href="projectTimeline.do?num=${tmp.proj_num }" style="border-bottom:1px solid #e9e9e9;"><img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/defaultImg.png" alt=""></a>
                        </c:if>
                          <c:if test="${!empty tmp.proj_imagePath}"> 
                            <a href="projectTimeline.do?num=${tmp.proj_num }" ><img class="card-img-top" src="${pageContext.request.contextPath }/upload/${tmp.proj_imagePath}" style="height:200px;" alt=""></a>
                        </c:if>                
                        <div class="card-body">
                          <h4 class="card-title">
                            <a href="projectTimeline.do?num=${tmp.proj_num }">${tmp.proj_title }</a>
                          </h4>
                          <p class="card-text"><a href="projectTimeline.do?num=${tmp.proj_num }" style="text-decoration:none;color:#000000;">${tmp.proj_content }</a></p>

                        </div>
                      </div>
                    </div>
                </c:forEach>
                <!-- card1 fin. -->
              </c:when>
          </c:choose>              
       
      </div>
      <!-- /.row -->
      <br /><br />

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; LOTTE.CODE 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>
</html>