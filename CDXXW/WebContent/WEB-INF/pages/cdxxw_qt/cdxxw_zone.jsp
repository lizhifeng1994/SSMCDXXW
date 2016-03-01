<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 导入标签必须用这种方式 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>长大信息网-个人中心</title>
    
	<script type="text/javascript" charset="UTF-8" src="CDXXW-ZONE/js/prefixfree.min.js"></script>
    <script type="text/javascript" src="CDXXW-ZONE/js/bootstrap.min.js"></script>
     		<!--顶部导航栏css样式-->
	<link href="login/css/demo.css" rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="CDXXW-ZONE/css/reset.css"/>
    <link rel="stylesheet" type="text/css" href="CDXXW-ZONE/css/base.css" media="all" />
    <link href="CDXXW-ZONE/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
    
	<style type="text/css">
		body {
			padding: 0;
			margin: 0;
			font-size: 16px;
			font-family: sans-serif;
		}
		.clearfix:after {
			content: "";
			display: block;
			height: 0;
			width: 0;
			clear: both;
		}
		.admin-panel {
			width: 990px;
			margin: 50px auto;
		}
		/*slidebar侧边栏*/
		.slidebar {
			width: 20%;
			min-height: 690px;
			float: left;
			border-right: 1px solid rgb(235,235,235);
			background-color: rgb(247,247,247);
		}
		.slidebar .logo {
			height: 145px;
			border-bottom: 1px solid rgb(235,235,235);
		}
		.slidebar ul {
			padding: 0;
			margin:0;
		}
		.slidebar li {
			list-style-type: none;
			margin: 0;
			position: relative;
		}
		.slidebar li:before {
			content: "";
			font-family: 'icomoon';
			speak: none;
			font-weight: normal;
			font-variant: normal;
			text-transform: none;
			position: absolute;
			display: block;
			line-height: 40px;
			color: rgb(102,102,102);
			right: 20px;
			-webkit-font-smoothing: antialiased;
		}
		/*插入icon图标*/
		.slidebar li:nth-child(1):before {content: "\63";}
		/*个人中心*/
		
		.slidebar li:nth-child(2):before {content: "\64";}
		/*兼职信息*/
				
		.slidebar li:nth-child(3):before {content: "\67";}
		/*二手信息*/
		
		.slidebar li:nth-child(4):before {content: "\68";}
		/*活动信息*/
		.slidebar li:nth-child(5):before {content: "\74";}
		/*我的收藏*/
		
		.slidebar li:nth-child(6):before {content: "\66";}
		/*站内通知*/
	/*	.slidebar li:nth-child(7):before {content: "\67";}
		.slidebar li:nth-child(8):before {content: "\68";}*/
		.slidebar li:nth-child(7):before {content: "\69";}
		.slidebar li:nth-child(8):before {content: "\6a";}
