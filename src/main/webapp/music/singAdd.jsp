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
                        <form class="form-horizontal m-t" action="${pageContext.request.contextPath}/AdminServlet/addSing">
                            <div class="form-group">
                                <label class="col-sm-3 control-label" type="text" name="name">歌曲名称：</label>
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
                                <label class="col-sm-3 control-label" type="text" name="pic">图片上传：</label>
                                <div class="col-sm-8">
                                    <input type="text" name="audio"/><%--(回填表单,用于提交表单的音频数据库存储)--%>
                                    <div  class="audioUpload"></div>				<%--(上传控件)--%>
                                    <div  class="preview"></div>           <%--(预览图)--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" name="gender">类别：</label>
                                <div class="col-sm-8">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender" checked value="1" >
                                            流行
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender"  value="2">
                                            民谣
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender"  value="3">
                                            欧美
                                        </label>
                                    </div>
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="gender"  value="4">
                                            嘻哈
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label" type="text" name="singerName">歌手名称：</label>
                                <div class="col-sm-8">
                                    <input name="singerName" minlength="2" type="text" class="form-control" >
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
    $('.audioUpload').each(function(){
        var aa = function(obj){
            obj.Huploadify({
                auto:true,
                fileTypeExts:'*.mp3',
                multi:false,
                //formData:{name:'image0'},
                fileSizeLimit:999999,
                showUploadedPercent:true,//是否实时显示上传的百分比，如20%
                showUploadedSize:true,
                removeTimeout:9999999,
                uploader:'${pageContext.request.contextPath}/UploadServlet/audio',
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
   <c:if test="${msg!=null}">
   layer.ready(function () {
       layer.msg('${msg}'/*,{icon:1}*/);
   })

   </c:if>

</script>
</html>
