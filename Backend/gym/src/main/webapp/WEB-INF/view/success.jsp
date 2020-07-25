<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
	<title>SBI</title>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="HandheldFriendly" content="True">
	<meta name="apple-mobile-web-app-status-bar-style"
		  content="white-translucent">

	<meta name="viewport"
		  content="initial-scale=1.0,width=device-width,user-scalable=0,user-scalable=no">

	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/resources/css/styles.css" />

</head>

<body>
<div class="content container">
	<div class="row">
		<div class="form-container">

			<form id="loginForm" method="get"
				  action="${pageContext.request.contextPath}/users">

				<div class="form-header">Successfully Registered</div>

				<div class="form-group">
					<button
							id="view"
							class="btn btn-default form-button"
							type="submit">View Users</button>

					<button
							id="submitButton"
							onClick="window.history.back()"
							class="btn btn-default form-button" type="reset">Register</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>

</html>