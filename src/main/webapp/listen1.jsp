<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>  
  <meta charset="utf-8" />
  <title>Musik | Web Application</title>
  <meta name="description" content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/jPlayer/jplayer.flat.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font.css" type="text/css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/app.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
  <section class="vbox">
    <header class="bg-black lter header header-md navbar navbar-fixed-top-xs">
      <div class="navbar-header aside bg-success nav-xs">
        <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen,open" data-target="#nav,html">
          <i class="icon-list"></i>
        </a>
        
		
        <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".user">
          <i class="icon-settings"></i>
        </a>
      </div>      
	  <!--搜索框-->
      <%--<form class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs" role="search">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-btn">
              <button type="submit" class="btn btn-sm bg-white btn-icon rounded"><i class="fa fa-search"></i></button>
            </span>
            <input type="text" class="form-control input-sm no-border rounded" placeholder="Search songs, albums...">
          </div>
        </div>
      </form>--%>
	  <!--右端用户的列表-->
      <div class="navbar-right ">
        <ul class="nav navbar-nav m-n hidden-xs nav-user user">
          <li class="hidden-xs">
            <a href="#" class="dropdown-toggle lt" data-toggle="dropdown">
              <i class="icon-bell"></i>
              <span class="badge badge-sm up bg-danger count">2</span>
            </a>
            <section class="dropdown-menu aside-xl animated fadeInUp">
             
            </section>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle bg clear" data-toggle="dropdown">
              <span class="thumb-sm avatar pull-right m-t-n-sm m-b-n-sm m-l-sm">
                <img src="${pageContext.request.contextPath}/images/a0.png" alt="...">
              </span>
              ${name} <b class="caret"></b>
            </a>
            <ul class="dropdown-menu animated fadeInRight">            
              <li>
                <span class="arrow top"></span>
                <a href="#">Settings</a>
              </li>
              <li>
                <a href="profile.html">Profile</a>
              </li>
              <li>
                <a href="#">
                  <span class="badge bg-danger pull-right">3</span>
                  Notifications
                </a>
              </li>
              <li>
                <a href="docs.html">Help</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="modal.lockme.html" data-toggle="ajaxModal" >Logout</a>
              </li>
            </ul>
          </li>
        </ul>
      </div>      
    </header>
    <section>
      <section class="hbox stretch">
        <!-- .aside -->
        <aside class="bg-black dk nav-xs aside hidden-print" id="nav">          
          <section class="vbox">
            <%--<section class="w-f-md scrollable">
             &lt;%&ndash; <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="10px" data-railOpacity="0.2">
                <!-- nav -->                 
                <nav class="nav-primary hidden-xs">
                  <ul class="nav bg clearfix">
                    &lt;%&ndash;<li>
                      <a href="listen.html">
                        <i class="icon-list icon  text-info-dker"></i>
                        <span class="font-bold">Listen</span>
                      </a>
                    </li>&ndash;%&gt;
                    &lt;%&ndash;<li class="m-b hidden-nav-xs"></li>&ndash;%&gt;
                  </ul>
                  
                </nav>
                <!-- / nav -->
              </div>&ndash;%&gt;
			  
            </section>--%>
			<!--左下角的列表-->
            <footer class="footer hidden-xs no-padder text-center-nav-xs">
              <div class="bg hidden-xs ">
                  <div class="dropdown dropup wrapper-sm clearfix">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                      <span class="thumb-sm avatar pull-left m-l-xs">                        
                        <img src="${pageContext.request.contextPath}/images/a3.png" class="dker" alt="...">
                        <i class="on b-black"></i>
                      </span>
                      <span class="hidden-nav-xs clear">
                        <span class="block m-l">
                          <strong class="font-bold text-lt">John.Smith</strong> 
                          <b class="caret"></b>
                        </span>
                        <span class="text-muted text-xs block m-l">Art Director</span>
                      </span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight aside text-left">                      
                      <li>
                        <span class="arrow bottom hidden-nav-xs"></span>
                        <a href="#">Settings</a>
                      </li>
                      <li>
                        <a href="profile.html">Profile</a>
                      </li>
                      <li>
                        <a href="#">
                          <span class="badge bg-danger pull-right">3</span>
                          Notifications
                        </a>
                      </li>
                      <li>
                        <a href="docs.html">Help</a>
                      </li>
                      <li class="divider"></li>
                      <li>
                        <a href="modal.lockme.html" data-toggle="ajaxModal" >Logout</a>
                      </li>
                    </ul>
                  </div>
                </div>
            </footer>
          </section>
        </aside>
        <!-- /.aside -->
        <section id="content">
          <section class="vbox">
          <section class="w-f-md">
            <section class="hbox stretch bg-black dker">
              <!-- side content -->
              <aside class="col-sm-5 no-padder" id="sidebar">
                <section class="vbox animated fadeInUp">
                  <section class="scrollable">
                    <div class="m-t-n-xxs item pos-rlt">
                      <div class="top text-right">
                        <span class="musicbar animate bg-success bg-empty inline m-r-lg m-t" style="width:25px;height:30px">
                          <span class="bar1 a3 lter"></span>
                          <span class="bar2 a5 lt"></span>
                          <span class="bar3 a1 bg"></span>
                          <span class="bar4 a4 dk"></span>
                          <span class="bar5 a2 dker"></span>
                        </span>
                      </div>
					  <!-- 大图 -->
                      <div class="bottom gd bg-info wrapper-lg">
                        <span class="pull-right text-sm">101,400 <br>Followers</span>
                        <span class="h2 font-thin">Soph Ashe</span>
                      </div>
                      <img class="img-full" src="${pageContext.request.contextPath}/images/m43.jpg" alt="...">
                    </div>
					<!-- 左侧歌曲列表开始-->
                    <ul class="list-group list-group-lg no-radius no-border no-bg m-t-n-xxs m-b-none auto">
                        <c:forEach items="${singList}" var="sing">
                      <li class="list-group-item">
                        <div class="pull-right m-l">
                          <%--<a href="#" class="m-r-sm"><i class="icon-cloud-download"></i></a>--%>
                          <a href="#"><i class="icon-plus"></i></a>
                        </div>
                        <a href="#" class=" m-r-sm pull-left">
						<!-- 歌曲左侧播放控制键-->
                          <audio id="audio2" src="${sing.singUrl}"></audio>
                          <i class="icon-control-play text"></i>
                          <i class="icon-control-pause text-active"></i>
                        </a>
                        <div class="clear text-ellipsis">
                          <span>${sing.singName}</span>
                          <span class="text-muted"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--${sing.singerName}</span>
                          <%--<span class="text-muted"> -- 02:35</span>--%>
                        </div>
                      </li>
                        </c:forEach>
                    </ul>
                  </section>
                </section>
              </aside>
              <!-- /中间部分列表展示区 -->
              <section class="col-sm-4 no-padder bg">
                <section class="vbox">
                  <section class="scrollable hover">
                    <ul class="list-group list-group-lg no-bg auto m-b-none m-t-n-xxs">
                      <c:forEach items="${singList1}" var="sing">
                      <li class="list-group-item clearfix">
                        <a href="#" class=" pull-right m-t-sm m-l text-md">
							<!-- 歌曲右侧播放控制键-->
                          <audio id="audio1"  src="${sing.singUrl}" ></audio>
                          <i class="icon-control-play text"></i>
                          <i class="icon-control-pause text-active"></i>
                        </a>
                        <a href="#" class="pull-left thumb-sm m-r">
							<!-- 歌曲左侧图片-->
                          <img src="${sing.singPic}" alt="...">
                        </a>
                        <a class="clear" href="#">
                          <span class="block text-ellipsis">${sing.singName}</span>
                          <small class="text-muted">${sing.singerName}</small>
                        </a>
                      </li>
                      </c:forEach>
                      </li>
                    </ul>
                  </section>
                </section>
              </section>
			  <!-- 右侧列表开始 -->
              <section class="col-sm-3 no-padder lt">
                <section class="vbox">
                  <section class="scrollable hover">
                    <div class="m-t-n-xxs">
                      <%--<c:forEach items="adList" var="ad">--%>
                      <div class="item pos-rlt">
                        <a href="#" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-info">Find</span>
                          <span class="text-muted">Find the peace in your heart</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="#">
                          <img class="img-full" src="${pageContext.request.contextPath}/images/m41.jpg" alt="...">
                        </a>
                      </div>
                     <%-- </c:forEach>--%>
                      <div class="item pos-rlt">
                        <a href="#" class="item-overlay active opacity wrapper-md font-xs text-right">
                          <span class="block h3 font-bold text-warning text-u-c">Listen</span>
                          <span class="text-muted">Find the peace in your heart</span>
                          <span class="bottom wrapper-md block"><i class="icon-arrow-right i-lg pull-left"></i> -</span>
                        </a>
                        <a href="#">
                          <img class="img-full" src="${pageContext.request.contextPath}/images/m41.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="#" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-success text-u-c">Share</span>
                          <span class="text-muted">Share the good songs with your loves</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="#">
                          <img class="img-full" src="${pageContext.request.contextPath}/images/m42.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="#" class="item-overlay active opacity wrapper-md font-xs text-right">
                          <span class="block h3 font-bold text-white text-u-c">2014</span>
                          <span class="text-muted">Find, Listen & Share</span>
                          <span class="bottom wrapper-md block"><i class="icon-arrow-right i-lg pull-left"></i> -</span>
                        </a>
                        <a href="#">
                          <img class="img-full" src="${pageContext.request.contextPath}/images/m44.jpg" alt="...">
                        </a>
                      </div>
                      <div class="item pos-rlt">
                        <a href="#" class="item-overlay active opacity wrapper-md font-xs">
                          <span class="block h3 font-bold text-danger-lter text-u-c">Top10</span>
                          <span class="text-muted">Selected songs</span>
                          <span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>
                        </a>
                        <a href="#">
                          <img class="img-full" src="${pageContext.request.contextPath}/images/m45.jpg" alt="...">
                        </a>
                      </div>
                    </div>
                  </section>
                </section>
              </section>
            </section>
          </section>
            <footer class="footer"style="background-color: #2b303a">
             <%-- <div id="jp_container_N"></div>--%>
            </footer>
        </section>
          <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
        </section>
      </section>
    </section>    
  </section>
  <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
  <!-- Bootstrap -->
  <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
  <!-- App -->
  <script src="${pageContext.request.contextPath}/app.js"></script>
  <script src="${pageContext.request.contextPath}/js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/app.plugin.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jPlayer/jquery.jplayer.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jPlayer/add-on/jplayer.playlist.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jPlayer/demo.js"></script>
</body>
<script>

    $('.icon-control-play.text').click(function(){
        //点击之后遍历所有的让其停止
        $('audio').each(function () {
            this.pause();
        });
        //然后播放上一个  得到的把它转化成一个原生对象
        $(this).prev()[0].play();
    });

  $('.icon-plus').click(function () {
      alert()
  })
</script>

</html>