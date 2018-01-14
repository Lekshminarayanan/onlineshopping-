%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Books Pointer</title>
<meta name="viewport" content="width=device-width", initial-scale=1">
<meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/Views/header.jsp"></jsp:include>


<c:if></c:if>
<c:forEach var="p" varStatus="st" items="${prodList }">
<tr>

<td><c:out value="${st.count }"></c:out></td>
<td><c:out value="${p.pid }"></c:out></td>
<td><c:out value="${p.pname }"></c:out></td>
<td><c:out value="${p.supplier.supplierName }"></c:out></td>
<td><c:out value="${p.category.cname }"></c:out></td>
<td class="span3"><c:out value="${p.description }"></c:out></td>
<td><c:out value="${p.price }"></c:out></td>
<td><c:out value="${p.stock  }"></c:out></td>
<td><img src="${pageContext.request.contextPath }/resources/${p.imgName }" height="50px">
<td class="span2">
<c:set var=contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-info" role="button" href="<c:url value="/prodDetails/${p.pid }"/>">Details
</a>
</td>
</tr>
</c:forEach>
</body>
</html>