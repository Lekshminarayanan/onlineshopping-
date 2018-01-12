<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html lang="en">
<head>

<title>Books World</title>
<meta name="viewport" content="width=device-width" , initial-scale=1">
<meta charset="utf-8">
<script type="text/javascript"	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/Views/header.jsp"></jsp:include>
	<table>
		<tr>
			<th>Product Name</th>
			<th>Product Quantity</th>
			<th>Product Price</th>
			<th>Product Image</th>
			<th>Sub Total</th>
			<th>Action</th>
		</tr>
		<c:if test="${empty cartInfo }">
			<tr>
				<td colspan="10" align="center">No record exists!!</td>
			</tr>
		</c:if>
		<c:forEach var="p" varStatus="st" items="${cartInfo }">
			<tr>
				<td><c:out value="${p.prodname} }"></c:out></td>
				<td><c:out value="${p.qty} }"></c:out></td>
				<td><c:out value="${p.price} }"></c:out></td>
				<td><c:out value="${p.stock} }"></c:out></td>
				<td><img src="${pageContext.request.contextPath }/resources/${p.imgName}" height="50px" width="50px"></td>
				<td><c:out value="${p.qty*p.price }" /></td>
				<td class="span2"><c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set> 
				<a	class="btn btn-danger" role="button" href="<c:url value="/deletepCart/${p.cartId }"/>">Delete</a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td><c:set var="gtot" value="${gtot+p.price*p.qty }"></c:set> 
			<span class="col-lg-9" align="right">
				<label>Grand Total</label>
				<c:out value="${gtot }" />
			</span>
			</td>
		
		<tfoot>
		<td>
			<a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath }/index">Continue shopping</a>
		</td>
		<td>
			<a class="btn btn-warning btn-lg" href="${pageContext.request.contextPath }/checkout">check out</a>
		</td>
		</tfoot>
		
		</tr>
	</table>
</body>
</html>