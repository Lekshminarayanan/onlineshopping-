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
<hr>
<div class="modal fade bs-example-demo-modal-sm" tabindex="1" role="dialog"

aria-labelledby="myModal" aria-hidden="true" id="onLoad">
<div class="modal-dialog modal-lg">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal">X</button>


</div>
<div class="modal-body"><span>Added Successfully!!!</span>

<div class="modal-footer">

<a href="${pageContext.request.contextPath }/admin/adding"
class="btn btn-primary" role="button"></a>
</div>
</div>
</div>


</div>


</div>
<script type="text/javascript">
$(document).ready(function()
{
	$('#onload').modal('show');});
	

</script>
</body>
</html>