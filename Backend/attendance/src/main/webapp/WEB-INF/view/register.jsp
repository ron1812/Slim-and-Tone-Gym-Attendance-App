<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
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

    <script type="text/javascript"
            src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/resources/js/form-decorator1.js"></script>

    <script type="text/javascript">
        $(function() {
            decorateForm ($('#registerForm'));
        });
    </script>

</head>

<body>
<div class="content container">
    <div class="row">
        <div class="form-container">

            <form id="registerForm" method="post"
                  action="${pageContext.request.contextPath}/register">

                <div class="form-header">Admin Registration</div>

                <input type="hidden" name="hash" id="hash">

                <div class="form-group">
                    <label
                            class="text-nowrap"
                            for="username">User Name <span>*</span></label>
                    <div>
                        <input
                                id="username"
                                name="username"
                                type="text"
                                class="form-control"
                                aria-describedby="userName">
                    </div>
                </div>

                <div class="form-group">
                    <label
                            class="text-nowrap"
                            for="password">Password <span>*</span></label>
                    <div>
                        <input
                                id="password"
                                name="password"
                                type="password"
                                autocomplete="off"
                                class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <button
                            id="submitButton"
                            class="btn btn-default form-button"
                            type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

</html>