/*		.slidebar li:nth-child(11):before {content: "\75";}*/

		.slidebar ul a {
			color: rgb(140,140,140);
			text-decoration: none;
			font:16px/40px helvetica,verdana,sans-serif;
			box-sizing:border-box;
			border-bottom: 1px solid rgb(235,235,235);
			display: block;
			box-shadow:inset 0 1px 0 rgb(255,255,255);
			text-indent: 20px;
			text-transform: capitalize;
		}
		.slidebar li:hover a {
			background-color: rgb(255,255,255);
			box-shadow: 1px 0 0 rgb(255,255,255),inset 5px 0 0 -1px rgb(234,83,63);
		}
		/*main*/
		.main {
			float: left;
			width: 79%;
			height: 690px;
			background-color: rgb(255,255,255);
			position: relative;
			font-family: helvetica,verdana,sans-serif;
		}
		.main .topbar {
			border-bottom: 1px solid rgb(235,235,235);
			margin: 0;
			padding: 0;
		}
		/*topbar顶部按钮栏*/
		.topbar li {
			float: right;
			list-style: none;
		}
		.topbar li:first-child {float: left;}
		.topbar a {
			font-family: 'icomoon';
			display: block;
			line-height: 50px;
			width: 50px;
			text-align: center;
			text-decoration: none;
			color: rgb(102,102,102);
			border-left: 1px solid rgb(235,235,235);
		}
		.topbar a:hover {
			background-color: rgb(247,247,247);
		}
		.topbar li:first-child a {
			border: none;
			border-right: 1px solid rgb(235,235,235);
		}
		/*mainContent*/
		.mainContent h4 {
			line-height: 1;
			font-size: 18px;
			margin: 1.3em 0 1em;
			margin-left: 17px;
		}
		
		.mainContent>div {
			position: absolute;
			opacity: 0;
			-webkit-transition:opacity 200ms linear;
			-moz-transition:opacity 200ms linear;
			-ms-transition:opacity 200ms linear;
			transition:opacity 200ms linear;
		}
		/*通过opacity来切换不同的选项卡*/
		.mainContent>div:target {
			opacity: 1;
		}
		.mainContent h2 {
			margin:1em 30px;
			color: rgb(234,83,63);
			font-size: 20px;
		}
		.mainContent h2:before {
			font-family: 'icomoon';
			content: attr(data-icon);
			font-weight: normal;
			font-variant: normal;
			text-transform: none;
			line-height: 1;
			margin-right: 10px;
			-webkit-font-smoothing: antialiased;
		}
		.mainContent div:nth-child(1) h2:before {content: "\63";}
		.mainContent div:nth-child(2) h2:before {content: "\64";}
		.mainContent div:nth-child(3) h2:before {content: "\67";}
		.mainContent div:nth-child(4) h2:before {content: "\68";}
		.mainContent div:nth-child(5) h2:before {content: "\74";}
		.mainContent div:nth-child(6) h2:before {content: "\66";}
		.mainContent div:nth-child(7) h2:before {content: "\69";}
		.mainContent div:nth-child(8) h2:before {content: "\6a";}
