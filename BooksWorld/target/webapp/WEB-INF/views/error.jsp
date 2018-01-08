<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Books World</title>
<meta name="viewport" content="width=device-width", initial-scale=1">
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h1>Authentication Error</h1>
<h3>Go back to Home or<a href="${pageContext.request.contextPath }/reLogin">Login</a>page</h3>
<img class="img-rounded" class="img-responsive center block" src="<spring:url value="/resources/Error.jpg">

</div>



</body>
</html>