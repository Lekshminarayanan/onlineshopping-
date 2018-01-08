<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/form/tags/"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Books World</title>
<meta name="viewport" content="width=device-width", initial-scale=1">
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<div class="container">
<h2>Registration Form</h2>
<div class="col-sm-8">
<div class="row">

<form:form modelAttribute="user" action="saveRegister" method="post">
<div class="form-group">
<form:errors path="name" cssClass="err" /><br>
<label>Name:</label><br>
<form:input path="name" class="form-control" placeholder="Enter Name"/>
</div>

<form:errors path="email" cssClass="err" /><br>
<div class="form-group">
<label>email:</label><br>
<form:input path="email" class="form-control" placeholder="Enter email"/>
</div>


<div class="form-group">
<label>password:</label><br>
<form:input path="password" type="password" class="form-control" placeholder="Enter password"/>
</div>


<div class="form-group">
<label>Address:</label><br>
<form:input path="address" class="form-control" placeholder="Enter address"/>
</div>

<form:errors path="phones" cssClass="err" /><br>
<div class="form-group">
<label>Phone:</label><br>
<form:input path="phone" class="form-control" placeholder="Enter phone"/>
</div>

<br><br>
<button type="submit" class="btn btn-lg btn-info">SUBMIT</button>
<br><br>
<button type="reset" class="btn btn-lg btn-info">CANCEL</button>


</form:form>

</div>

</div>


</div>






</body>
</html>