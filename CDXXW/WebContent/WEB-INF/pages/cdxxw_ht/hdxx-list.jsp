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
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<title>活动信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 活动信息管理 <span class="c-gray en">&gt;</span> 活动信息列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
 <form action="/CDXXW/hdxx/query" method="post">
	<div class="text-c"> 
    	发布时间：
		<input type="text" name="start_time" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" name="end_time" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
        <input type="text" name="user_name" id="" placeholder="  发布者 " style="width:100px" class="input-text">
		<input type="text" name="hdxx_title" id="" placeholder=" 活动信息标题 " style="width:250px" class="input-text">
        <span class="select-box inline">
		<select name="hdxx_type" class="select">
			<option value="">请选择</option>
			<option value="1">长大主办</option>
			<option value="2">系部活动</option>
            <option value="3">社团活动</option>
            <option value="4">个人发起</option>
		</select>
		</span>
        <span class="select-box inline">
		<select name="XX_STATE" class="select">
			<option value="">请选择</option>
			<option value="1">待审核</option>
			<option value="0">已通过审核</option>
		</select>
		</span>
		<button name="" id="" class="btn btn-success" onclick="this.form.submit()"><i class="Hui-iconfont">&#xe665;</i> 搜活动信息</button>
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	<span class="l"><a href="javascript:;" onclick="delALL();" class="btn btn-danger radius">
	<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
	<a class="btn btn-primary radius" onclick="hdxx_add('添加活动信息','/CDXXW/hdxx/add')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加活动信息</a></span>
	<span class="r" id="rowCount" >共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input type="checkbox" name="XX_IDS"></th>
					<th width="100">活动信息标题</th>
					<th width="80">发布者</th>
					<th width="80">活动信息类型</th>
					<th width="100">发布时间</th>
					<th width="60">浏览量</th>
					<th width="60">收藏量</th>
                    <th width="60">发布状态</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="hdxx">
			<tr class="text-c">
				<td><input name="XX_IDS" ID="XX_ID" type="checkbox" value="${hdxx.XX_ID}"></td>
				<td><u style="cursor:pointer" class="ml-5" onClick="hdxx_mx('查看活动信息明细','/CDXXW/hdxx/hdmx?XX_ID=${hdxx.XX_ID}','1001','1000','570')" href="javascript:;" title="编辑">${hdxx.XX_TITLE}</u></td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('查看用户明细','/CDXXW/user/xxusermx?USER_NAME=${hdxx.USER_NAME}','10001','360','400')">${hdxx.USER_NAME}</u></td>
				<td>
				<c:choose>
					<c:when test="${hdxx.XXMX_TYPE eq '1'}">长大主办</c:when>
					<c:when test="${hdxx.XXMX_TYPE eq '2'}">系部活动</c:when>
					<c:when test="${hdxx.XXMX_TYPE eq '3'}">社团活动</c:when>
					<c:when test="${hdxx.XXMX_TYPE eq '4'}">个人发起</c:when>
				</c:choose>
				</td>
				<td>${hdxx.XX_TIME}</td>
				<td>${hdxx.XX_LL}</td>
				<td>${hdxx.XX_SC}</td>
				<td class="td-status">
				<c:choose>
					<c:when test="${hdxx.XX_STATE eq '1'}"><span class="label label-danger radius">待审核</span></c:when>
					<c:when test="${hdxx.XX_STATE eq '0'}"><span class="label label-success radius">审核通过</span></c:when>
				</c:choose>
				</td>
				
				<td class="f-14 td-manage">
				<c:choose>
						<c:when test="${hdxx.XX_STATE eq '1'}">	
						<a style="text-decoration:none" onClick="hdxx_sh(this,'${hdxx.XX_ID}',0)" href="javascript:;">
							<i>审核</i>
						</a>
						</c:when>
						<c:when test="${hdxx.XX_STATE eq '0'}">	
						<a class="c-primary" onClick="hdxx_xx(this,'${hdxx.XX_ID}',1)" href="javascript:;">
							<i class="c-primary">下线</i>
						</a>
						</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${hdxx.XX_STATE eq '1'}">
						<a style="text-decoration:none" class="ml-5" onClick="hdxx_xg('编辑活动信息','/CDXXW/hdxx/hdxxedit?XX_ID=${hdxx.XX_ID}','1001')" href="javascript:;" title="编辑">
							 <i class="Hui-iconfont" id="${hdxx.XX_ID}">&#xe6df;</i>
						</a> 
				 	</c:when>
				 	<c:otherwise>
				 		<a style="text-decoration:none" class="ml-5" onClick="hdxx_xg('编辑活动信息','/CDXXW/hdxx/hdxxedit?XX_ID=${hdxx.XX_ID}','1001')" href="javascript:;" title="编辑">
							 <i class="Hui-iconfont" id="${hdxx.XX_ID}" style="display: none">&#xe6df;</i>
						</a> 
				 	</c:otherwise>
				 	
				</c:choose>
				
				 <a style="text-decoration:none" class="ml-5" onClick="hdxx_del(this,'${hdxx.XX_ID}')" href="javascript:;" title="删除">
				 <i class="Hui-iconfont">&#xe6e2;</i>
				 </a>
				 </td>
				 </tr>
			</c:forEach>	
			
			</tbody>
		</table>
		 <div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/hdxx/list?pageNow=1&&"  class="laypage_last" title="首页" data-page="66">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/hdxx/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/hdxx/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/hdxx/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/hdxx/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/hdxx/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

    	<a>第${pageNow}页/共${pageCount}页</a>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.admin.js"></script>
