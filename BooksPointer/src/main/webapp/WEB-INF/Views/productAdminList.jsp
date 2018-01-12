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
		<h2>Product List for Admin</h2>
		<table class="table table-hover" id="apl" class="display" border="2"
			width="80" align="Center">
			<tr>
				<th>SI No</th>
				<th>PID</th>
				<th>Product Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Stock</th>
				<th>Image</th>
				<th class="span2">Action</th>
			</tr>
			<C:if test="${empty prodList }">
				<tr>
					<td colspan="10" align="center">No record exists!!</td>
				</tr>
			</C:if>
			<c:forEach var="p" varStatus="st" items="${prodList }">
				<tr>
					<td><c:out value="${st.count }"></c:out></td>
					<td><c:out value="${p.pid }"></c:out></td>
					<td><c:out value="${p.pname }"></c:out></td>
					<td><c:out value="${p.supplier.supplierName }"></c:out></td>
					<td><c:out value="${p.category.cname }"></c:out></td>
					<td class="span3"><c:out value="${p.description }"></c:out></td>
					<td><c:out value="${p.price }"></c:out></td>
					<td><c:out value="${p.stock }"></c:out></td>
					<td><img src="${pageContext.request.contextPath}/resources/${p.imgName}" height="50px" width="50px"></td>
					<td class="span4"><c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
					<!-- a class="btn btn-info" role="button" href="<c:url value="${contextRoot}/admin/updateProd?id=<c:out value="${p.pid }"></c:cout>"/>Edit</a-->
					
					<a class="btn btn-info" role="button" href='<c:url value="${contextRoot}/admin/updateProd?pid= "/>'>Edit</a>
					<a class="btn btn-danger" role="button" href="<c:url value="/admin/deleteProd/${p.pid }"/>">Delete</a></td>


</tr>

</c:forEach>


</table>

</div>



</body>
</html>