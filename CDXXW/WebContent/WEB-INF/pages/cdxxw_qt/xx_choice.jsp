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
<title>选择信息类型</title> 
		<link rel="stylesheet" type="text/css" href="infosend/css/default.css"/>
		<link rel="stylesheet" type="text/css" href="infosend/css/component.css"/>
        <link rel="stylesheet" type="text/css" href="infosend/css/style.css" />
                <!--额外我自己引进来的-->
        <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="lib/js/H-ui.js"></script> 
		<script type="text/javascript" src="lib/js/H-ui.admin.js"></script>  	
        
		<script src="js/modernizr.custom.js"></script>
<link href="webcss/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Pricing Tables Design ,Flat Pricing Tables Design ,Popup Pricing Tables Design,Clean Pricing Tables Design "./>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

</head>
<body class="cbp-spmenu-push">

<script src="webjs/jquery.magnific-popup.js" type="text/javascript"></script>
<script type="text/javascript" src="webjs/modernizr.custom.53451.js"></script> 
		<script src="webjs/classie.js"></script>
<script type="text/javascript">
//发布活动，不同的用户权限可以选择不同的情况
	function user_hd(XXMX_TYPE)
	{
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/web/user_power?XXMX_TYPE="+XXMX_TYPE,
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{
	        		location.href="/CDXXW/webhdxx/add?flag=0&XXMX_TYPE="+XXMX_TYPE;
	        	}
	        	else
	        	{
	        		layer.msg('没有该权限',{icon: 3,time:1000});     		
	        	}
	        },
	        error: function(xhr){
	            layer.msg('error');
	        }
	    });
		
	
	}
</script>
<div class="pricing-plans">
					 <div class="wrap">
						<div class="pricing-grid1">
							<div class="price-value">
									<h2><a>长大兼职</a></h2>
									
							  <div class="sale-box">
							</div>

							</div>
							<div class="price-bg">
							<ul>
								<li class="whyt"><a href="/CDXXW/webjzxx/add?XXMX_TYPE=1">教育家教</a></li>
								<li><a href="/CDXXW/webjzxx/add?XXMX_TYPE=2">宣传促销</a></li>
								<li class="whyt"><a href="/CDXXW/webjzxx/add?XXMX_TYPE=3">餐饮服务</a></li>
								<li><a href="/CDXXW/webjzxx/add?XXMX_TYPE=4">网络兼职</a></li>
								<li class="whyt"><a href="/CDXXW/webjzxx/add?XXMX_TYPE=5">其他兼职</a></li>
							</ul>
							</div>
						</div>
						<div class="pricing-grid2">
							<div class="price-value two">
								<h3><a>二手市集</a></h3>
								<div class="sale-box two">
							</div>

							</div>
							<div class="price-bg">
							<ul>
								<li class="whyt"><a href="/CDXXW/webesxx/add?XXMX_TYPE=1">手机数码</a></li>
								<li><a href="/CDXXW/webesxx/add?XXMX_TYPE=2">书籍教材</a></li>
								<li class="whyt"><a href="/CDXXW/webesxx/add?XXMX_TYPE=3">生活用品</a></li>
								<li><a href="/CDXXW/webesxx/add?XXMX_TYPE=4">二手文体</a></li>
								<li class="whyt"><a href="/CDXXW/webesxx/add?XXMX_TYPE=5">其他二手</a></li>
							</ul>
							</div>
						</div>
						<div class="pricing-grid3">
							<div class="price-value three">
								<h4><a href="">长大活动</a></h4>
								
								<div class="sale-box three">
							
							</div>

							</div>
							<div class="price-bg">
							<ul>
								<li class="whyt" style="display:block; height: 64px;"><a onclick="user_hd(1);">长大主办</a></li>
								<li style="display:block; height: 70px;"><a onclick="user_hd(2);">系部活动</a></li>
								<li class="whyt" style="display:block; height: 74px;"><a onclick="user_hd(3);">社团活动</a></li>
								<li style="display:block; height:70px;"><a onclick="user_hd(4);">个人发起</a></li>
							</ul>
							</div>
						</div>
							<div class="clear"> </div>
					   </div>
						<div class="clear"> </div>
					</div>
				

</body>
</html>