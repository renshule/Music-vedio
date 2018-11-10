<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>用户注册</title>
    <style type="text/css">
        .err{
            color: red;
            font-size: 12px;
            font-weight: bold;
        }
    </style>

    <jsp:include page="/layout/css.jsp"/>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-10">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户注册</h5>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal m-t" method="post" action="${pageContext.request.contextPath}/user_addServlet/add">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户名:</label>
                            <div class="col-sm-8">
                                <input  name="name"  type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">密码:</label>
                            <div class="col-sm-8">
                                <input  type="password" class="form-control" name="psd">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">确认密码:</label>
                            <div class="col-sm-8">
                                <input  type="password" class="form-control" name="rpsd">
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
</body>
<jsp:include page="/layout/script.jsp"/>
<script>
    $('form-horizontal m-t').validate({
        rules:{
            name:{
                required:true,
                rangelength:[5,8]
            },
            psd:'required',
            rpsd:{
                equalTo:"[name=psd]"
            }
        },
        messages:{
            name:{
                required:'必须输入用户名',
                rangelength:'用户名必须是5-8位'
            },
            psd:'密码不能为空',
            rpsd:{
                equalTo:'两次密码输入不一致'
            }
        },
        errorPlacement: function(error, element) {
            $('#'+element.attr('name')+'Msg').append(error);
        }
    });
</script>

</html>