/*		.mainContent div:nth-child(9) h2:before {content: "\69";}
		.mainContent div:nth-child(10) h2:before {content: "\6a";}
		.mainContent div:nth-child(11) h2:before {content: "\75";}*/

		#dashboard>div {
			border: 1px solid rgb(235,235,235);
			margin-left: 30px;
			float: left;
			border-radius: 5px;
			min-width: 345px;
			/*这里是我的地盘我做主的下面那个框框的高度*/
			height: 200px;
			display: inline-block;
		}
		.monitor ul {
			float: left;
			padding: 0;
			margin: 0 31px 0 17px;
		}
		.monitor li {
			list-style:none;
			font: 600 14px/28px helvetica,verdana,sans-serif;
			color: rgb(102,102,102);
			text-transform: capitalize;
		}
		.monitor li a {
			color: rgb(102,102,102);
			text-transform: capitalize;
			text-decoration: none;
		}
		.monitor li:first-child {
			border-bottom: 1px dotted rgb(153,153,153);
		}
		.discussions .comments {color: rgb(27,106,173);}
		.discussions .approved {color: rgb(105,174,48);}
		.discussions .pending {color: rgb(246,129,15);}
		.discussions .spam {color: rgb(243,47,47);}
		.monitor .count {
			color: rgb(27,106,173);
			text-align: right;
			font-weight: 600;
			margin-right: 15px;
			min-width: 25px;
			display: inline-block;
		}
		.monitor p {
			color: rgb(128,128,128);
			margin: 28px 0 18px 17px;
			display: block;
			font-weight: 600;
			font-size: 12px;
		}
		.monitor p a {
			text-decoration: none;
			color:rgb(27,106,173);
		}
		.quick-press form {
			margin:0 20px 0 13px;
		}
		.quick-press input[type="password"] {
			display: block;
			width: 100%;
			-moz-box-sizing:border-box;
			box-sizing:border-box;
			height: 35px;
			line-height: 15px;
			padding: 10px 0;
			margin:0 0 7px 0;
			background-color: rgb(246,246,246);
			outline: none;
			border: none;
			text-indent: 10px;
		}
		/*统一各浏览器下placeholder内的字体样式*/
		.quick-press input[type="password"]::-webkit-input-placeholder {font-size: 14px;}
		.quick-press input[type="password"]:-moz-input-placeholder {font-size: 14px;}
		.quick-press input[type="password"]::-moz-input-placeholder {font-size: 14px;}
		.quick-press input[type="password"]:-ms-input-placeholder {font-size: 14px;}

		.quick-press button {
			margin-top: 13px;
			border-radius: 5px;
			text-align: center;
			line-height: 30px;
			padding: 0;
		}
		.quick-press .save, .quick-press .delet {
			font-family: 'icomoon';
			width: 37px;
			background: -webkit-linear-gradient(top,rgb(246,246,240),rgb(232,232,232));
			background: -moz-linear-gradient(top,rgb(246,246,240),rgb(232,232,232));
			background: -ms-linear-gradient(top,rgb(246,246,240),rgb(232,232,232));
			background: linear-gradient(top,rgb(246,246,240),rgb(232,232,232));
			border: 1px solid rgb(229,229,229);	
			color: rgb(102,102,102);				
			float: left;
			margin-right: 5px;
		}
		.quick-press .save:hover, .quick-press .delet:hover {
			background: -webkit-linear-gradient(top,rgb(232,232,232),rgb(246,246,240));
			background: -moz-linear-gradient(top,rgb(232,232,232),rgb(246,246,240));
			background: -ms-linear-gradient(top,rgb(232,232,232),rgb(246,246,240));
			background: linear-gradient(top,rgb(232,232,232),rgb(246,246,240));
		}
		.quick-press .save:active, .quick-press .delet:active {
			background: -webkit-linear-gradient(top,rgb(228,228,228),rgb(210,210,210));
			background: -moz-linear-gradient(top,rgb(228,228,228),rgb(210,210,210));
			background: -ms-linear-gradient(top,rgb(228,228,228),rgb(210,210,210));
			background: linear-gradient(top,rgb(228,228,228),rgb(210,210,210));
		}
		.quick-press .submit {
			float: right;
			width: 70px;
			border: 1px solid rgb(238,85,64);
			color: #fff;
			font-size: 16px;
			background: -webkit-linear-gradient(top,rgb(245,101,82),rgb(234,83,63));
			background: -moz-linear-gradient(top,rgb(245,101,82),rgb(234,83,63));
			background: -ms-linear-gradient(top,rgb(245,101,82),rgb(234,83,63));
			background: linear-gradient(top,rgb(245,101,82),rgb(234,83,63));
		}
		.quick-press .submit:hover {
			background: -webkit-linear-gradient(top,rgb(220,85,70),rgb(210,65,53));
			background: -moz-linear-gradient(top,rgb(220,85,70),rgb(210,65,53));
			background: -ms-linear-gradient(top,rgb(220,85,70),rgb(210,65,53));
			background: linear-gradient(top,rgb(220,85,70),rgb(210,65,53));
		}
		/*logo*/
		.logo a {
			width: 88px;
			height: 88px;
			display: inline-block;
			position: relative;
			left: 50%;
			top: 50%;
			margin: -45px 0 0 -45px;
			border: 1px solid rgb(200,200,200);
			border-radius: 50%;
			background-color: rgb(214,214,214);
		}
		.logo a:before {
			content: "A";
			width: 70px;
			height: 70px;
			font: 50px/70px helvetica,verdana,sans-serif;
			text-align: center;
			position: absolute;
			top: 8px;
			left: 8px;
			border-radius: 35px;
			border: 1px solid rgb(210,210,210);
			display: inline-block;
			background: -webkit-linear-gradient(top,rgb(255,255,255),rgb(245,245,245));
			background: -moz-linear-gradient(top,rgb(255,255,255),rgb(245,245,245));
			background: -ms-linear-gradient(top,rgb(255,255,255),rgb(245,245,245));
			background: linear-gradient(top,rgb(255,255,255),rgb(245,245,245));
		}
		/*statusbar底部功能按钮*/
		.statusbar {
			position: absolute;
			bottom: 0;
			border-top: 1px solid rgb(235,235,235);
			width: 100%;
			padding: 0;
			margin: 0;
		}
		.statusbar li {
			list-style: none;
		}
		.statusbar a {
			color: rgb(102,102,102);
			text-decoration: none;
			text-align: center;
			display: block;
		}
		.statusbar a:hover {
			background-color: rgb(247,247,247);
		}
		.statusbar .profiles-setting, .statusbar .logout {
			float: right;
		}
		.statusbar .profiles-setting a, .statusbar .logout a {
			font-family: 'icomoon';
			width: 49px;
			height: 49px;
			line-height: 50px;
			border-left: 1px solid rgb(235,235,235);
		}
		@font-face {
			font-family: 'icomoon';
			src:url('CDXXW-ZONE/fonts/icomoon.eot');
			src:url('CDXXW-ZONE/fonts/icomoon.eot?#iefix') format('embedded-opentype'),
				url('CDXXW-ZONE/fonts/icomoon.woff') format('woff'),
				url('CDXXW-ZONE/fonts/icomoon.ttf') format('truetype'),
				url('CDXXW-ZONE/fonts/icomoon.svg#icomoon') format('svg');
			font-weight: normal;
			font-style: normal;
		}
	</style>
	
    	<!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>  	
        
	<script type="text/javascript">
    
    function userexit()
    {
    	
    	layer.confirm('确定退出长大信息网?', {icon: 3, title:'提示'}, function(index){
    		$.ajax({
    	        type: 'POST',
    	        url: "/CDXXW/webuser/userexit",
    	        dataType: 'json',
    	        success: function(data){
    	        	if(data)
    	        	{
    	        		location.href="/CDXXW/web/cdxxw";
    	        	}
    	        },
    	        error: function(xhr){
    	            layer.msg('error');
    	        }
    	    });
			
    	});
    }
	</script>
