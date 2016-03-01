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
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>编辑用户信息</title>
</head>
<body>
<div class="pd-20">
	<form method="post" class="form form-horizontal" id="form-admin-edit">
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text"  datatype="*2-16" ajaxurl="/CDXXW/user/USER_NAMEexits?flag=1"  sucmsg="用户名验证通过！"     nullmsg="用户名不能为空"  value="${user.USER_NAME}"  id="USER_NAME" name="USER_NAME" >
				<span class="c-red" id="USER_NAME1"></span>
			</div>
			<div class="col-4"> </div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
			<div class="formControls col-5">
				<input type="text" class="input-text"  ajaxurl="/CDXXW/user/USER_EMAILexits?flag=1" value="${user.USER_EMAIL}" name="USER_EMAIL" id="USER_EMAIL" sucmsg="邮箱验证通过！"   datatype="e" nullmsg="请输入邮箱！" >
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>角色：</label>
			<div class="formControls col-5"> <span class="select-box" style="width:150px;">
				<select class="select" name="USER_TYPE" size="1">
				<c:choose>
					<c:when test="${user.USER_TYPE eq '2'}">
						<option value="2">普通用户</option>
						<option value="3">校部活动负责人</option>
						<option value="4">系部活动负责人</option>
						<option value="5">社团活动负责人</option>
					</c:when>
					<c:when test="${user.USER_TYPE eq '3'}">
						<option value="3">校部活动负责人</option>
						<option value="2">普通用户</option>
						<option value="4">系部活动负责人</option>
						<option value="5">社团活动负责人</option>
					</c:when>
					<c:when test="${user.USER_TYPE eq '4'}">
						<option value="4">系部活动负责人</option>
						<option value="2">普通用户</option>
						<option value="3">校部活动负责人</option>
						<option value="5">社团活动负责人</option>
					</c:when>
					<c:when test="${user.USER_TYPE eq '5'}">
						<option value="5">社团活动负责人</option>
						<option value="2">普通用户</option>
						<option value="3">校部活动负责人</option>
						<option value="4">系部活动负责人</option>
					</c:when>
				</c:choose>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-3">备注：</label>
			<div class="formControls col-5">
				<textarea name="USER_MARK" cols="" rows="" class="textarea"  placeholder="说点什么..." dragonfly="true" onKeyUp="textarealength(this,100)">${user.USER_MARK}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">${fn:length(user.USER_MARK)}</em>/100</p>
			</div>
			<div class="col-4"> </div>
		</div>
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<button class="btn btn-primary radius"  type="submit" ><i class="Hui-iconfont">&#xe632;</i>提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	var USER_NAME = '${user.USER_NAME}';
	/*为什么邮箱格式需要用''包起来*/
	var USER_EMAIL = '${user.USER_EMAIL}';
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#form-admin-edit").Validform({
		tiptype:2,		
		datatype:{
			USER_NAME:function(gets){
				if(USER_NAME==$("#USER_NAME").val()){
					return "新用户名不能和原用户名一样！";	
				}
			},
			USER_EMAIL:function(gets){
				if(USER_EMAIL==$("#USER_EMAIL").val()){
					return "新邮箱不能和原邮箱一样！";	
				}
			}	
		},
		callback:function(){
			ajaxPost()
			parent.location.reload(); 
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	});
});


function ajaxPost()
{
	$.ajax({
	       type: 'POST',
	        url: "/CDXXW/user/useredit",
	        data:$('#form-admin-edit').serialize(),
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

function userConfirm1()
{
	var USER_NAME = $("#USER_NAME").val();
	var USER_EMAIL = $("#USER_EMAIL").val();
	
	if(USER_NAME==""||USER_NAME==null)
	{
		$("#USER_NAME1").html("用户名不能为空");
		$("#USER_NAME").focus(); 
		return false;
	}
	
	if(USER_EMAIL==""||USER_EMAIL==null)
	{
		$("#USER_EMAIL1").html("邮箱不能为空");
		$("#USER_EMAIL").focus();
		return false;
	}
	if(USER_EMAIL!=""||USER_EMAIL!=null)
	{
		return confirmUSER_EMAIL();
	}
	
	return true;
}

function user1()
{
	if(userConfirm1())
	{
		$("form-admin-edit").submit();
		layer.open({
	    type: 2,
	    content: '添加用户成功',
	    success: function(layero, index){
	    	parent.location.reload(); 
	    	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	    	parent.layer.close(index); //再执行关闭  
	    }
		}); 
	}
	else
	{
		layer.msg("请填写正确信息");
	}
}

/*确认用户名是否存在*/
	function checkUSER_NAME(USER_NAME1)
	{
		var USER_NAME = $("#USER_NAME").val();
		if(USER_NAME!=USER_NAME1)
		{
			var USER_NAME = $("#USER_NAME").val();
			$.ajax({
		       type: 'POST',
		        url: "/CDXXW/user/USER_NAMEexits",
		        data:{USER_NAME:USER_NAME},
		        dataType: 'json',
		        success: function(data){
		        	/*传过来的数据是删除后的总条数*/
		        	if(data)
		        	{
		     			layer.msg('用户已存在!');
		     			
		        	}
		        	else
		        	{
		        		$("#USER_NAME1").html("");
		        	}
		        },
		        error: function(xhr){
		            layer.msg('error');
		        }
		    	});
			}

	}
	

/*邮箱验证*/
function confirmUSER_EMAIL()
{
	var USER_EMAIL = $("#USER_EMAIL").val();
	/*邮箱的正则表达式*/
	var szReg=/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/;
	if(szReg.test(USER_EMAIL))
	{
		$("#USER_EMAIL1").html("");
		/*如果密码格式正确，则发送ajax请求看该邮箱是否已经被注册*/
		$.ajax({
		       type: 'POST',
		        url: "/CDXXW/user/USER_EMAILexits",
		        data:{USER_EMAIL:USER_EMAIL},
		        dataType: 'json',
		        success: function(data){
		        	/*传过来的数据是删除后的总条数*/
		        	if(data)
		        	{
		        		/*如果邮箱存在，打印信息，并且光标不能移出*/
		     			layer.msg('该邮箱已被注册!');
		     			$("#USER_EMAIL").focus();
		        	}
		        },
		        error: function(xhr){
		            layer.msg('error');
		        }
		    	});
		return true;
	}
	else
	{
		$("#USER_EMAIL1").html("请输入正确的邮箱格式");
		$("#USER_EMAIL").focus();
		return false;
	}
}

</script>
</body>
</html>