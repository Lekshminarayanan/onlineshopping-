<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Books World</title>
<meta name="viewport" content="width=device-width" , initial-scale=1">
<meta charset="utf-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/Views/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 item-photo">
				<img style="max-width: 100%; margin-top: 30px;"
					src="${pageContext.request.contextPath }/resources/${prod.imgName }" />
			</div>
			<div class=col-sm-5 " style="border: Opx solid gray">
				<h3>${prod.pname }</h3>
				<h4>${prod.description }</h4>
				<h4>${prod.price }</h4>
				<h5>${prod.supplierName }</h5>

				<div class="section" style="padding-bottom: 20px;">
					<form action="${pageContext.request.contextPath }/addToCart" method="post">
						<input type="hidden" value="${prod.pid }" name="pid"/>
						<input type="hidden" value="${prod.price }" name="pPrice"/>
						<input type="hidden" value="${prod.pname }" name="pName"/>
						<input type="hidden" value="${prod.imgName }" name="imgName"/>
	<label>Qty</label><input type="number" class="form-control" name="pQty" required/><br><br>
	<input class="btn btn-warning btn-lg" type="submit" value="Add To Cart" >
	<h6><span style="color:red;" class="glyphicon-heart-empty" style="cursor:pointer;"></span>Wish List</h6>
</form>
</div>
					<div class="col-sm-9">
<h3>Product Details</h3>
<ul class="menu-items">
<li>All the books are sanctioned by BLRO of India</li>
<li>All the  books are available</li>

</ul>
</div>
					<br><br>
<h6>We are Authorised by Indian Govt.</h6>
</div>
<h1></h1>
<h2></h2>

<hr>



</div>




</body>
</html>