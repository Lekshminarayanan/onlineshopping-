<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!doctype html>
<html>
<head>

<title>Books World</title>
<meta name="viewport" content="width-device", initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">


</head>


<body>
<nav id="navbar-black" class="navbar navbar-inverse navbar-static-top" role="navigation">



<div class="container">
<ul class="nav navbar-nav">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navDemo">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span></button>
</ul>
</div>
<div class="collapse navbar-collapse" id="navDemo">
<ul class="nav navbar-nav">
<li><a href="index">Home</a>
<li><a href="contact.jsp"><i class="fa fa-address-book" aria-hidden="true"></i></a></li>
<li><a href="productList">Product List</a>
<li><a href="/admin/adding">Admin</a><li>
<li class="dropdown"><a class="dropdowntoggle" data-toggle="dropdown" href="#">Admin List<span class="caret"></span></a>

<ul class="dropdown-mwnu">
<li><a href="${pageContext.request.contextPath }/admin/productList">Product</a></li>
<li><a href="${pageContext.request.contextPath }/admin/supplierList">Supplier</a></li>
<li><a href="${pageContext.request.contextPath }/admin/categoryList">Category</a></li>
</ul>
</li>

<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
Category Choice <span class="caret></span></a>



<ul class="dropdown-menu">
<c:forEach var="catVal" items="${catList }">
<li><a href="${pageContext.request.contextPath }/ProductCustList?cid=${catVal.cid}">${catVal.cname}</a></li>

</c:foeEach>
</ul>


<ul class="nav navbar-nav navbar right">

<c:if test="${pageContext.request.userPrincipal.name==null }">
<li><a href="${pageContext.request.contextPath }/goToRegister"></a></li>
<li><a href="${pageContext.request.contextPath }/goToLogin"></a></li>
</c:if>

<c:if test="${pageContext.request.userPrincipal.name!=null }">
<li><a>Welcome:${pageContext.request.userPrincipal.name }></a></li>
<li><a href="${pageContext.request.contextPath }/Logout">Logout</a></li>
</c:if>

</ul>
</li>

</div> 

</nav>

</body>
</html>