<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Books Pointer</title>
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
		<h2>Welcome to login page!!!</h2>
		<form action="${pageContext.request.contextPath }/login" class="form-signin" method="post">
		    <h3><label>Email:</label></h3>
			<input type="text" name="username" class="login-box" required>
            <h3><label>Password:</label></h3>
            <input type="password" name="password" class="login-box" required/>
<button class="btn btn-lg btn-primary" type="submit">Login</button>
<button class="btn btn-lg btn-warning" type="reset">Cancel</button>
</form>
</div>
</body>
</html>