<script type="text/javascript">
/*活动信息审核*/
function hdxx_sh(obj,id,XX_STATE){
	layer.confirm('审核通过吗？',function(index){
		$.ajax({
			type:'POST',
			url:'/CDXXW/hdxx/sh',
			data:{XX_ID:id,XX_STATE:XX_STATE},
			dataType: 'json',
			success:function(data){
				if(data){
					var $icon = $('<i class="c-primary">下线</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						style: 'text-decoration:none'
					});
					$a.click(function(){
						hdxx_xx(this, id, 1);
					});
					
					$a.append($icon);
					var ui = document.getElementById(id); 
					ui.style.display="none"; 
					$(obj).parents("tr").find(".td-manage").prepend($a);
					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">审核通过</span>');
					$(obj).remove();
					layer.msg('已通过审核!',{icon: 6,time:1000});	
				}else{
	        		layer.msg('系统错误!',{icon: 2,time:1000});
	        	}
				
			}
		});
	});
	/*
	layer.confirm('审核通过吗？',function(index){
		
		location.href="/CDXXW/hdxx/sh?XX_STATE=0&XX_ID="+id;
	});
	*/
	
}

/*活动信息下线*/
function hdxx_xx(obj,id,XX_STATE){
	layer.confirm('是否下线该活动?',function(index){
		$.ajax({
			type:'POST',
			url:'/CDXXW/hdxx/sh',
			data:{XX_ID:id,XX_STATE:XX_STATE},
			dataType: 'json',
			success:function(data){
				if(data)
				{
					var $icon = $('<i>审核</i>');
					var $a = $('<a>',{
						href: 'javascript:;',
						style: 'text-decoration:none'
					});
					$a.click(function(){
						hdxx_sh(this, id, 0);
					});
					
					$a.append($icon);
					var ui = document.getElementById(id); 
					ui.style.display=""; 
					$(obj).parents("tr").find(".td-manage").prepend($a);
					$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">待审核</span>');
					$(obj).remove();
					layer.msg('该活动已下线!',{icon: 4,time:1000});
				}else{
	        		layer.msg('系统错误!',{icon: 2,time:1000});
	        	}
				
			}
		});
	});
	/*
	layer.confirm('是否下线该活动？',function(index){
		location.href="/CDXXW/hdxx/sh?XX_STATE=1&XX_ID="+id;
	});
	*/
	
}

/*活动信息-明细*/
function hdxx_mx(title,url,id,w,h){
/*	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});*/
<!--	layer.full(index);-->
	layer_show(title,url,w,h);
}
/*活动信息-添加*/
function hdxx_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*活动信息-编辑*/
function hdxx_xg(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*资讯-删除*/
function hdxx_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		 $.ajax({
		        type: 'POST',
		        url: "/CDXXW/hdxx/del",
		        data:{XX_ID:id},
		        dataType: 'json',
		        success: function(data){
		        	/*传过来的数据是删除后的总条数*/
		        	var rowCount = data[0];
		        	$("#rowCount").html("共有数据：<strong>"+rowCount+"</strong> 条");
		        	$(obj).parents("tr").remove();
		     		layer.msg('已删除!',{icon:1,time:1000});
		        },
		        error: function(xhr){
		            layer.msg('error');
		        }
		    });
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
		
		location.href="/CDXXW/hdxx/delAll?XX_IDS="+bb;
		});  
	}

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
</script> 
</body>
</html>