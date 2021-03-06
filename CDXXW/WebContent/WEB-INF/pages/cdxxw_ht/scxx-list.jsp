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
<link href="lib/laypage/1.2/skin/laypage.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>用户收藏信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 用户中心 <span class="c-gray en">&gt;</span> 用户收藏信息 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
<form action="/CDXXW/scxx/query" method="post">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入用户名" id="" name="USER_NAME">
        <input type="text" class="input-text" style="width:150px" placeholder="输入信息标题" id="" name="XX_TITLE">
               <span class="select-box inline">
             <select class="select" name="SC_TYPE">
        			<option value="">请选择收藏类型</option>
					<option value="1">兼职信息</option>
					<option value="2">二手信息</option>
					<option value="3">活动信息</option>
				</select>
                </span>
		<button  class="btn btn-success radius" onclick="this.form.submit()" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜收藏信息</button>
	</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="delALL();" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> </span>
	 <span class="r" id="rowCount">共有数据：<strong>${rowCount}</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="SC_IDS"></th>
				<th width="150">信息标题</th>
				<th width="70">收藏者</th>
                <th width="70">收藏类型</th>	
				<th width="130">收藏时间</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="scxx">
		<tr class="text-c">
				<td><input type="checkbox" value="${scxx.SC_ID}" name="SC_IDS"></td>
				<td>
				<c:choose>
					<c:when test="${scxx.SC_TYPE eq '1'}">
					<u style="cursor:pointer" class="text-primary" onclick="object_show('查看兼职明细','/CDXXW/jzxx/jzmx?XX_ID=${scxx.XX_ID}','10001','1000','570')">${scxx.XX_TITLE}</u>
					</c:when>
					<c:when test="${scxx.SC_TYPE eq '2'}">
						<u style="cursor:pointer" class="text-primary" onclick="object_show('查看二手明细','/CDXXW/esxx/esmx?XX_ID=${scxx.XX_ID}','10001','1000','570')">${scxx.XX_TITLE}</u>
					</c:when>
					<c:when test="${scxx.SC_TYPE eq '3'}">
						<u style="cursor:pointer" class="text-primary" onclick="object_show('查看活动明细','/CDXXW/hdxx/hdmx?XX_ID=${scxx.XX_ID}','10001','1000','570')">${scxx.XX_TITLE}</u>
					</c:when>
				</c:choose>
				</td>
				<td><u style="cursor:pointer" class="text-primary" onclick="object_show('查看用户明细','/CDXXW/user/xxusermx?USER_NAME=${scxx.USER_NAME}','10001','360','400')">${scxx.USER_NAME}</u></td>
				<td>
				<c:choose>
					<c:when test="${scxx.SC_TYPE eq '1'}">兼职信息</c:when>
					<c:when test="${scxx.SC_TYPE eq '2'}">二手信息</c:when>
					<c:when test="${scxx.SC_TYPE eq '3'}">活动信息</c:when>
				</c:choose>
				</td>
				<td>${scxx.SC_TIME}</td>
				<td class="td-manage"><a title="删除" href="javascript:;" onclick="scxx_del(this,'${scxx.SC_ID}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr> 
		</c:forEach>    
		</tbody>
	</table>
	<div class="laypage_main laypageskin_default" align="right" style="margin-top:10px;">

	<a href="/CDXXW/scxx/list?pageNow=1&&"  class="laypage_last" title="首页" data-page="66">首页</a>
	<c:choose>
		<c:when test="${pageNow - 1 > 0}">
			<a href="/CDXXW/scxx/list?pageNow=${pageNow - 1}" class="laypage_last">上一页</a>
		</c:when>
		<c:when test="${pageNow - 1 <= 0}">
			<a href="/CDXXW/scxx/list?pageNow=1" class="laypage_last">上一页</a>
		</c:when>
	</c:choose>
 
 	<c:choose>		
		<c:when test="${pageNow + 1 < pageCount}">
			<a href="/CDXXW/scxx/list?pageNow=${pageNow + 1}" class="laypage_last">下一页</a>
		</c:when>
		<c:when test="${pageNow + 1 >= pageCount}">
			<a href="/CDXXW/scxx/list?pageNow=${pageCount}" class="laypage_last">下一页</a>
		</c:when>

	</c:choose>
		<a href="/CDXXW/scxx/list?pageNow=${pageCount}" class="laypage_last">尾页</a>

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

/*展示信息*/
function object_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*收藏信息-删除*/
function scxx_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		var pageNow = ${pageNow};
		var pageCount =${pageCount};
		 $.ajax({
		        type: 'POST',
		        url: "/CDXXW/scxx/del",
		        data:{SC_ID:id},
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

//批量删除
function delALL()
{
	 var bb = "";  
     var temp = "";  
     var a = document.getElementsByName("SC_IDS");  
     for ( var i = 0; i < a.length; i++) {  
     if (a[i].checked) {  
    	temp = a[i].value;  
    	 bb =temp+","+bb;  
    	 }  
     }  
	layer.confirm('确认要删除选中的这些吗？',function(index){
		
		location.href="/CDXXW/scxx/delAll?SC_IDS="+bb;
		});  
}
</script> 
</body>
</html>