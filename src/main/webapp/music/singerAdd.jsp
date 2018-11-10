<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学生添加</title>
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <jsp:include page="/layout/css.jsp"/>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>学生添加</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <a href="form_basic.html#">选项1</a>
                                </li>
                                <li>
                                    <a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" action="${pageContext.request.contextPath}/AdminServlet/addSinger">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" type="text" name="name">歌手姓名：</label>
                                <div class="col-sm-8">
                                    <input name="name" minlength="2" type="text" class="form-control" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" type="text" name="age">歌手简介：</label>
                                <div class="col-sm-8">
                                    <input   class="form-control" name="introduce" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/layout/script.jsp"/>
</body>
<script>
   <c:if test="${msg!=null}">
   layer.ready(function () {
       layer.msg('${msg}'/*,{icon:1}*/);
   })

   </c:if>

</script>
</html>
