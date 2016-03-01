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
		<title>长大二手</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width">
		
		<!-- CSS -->
		 <!--顶部导航栏css样式-->
		<link href="login/css/demo.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="webcss/style.css">
		<link rel="stylesheet" href="webcss/responsive.css">
		<link rel="stylesheet" type="text/css" href="webcss/default_ss.css" />
		<link rel="stylesheet" type="text/css" href="webcss/component.css" />

		

		<link rel="stylesheet" type="text/css" href="webcss/normalize_lzf.css" />
		<link rel="stylesheet" type="text/css" href="webcss/default.css">
		  <!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>  	
        
		<script src="webjs/modernizr.js"></script>
        	<script src="webjs/modernizr.custom.js"></script>
            
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
  	        			content:"/CDXXW/webesxx/add?XXMX_TYPE=0",
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
				<c:choose>
						<c:when test="${XXMX_TYPE eq '0' }">
							<li class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
						<c:when test="${XXMX_TYPE eq '1' }">
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
						<c:when test="${XXMX_TYPE eq '2' }">
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
						<c:when test="${XXMX_TYPE eq '3' }">
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
						<c:when test="${XXMX_TYPE eq '4' }">
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li  class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
						<c:when test="${XXMX_TYPE eq '5' }">
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=0">长大二手</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=1">手机数码</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=2">书籍教材</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=3">生活用品</a></li>
							<li><a href="/CDXXW/webesxx/list?XXMX_TYPE=4">二手文体</a></li>
                    		<li class="current-menu-item"><a href="/CDXXW/webesxx/list?XXMX_TYPE=5">其他二手</a></li>
						</c:when>
				</c:choose>
				<li class="important" style=" margin-left:200px"><a onclick="choice_select('发布二手信息','1001')">发布你的二手信息</a></li>
				</ul>
                <li>
                				<div class="column">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="很实惠的！！！" type="text" value="" name="search" id="search">
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
			
			
			<!-- MAIN -->
			<div id="main" class="cf" style="margin-top:60px;">		
				<!-- work list -->
				<ul class="work-list cf" id="filter-container" style="margin-top: 30px;">
					<c:forEach items="${esxxvoList}" var="esxxvo">
						<li>
						<a href="/CDXXW/webesxx/esmx?XX_ID=${esxxvo.XX_ID}" class="thumb" >
							<img src="esxx/${esxxvo.IMAGE_NAME}" alt="Thumbnail" height="336px;" width="300px;" />
							<div class="img-overlay">${esxxvo.ES_PRICE}元</div>
						</a>
						<a href="/CDXXW/webesxx/esmx?XX_ID=${esxxvo.XX_ID}"  class="title">${esxxvo.XX_TITLE}</a>
						
						<div class="categories">${esxxvo.USER_NAME} 发布于 ${esxxvo.XX_TIME}</div>
					</li>
					</c:forEach>
					
				</ul>
				<!-- ENDS work list -->	
				
				<!-- pager -->
				<ul class="pager cf">
					<li class="paged">第${pageNow}页/共${pageCount}页</li>
					<li><a href="/CDXXW/webesxx/list?pageNow=1&&XXMX_TYPE=${XXMX_TYPE}" style="width: 40px;">首页</a></li>
					<c:choose>
						<c:when test="${pageNow - 1 > 0}">
							<li><a href="/CDXXW/webesxx/list?pageNow=${pageNow - 1}&&XXMX_TYPE=${XXMX_TYPE}" style="width: 60px;">上一页</a></li>
						</c:when>
						<c:when test="${pageNow - 1 <= 0}">
							<li><a href="/CDXXW/webesxx/list?pageNow=1&&XXMX_TYPE=${XXMX_TYPE}" style="width: 60px;">上一页</a></li>
						</c:when>
					</c:choose>
					
					<c:choose>
						<c:when test="${pageNow + 1 < pageCount}">
							<li><a href="/CDXXW/webesxx/list?pageNow=${pageNow + 1}&&XXMX_TYPE=${XXMX_TYPE}" style="width: 60px;">下一页</a></li>
						</c:when>
						<c:when test="${pageNow + 1 >= pageCount}">
							<li><a href="/CDXXW/webesxx/list?pageNow=${pageCount}&&XXMX_TYPE=${XXMX_TYPE}" style="width: 60px;">下一页</a></li>
						</c:when>
					</c:choose>

					<li><a href="/CDXXW/webesxx/list?pageNow=${pageCount}&&XXMX_TYPE=${XXMX_TYPE}" style="width: 40px;">尾页</a></li>
				</ul>
				<!-- ENDS pager -->
			
					
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
						<script src="js/chirp.js"></script>
						<script>Chirp({user:'ansimuz',max:2})</script>
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
			<div class="footer-divider"></div>
			<footer class="cf">
				Madison Theme. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> 
			</footer>
			<!-- ENDS FOOTER -->
		
		</div>
		<!-- ENDS WRAPPER -->
		
		<!-- JS -->
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
		<script src="webjs/tabs.js"></script>
	
		<!-- ENDS JS -->
	</body>
</html>