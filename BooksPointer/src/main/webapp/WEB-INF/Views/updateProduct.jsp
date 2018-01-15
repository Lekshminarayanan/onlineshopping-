<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="container">
<c:url value="productUpdate" var="pru"></c:url>
<form method="post" action="productUpdate" enctype="multipart/form-data">

<span id="reauth-email" class="reauth-email"/></span>
<input type="hidden" name="pid" value="$(prod.pid)">


<h4 class="input-title">Product Name</h4><br>
<input value="$(prod.pname)" type="text" name="pName" required/><br>

<h4 class="input-title">Product Description</h4><br>
<input value="$(prod.description)" type="text" name="pDescription" required/><br>

<h4 class="input-title">Product Price</h4><br>
<input value="$(prod.price)" type="number" name="pPrice" required/><br>

<h4 class="input-title">Product Stock</h4><br>
<input value="$(prod.stock)" type="number" name="pStock" required/><br>

<div class="form-group">
<table>
<tr>
<td>Select Supplier</td>
<td>
<select class="form-control" name="pSupplier" required>
<option value="">---Select Supplier---</option>
<c:forEach items="${satList }" var="sat">
<option value="${sat.sid }">sat.supplierName</option>


</c:forEach>


</select></td></tr>


</table></div>

<div class="form-group">
<table>
<tr>
<td>Select Category</td>
<td>
<select class="form-control" name="pCategory" required>
<option value="">---Select Cat---</option>
<c:forEach items="${catList }" var="sat">
<option value="${cat.cid }">cat.cname</option>
</c:forEach></select>
</td>
</tr>
</table>
</div>

<div class="fileinput fileinput-new" data-provides="fileinput">
<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="image/*"></td><!-- browser & upload -->
</div>

<br><br>
<button class="btn btn-lg btn-primary" type="submit">Update</button>
<button class="btn btn-lg btn-warning" type="reset">Cancel</button>


</form>
</div>
</body>
</html>