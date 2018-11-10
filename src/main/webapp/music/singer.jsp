<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>管理员页面</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/bootstrap-table/bootstrap-table.css">
    <jsp:include page="/layout/css.jsp"/>

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="table_basic.html#">选项1</a>
                            </li>
                            <li><a href="table_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>

                <div class="ibox-content">

                    <table id="table"></table>
                    <div class="btn btn-warning" id="removeAll">删除所选</div>
                    <a  class="btn btn-success" href="${pageContext.request.contextPath}/music/singerAdd.jsp">添加分类</a>

                </div>

            </div>
        </div>

    </div>

</div>

<jsp:include page="/layout/script.jsp"/>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- Peity -->
<script src="${pageContext.request.contextPath}/js/plugins/peity/jquery.peity.min.js"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/js/content.js?v=1.0.0"></script>
<!-- Peity -->
<script src="${pageContext.request.contextPath}/js/demo/peity-demo.js"></script>
<script type="text/javascript">

    $('#table').bootstrapTable({
       url:'${pageContext.request.contextPath}/AdminServlet/Singer',
        pagination:true,
       /* pageSize:5,
        pageList:[5,7,'All'],
        showColumns:true,
        search:true,
        showRefresh:true,*/
      /*  sidePagination:'Client',*/
        columns: [
            {
                checkbox:true
            },
            {
                field: 'singerName',
                title: '歌手名称',
            },
            {
                field: 'singerIntro',
                title: '歌手简介',
            },
        ]

    });
</script>
</body>

</html>
