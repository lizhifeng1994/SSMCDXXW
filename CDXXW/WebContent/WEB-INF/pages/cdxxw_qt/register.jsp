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
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>长大信息网注册</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="stylesheet" type="text/css" href="login/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="login/css/style.css" />
         <!--额外我自己引进来的-->
        <script type="text/javascript" src="weblib/jquery/1.9.1/jquery.min.js"></script> 
		<script type="text/javascript" src="weblib/layer/1.9.3/layer.js"></script>
        <script type="text/javascript" src="weblib/js/H-ui.js"></script> 
		<script type="text/javascript" src="weblib/js/H-ui.admin.js"></script>
		<script type="text/javascript" src="weblib/Validform/5.3.2/Validform.min.js"></script> 
		<script type="text/javascript">
		$(function(){
			$("#webuser-register").Validform({
				tiptype:3,
				ajaxPost:true,
				callback:function(data){
					if(data){
						layer.msg('注册成功');
						location.href="/CDXXW/web/cdxxw";
					}
					else{
						layer.msg('注册失败');
						location.href="/CDXXW/webuser/register";
					}
						
				}
			});
		});
		</script>
    </head>
    <body>
        <div class="container">
            <!-- Codrops top bar -->
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
                <div id="container_demo" >
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                         <div id="login" class="animate form">
                            <form  action="/CDXXW/webuser/add" id="webuser-register"  method="post"> 
                                <h1> 注册 </h1> 
                                <p> 
                                    <label  class="uname" data-icon="u">用户名</label>
                                    <input name="USER_NAME" id="USER_NAME" placeholder="请输入您的用户名"  sucmsg="用户名验证通过！" ajaxurl="/CDXXW/user/USER_NAMEexits?flag=0"  datatype="*2-16" nullmsg="用户名不能为空" />
                                </p>
                                
                                <p> 
                                    <label class="youmail" data-icon="e" > 邮箱</label>
                                    <input name="USER_EMAIL"  datatype="e" nullmsg="请输入邮箱！" ajaxurl="/CDXXW/user/USER_EMAILexits?flag=0" sucmsg="邮箱验证通过！"  placeholder="请正确输入您的邮箱地址"/> 
                                </p>
                                
                                <p> 
                                    <label class="youpasswd" data-icon="p">密码 </label>
                                    <input type="password" name="password" id="password" datatype="*6-18" nullmsg="请输入密码！"  placeholder="请输入您的密码"/>
                                </p>
                                
                                <p> 
                                    <label class="youpasswd" data-icon="p">确认密码 </label>
                                    <input type="password" name="password2" id="password2" recheck="password" datatype="*6-18" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！" placeholder="请再次输入您的密码"/>
                                </p>
                                <p class="signin button"> 
									<input type="submit" value="加入我们"/> 
								</p>
                                <p class="change_link">  
									已有账号?
									<a href="/CDXXW/webuser/login" class="to_register"> 立即登陆 </a>
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
        </div>

  
	</body>
</html>