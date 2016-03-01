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
        <title>登陆</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="login/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
		<link rel="stylesheet" type="text/css" href="login/css/animate-custom.css" />
		
		         <!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>
		<script type="text/javascript" src="weblib/Validform/5.3.2/Validform.min.js"></script>
		<script type="text/javascript">
		$(function(){
			var url ="${url}"; 
			$("#webuser-login").Validform({
				tiptype:3,
				ajaxPost:true,
				callback:function(data){
					if(data){
						layer.msg('登陆成功');
						setTimeout(function(){
							location.href=url;
						},500);
						
					}
					else{
						layer.msg('用户名或密码错误');
						setTimeout(function(){
							document.getElementById("webuser-login").reset(); 
						},500);
					}
						
				}
			});
		});
		</script> 
    </head>
    <body>
        <div class="container">
            <div class="codrops-top">
                <span class="right">
                    <a href="/CDXXW/web/cdxxw">
                        <strong>返回长大信息网首页</strong>
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ Codrops top bar -->
            <header>
                <h1 style="color:#FFF">欢迎来到<a href="/CDXXW/web/cdxxw"><span>长大信息网</span></a></h1>
            </header>
			<div style="text-align:center;clear:both;">
			</div>
            <section>				
                <div id="container_demo" >
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form  action="/CDXXW/webuser/weblogin" autocomplete="on" method="post" id="webuser-login" > 
                                <h1>登 	陆</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u" > 邮箱或用户名 </label>
                                    <input name="USER_NAME" id="USER_NAME"  required type="text" placeholder="请输入您的邮箱或用户名"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> 密码 </label>
                                    <input id="USER_PWD" name="USER_PWD" required type="password" placeholder="请输入您的密码" /> 
                                </p>
                                <p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
									<label for="loginkeeping">记住我</label>
								</p>
                                <p class="login button"> 
                                    <input type="submit" value="登陆" /> 
								</p>
                                <p class="change_link">
									还没账号 ?
									<a href="/CDXXW/webuser/register" class="to_register">立即注册</a>
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>

  
	</body>
</html>