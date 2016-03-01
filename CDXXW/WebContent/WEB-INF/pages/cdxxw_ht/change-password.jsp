<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 导入标签必须用这种方式 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<base href="<%=basePath%>">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<title>修改密码</title>
</head>
<body>
<div class="pd-20">
	<form  method="post" class="form form-horizontal" id="form-change-password">
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>账户：</label>
			<div class="formControls col-4">${USER_NAME}</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>新密码：</label>
			<div class="formControls col-4">
				<input type="password" class="input-text"  autocomplete="off" placeholder="不修改请留空" name="USER_PWD" id="USER_PWD" datatype="USER_PWD,*6-18" nullmsg="密码不能为空" >
			</div>
			<div class="col-4"> </div> 	
		</div>
		<div class="row cl">
			<label class="form-label col-4"><span class="c-red">*</span>确认密码：</label>
			<div class="formControls col-4">
				<input type="password" class="input-text" autocomplete="off" placeholder="不修改请留空" name="new-password2" id="new-password2" recheck="USER_PWD" datatype="*6-18" errormsg="您两次输入的密码不一致！" ignore="ignore" >
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<div class="col-8 col-offset-4">
				<input class="btn btn-primary radius" type="submit"  value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script>
$(function(){
	var USER_PWD = ${USER_PWD};
	$("#form-change-password").Validform({
		tiptype:2,
		datatype:{
			USER_PWD:function(gets){
				if(USER_PWD==$("#USER_PWD").val()){
					return "新密码不能和原密码不能一样！";	
				}
			}	
		},
		callback:function(form){
			
			 ajaxPost();
			 var index = parent.layer.getFrameIndex(window.name);
  			parent.layer.close(index);
		}
	});
	
});

function ajaxPost()
{
	$.ajax({
	       type: 'POST',
	        url: "/CDXXW/user/changePWD",
	        data:$('#form-change-password').serialize(),
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{
	        		 layer.msg('修改用户信息成功');	
	        	}
	        },
	        error: function(xhr){
	            layer.msg('error');
	        }
	   });
	
}
</script>
</body>
</html>