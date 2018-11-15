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
       url:'${pageContext.request.contextPath}/AdminServlet/classify',
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
                field: 'cName',
                title: '类别名称',
            },
            {
                title:'操作',
                formatter:'caozuoFormater',
                events:'operateEvents'
            }
        ]

    });
    window.operateEvents = {
        'click .edit': function (e, value, row) {
           /* alert('You click like action, row: ' + JSON.stringify(row));*/
            $('#rr [name=name]').val(row['cName']);
            $('#rr [name=id]').val(row['cId']);
            inde = layer.open({
                type: 1,
                content: $('#rr'),
                area: ['600px', '400px'],
            })
        },
    }
    function caozuoFormater(value, row, index) {
        return [
            '<div>',
            '<a class="edit" href="javascript:void(0)" title="Like">',
            '<i class="fa fa-pencil"></i>',
            '</a>',
            '</div>'
        ].join('');
    };

    $(function () {
        $('#sub').click(function () {
            /*alert($('form').serialize());*/
            $.post('${pageContext.request.contextPath}/AdminServlet/updateByIdClassify',$('form').serialize(),function (r) {
                if(r){
                    layer.msg("修改成功");
                    layer.close(inde);
                    $('#table').bootstrapTable('refresh');
                }else{
                    layer.msg("修改失败");
                }
            })
        })
    })
</script>
</body>
<div class="row" id="rr" style="display: none">
    <div class="col-sm-12">
        <div class="ibox float-e-margins">

            <div class="ibox-content">
                <form class="form-horizontal m-t" >
                    <input type="hidden" name="id">
                    <div class="form-group">
                        <label class="col-sm-3 control-label" type="text" name="name">类别名称：</label>
                        <div class="col-sm-8">
                            <input name="name" minlength="2" type="text" class="form-control" >
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-3">
                            <div class="btn btn-primary" id="sub">提交</div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</html>
