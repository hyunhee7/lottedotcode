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
       <script src="https://cdnjs.cloudflare.com/ajax/libs/marked/0.3.12/marked.min.js"></script>
       <script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

       
    <style>
        .menu1 { font-weight : bold;}
        .CodeMirror, .CodeMirror-scroll {
            min-height: 250px;
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
      <h1 class="mt-4 mb-3">${dto.post_title}
        <small style="font-size:25px;"> by
          <a href="#" >${dto.post_regr_id}</a>
        </small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="${pageContext.request.contextPath }/service/projectTimeline.do?num=${dto.post_proj_num}">Project Timeline</a>
        </li>
        <li class="breadcrumb-item active">${dto.post_title }</li>
      </ol>

      <div class="row">

        <!-- Post Content Column -->
        <div class="col-lg-8">

<!--           Preview Image
          <img class="img-fluid rounded" src="http://placehold.it/900x300" alt="">
 -->
          <hr>
          <c:set value="${dto.post_regr_id }" var="post_regr_id"/>
          <% String post_regr_id = (String)pageContext.getAttribute("post_regr_id"); %>
          
          <% if (post_regr_id.equals(regr_id) ){ %>
          <!-- Post Insert Btn -->
            <button type="button" class="btn btn-primary mobile-hidden" style="float:right; margin-bottom:15px; font-size:10px;" onclick="location.href='postUpdateform.do?proj_num=${dto.post_proj_num }&post_num=${dto.post_num}'">수정</button>
            <button type="button" class="btn btn-primary mobile-hidden" style="float:right; margin-bottom:15px; margin-right:2px;font-size:10px;" onclick="location.href='postDelete.do?proj_num=${dto.post_proj_num }&post_num=${dto.post_num}'">삭제</button>  
          <%} %>
          <!-- Date/Time -->
          <p>Posted on ${dto.post_reg_dtime}</p>

          <hr>
          <c:choose>
              <c:when test="${!empty dto.post_filePath}">
                    <div style="border:1px solid #e9e9e9" class="mobile-hidden">
                        <p style="margin:2px 3px 0 3px "><i class="fas fa-file" style="margin-right:3px"></i> <a href="FileDownload.do?proj_num=${dto.post_proj_num}&post_num=${dto.post_num}">${dto.post_filePath}</a></p>
                    </div>
                    <div style="border:1px solid #e9e9e9" class="web-hidden">
                        <p style="margin:2px 3px 0 3px "><i class="fas fa-file" style="margin-right:3px"></i> 첨부파일은 PC에서만 확인 가능합니다.</p>
                    </div>                      
                    <br />         
              </c:when> 
              <c:when test="${empty dto.post_filePath}">
                    <div style="display:none">
                        <p style="margin:2px 3px 0 3px "><i class="fas fa-file" style="margin-right:3px"></i> ${dto.post_filePath}</p>
                    </div>          
              </c:when>                        
          </c:choose>
          
          

          <!-- Post Content -->
          <textarea class="form-control CodeMirror CodeMirror-scroll post_code_content" rows="3" style="margin-top:17px;" name="post_content"
             >${dto.post_content }</textarea>

          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">Leave a Comment:</h5>
            <div class="card-body">
              <form action="PostCommentInsert.do" method="post" id="postCmt">
                <div class="form-group">
                  <textarea class="form-control" name="cmt_content" rows="3"></textarea>
                </div>
                <div class="form-group">
                      <input type=hidden name="cmt_post_num" value="${dto.post_num }"> 
                      <input type=hidden name="cmt_proj_num" value="${dto.post_proj_num }"> 
                      <input type=hidden id="cmt_writer" value="${sessionScope.id}"> 
                </div>   
                    <button type="submit" class="btn btn-primary" id="cmtSubmit">Submit</button>
              </form>
            </div>
          </div>

          <!-- Single Comment -->
          <c:forEach items="${dto.cmts}" var="cmtList">
          <div class="media mb-4" style="padding:0 0 5px 0; border-bottom:1px solid #e9e9e9;">
            <img class="d-flex mr-3 rounded-circle" id="profile-preview" src="${pageContext.request.contextPath }/upload/${cmtList.cmt_imgPath}" style="width:50px;height:50px;">
            <div class="media-body">
              <h5 class="mt-0">${cmtList.cmt_regr_id}</h5>
              ${cmtList.cmt_content}
            </div>
          </div>
          </c:forEach>


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

                   
                    <c:forEach items="${dto.post_tag}" var="list">
                            <li>
                              <a href="#">${list.tag_name}</a>
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
        
        $("#postCmt").submit(function(){
             var cmt_writer = $('#cmt_writer').val();
             console.log(cmt_writer);
             if(cmt_writer==""){
                  alert( "로그인이 필요합니다!" );
                  event.preventDefault();
             }
        });
    </script>
</body>
</html>