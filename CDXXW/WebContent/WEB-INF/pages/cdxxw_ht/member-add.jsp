<%@page import="java.util.List"%>
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
<head>
<base href="<%=basePath%>">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>添加用户</title>
</head>
<body>
<div class="pd-20">
	<form action="/CDXXW/user/useradd"  method="post" class="form form-horizontal" id="form-admin-add">
		<div class="row cl">

			<label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" ajaxurl="/CDXXW/user/USER_NAMEexits?flag=0" autocomplete="off" placeholder="用户名"  datatype="*2-16"  sucmsg="用户名验证通过！" id="user-name" name="user-name" nullmsg="用户名不能为空">
			</div>
			
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>初始密码：</label>
			<div class="formControls col-5">
				<input type="password" class="input-text" autocomplete="off" placeholder="密码" name="password" id="password" datatype="*6-18" nullmsg="请输入密码！">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-5">
				<input type="password" class="input-text" autocomplete="off" placeholder="密码" name="password2" id="password2" recheck="password" datatype="*6-18" nullmsg="请再输入一次密码！" errormsg="您两次输入的密码不一致！">
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text" ajaxurl="/CDXXW/user/USER_EMAILexits?flag=0" sucmsg="邮箱验证通过！" placeholder="@" name="email" id="email" datatype="e" nullmsg="请输入邮箱！">
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>角色：</label>
			<div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" name="admin-role" size="1">
					<option value="2">普通用户</option>
					<option value="3">校部活动负责人</option>
					<option value="4">系部活动负责人</option>
					<option value="5">社团活动负责人</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">备注：</label>
			<div class="formControls col-5">
				<textarea name="USER_MARK" cols="" rows="" class="textarea"  placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="textarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	//自带的ajax传值
	$("#form-admin-add").Validform({
		tiptype:2,	
		ajaxPost:true,
		callback:function(data){
			if(data){
				setTimeout(function(){
					//$.Hidemsg(); //公用方法关闭信息提示框;显示方法是$.Showmsg("message goes here.");
					$.Showmsg("添加用户成功");
					 parent.location.reload(); 
			 		 var index = parent.layer.getFrameIndex(window.name);
			 		 parent.layer.close(index);
				},500);
			}
		}
/*
		tiptype:2,		
		callback:function(){
			ajaxPost()
			 parent.location.reload(); 
 			var index = parent.layer.getFrameIndex(window.name);
 			parent.layer.close(index);
		}
	*/
	});
});

</script>
</body>
</html>