<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String id = (String)session.getAttribute("id");
    String tag_name = (String)request.getParameter("tag_name");
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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vendor/bootstrap/css/custom.css" />
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/resources/css/modern-business.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/resources/css/main-custom.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    
    <!-- Editor -->
    <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/marked/0.3.12/marked.min.js"></script>    
    <style>
        .menu2 { font-weight : bold;}
        .CodeMirror, .CodeMirror-scroll {
            min-height: 148px;
            
        }        
    </style>    
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">

      <h2 class="my-4">"<%=tag_name %>" 태그 관련 검색 결과</h2>
          
      <br /> 
      <!-- Marketing Icons Section -->
      <div class="row">

          <c:choose>
              <c:when test="${empty list}">
                <div class="default-img" style="border:1px solid #e9e9e9;width:100%;height:250px;">
                    <p style="text-align: center;line-height: 250px;">해당 태그의 검색 결과가 없습니다.</p>
                </div>
                <br /><br />              
              </c:when>
              <c:when test="${list ne null }">
                  <!-- 카드1 -->
                  <c:forEach var="tmp" items="${list }">
                    <div class="col-lg-4 mb-4">
                      <div class="card h-100">
                        <h4 class="card-header">${tmp.kh_title }</h4>
                          <c:if test="${empty tmp.kh_filePath}">
                            <a href="knowhowDetail.do?kh_num=${tmp.kh_num }" style="border-bottom:1px solid #e9e9e9;"><img class="card-img-top" src="${pageContext.request.contextPath }/resources/images/defaultImg.png" alt=""></a>
                        </c:if>
                          <c:if test="${!empty tmp.kh_filePath}"> 
                            <a href="knowhowDetail.do?kh_num=${tmp.kh_num }"><img class="card-img-top" src="${pageContext.request.contextPath }/upload/${tmp.kh_filePath}" alt="" style="width:348px;height:200px;"></a>
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
          <br />    <br />    
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->
<br /><br /><br />
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
    })
        
    
    </script>
</body>
</html>