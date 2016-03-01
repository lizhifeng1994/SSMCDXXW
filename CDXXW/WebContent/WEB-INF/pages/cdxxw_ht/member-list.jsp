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
<base href="<%=basePath%>">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a id="btn-refresh" class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
<form action="/CDXXW/user/query" method="post">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:150px" placeholder="输入用户名" id="" name="USER_NAME">
        <input type="text" class="input-text" style="width:150px" placeholder="输入邮箱地址" id="" name="USER_EMAIL">
               <span class="select-box inline">
             <select class="select" name="USER_TYPE">
        			<option value="">请选择</option>
					<option value="2">普通用户</option>
					<option value="3">校部活动负责人</option>
					<option value="4">系部活动负责人</option>
					<option value="5">社团活动负责人</option>
				</select>
                </span>
                <span class="select-box inline">
             <select class="select" name="USER_WORK">
        			<option value="">请选择</option>
					<option value="1">已启用</option>
					<option value="0">已停用</option>
				</select>
                </span>
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="delALL();" class="btn btn-danger radius">
	<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
	 <a href="javascript:;" onclick="member_add('添加用户','/CDXXW/user/add','','510')" class="btn btn-primary radius">
	 <i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span> <span class="r" id="rowCount">共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>

			<tr class="text-c">
				<th width="25"><input type="checkbox" name="USER_IDS"></th>
				<th width="100">用户名</th>
				<th width="150">邮箱</th>
                <th width="70">用户角色</th>	
				<th width="130">加入时间</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="user">
			<tr class="text-c">
				<td><input type="checkbox" value="${user.USER_ID}" name="USER_IDS"></td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('查看用户明细','/CDXXW/user/usermx?USER_ID=${user.USER_ID}','10001','360','400')">${user.USER_NAME}</u></td>
				<td>${user.USER_EMAIL}</td>
				<td>
				<c:choose>
					<c:when test="${user.USER_TYPE eq '2'}">普通用户</c:when>
					<c:when test="${user.USER_TYPE eq '3'}">校部活动负责人</c:when>
					<c:when test="${user.USER_TYPE eq '4'}">系部活动负责人</c:when>
					<c:when test="${user.USER_TYPE eq '5'}">社团活动负责人</c:when>
				</c:choose>
				</td>
				<td>${user.USER_TIME}</td>
				<td class="td-status">
				<c:choose>
					<c:when test="${user.USER_WORK eq '1'}"><span class="label label-success radius">已启用</span></c:when>
					<c:when test="${user.USER_WORK eq '0'}"><span class="label label-defaunt radius">已停用</span></c:when>
				</c:choose>
				</td>
				<td class="td-manage">
				<c:choose>
					<c:when test="${user.USER_WORK eq '1'}">
						<a style="text-decoration:none" onClick="member_stop(this,'${user.USER_ID}','0','${user.USER_NAME}')" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>
					</c:when>
					<c:when test="${user.USER_WORK eq '0'}">
						<a style="text-decoration:none" onClick="member_start(this,'${user.USER_ID}','1','${user.USER_NAME}')" href="javascript:;" title="启用"><i class="Hui-iconfont">&#xe6e1;</i></a>
					</c:when>
				</c:choose>				
				 <a title="编辑" href="javascript:;" onclick="member_edit('编辑用户信息','/CDXXW/user/edit?USER_ID=${user.USER_ID}','4','','510')" class="ml-5" style="text-decoration:none">
				 	<c:choose>
				 	 	<c:when test="${user.USER_WORK eq '1'}">
				 	 		<i class="Hui-iconfont" id="${user.USER_ID}">&#xe6df;</i>
				 	 	</c:when>
				 	 	<c:when test="${user.USER_WORK eq '0'}">
				 	 	 	<i class="Hui-iconfont" id="${user.USER_ID}" style="display: none">&#xe6df;</i>
				 	 	</c:when>
				 	</c:choose>	
				 </a>
				  <a style="text-decoration:none" class="ml-5" onClick="change_password('修改密码','/CDXXW/user/change-password?USER_ID=${user.USER_ID}','10001','600','350')" href="javascript:;" title="修改密码">
				  	<c:choose>
				 	 	<c:when test="${user.USER_WORK eq '1'}">
				 	 		<i class="Hui-iconfont" id="${user.USER_NAME}">&#xe63f;</i>
				 	 	</c:when>
				 	 	<c:when test="${user.USER_WORK eq '0'}">
				 	 	 	<i class="Hui-iconfont" id="${user.USER_NAME}" style="display: none">&#xe63f;</i>
				 	 	</c:when>
				 	</c:choose>
				  </a> 
				  <a title="删除" href="javascript:;" onclick="member_del(this,'${user.USER_ID}')" class="ml-5" style="text-decoration:none">
				  	<i class="Hui-iconfont">&#xe6e2;</i>
				  </a>
				  </td>
			</tr>  
		</c:forEach>       
		</tbody>
		
	</table>
	<div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/user/list?pageNow=1&&"  class="laypage_last" title="首页">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/user/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/user/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/user/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/user/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/user/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

    	<a id="pageCont">第${pageNow}页/共${pageCount}页</a>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.admin.js"></script> 
