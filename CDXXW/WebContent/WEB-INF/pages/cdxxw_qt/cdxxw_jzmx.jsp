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
		<title>长大兼职</title>
		<meta name="description" content="">
		<meta name="viewport" content="width=device-width">
		<!-- CSS -->
		<!--顶部导航栏css样式-->
		<link href="login/css/demo.css" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="webcss/style.css">
		<link rel="stylesheet" href="webcss/responsive.css">
		<link rel="stylesheet" type="webtext/css" href="webcss/default_ss.css" />
		<link rel="stylesheet" type="webtext/css" href="webcss/component.css" />



		<link rel="stylesheet" type="webtext/css" href="webcss/normalize_lzf.css" />
		<link rel="stylesheet" type="text/css" href="webcss/default.css">

       
       	  <!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>  	
        
		<script src="webjs/modernizr.js"></script>
        <script src="webjs/modernizr.custom.js"></script>
		
		<script src="webjs/modernizr.js"></script>
        <link rel="stylesheet" type="text/css" href="webcss/tblh.css">
		<script type="text/javascript" src="webjs/jquery.tblh.js"></script>
		<script type="text/javascript" src="webjs/tblh.js"></script>
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
      	        			content:"/CDXXW/webjzxx/add?XXMX_TYPE=0",
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
		layer.config({
    		extend: 'extend/layer.ext.js'
		}); 
		
		
		function jzxx_jb()
		{
			var USERINFO = "${webuser}";
			var XX_TITLE = "${XXINFO.XX_TITLE}";
			var USER_NAME= "${webuser.USER_NAME}";
			var XX_ID  = "${XXINFO.XX_ID}";
			var JB_TYPE = "${XXINFO.XX_TYPE}";
			if((USERINFO==null)||(USERINFO==""))
			{
				layer.msg('请登录',{icon: 3,time:1000});
	        		setTimeout(function(){
	        			location.href="/CDXXW/webuser/login";
					},500);
			}
			else
			{
				layer.prompt({title: '请如实填写您的举报信息', formType: 2}, function(text){
					$.ajax({
		      	        type: 'POST',
		      	        url: "/CDXXW/jbxx/add",
		      	        data:{XX_TITLE:XX_TITLE,USER_NAME:USER_NAME,XX_ID:XX_ID,JB_TYPE:JB_TYPE,JB_CONTENT:text},
		      	        dataType: 'json',
		      	        success: function(data){
		      	        	if(data)
		      	        	{
		      	        		layer.msg('感谢您的反馈，我们会及时处理，并且给出处理结果',{icon:1,time:1000});
		      	        	}
		      	        	
		      	        },
		      	        error: function(xhr){
		      	            layer.msg('error');
		      	        }
		      	    });
    			});
			}
		}
		
		
		
		function xx_sc()
		{
			var USERINFO = "${webuser}";
			var XX_TITLE = "${XXINFO.XX_TITLE}";
			var USER_NAME= "${webuser.USER_NAME}";
			var XX_ID  = "${XXINFO.XX_ID}";
			var SC_TYPE = "${XXINFO.XX_TYPE}";
			var XX_SC = "${XXINFO.XX_SC}"
			var YHDT_TYPE = 1;
			if((USERINFO==null)||(USERINFO==""))
			{
				layer.msg('请登录',{icon: 3,time:1000});
	        		setTimeout(function(){
	        			location.href="/CDXXW/webuser/login";
					},500);
			}
			else
			{
				$.ajax({
	      	        type: 'POST',
	      	        url: "/CDXXW/scxx/exits",
	      	        data:{USER_NAME:USER_NAME,XX_ID:XX_ID},
	      	        dataType: 'json',
	      	        success: function(data){
	      	        	if(data)
	      	        	{
	      	        		layer.msg('您已经收藏了该信息',{icon:1,time:1000});
	      	        	}
	      	        	else
	      	        	{
	      	        		$.ajax({
	    		      	        type: 'POST',
	    		      	        url: "/CDXXW/scxx/add",
	    		      	        data:{XX_TITLE:XX_TITLE,USER_NAME:USER_NAME,XX_ID:XX_ID,SC_TYPE:SC_TYPE,YHDT_TYPE:YHDT_TYPE,XX_SC:XX_SC},
	    		      	        dataType: 'json',
	    		      	        success: function(data){
	    		      	        	if(data)
	    		      	        	{
	    		      	        		layer.msg('已收藏到个人中心',{icon:1,time:1000});
	    		      	        	}
	    		      	        },
	    		      	        error: function(xhr){
	    		      	            layer.msg('error');
	    		      	        }
	    		      	    });
	      	        	}
	      	        	
	      	        },
	      	        error: function(xhr){
	      	            layer.msg('error');
	      	        }
	      	    });
			}
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
					<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=0">长大兼职</a></li>
					<c:choose>
						<c:when test="${XXINFO.XXMX_TYPE eq '1'}">
							<li class="current-menu-item"><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                    		<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
						</c:when>
						
						<c:when test="${XXINFO.XXMX_TYPE eq '2'}">
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li class="current-menu-item"><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                    		<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
						</c:when>
						
						<c:when test="${XXINFO.XXMX_TYPE eq '3'}">
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li  class="current-menu-item"><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                    		<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
						</c:when>
						
						<c:when test="${XXINFO.XXMX_TYPE eq '4'}">
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
							<li   class="current-menu-item"><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                    		<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
						</c:when>
						
						<c:when test="${XXINFO.XXMX_TYPE eq '5'}">
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=1">教育家教</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=2">宣传促销</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=3">餐饮服务</a></li>
							<li><a href="/CDXXW/webjzxx/list?XXMX_TYPE=4">网络兼职</a></li>
                    		<li    class="current-menu-item"><a href="/CDXXW/webjzxx/list?XXMX_TYPE=5">其他兼职</a></li>
						</c:when>
						
					</c:choose>
					<li class="important" style=" margin-left:200px" ><a onclick="choice_select('发布兼职信息','1001')">发布你的兼职信息</a></li>
				</ul>
                 <li>
                				<div class="column">
					<div id="sb-search" class="sb-search">
						<form>
							<input class="sb-search-input" placeholder="嘿，这里很真实！" type="text" value="" name="search" id="search">
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
			<div id="main" class="cf">
				
				<!-- posts list -->
				<div id="posts-list" class="cf single-post"> 
					<article class="cf">
                    		<div class="entry-title">
							<div class="post-heading" >
                            <h2>${XXINFO.XX_TITLE}</h2>
                            </div>
                            <span style="margin-left:250px;">浏览量：${XXINFO.XX_LL}</span>
                            <span style="margin-left:20px;">发布时间：${fn:substring(XXINFO.XX_TIME,0,16)}</span> 
						</div>
						<div class="excerpt entry-content">
                        <h4>职位描述</h4>
                        <hr></hr>
							<p>${jzmxinfo.JZZW_MARK}</p>
						</div>	
                        <div class="excerpt entry-content">
                        <h4>公司描述</h4>
                        <hr></hr>
							<p>${jzmxinfo.JZGS_MARK}</p> 
						</div>	
                        <h4>图片详情</h4>
                        <hr></hr>
						<div class="banner">

	<div class="banner-btn">
		<a href="javascript:;" class="prevBtn"><i></i></a>
		<a href="javascript:;" class="nextBtn"><i></i></a>
	</div>
	<ul class="banner-img">
	<c:forEach items="${IMAGEList}" var="image">
		<li><a href="#"><img src="jzxx/${image.IMAGE_NAME}" width="520px;" height="300px;"></a></li>
	</c:forEach>
	</ul>
	<ul class="banner-circle"></ul>
</div>

				
					</article>
					
					
					<!-- Comments wrap-->
					
					<!-- ENDS Comments wrap -->
					
					<!-- Respond -->
					
					<!-- ENDS Respond -->
				
				</div>
				<!-- ENDS post list -->
				
				<!-- SIDEBAR -->
				<aside id="sidebar" >
				
					<ul>
						<li class="block">
							<h4 class="heading">兼职详情</h4>
							<ul>
								<li class="cat-item"><font style="font-weight:700">兼职工资：</font>${jzmxinfo.JZ_SALARY}</li>
								<li class="cat-item"><font style="font-weight:700">结算类型：</font>${jzmxinfo.JZJS_TYPE}</li>
								<li class="cat-item"><font style="font-weight:700">招聘人数：</font>${jzmxinfo.JZZP_NUMBER}人</li>
								<li class="cat-item"><font style="font-weight:700">工作区域：</font>${jzmxinfo.JZGZ_FIELD}</li>
                               <li class="cat-item"><font style="font-weight:700">工作开始时间：</font>${fn:substring(jzmxinfo.JZGZ_TIME,0,16)}</li>
                               <li class="cat-item"><font style="font-weight:700">工作开始时间：</font>${fn:substring(jzmxinfo.JZGZ_TIME,21,37)}</li>
                                <li class="cat-item"><font style="font-weight:700">联系方式：</font>
                                 <table border="0" width="270px;">
                                 <tr>
                                 	<th align="right">QQ号：</th>
                                    <td align="left">${jzmxinfo.JZ_QQ}</td>
                                 <tr>
                                 <tr>
                                 	<th align="right">联系电话：</th>
                                    <td align="left">${jzmxinfo.JZ_PHONE}</td>
                                 </tr>
                                 </table>
                                </li>
                                <li style="margin-top:20px;"><a class="comment-reply-link" onclick="xx_sc();" >收藏到我的个人中心</a><a class="comment-reply-link"  onClick="jzxx_jb();" style="margin-left:40px;">我要举报</a></li>
							</ul>
                            
						</li>
						
						<li class="block">
						<!-- 相同类型的兼职信息推荐，最多5个 -->
							<h4 class="heading">相关兼职推荐</h4>
							<div class="small-posts-list ">
							<c:forEach items="${groomJZXXList}" var="groomJZXX">
								<div class="post cf">
									<div class="post-head">
										<a href="/CDXXW/webjzxx/jzmx?XX_ID=${groomJZXX.XX_ID}">${groomJZXX.XX_TITLE}</a><span class="meta">${fn:substring(groomJZXX.XX_TIME,0,16)}
										<font style="margin-left:20px;">${groomJZXX.USER_NAME}<span style="margin-left: 20px;">发布</span></font></span>
									</div>
								</div>
							</c:forEach>	
							</div>		
						</li>
		
					</ul>
				</aside>
				<!-- ENDS SIDEBAR -->
				
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