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
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<title>举报信息信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 举报信息管理 <span class="c-gray en">&gt;</span> 举报信息列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
<form action="/CDXXW/jbxx/query" method="post">
	<div class="text-c"> 
    	日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
        <input type="text" name="USER_NAME" id="" placeholder="  举报者 " style="width:100px" class="input-text">
		<input type="text" name="XX_TITLE" id="" placeholder=" 信息标题 " style="width:250px" class="input-text">
        <span class="select-box inline">
		<select name="JB_TYPE" class="select">
			<option value=>请选择</option>
			<option value="1">兼职信息</option>
			<option value="2">二手信息</option>
		</select>
		</span>
        <span class="select-box inline">
		<select name="JB_STATE" class="select">
			<option value=>请选择</option>
			<option value="0">已受理</option>
			<option value="1">未受理</option>
		</select>
		</span>
		<button  onclick="this.form.submit()" class="btn btn-success" ><i class="Hui-iconfont">&#xe665;</i> 搜举报信息</button>
	</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="delALL()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a></span>
	 <span class="r" id="rowCount">共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="JB_IDS" value=""></th>
					<th width="100">举报信息标题</th>
					<th width="80">举报者</th>
					<th width="100">举报信息信息类型</th>
					<th width="160">举报类容</th>
					<th width="75">举报时间</th>
                    <th width="60">处理状态</th>
					<th width="120">操作</th>
				</tr>	
			</thead>
			<tbody>
			<c:forEach items="${list}" var="jbxx">
				<tr class="text-c">
					<td><input type="checkbox" value="${jbxx.JB_ID}" name="JB_IDS" id="JB_ID"></td>
					<td>
					<c:choose>
						<c:when test="${jbxx.JB_TYPE eq '1'}">
							<u style="cursor:pointer" class="ml-5" onClick="object_show('查看兼职信息明细','/CDXXW/jzxx/jzmx?XX_ID=${jbxx.XX_ID}','10001','1000','570')" href="javascript:;" title="查看信息明细">${jbxx.XX_TITLE}</u>
						</c:when>
						<c:when test="${jbxx.JB_TYPE eq '2'}">
							<u style="cursor:pointer" class="ml-5" onClick="object_show('查看二手明细','/CDXXW/esxx/esmx?XX_ID=${jbxx.XX_ID}','10001','1000','570')" href="javascript:;" title="查看信息明细">${jbxx.XX_TITLE}</u>
						</c:when>
					</c:choose>
					</td>
					<td><u style="cursor:pointer" class="text-primary" onclick="object_show('查看用户明细','/CDXXW/user/xxusermx?USER_NAME=${jbxx.USER_NAME}','10001','360','400')">${jbxx.USER_NAME}</u></td>
					<td>
					<c:choose>
						<c:when test="${jbxx.JB_TYPE eq '1'}">兼职信息</c:when>
						<c:when test="${jbxx.JB_TYPE eq '2'}">二手信息</c:when>
					</c:choose>
					</td>
                    <td>${jbxx.JB_CONTENT}</td>
					<td>${jbxx.JB_TIME}</td>
					<td class="td-status">
					<c:choose>
						<c:when test="${jbxx.JB_STATE eq '1'}"><span class="label label-danger radius">待处理</span></c:when>
						<c:when test="${jbxx.JB_STATE eq '0'}"><span class="label label-success radius">已处理</span></c:when>
					</c:choose>
					</td>
					<td class="td-manage">
					<c:choose>
						<c:when test="${jbxx.JB_STATE eq '1'}">
							<a style="text-decoration:none" onClick="jbxx_sh(this,'${jbxx.USER_NAME}','${jbxx.JB_ID}')" href="javascript:;" title="处理">处理</a>
						</c:when>
					</c:choose>
					<a style="text-decoration:none" class="ml-5" onClick="jbxx_del(this,'${jbxx.JB_ID}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/jbxx/list?pageNow=1&&"  class="laypage_last" title="首页" data-page="66">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/jbxx/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/jbxx/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/jbxx/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/jbxx/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/yhdt/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

    	<a id="pageCont">第${pageNow}页/共${pageCount}页</a>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/H-ui.admin.js"></script>
<script type="text/javascript">
// layer.prompt扩展方法依赖于layer.ext.js，默认不会加载，必须进行以下配置才可使用：
layer.config({
    extend: 'extend/layer.ext.js'
});    
function object_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

function jbxx_zntz(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*资讯-删除*/
function jbxx_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		var pageNow = ${pageNow};
		var pageCount =${pageCount};
		 $.ajax({
		        type: 'POST',
		        url: "/CDXXW/jbxx/del",
		        data:{JB_ID:id},
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


//审核信息
function jbxx_sh(obj,id,JB_ID)
{
	layer.confirm('是否处理该举报信息？',function(index){
		 layer.prompt({title: '请填写处理结果', formType: 2}, function(text){
		       	$.ajax({
		       	 	type: 'POST',
			        url: "/CDXXW/zntz/jbxx_add",
			        data:{USER_NAME:id,ZNTZ_CONTENT:text,JB_ID:JB_ID},
			        dataType: 'json',
			        success: function(data){
			        	/*传过来的数据是删除后的总条数*/
			     		layer.msg('已处理!',{icon:1,time:1000});
			     		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已处理</span>');
			     		$(obj).parents("tr").find(".td-manage").html('<a style="text-decoration:none" class="ml-5" onClick="jbxx_del(this,JB_ID)" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>')
			        },
			        error: function(xhr){
			            layer.msg('error');
			        }
			        
		       	});
		    });
	});
}


//批量删除
function delALL()
{
	 var bb = "";  
     var temp = "";  
     var a = document.getElementsByName("JB_IDS");  
     for ( var i = 0; i < a.length; i++) {  
     if (a[i].checked) {  
    	temp = a[i].value;  
    	 bb =temp+","+bb;  
    	 }  
     }  
	layer.confirm('确认要删除选中的这些吗？',function(index){
		
		location.href="/CDXXW/jbxx/delAll?JB_IDS="+bb;
		});  
}

</script> 
</body>
</html>