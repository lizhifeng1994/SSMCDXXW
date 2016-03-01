<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>站内通知</title>
</head>
<body>
<div class="pd-20">
	<form action="/CDXXW/zntz/realadd" method="post" class="form form-horizontal" id="form-zntz-add">
		
        <div id="tab-category" class="HuiTab">
			<div class="tabBar cl"><span>发送站内通知</span></div>
			
            <div class="tabCon" style="margin-top:20px;">
				<div class="row cl" >
					<label class="form-label col-3" style="margin-top:20px;">
					<span class="c-red">*</span>用户类型：</label>
					<div class="formControls col-7" style="margin-top:20px;">
					<input name="USER_TYPE" id="USER_TYPE1" type="checkbox"  value="2"  errormsg="请选择您常去的购物网站！" />
					<label for="USER_TYPE1">普通用户</label>
					<input name="USER_TYPE" id="USER_TYPE2" type="checkbox"  value="3" />
					<label for="USER_TYPE2">校部负责人</label>
					<input name="USER_TYPE" id="USER_TYPE3" type="checkbox"  value="4" />
					<label for="USER_TYPE3">系部负责人</label>
					<input name="USER_TYPE" id="USER_TYPE4" type="checkbox"  value="5" />
					<label for="USER_TYPE4">社团负责人</label>
							
					</div>
				</div>
              
                			<div class="row cl">
					<label class="form-label col-3"><span class="c-red">*</span>站内通知内容：</label>
					<div class="formControls col-7">
						<textarea name="ZNTZ_CONTENT" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-140" dragonfly="true"  nullmsg="内容不能为空！" onKeyUp="textarealength(this,140)"></textarea>
						<p class="textarea-numberbar"><em class="textarea-length">0</em>/140</p>
					</div>
      			</div>
			</div>
                 
		<div class="row cl">
			<div class="col-9 col-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;发送站内通知&nbsp;&nbsp;">
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
	var demo=$("#form-zntz-add").Validform({
		tiptype:3,
		label:"#label",
		showAllError:true,
		ajaxPost:true,
		callback:function(data){
			if(data){
				setTimeout(function(){
					//$.Hidemsg(); //公用方法关闭信息提示框;显示方法是$.Showmsg("message goes here.");
					$.Showmsg("发送站内通知成功");
					 parent.location.reload(); 
			 		 var index = parent.layer.getFrameIndex(window.name);
			 		 parent.layer.close(index);
				},500);
			}
		}
	});
	
	demo.addRule([
	{
		ele:":checkbox:first",
		datatype:"*"
	}]);

	$.Huitab("#tab-category .tabBar span","#tab-category .tabCon","current","click","0");
});
</script>
</body>
</html>