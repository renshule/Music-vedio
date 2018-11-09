<%@page pageEncoding='utf-8'%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 登录</title>
    <jsp:include page="/layout/css.jsp"/>
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">H+</h1>

        </div>
        <h3>欢迎使用 H+</h3>

        <form class="m-t" role="form" action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="name">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码"  name="password">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center"> <a href="login.html#"><small style="color:red">${errMsg}</small></a></p>

        </form>
    </div>
</div>

<!-- 全局js -->
<jsp:include page="/layout/script.jsp"/>

</body>

</html>
