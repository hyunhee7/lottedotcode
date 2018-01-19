<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>views/home.do</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />		
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/home.css" />	
	
	<!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery-3.2.0.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
    <!-- Angular.js -->
    <script src="${pageContext.request.contextPath }/resources/js/angular.min.js"></script> 		
</head>
<body>

	<h1>
		Hello world!  
	</h1>
	<div data-ng-app="" data-ng-init="firstName='John'">
	 
	<p>The name is <span data-ng-bind="firstName"></span></p>
	 
	</div>

</body>
</html>
