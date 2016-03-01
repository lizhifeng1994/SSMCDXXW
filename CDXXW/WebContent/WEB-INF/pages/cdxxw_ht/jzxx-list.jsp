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
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>兼职信息列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 兼职信息管理 <span class="c-gray en">&gt;</span> 兼职信息列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="/CDXXW/jzxx/jzxxlist" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">

	    <form action="/CDXXW/jzxx/query" method="post">
	<div class="text-c"> 发布时间：
		<input type="text" name="start_time" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'logmax\')||\'%y-%M-%d\'}'})" id="logmin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text"  name="end_time" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'logmin\')}',maxDate:'%y-%M-%d'})" id="logmax" class="input-text Wdate" style="width:120px;">
		<input type="text" name="jzxx_title" id="jzxx_title" placeholder=" 兼职标题" style="width:250px" class="input-text">
        <input type="text" name="user_name" id="user_name" placeholder=" 发布者" style="width:150px" class="input-text">
        <span class="select-box inline">
             <select class="select" name="jzxx_type">
        			<option value="">请选择兼职类型</option>
					<option value="1">教育家教</option>
					<option value="2">宣传促销</option>
					<option value="3">餐饮服务</option>
					<option value="4">网络兼职</option>
                    <option value="5">其他兼职</option>
				</select>
        </span>
		<button name="" id="find" class="btn btn-success" onclick="this.form.submit()"><i class="Hui-iconfont">&#xe665;</i> 搜兼职信息</button>
	</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	<span class="l"><a href="javascript:;" onclick="delALL();" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i>
	 批量删除</a> <a class="btn btn-primary radius" onclick="jzxx_add('添加兼职信息','/CDXXW/jzxx/add')" href="javascript:;">
	 <i class="Hui-iconfont">&#xe600;</i> 添加兼职信息</a></span> <span class="r">共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
	  显示：<span class="select-box inline" style=" margin-bottom:10px;">
             <select class="select">
					<option value="1">10</option>
                    <option value="2">25</option>
                    <option value="3">30</option>
				</select>
        </span>
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="40"><input name="XX_IDS" type="checkbox" value=""></th>
					<th width="100">兼职信息标题</th>
					<th width="80">兼职信息发布者</th>
					<th width="80">兼职类型</th>
					<th width="100">发布时间</th>
                    <th width="60">浏览量</th>
                    <th width="60">收藏量</th>                     
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${list}" var="jzxx">
			<tr class="text-c">
				<td><input type="checkbox"  value="${jzxx.XX_ID}" name="XX_IDS"></td>
				<td><u class="ml-5" onClick="jzxx_mx('查看兼职信息明细','/CDXXW/jzxx/jzmx?XX_ID=${jzxx.XX_ID}','${jzxx.XX_ID}','1000','570')" href="javascript:;" title="编辑">${jzxx.XX_TITLE}</u></td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('查看用户明细','/CDXXW/user/xxusermx?USER_NAME=${jzxx.USER_NAME}','10001','360','400')">${jzxx.USER_NAME}</u></td>
				<td>
				<c:choose>
					<c:when test="${jzxx.XXMX_TYPE eq '1'}">教育家教</c:when>
					<c:when test="${jzxx.XXMX_TYPE eq '2'}">宣传促销</c:when>
					<c:when test="${jzxx.XXMX_TYPE eq '3'}">餐饮服务</c:when>
					<c:when test="${jzxx.XXMX_TYPE eq '4'}">网络兼职</c:when>
					<c:when test="${jzxx.XXMX_TYPE eq '5'}">其他兼职</c:when>
				</c:choose>
				
				</td>
				<td>${jzxx.XX_TIME}</td>
				<td>${jzxx.XX_LL}</td>
				<td>${jzxx.XX_SC}</td>
				<td class="td-manage"><a style="text-decoration:none" class="ml-5" onClick="jzxx_edit('编辑兼职信息','/CDXXW/jzxx/jzxxedit?XX_ID=${jzxx.XX_ID}','${jzxx.XX_ID}')" href="javascript:;" title="编辑">
				<i class="Hui-iconfont">&#xe6df;</i></a> 
				<a style="text-decoration:none" class="ml-5" onClick="jzxx_del(this,'${jzxx.XX_ID}')" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				
			</tr>
		</c:forEach>
			</tbody>
		</table>
		 <div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/jzxx/list?pageNow=1&&"  class="laypage_last" title="首页" data-page="66">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/jzxx/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/jzxx/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/jzxx/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/jzxx/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/jzxx/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

    	<a>第${pageNow}页/共${pageCount}页</a>
</div>
	</div>
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/lib/My97DatePicker/WdatePicker.js"></script> 
<!-- <script type="text/javascript" src="<%=request.getContextPath() %>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>  -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/js/H-ui.admin.js"></script> 
<script type="text/javascript">


/*兼职信息-添加*/
function jzxx_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

function jzxx_mx(title,url,id,w,h){
/*	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});*/

	layer_show(title,url,w,h);
}
/*兼职信息-编辑*/
function jzxx_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*兼职信息-删除*/
function jzxx_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		
		location.href="/CDXXW/jzxx/del?XX_ID="+id;
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
		
		location.href="/CDXXW/jzxx/del?XX_IDS="+bb;
		});  
}

/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>