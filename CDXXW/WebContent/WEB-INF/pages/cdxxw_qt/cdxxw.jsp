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
		<title>长大信息网首页</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width">
		
		<!-- CSS -->
        <!--顶部导航栏css样式-->
		<link href="login/css/demo.css" rel="stylesheet" type="text/css"/>
		
		<link rel="stylesheet" href="webcss/style.css">
		<link rel="stylesheet" href="webcss/responsive.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<link rel="stylesheet" type="text/css" href="webcss/default_ss.css" />
		<link rel="stylesheet" type="text/css" href="webcss/component.css" />
        
		<link rel="stylesheet" type="text/css" href="webcss/normalize_lzf.css" />
		<link rel="stylesheet" type="text/css" href="webcss/default.css">
		<link href="webcss/bootstrap.min.css" rel="stylesheet" type="text/css" />
    	<link href="webcss/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
    	<link href="webcss/site.css" rel="stylesheet" type="text/css" />

    	<!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>  	
        
        
		<script src="webjs/modernizr.custom.js"></script>
		
		<script src="webjs/modernizr.js"></script>
       	<script src="webjs/jquery.min.js"></script>
		<script>window.jQuery || document.write('<script src="webjs/jquery.js"><\/script>')</script>
		<script src="webjs/custom.js"></script>
		
		<!-- superfish -->
		<script  src="webjs/superfish-1.4.8/js/hoverIntent.js"></script>
		<script  src="webjs/superfish-1.4.8/js/superfish.js"></script>
		<script  src="webjs/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<script src="webjs/css3-mediaqueries.js"></script>
		
		<script src="webjs/nivoslider.js"></script>
        <script src="webjs/jquerymin.js" type="text/javascript"></script>
		<script src="webjs/jquery.bootstrap.newsbox.min.js" type="text/javascript"></script>        
    <script type="text/javascript">
	
	function choice_select(title,id){
		
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/web/user_exits",
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{
	        		var index = layer.open({
	    				title:title,
	        			type: 2,
	        			content:"/CDXXW/web/xx_choice",
	        			area: ['1000px', '500px'],
	    				//屏蔽浏览器滚动条
	    				scrollbar: false,
	    			});
	        	}
	        	else
	        	{
	        		layer.msg('请登录',{icon: 3,time:1000});
	        		setTimeout(function(){
	        			location.href="/CDXXW/webuser/login";
					},500);
	        		
	        	}
	        },
	        error: function(xhr){
	            layer.msg('error');
	        }
	    });
		
	}
	
	
	
    $(function () {
        $(".demo1").bootstrapNews({
            newsPerPage: 4,
            autoplay: true,
			pauseOnHover:true,
            direction: 'up',
            newsTickerInterval: 1500,
            onToDo: function () {
                //console.log(this);
            }
        });
		
		$(".demo2").bootstrapNews({
            newsPerPage: 6,
            autoplay: true,
			pauseOnHover: true,
			navigation: false,
            direction: 'down',
            newsTickerInterval: 1500,
            onToDo: function () {
                //console.log(this);
            }
        });

      
    });
    
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
	<body>
	
		<div class="codrops-top">
              
               <c:if test="${empty sessionScope.webuser }">
               		<span class="right">
                    		<a href="/CDXXW/webuser/login"  style="text-decoration:none">
                        		<strong>登陆</strong>
                    		</a>
                		</span>
               			 <span class="right">
                   		 	<a href="/CDXXW/webuser/register"  style="text-decoration:none">
                        		<strong>注册</strong>
                    			</a>
                		</span>
               </c:if>
 				
 			<c:if test="${not empty sessionScope.webuser}">
 						<span class="right">
                    		<a onclick="userexit();" style="text-decoration:none">
                        		<strong>退出</strong>
                    		</a>
               			 </span>
                		 <span class="right">
                    		<a href="/CDXXW/webzone/zone?param=#dashboard" style="text-decoration:none">
                        		<strong>个人中心</strong>
                    		</a>
               			 </span>
               			 <span class="right">
                    		<a href="" style="text-decoration:none">
                        		<strong>欢迎您， ${sessionScope.webuser.USER_NAME}</strong>
                    		</a>
               			 </span>
 			</c:if>
               
                
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
		<!-- WRAPPER -->
		<div class="wrapper">
		
			<!-- HEADER -->
			<header class="cf">
				<div id="logo"><a href="/CDXXW/web/cdxxw"><img src="img/logo.png" alt="Madison Template" /></a></div>
				
				<!-- social-bar -->
				<!-- ENDS social-bar -->
				
			</header>
			<!-- ENDS HEADER -->
			
			<!-- NAV -->
			<nav class="cf">
				<ul id="nav" class="sf-menu">
					<li class="current-menu-item"><a href="/CDXXW/web/cdxxw">长大信息网</a></li>
					<li><a href="/CDXXW/webhdxx/list?XXMX_TYPE=0">长大活动</a>
						<ul>
							<li><a href="/CDXXW/webhdxx/list?XXMX_TYPE=1">长大主办</a></li>
							<li><a href="/CDXXW/webhdxx/list?XXMX_TYPE=2">系部活动</a></li>
							<li><a href="/CDXXW/webhdxx/list?XXMX_TYPE=3">社团活动</a></li>
                         	<li><a href="/CDXXW/webhdxx/list?XXMX_TYPE=4">个人发起</a></li>							
						</ul>	
					</li>
					
                    <li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a>
						<ul>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
                            <li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                            <li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</ul>	
                        
					</li>
                    
                    <li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=0">长大兼职</a>
						<ul>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
                            <li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                            <li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
							
						</ul>	
					</li>
                					<li  style=" margin-left:400px" class="important"><a onclick="choice_select('发布信息','1001')">发布你的信息</a></li>
					
				</ul>
                <li>
                <div class="column">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="搜活动、二手、兼职" type="text" value="" name="search" id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"></span>
						</form>
					</div>
				</div>
                </li>
                
        <script src="webjs/classie.js"></script>
		<script src="webjs/uisearch.js"></script>
		<script>
			new UISearch( document.getElementById( 'sb-search' ) );
		</script>
