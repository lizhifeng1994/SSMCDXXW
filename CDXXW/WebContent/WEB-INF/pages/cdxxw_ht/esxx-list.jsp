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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>二手信息列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 二手信息管理 <span class="c-gray en">&gt;</span> 二手信息列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="/CDXXW/esxx/esxxlist" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
 <form action="/CDXXW/esxx/query" method="post">
	<div class="text-c"> 发布时间：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
		<input type="text" name="esxx_title" id="" placeholder=" 二手信息标题" style="width:200px" class="input-text">
        <input type="text" name="user_name" id="" placeholder=" 发布者" style="width:100px" class="input-text">
        <span class="select-box inline">
             <select class="select" name="esxx_type">
        			<option value="">请选择</option>
					<option value="1">手机数码</option>
					<option value="2">书籍教材</option>
					<option value="3">生活用品</option>
					<option value="4">二手文体</option>
                    <option value="5">其他二手</option>
				</select>
                </span>
               <span class="select-box inline">
                 <select class="select" name="XX_STATE">
        			<option value="">请选择</option>
					<option value="0">已交易</option>
					<option value="1">未交易</option>
				</select>
                </span>
		<button name="" id="" class="btn btn-success" onclick="this.form.submit()"><i class="Hui-iconfont">&#xe665;</i> 搜二手信息</button>
	</div>
		</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	 <span class="l"><a href="javascript:;" onclick="delALL();" class="btn btn-danger radius">
	 <i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="esxx_add('添加二手信息','/CDXXW/esxx/add')" href="javascript:;">
	 <i class="Hui-iconfont">&#xe600;</i> 添加二手信息</a></span>
	 <span class="r">共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="XX_IDS" type="checkbox" value=""></th>

					<th width="100">二手信息标题</th>
					<th width="80">二手信息发布者</th>
					<th width="80">二手类型</th>
					<th width="100">发布时间</th>
                   
                    <th width="60">浏览量</th>
                    <th width="60">收藏量</th>
                     <th width="60">状态</th>                     
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="esxx">
					<tr class="text-c">
						<td><input name="XX_IDS" type="checkbox" value="${esxx.XX_ID}"></td>
						<td><u style="cursor:pointer" class="ml-5" onClick="esxx_mx('查看二手信息明细','/CDXXW/esxx/esmx?XX_ID=${esxx.XX_ID}','1001','1000','570')" href="javascript:;" title="编辑">${esxx.XX_TITLE}</u></td>
					<td><u style="cursor:pointer" class="text-primary" onclick="member_show('查看用户明细','/CDXXW/user/xxusermx?USER_NAME=${esxx.USER_NAME}','10001','360','400')">${esxx.USER_NAME}</u></td>
				<td>
				<c:choose>
					<c:when test="${esxx.XXMX_TYPE eq '1'}">手机数码</c:when>
					<c:when test="${esxx.XXMX_TYPE eq '2'}">书籍教材</c:when>
					<c:when test="${esxx.XXMX_TYPE eq '3'}">生活用品</c:when>
					<c:when test="${esxx.XXMX_TYPE eq '4'}">二手文体</c:when>
					<c:when test="${esxx.XXMX_TYPE eq '5'}">其他二手</c:when>
				</c:choose>
				
				</td>
				<td>${esxx.XX_TIME}</td>
				<td>${esxx.XX_LL}</td>
				<td>${esxx.XX_SC}</td>
				<td class="td-status">
				<c:choose>
					<c:when test="${esxx.XX_STATE eq '1'}"><span class="label label-success radius">未交易</span></c:when>
					<c:when test="${esxx.XX_STATE eq '0'}"><span class="label label-defaunt radius">已交易</span></c:when>
				</c:choose>
				</td>
				<td class="td-manage">
				<c:choose>
						<c:when test="${esxx.XX_STATE eq '0'}">	
							<a style="text-decoration:none" onClick="esxx_jy(this,'${esxx.XX_ID}','1')" href="javascript:;" title="交易">
								<i class="Hui-iconfont">&#xe631;</i>
							</a>
						</c:when>
						<c:when test="${esxx.XX_STATE eq '1'}">
							<a style="text-decoration:none" onClick="esxx_wjy(this,'${esxx.XX_ID}','0')" href="javascript:;" title="未交易">
								<i class="Hui-iconfont">&#xe603;</i>
							</a>
						</c:when>	
				</c:choose>
				<a style="text-decoration:none" class="ml-5" onClick="esxx_edit('编辑二手信息','/CDXXW/esxx/esxxedit?XX_ID=${esxx.XX_ID}','10001')" href="javascript:;" title="编辑">
					<c:choose>
						<c:when test="${esxx.XX_STATE eq '1'}">	<i class="Hui-iconfont" id="${esxx.XX_ID}">&#xe6df;</i></c:when>
						<c:otherwise><i class="Hui-iconfont" id="${esxx.XX_ID}" style="display: none">&#xe6df;</i></c:otherwise>			
					</c:choose>
				</a> 
				<a style="text-decoration:none" class="ml-5" onClick="esxx_del(this,'${esxx.XX_ID}')" href="javascript:;" title="删除">
				<i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
			</c:forEach>
			
			</tbody>
		</table>
		 <div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/esxx/list?pageNow=1&&"  class="laypage_last" title="首页">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/esxx/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/esxx/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/esxx/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/esxx/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/esxx/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

    	<a>第${pageNow}页/共${pageCount}页</a>
