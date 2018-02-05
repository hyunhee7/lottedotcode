<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <style>
    	.menu2 { font-weight : bold;}
    </style>    
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="navigationBar.jsp"></jsp:include>

    <!-- Page Content -->
    <div class="container">

      <h1 class="my-4">Develop Knowhow</h1>
      
      <br />
      
      <!-- Post Insert Btn -->
      <div class="mobile-hidden write col-lg-12" style="margin-left:15px;margin-top:5px;">
      		<button type="button" class="btn btn-primary" style="float:right; margin-bottom:10px" onclick="location.href='knowhowInsertform.do'">글쓰기</button> 
      </div>	      
      <!-- Marketing Icons Section -->
      <div class="row">
      
      	<!-- 카드1 -->
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">Card Title</h4>
            <a href="knowhowDetail.do"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer">
              <a href="knowhowDetail.do" class="btn btn-primary">Learn More</a>
            </div>
          </div>
        </div>
        <!-- 카드1 fin. -->
        
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