<div style="text-align:center;clear:both">
</div>
			</nav>
			<!-- ENDS NAV -->
			
			<h1 class="important" style="margin-left:40px;">一周大事件</h1>
			<!-- MAIN -->
			<div id="main" class="cf">
			
				<!-- SLIDER -->
				<div class="slider-wrapper">
		            <div id="slider" class="nivoSlider">
						<img  src="img/dummies/slides/01.jpg" alt=""  />
		                <img src="img/dummies/slides/02.jpg" alt="" />
		                <img src="img/dummies/slides/03.jpg" alt="" />
		            </div>
		        </div>
				<!-- ENDS SLIDER -->
				
				<!-- tagline -->

				<!-- ENDS tagline -->
				<!-- featured -->
				<div class="line-heading">
					热门活动  <a href="/CDXXW/webhdxx/list?XXMX_TYPE=0"  style="text-decoration:none" >查看全部</a>
				</div>
				<ul class="feature cf">
				<c:forEach items="${hotHDMXList}" var="hotHDMX">
					<li>
						<a href="/CDXXW/webhdxx/hdmx?XX_ID=${hotHDMX.XX_ID}" class="thumb" >
							<img src="hdxx/${hotHDMX.IMAGE_NAME}" alt="Thumbnail" width="290px;" height="320px;"  />
							<div class="img-overlay">查看更多</div>
						</a>
						<a href="/CDXXW/webhdxx/hdmx?XX_ID=${hotHDMX.XX_ID}"  class="title">${hotHDMX.XX_TITLE}</a>
						<div class="categories">
						<c:choose>
							<c:when test="${hotHDMX.XXMX_TYPE eq '1' }"><a href="/CDXXW/webhdxx/list?XXMX_TYPE=1">长大主办</a></c:when>
							<c:when test="${hotHDMX.XXMX_TYPE eq '2' }"><a href="/CDXXW/webhdxx/list?XXMX_TYPE=2">系部活动</a></c:when>
							<c:when test="${hotHDMX.XXMX_TYPE eq '3' }"><a href="/CDXXW/webhdxx/list?XXMX_TYPE=3">社团主办</a></c:when>
							<c:when test="${hotHDMX.XXMX_TYPE eq '4' }"><a href="/CDXXW/webhdxx/list?XXMX_TYPE=4">个人发起</a></c:when>
						</c:choose>
						<a href="#" style="margin-left: 10px;">${hotHDMX.USER_NAME} 发布</a>
						</div>
						<div  class="excerpt">
						<!-- 只截取内容的一部分 -->
						<c:if test="${fn:length(hotHDMX.HD_CONTENT)>28}">${fn:substring(hotHDMX.HD_CONTENT,0,28)}...</c:if>
   　　  					<c:if test="${fn:length(hotHDMX.HD_CONTENT)<=28}">${hotHDMX.HD_CONTENT}</c:if>
						<a href="/CDXXW/webhdxx/hdmx?XX_ID=${hotHDMX.XX_ID}">查看更多>>
						</a></div>
					</li>
				</c:forEach>
				</ul>
				<!-- ENDS featured -->
				
				
				<!-- RECENT POSTS -->
				<div class="one-third-col">
					<div class="line-heading">
						最新兼职信息 <a href="/CDXXW/webjzxx/list?XXMX_TYPE=0" style="text-decoration:none" >查看全部</a>
					</div>
                  <div class="col-md-4" style="width:300px;">
					<div class="panel panel-default">
						<div class="panel-body" style=" background-color:#DEDAD3">
							<div class="row">
								<div class="col-xs-12">
									<ul class="demo1">
									<c:forEach items="${newJZXXList}" var="newJZXX">
										<li class="news-item">
											<table cellpadding="4" style="width:100%;">
												<tr>
                                                	<tr>
                                                    	<td style="font-size: 14px; font-weight:700">${newJZXX.XX_TITLE}</td>
                                                        <td align="right"> <a href="/CDXXW/webjzxx/jzmx?XX_ID=${newJZXX.XX_ID}">查看详情</a></td>
                                                    </tr>
                                                    <tr>
                                                    	<td>${newJZXX.USER_NAME} 发布</td>
                                                        <td align="right">${newJZXX.XX_TIME}</td>
                                                    </tr>                                          
												</tr>
											</table>
										</li>
									</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>  
                  </div>
                  
				<!-- ENDS RECENT POSTS -->	
				
				<!-- FEATURED VIDEO-->
				<div class="two-third-col">
							<div class="line-heading">
						最新二手信息 <a href="/CDXXW/webesxx/list?XXMX_TYPE=0" style="text-decoration:none" >查看全部</a>
					</div>
                  <div class="col-md-4" style="width:600px;">
					<div class="panel panel-default">
						<div class="panel-body" style=" background-color:#DEDAD3">
							<div class="row">
								<div class="col-xs-12">
									<ul class="demo1">
									<c:forEach items="${newESXXList}" var="newESXX">
										<li class="news-item" >
											<table cellpadding="4" style="width:100%;">
												<tr>
                                                	<tr>
                                                    	<td style="font-size: 14px; font-weight:700">${newESXX.XX_TITLE}</td>
                                                        <td align="right"> <a href="/CDXXW/webesxx/esmx?XX_ID=${newESXX.XX_ID}">查看详情</a></td>
                                                    </tr>
                                                    <tr>
                                                    	<td>${newESXX.USER_NAME} 发布</td>
                                                        <td align="right">${newESXX.XX_TIME}</td>
                                                    </tr>                                          
												</tr>
											</table>
										</li>
									</c:forEach>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>  
                  

				</div>
             
				<!-- ENDS FEATURED VIDEO -->
				
				
			</div>
			<!-- ENDS MAIN -->
			
			
			<!-- WIDGETS -->
			<ul  class="widget-cols cf">
				<li class="first-col">
					
					<div class="widget-block">
						<h4>MADISON TEMPLATE</h4>
						<p>Use this template on your commercial or personal projects no links back required but much appreciated. Read the complete license agreement on this <a href="#/blog/license/" >link</a> </p>
		     		</div>
				</li>
				
				<li class="second-col">
					
					<div class="widget-block">
						<h4>LATEST TWEETS</h4>
                        11
		     		</div>
					
				</li>
				
				<li class="third-col">
					
					<div class="widget-block">
						<h4>DUMMY TEXT</h4>
						<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper.</p>
		     		</div>
		     		
				</li>
				
				<li class="fourth-col">
					
					<div class="widget-block">
						<h4>CATEGORIES</h4>
						<ul>
							<li class="cat-item"><a href="#" >Design</a></li>
							<li class="cat-item"><a href="#" >Photo</a></li>
							<li class="cat-item"><a href="#" >Art</a></li>
							<li class="cat-item"><a href="#" >Game</a></li>
							<li class="cat-item"><a href="#" >Film</a></li>
							<li class="cat-item"><a href="#" >TV</a></li>
						</ul>
					</div>
		     		
				</li>
				<li class="scroll"></li>
			</ul>
			<!-- ENDS WIDGETS -->
			
			
			<!-- FOOTER -->
			<!-- ENDS FOOTER -->
		
		</div>
		<!-- ENDS WRAPPER -->
		
		<!-- JS -->	
		<!-- ENDS JS -->
	</body>
</html>