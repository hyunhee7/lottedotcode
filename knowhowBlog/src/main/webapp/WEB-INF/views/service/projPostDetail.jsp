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
    <style>
    	.menu1 { font-weight : bold;}
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

          <!-- Date/Time -->
          <p>Posted on ${dto.post_reg_dtime}</p>

          <hr>

          <!-- Post Content -->
          <textarea class="form-control CodeMirror CodeMirror-scroll post_code_content" rows="3" style="margin-top:17px;" name="post_content"
			 >${dto.post_content }</textarea>

          <hr>

          <!-- Comments Form -->
          <div class="card my-4">
            <h5 class="card-header">Leave a Comment:</h5>
            <div class="card-body">
              <form>
                <div class="form-group">
                  <textarea class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
              </form>
            </div>
          </div>

          <!-- Single Comment -->
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">Commenter Name</h5>
              Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
            </div>
          </div>

          <!-- Comment with nested comments -->
          <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
            <div class="media-body">
              <h5 class="mt-0">김현희</h5>
              	안녕하세요! 해당 API를 확인했습니다. 오류에 대해 확인하여 새로 포스팅하였으니 확인하시고 회신 부탁드립니다!

<!--               <div class="media mt-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                  <h5 class="mt-0">Commenter Name</h5>
                  Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
              </div>

              <div class="media mt-4">
                <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                <div class="media-body">
                  <h5 class="mt-0">Commenter Name</h5>
                  Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
                </div>
              </div> -->

            </div>
          </div>

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
	</script>
</body>
</html>