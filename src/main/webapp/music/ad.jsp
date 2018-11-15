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
                    <div class="btn btn-warning" id="removeAll">删除所选</div>
                    <a  class="btn btn-success" href="${pageContext.request.contextPath}/music/adAdd.jsp">添加广告</a>
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
       url:'${pageContext.request.contextPath}/AdminServlet/selectAllAd',
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
                field: 'adIntro',
                title: '广告简介',
            },
            {
                field: 'adHot',
                title: '是否热门',
            },{
                title:'操作',
                formatter:'caozuoFormater',
                events:'operateEvents'
            }
        ]

    });
    window.operateEvents = {
        'click .edit': function (e, value, row) {
            alert('You click like action, row: ' + JSON.stringify(row));
            $('#rr [name=name]').val(row['adIntro']);
            $('#rr [name=pic]').val(row['adPic']);
            $('#rr [name=id]').val(row['adId']);
            if(row['adHot']==1){
                $('#rr [name=hot][value=1]').prop('checked',true)
            }else if(row['adHot']==0){
                $('#rr [name=hot][value=0]').prop('checked',true)
            }

            inde=layer.open({
                type:1,
                content:$('#rr'),
                area:['600px','400px'],
            })
        },
        'click .remove': function (e, value, row) {
           /* console.log(e);
            console.log(value);
            console.log(row);
            alert(row['adId']);
            alert('You click remove action, row: ' + JSON.stringify(row));*/
            //用ajax传递参数
            $.post('${pageContext.request.contextPath}/AdminServlet/removeByIdAd?ad_id='+row['adId'],function (r) {
                if(r){
                    layer.msg("删除成功");
                    $('#table').bootstrapTable('refresh');
                }else{
                    layer.msg("删除失败");
                }
            });
        }
    };
    function caozuoFormater(value, row, index) {
        return [
            '<div>',
            '<a class="edit" href="javascript:void(0)" title="Like">',
            '<i class="fa fa-pencil"></i>',
            '</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="fa fa-times"></i>',
            '</a>',
            '</div>'
        ].join('');
    };
    $('#removeAll').click(function () {
        if(confirm("确定删除所选?")){
            json_arr=$('#table').bootstrapTable('getSelections');
            arr='';
            for (i in json_arr){
                arr+=json_arr[i]['adId']+',';
            }
            arr1=arr.substring(0,arr.length-1);
           alert(arr1);
            $.post('${pageContext.request.contextPath}/AdminServlet/removeAllAd?ids='+arr1,function (r) {
                if(r){
                    alert("删除成功");
                    $('#table').bootstrapTable('refresh');
                }else{
                    alert("删除失败");
                }
            });
        }
    });

    $(function () {
        $('#sub').click(function () {
            /*alert($('form').serialize());*/
            $.post('${pageContext.request.contextPath}/AdminServlet/updateById',$('form').serialize(),function (r) {
                if(r){
                    layer.msg("修改成功");
                    $('#table').bootstrapTable('refresh');
                }else{
                    layer.msg("修改失败");
                }
            })
        })
    })
    $(function () {
        $('.imageUpload').each(function(){
            var aa = function(obj){
                obj.Huploadify({
                    auto:true,
                    fileTypeExts:'*.jpg;*.png;',
                    multi:false,
                    //formData:{name:'image0'},
                    fileSizeLimit:9999,
                    showUploadedPercent:true,//是否实时显示上传的百分比，如20%
                    showUploadedSize:true,
                    removeTimeout:9999999,
                    uploader:'${pageContext.request.contextPath}/UploadServlet/pic',
                    onUploadComplete:function(file,path,response){
                        //获得回填数据
                        src = "${pageContext.request.contextPath}"+path;
                        //此处obj为上传控件  ,代表每个imageUpload
                        //回填表单
                        obj.prev().val(path);
                        //填充预览图
                        obj.next().html("<img src='"+src+"'/>");
                        setTimeout(function(){
                            obj.find('.uploadify-queue-item').html('');
                        },1000);
                    }
                });
            }
            aa($(this));
        });
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
                        <label class="col-sm-3 control-label" type="text" name="name">广告简介：</label>
                        <div class="col-sm-8">
                            <input name="name" minlength="2" type="text" class="form-control" >
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" type="text" name="pic">图片上传：</label>
                        <div class="col-sm-8">
                            <input type="text" name="pic"/><%--(回填表单,用于提交表单的图片数据库存储)--%>
                            <div  class="imageUpload"></div>				<%--(上传控件)--%>
                            <div  class="preview"></div>           <%--(预览图)--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label" name="hot">是否热门：</label>
                        <div class="col-sm-8">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="hot" checked value="1" >
                                    热门
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="hot"  value="0">
                                    不热门
                                </label>
                            </div>
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