<script type="text/javascript">

/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function member_stop(obj,id,USER_WORK,USER_NAME){
	layer.confirm('确认要停用吗？',function(index){
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/user/userwork",
	        data:{USER_ID:id,USER_WORK:USER_WORK},
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{
	        		var $icon = $('<i class="Hui-iconfont">&#xe6e1;</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						title: '启用',
						style: 'text-decoration:none'
					});
					$a.click(function(){
						member_start(this, id, 1,USER_NAME);
					});
					
					$a.append($icon);
					var ui = document.getElementById(id); 
					ui.style.display="none"; 
					
					var pwd = document.getElementById(USER_NAME); 
					pwd.style.display="none"; 
					$(obj).parents("tr").find(".td-manage").prepend($a);
	    			$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
	    			$(obj).remove();
	    			layer.msg('已停用!',{icon: 5,time:1000});
	        	}
	        	else
	        	{
	        		layer.msg('系统错误!',{icon: 2,time:1000});
	        	}
	        },
	        error: function(xhr){
	            layer.msg('error');
	        }
	    });
	
	});
}

/*用户-启用*/
function member_start(obj,id,USER_WORK,USER_NAME){
	layer.confirm('确认要启用吗？',function(index){
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/user/userwork",
	        data:{USER_ID:id,USER_WORK:USER_WORK},
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{
	        		var $icon = $('<i class="Hui-iconfont">&#xe631;</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						title: '启用',
						style: 'text-decoration:none'
					});
					$a.click(function(){
						member_stop(this, id, 0,USER_NAME);
					});
					
					$a.append($icon);
					var ui = document.getElementById(id); 
					ui.style.display=""; 
					
					var pwd = document.getElementById(USER_NAME); 
					pwd.style.display=""; 
					$(obj).parents("tr").find(".td-manage").prepend($a);
	        		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
	        		$(obj).remove();
	        		layer.msg('已启用!',{icon: 6,time:1000});
	        	}
	        	else
	        	{
	        		layer.msg('系统错误!',{icon: 2,time:1000});
	        	}
	        },
	        error: function(xhr){
	            layer.msg('error');
	        }
	    });
		
	});
}

/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	var pageNow = ${pageNow};
	var pageCount =${pageCount};
	layer.confirm('确认要删除吗？',function(index){
		 $.ajax({
		        type: 'POST',
		        url: "/CDXXW/user/del",
		        data:{USER_ID:id},
		        dataType: 'json',
		        success: function(data){
		        	/*传过来的数据是删除后的总条数*/
		        	var rowCount = data[0];
		        	$("#rowCount").html("共有数据：<strong>"+rowCount+"</strong> 条");
		        	$("#pageCont").html("第"+pageNow+"页/共"+pageCount+"页");
		        	$(obj).parents("tr").remove();
		     		layer.msg('已删除!',{icon:1,time:1000});
		        },
		        error: function(xhr){
		            layer.msg('error');
		        }
		    });
	});  
}

function delALL()
{
	 var bb = "";  
     var temp = "";  
     var a = document.getElementsByName("USER_IDS");  
     for ( var i = 0; i < a.length; i++) {  
     if (a[i].checked) {  
    	temp = a[i].value;  
    	 bb =temp+","+bb;  
    	 }  
     }  
	layer.confirm('确认要删除选中的这些吗？',function(index){
		
		location.href="/CDXXW/user/delAll?USER_IDS="+bb;
		});  
}
</script> 
</body>
</html>