</head>
	<div class="codrops-top">
                <span class="right">
                    <a onclick="userexit();" style="text-decoration:none">
                        <strong>退出</strong>
                    </a>
                </span>
                
                <span class="left">
                    <a href="/CDXXW/web/cdxxw"  style="text-decoration:none">
                        <strong>长大信息网</strong>
                    </a>
                </span>
                <span class="left">
                    <a href="/CDXXW/webhdxx/list?XXMX_TYPE=0"  style="text-decoration:none">
                        <strong>长大活动</strong>
                    </a>
                </span>
                <span class="left">
                    <a href="/CDXXW/webesxx/list?XXMX_TYPE=0"  style="text-decoration:none">
                        <strong>长大二手</strong>
                    </a>
                </span>
                <span class="left">
                    <a href="/CDXXW/webjzxx/list?XXMX_TYPE=0"  style="text-decoration:none">
                        <strong>长大兼职</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
<body>
	<div class="page">
		<section class="demo">
			<div class="admin-panel clearfix">
				<div class="slidebar">
					<div class="logo">
						<a href=""></a>
					</div>
					<ul>
						<li><a href="/CDXXW/webzone/zone?param=#dashboard">个人中心</a></li>
						<li><a href="/CDXXW/webzone/jzxx?param=#posts">兼职信息</a></li>
						<li><a href="/CDXXW/webzone/esxx?param=#media">二手信息</a></li>
						<li><a href="/CDXXW/webzone/hdxx?param=#pages">活动信息</a></li>
						<li><a href="/CDXXW/webzone/scxx?param=#links">我的收藏</a></li>
						<li><a href="/CDXXW/webzone/zntz?param=#comments">站内通知</a></li>
						<li><a href="/CDXXW/webzone/user?param=#users">个人资料</a></li>
					</ul>
				</div>
				<div class="main">
					<ul class="topbar clearfix">
						<li><a href="#" title="发布信息">q</a></li>
						<!--<li><a href="#">p</a></li>
						<li><a href="#">o</a></li>
						<li><a href="#">f</a></li>
						<li><a href="#">n</a></li>-->
					</ul>
					<div class="mainContent clearfix">
						<div id="dashboard">
							<h2 class="header"><span class="icon"></span>我的地盘，我做主</h2>
							<div class="monitor" style="border:none">
								<h4>${webuser.USER_NAME}</h4>
								<div class="clearfix">
									<ul class="content"  style=" width:300px;" >
										<li>基本信息</li>
										<li class="posts">我的发布：<span class="count">${XX_COUNT}</span></li>
										<li class="pages">我的收藏：<span class="count">${SC_COUNT}</span></li>
										<li class="pages">我的加入时间：<span class="count">${fn:substring(webuser.USER_TIME,0,16)}</span></li>
                                   		<c:choose>
                                   			<c:when test="${webuser.USER_TYPE eq '2' }">
                                   				<li class="pages">用户类型：<span class="count">普通用户</span></li>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '3' }">
                                   				<li class="pages">用户类型：<span class="count">校部活动负责人</span></li>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '4' }">
                                   				<li class="pages">用户类型：<span class="count">系部活动负责人</span></li>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '5' }">
                                   				<li class="pages">用户类型：<span class="count">社团活动负责人</span></li>
                                   			</c:when>
                                   		</c:choose>
									</ul>
								</div>
							</div>
								<div class="monitor" style="margin-top:20px; height:295px; border:none">
								<div class="clearfix">
									<ul class="content" style=" width:500px;" >
                                    	<li><font size="+1">我的个人动态</font></li>
                                    	<c:forEach items="${list}" var="yhdt">
                                    		<li class="posts" style="margin-top:5px;">我${yhdt.YHDT_TYPE}
                                    		<c:if test="${yhdt.XX_TYPE eq 1 }">兼职信息</c:if>
                                    		<c:if test="${yhdt.XX_TYPE eq 2 }">二手信息</c:if>
                                    		<c:if test="${yhdt.XX_TYPE eq 3 }">活动信息</c:if>		
                                    		--<a href="">
                                    		<span class="count">${yhdt.XX_TITLE}</span></a><font style="display:block;float:right;">${fn:substring(yhdt.YHDT_TIME,0,16)}</font>
                                    		</li>
                                    	</c:forEach>
									</ul>
                                    <ul class="pagination pagination-sm" style="margin-left:460px; margin-top:10px;">
                                    <c:choose>
										<c:when test="${pageNow - 1 > 0}">
											<li><a href="/CDXXW/webzone/zone?pageNow=${pageNow - 1}&param=#dashboard">&laquo;</a></li>
										</c:when>
										<c:when test="${pageNow - 1 <= 0}">
											<li><a  href="/CDXXW/webzone/zone?pageNow=1&param=#dashboard">&laquo;</a></li>
										</c:when>
									</c:choose>
 
 									<c:choose>		
										<c:when test="${pageNow + 1 < pageCount}">
											<li><a href="/CDXXW/webzone/zone?pageNow=${pageNow + 1}&param=#dashboard" >&raquo;</a></li>
										</c:when>
										<c:when test="${pageNow + 1 >= pageCount}">
											<li><a href="/CDXXW/webzone/zone?pageNow=${pageCount}&param=#dashboard">&raquo;</a></li>
										</c:when>
									</c:choose>			
									</ul>
                                    
									
									<!--<ul class="discussions">
										<li>discussions</li>
										<li class="comments"><span class="count">353</span><a href="">comments</a></li>
										<li class="approved"><span class="count">319</span><a href="">approved</a></li>
										<li class="pending"><span class="count">0</span><a href="">pending</a></li>
										<li class="spam"><span class="count">34</span><a href="">spam</a></li>
									</ul>-->
								</div>
							</div>
                            
						</div>
                        
						<div id="posts">
							<h2 class="header">我发布的兼职信息</h2>
                                <div class="input-group" style="width:400px; margin-left:200px;">
         							<input type="text" class="form-control" placeholder="搜索你的兼职信息">
 							        <span class="input-group-addon">搜索</span>
      							</div>
                                <table style="margin-top:20px; margin-left:40px;" border="0" >
                                <c:forEach items="${jzxxvoList}" var="jzxxvo">
                                	<tr>
    									<td rowspan="2"><input type="checkbox"><img src="jzxx/${jzxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;"></td>
    									<td><h4>${jzxxvo.XX_TITLE}</h4></td>
    									<td style="display:block; margin-left:40px; margin-top:18px;">
    									<c:choose>
    										<c:when test="${jzxxvo.XXMX_TYPE eq '1' }"><span class="label label-info">教育家教</span></c:when>
    										<c:when test="${jzxxvo.XXMX_TYPE eq '2' }"><span class="label label-info">宣传促销</span></c:when>
    										<c:when test="${jzxxvo.XXMX_TYPE eq '3' }"><span class="label label-info">餐饮服务</span></c:when>
    										<c:when test="${jzxxvo.XXMX_TYPE eq '4' }"><span class="label label-info">网络兼职</span></c:when>
    										<c:when test="${jzxxvo.XXMX_TYPE eq '5' }"><span class="label label-info">其他兼职</span></c:when>
    									</c:choose>
    									</td>
    									<td><span class="glyphicon glyphicon-star" style="margin-left:60px;"></span>+${jzxxvo.XX_SC}</td>
    									<td width="98"> <span class="glyphicon glyphicon-search" style="margin-left:40px;"></span>+${jzxxvo.XX_LL}</td>
  									</tr>
                      
  									
  									<tr style="margin-top:20px;">
    									<td><span style="margin-left:20px;">发布于${fn:substring(jzxxvo.XX_TIME,0,16) }</span></td>
    									<td>&nbsp;</td>
    									<td>
                                        <button type="button" class="btn btn-default btn-sm" style="margin-left:40px; "><span class="glyphicon glyphicon-pencil"></span>修改</button>
                                        </td>
    									<td>
                                         <button type="button" class="btn btn-default btn-sm" style="margin-left:20px;"><span class="glyphicon glyphicon-remove"></span>删除</button>
                                        </td>
  									</tr>
  									</c:forEach>
                                 
								</table>
                                
                                <ul class="pagination pagination-sm" style="margin-left:540px; margin-top:20px;">
  										<li><a href="#">&laquo;</a></li>
  										<li><a href="#">&raquo;</a></li>
									</ul>
						</div>
						<div id="media">
							<h2 class="header">我发布的二手信息</h2>
                             <div class="input-group" style="width:400px; margin-left:200px;">
         							<input type="text" class="form-control" placeholder="搜索你的二手信息">
 							        <span class="input-group-addon">搜索</span>
      							</div>
                                
                                <table style="margin-top:20px; margin-left:40px;" border="0" >
                                <c:forEach items="${esxxvoList}" var="esxxvo">
                                	<tr>
    									<td rowspan="2"><input type="checkbox"><img src="esxx/${esxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;"></td>
    									<td><h4>${esxxvo.XX_TITLE}</h4></td>
    									<td style="display:block; margin-left:40px; margin-top:18px;">
    									<c:choose>
    										<c:when test="${esxxvo.XXMX_TYPE eq '1' }">
    											<span class="label label-info">手机数码</span>
    										</c:when>
    										<c:when test="${esxxvo.XXMX_TYPE eq '2' }">
    											<span class="label label-info">书籍教材</span>
    										</c:when>
    										<c:when test="${esxxvo.XXMX_TYPE eq '3' }">
    											<span class="label label-info">生活用品</span>
    										</c:when>
    										<c:when test="${esxxvo.XXMX_TYPE eq '4' }">
    											<span class="label label-info">二手文体</span>
    										</c:when>
    										<c:when test="${esxxvo.XXMX_TYPE eq '5' }">
    											<span class="label label-info">其他二手</span>
    										</c:when>
    									</c:choose>
    									
    									</td>
    									<td><span class="glyphicon glyphicon-star" style="margin-left:60px;"></span>+${esxxvo.XX_SC}</td>
    									<td width="98"> <span class="glyphicon glyphicon-search" style="margin-left:40px;"></span>+${esxxvo.XX_LL}</td>
  									</tr>
  									<tr style="margin-top:20px;">
    									<td><span style="margin-left:20px;">发布于${esxxvo.XX_TIME}</span></td>
    									<c:if test="${esxxvo.XX_STATE eq '0' }">
    										<td><span class="label label-danger" style=" margin-left:40px;">已交易</span></td>
    										<td>
                                        	</td>
    										<td>
                                         		<button type="button" class="btn btn-default btn-sm" style="margin-left:20px;"><span class="glyphicon glyphicon-remove"></span>删除</button>
                                        	</td>
                                        </c:if>
                                        <c:if test="${esxxvo.XX_STATE eq '1' }">
                                        	<td><span class="label label-success" style=" margin-left:40px;">未交易</span></td>
    										<td>
                                       			 <button type="button" class="btn btn-default btn-sm" style="margin-left:40px; "><span class="glyphicon glyphicon-pencil"></span>修改</button>
                                        	</td>
    										<td>
                                        	 	<button type="button" class="btn btn-default btn-sm" style="margin-left:20px;"><span class="glyphicon glyphicon-remove"></span>删除</button>
                                        	</td>
                                        	<td>
                                        		<button type="button" class="btn btn-default btn-sm">成功交易</button>
                                        	</td>
                                        </c:if>
                                        
  									</tr>
                                    
                                </c:forEach>
                         
								</table>
                                
                                <ul class="pagination pagination-sm" style="margin-left:540px; margin-top:20px;">
  										<li><a href="#">&laquo;</a></li>
  										<li><a href="#">&raquo;</a></li>
									</ul>
						</div>
						<div id="pages">
							<h2 class="header">我发布的活动信息</h2>、
                             <div class="input-group" style="width:400px; margin-left:200px;">
         							<input type="text" class="form-control" placeholder="搜索你的活动信息">
 							        <span class="input-group-addon">搜索</span>
      							</div>
                                <table style="margin-top:20px; margin-left:40px;" border="0" >
                                	<c:forEach items="${hdxxvoList}" var="hdxxvo">
                                		<tr>
    									<td rowspan="2"><input type="checkbox"><img src="hdxx/${hdxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;"></td>
    									<td><h4>${hdxxvo.XX_TITLE}</h4></td>
    									<td style="display:block; margin-left:40px; margin-top:18px;">
    									<c:choose>
    										<c:when test="${hdxxvo.XXMX_TYPE eq '1' }">
    											<span class="label label-info">长大主办</span>
    										</c:when>
    										<c:when test="${hdxxvo.XXMX_TYPE eq '2' }">
    											<span class="label label-info">系部活动</span>
    										</c:when>
    										<c:when test="${hdxxvo.XXMX_TYPE eq '3' }">
    											<span class="label label-info">社团活动</span>
    										</c:when>
    										<c:when test="${hdxxvo.XXMX_TYPE eq '4' }">
    											<span class="label label-info">个人发起</span>
    										</c:when>
    									</c:choose>
    									
    									</td>
    									<td><span class="glyphicon glyphicon-star" style="margin-left:60px;"></span>+${hdxxvo.XX_SC}</td>
    									<td width="98"> <span class="glyphicon glyphicon-search" style="margin-left:40px;"></span>+${hdxxvo.XX_LL}</td>
  									</tr>
  									<tr>
    									<td><span style="margin-left:20px;">发布于${fn:substring(hdxxvo.XX_TIME,0,16)}</span></td>
    									<td>
    									<c:if test="${hdxxvo.XX_STATE eq '1' }">
    										<span class="label label-danger" style=" margin-left:40px;">待审核</span>
    									</c:if>
    									<c:if test="${hdxxvo.XX_STATE eq '0' }">
    										<span class="label label-success" style=" margin-left:40px;">审核通过</span>
    									</c:if>
    									</td>
    									<td>
                                        <button type="button" class="btn btn-default btn-sm" style="margin-left:40px; "><span class="glyphicon glyphicon-pencil"></span>修改</button>
                                        </td>
    									<td>
                                         <button type="button" class="btn btn-default btn-sm" style="margin-left:20px;"><span class="glyphicon glyphicon-remove"></span>删除</button>
                                        </td>
  									</tr>   
                                	</c:forEach>                                    
								</table>
                                
                                <ul class="pagination pagination-sm" style="margin-left:540px; margin-top:20px;">
  										<li><a href="#">&laquo;</a></li>
  										<li><a href="#">&raquo;</a></li>
									</ul>
                            
						</div>
						<div id="links">
							<h2 class="header">我的收藏</h2>
                              <div class="input-group" style="width:400px; margin-left:200px;">
         							<input type="text" class="form-control" placeholder="搜索你的收藏信息">
 							        <span class="input-group-addon">搜索</span>
      							</div>
                            <table style="margin-top:20px; margin-left:40px;" border="0" >
                 				<c:forEach items="${scxxvoList}" var="scxxvo">
                 					<tr>
                                	<td>
                                	<c:if test="${scxxvo.XX_TYPE eq '1'}">
                                		<img src="jzxx/${scxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;">
                                	</c:if>
                                	<c:if test="${scxxvo.XX_TYPE eq '2'}">
                                		<img src="esxx/${scxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;">
                                	</c:if>
                                	<c:if test="${scxxvo.XX_TYPE eq '3'}">
                                		<img src="hdxx/${scxxvo.IMAGE_NAME}" class="img-rounded" style="width:60px; height:60px; margin-left:10px; margin-top:10px;">
                                	</c:if>
                                    </td>
                                    <td><h4 style="margin-top:30px;">${scxxvo.XX_TITLE}</h4></td>
                                    <td><span style="display:block; margin-left:40px; margin-top:15px;">收藏于：${fn:substring(scxxvo.SC_TIME,0,16) }</span></td>
                                    <td><button type="button" class="btn btn-primary" style="margin-left:100px; margin-top:10px;">取消收藏</button></td>
                                </tr>
                 				</c:forEach>
                            	
                            </table>
                             <ul class="pagination pagination-sm" style="margin-left:600px; margin-top:20px;">
  										<li><a href="#">&laquo;</a></li>
  										<li><a href="#">&raquo;</a></li>
									</ul>
						</div>
						<div id="comments">
							<h2 class="header">站内通知</h2>
                            
                            <table style="margin-top:40px; margin-left:40px;">
                            	<c:forEach items="${zntzList}" var="zntz">
                            	<tr  style="height:60px">
    								<td>${zntz.ZNTZ_CONTENT}</td>
    								<td rowspan="2"><button type="button" class="btn btn-warning" style="margin-left:300px;">信息已读</button></td>
  								</tr>
  								<tr>
    								<td><span>${fn:substring(zntz.ZNTZ_TIME,0,16)}</span></td>
  								</tr>
                            	</c:forEach>
							</table>
						</div>
						<!--<div id="widgets">
							<h2 class="header">widgets</h2>
						</div>-->
						<!--<div id="plugins">
							<h2 class="header">plugins</h2>
						</div>-->
						<div id="users">
							<h2 class="header">我的个人资料</h2>
                           <div class="monitor">
								<div class="clearfix" style="margin-left:50px;">
									<ul class="content">
										<li>基本信息</li>
										<li class="posts">用户名：<span class="count">${webuser.USER_NAME}</span></li>
										<li class="pages">注册邮箱：<span class="count">${webuser.USER_EMAIL}</span></li>
										<li class="pages">我的加入时间：<span class="count">${fn:substring(webuser.USER_TIME,0,16)}</span></li>
                                   		<li class="pages">用户类型：
                                   		<c:choose>
                                   			<c:when test="${webuser.USER_TYPE eq '2' }">
                                   				<span class="count">普通用户</span>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '3' }">
                                   				<span class="count">校部活动负责人</span>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '4' }">
                                   				<span class="count">系部活动负责人</span>
                                   			</c:when>
                                   			<c:when test="${webuser.USER_TYPE eq '5' }">
                                   				<span class="count">社团活动负责人</span>
                                   			</c:when>
                                   		</c:choose>
                                   		
                                   		</li>
                                        <li class="pages">用户备注：<span class="count">${webuser.USER_MARK}</span></li>
										<!--<li class="categories"><span class="count">21</span><a href="">categories</a></li>
										<li class="tags"><span class="count">305</span><a href="">tags</a></li>-->
									</ul>
                                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">修改个人资料</button>
								</div>
                                <div class="quick-press" style="margin-top:50px; margin-left:50px;">
								<h4>修改密码</h4>
								<form action="" method="post">
									<input type="password" name="title" placeholder="老密码"/>
									<input type="password" name="content" placeholder="新密码"/>
									<input type="password" name="tags" placeholder="确认密码"/>
									<button type="submit" class="submit" name="submit">修改密码</button>
								</form>
							</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			
		</section>

	</div>

</body>
</html>