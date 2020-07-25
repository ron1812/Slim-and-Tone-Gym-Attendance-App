<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page session="false"%>

<html>
<head>
<title>DEMO</title>
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

				<form id="error" method="post"
					action="${pageContext.request.contextPath}/register">

					<div class="form-header">THERE WAS AN ERROR</div>

					<div id="alert" role="alert"
						class="alert alert-danger alert-dismissible fade show">
						<section class="action-info">
							<pre>${errorMsg}</pre>
						</section>
					</div>

					<div class="form-group">
						<button
							id="submitButton"
							onClick="window.history.back()"
							class="btn btn-default form-button" type="reset">Retry</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>