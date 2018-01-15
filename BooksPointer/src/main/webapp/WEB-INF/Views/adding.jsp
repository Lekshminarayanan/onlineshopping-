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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }resources/nav.css">
</head>
<body>
	<jsp:include page="/WEB-INF/Views/header.jsp"></jsp:include>
	<div class="container"></div>
		<br>
		<div class="page-header"></div>
			<div class="container"></div>
				<div class="row"></div>
					<div class="col-md-6"></div>
						<div class="panel with-nav-tabs panel-primary"></div>
							<div class="panel-heading"></div>
								<ul class="nav nav-tabs">
									<li class="active"><a href=#tab1 data-toggle="tab">Category</a>
									<li><a href=#tab2 data-toggle="tab">Supplier</a>
									<li><a href=#tab3 data-toggle="tab">Product</a>
								</ul>
							
							<div class="panel-body"></div>
								<div class="tab-content"></div>
									<div class="tab-pane fade in active" id="tab1">
										<form method="post" action="<c:url value="/admin/saveSupp"/>"
											class="form-sign-in">
											<span id="reauth-email" class="reauth-email"></span>
											<h4 class="input-title">Supplier Id</h4>
											<br> <input class="form-control" type="number"
												name="sid" required />

											<h4 class="input-title">Supplier Name</h4>
											<br> <input class="form-control" type="text"
												name="sname" required />
									</div>
									<br>
									<br>
									<button class="btn btn-lg btn-primary" type="submit">Save</button>
									<button class="btn btn-lg btn-warning" type="reset">Cancel</button>


									<div class="tab-pane fade" id="tab2">
										<form method="post" action="<c:url value="/admin/saveCat"/>"
											class="form-sign-in"></form>
											<span id="reauth-email" class="reauth-email"></span>
											<h4 class="input-title">Category Id</h4>
											<br> <input class="form-control" type="number"
												name="sid" required />

											<h4 class="input-title">Category Name</h4>
											<br> <input class="form-control" type="text"
												name="sname" required />
									</div>

									<br>
									<br>
									<button class="btn btn-lg btn-primary" type="submit">Save</button>
									<button class="btn btn-lg btn-warning" type="reset">Cancel</button>

									<div class="tab-pane fade" id="tab3"></div>
										<form method="post"
											action="<c:url value="/admin/saveProduct" />"
											class="form-sign-in" enctype="multipart/form-data"></form>
											<span id="reauth-email" class="reauth-email"></span>

											<h4 class="input-title">Product Name</h4>
											<br> <input class="form-control" type="text"
												name="pname" required /><br>

											<h4 class="input-title">Product Description</h4>
											<br> <input class="form-control" type="text"
												name="pDescription" required /><br>

											<h4 class="input-title">Product price</h4>
											<br> <input class="form-control" type="number"
												name="pPrice" required /><br>

											<h4 class="input-title">Product Stock</h4>
											<br> <input class="form-control" type="number"
												name="pStock" required /><br>



											<div class="form-group">
												<table>
													<tr>
														<td>Select Supplier</td>
														<td><select class="form-control" name="pSupplier"	required="required">
																<option value="">--Select Supplier--</option>
																<c:forEach items="${satList }" var="sat">

																	<option value="${satList }">${sat.supplierName}</option>
																</c:forEach>
														</select>
													</tr>
													
</table></div>
													<div class="form-group">
														<table>
															<tr>
																<td>Select Category</td>
																<td><select class="form-control" name="pCategory"
																	required>
																		<option value="">--Select Category--</option>
																		<c:forEach items="${catList }" var="cat">

																			<option value="${catList }">${cat.cname}</option>
																			</c:forEach>
																</select>
															</tr>


														</table>
													</div>

													<div class="fileinput fileinput-new"
														data-provides="fileinput">


														<td>Product Image</td>
														<td><input class="form-control" type="file"
															name="file" accept="image/*"></td> <br>
														<br>
														<button class="btn btn-lg btn-primary" type="submit">Save</button>
														<button class="btn btn-lg btn-warning" type="reset">Cancel</button>

														</form>



													</div>


													</div>
													</div>

													</div>
													</div>


													</div>



													</div>



													</div>
</body>
</html>