</div>
	</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.admin.js"></script> 
<script type="text/javascript">

/*图片-添加*/
function esxx_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*图片-查看*/
function picture_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*已经交易*/
function esxx_jy(obj,id,XX_STATE){
	layer.confirm('确认未交易吗？',function(index){
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/esxx/jy",
	        data:{XX_ID:id,XX_STATE:XX_STATE},
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{	
	        		var $icon = $('<i class="Hui-iconfont">&#xe603;</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						title: '已交易',
						style: 'text-decoration:none'
					});
					$a.click(function(){
						esxx_wjy(this, id, 1);
					});
					
					$a.append($icon);
					var ui = document.getElementById(id); 
					ui.style.display=""; 
					$(obj).parents("tr").find(".td-manage").prepend($a);
					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">未交易</span>');
					$(obj).remove();
	    			layer.msg('未交易!',{icon: 4,time:1000});
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

/*未交易*/
function esxx_wjy(obj,id,XX_STATE){
	layer.confirm('确认已交易吗？',function(index){
		$.ajax({
	        type: 'POST',
	        url: "/CDXXW/esxx/jy",
	        data:{XX_ID:id,XX_STATE:XX_STATE},
	        dataType: 'json',
	        success: function(data){
	        	if(data)
	        	{		
	        		var $icon = $('<i class="Hui-iconfont">&#xe631;</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						title: '未交易',
						style: 'text-decoration:none'
					});
					$a.click(function(){
					esxx_jy(this, id, 0);
					});
					/*
						出现问题，只会改变第一行的
					*/
					var ui = document.getElementById(id); 
					ui.style.display="none"; 
				$a.append($icon);
				$(obj).parents("tr").find(".td-manage").prepend($a);
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已交易</span>');
	    			$(obj).remove();
	    			layer.msg('已交易!',{icon: 6,time:1000});
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

function esxx_mx(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*图片-编辑*/
function esxx_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*二手信息-删除*/
function esxx_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		location.href="/CDXXW/esxx/del?XX_ID="+id;
	});  
}
/*批量删除*/
function delALL()
{
	 var bb = "";  
     var temp = "";  
     var a = document.getElementsByName("XX_IDS");  
     for ( var i = 0; i < a.length; i++) {  
     if (a[i].checked) {  
    	temp = a[i].value;  
    	 bb =temp+","+bb;  
    	 }  
     }  
	layer.confirm('确认要删除选中的这些吗？',function(index){
		
		location.href="/CDXXW/esxx/del?XX_IDS="+bb;
		});  
	}
	
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>