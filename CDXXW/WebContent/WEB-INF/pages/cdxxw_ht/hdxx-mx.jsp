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
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>活动信息明细</title>
</head>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
layer.config({
    extend: 'extend/layer.ext.js'
});  

layer.ready(function(){
    layer.photos({
        photos: '#layer-photos-demo'
    });
});  
</script> 
<body>
<div class="pd-20">
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>活动标题：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${XXINFO.XX_TITLE}"  readonly>
			</div>
		</div>
        
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>活动类型：</label>
			<div class="formControls col-2">
				<c:choose>
					<c:when test="${XXINFO.XXMX_TYPE eq '1'}"><input type="text" class="input-text" value="长大主办"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '2'}"><input type="text" class="input-text" value="系部活动"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '3'}"><input type="text" class="input-text" value="社团活动"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '4'}"><input type="text" class="input-text" value="个人发起"  readonly></c:when>
				</c:choose>
			</div>
			<label class="form-label col-2"><span class="c-red">*</span>活动地点：</label>
			<div class="formControls col-4">
				<input type="text" class="input-text" value="${HDMXINFO.HD_PLACE}"  readonly>              
			</div> 
		</div>
			
			
		<div class="row cl">
         <label class="form-label col-2"><span class="c-red">*</span>活动开始时间：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${HDMXINFO.HD_START_TIME}"  readonly>
			</div>
            <label class="form-label col-2"><span class="c-red">*</span>活动截止时间：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${HDMXINFO.HD_END_TIME}"  readonly>
			</div>           
		</div>
        
        <div class="row cl">
         <label class="form-label col-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${HDMXINFO.HD_PHONE}" readonly>
			</div>
            <label class="form-label col-2">QQ号：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${HDMXINFO.HD_QQ}"  readonly>
			</div>
                        <label class="form-label col-2">官方网站：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${HDMXINFO.HD_WEB}"  readonly>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>活动详细内容：</label>
			<div class="formControls col-10">
				<textarea name="" cols="" rows="" class="textarea"  datatype="*10-500" dragonfly="true" readonly  >${HDMXINFO.HD_CONTENT}</textarea>
			</div>
		</div>
       
            <div class="row cl">
			<label class="form-label col-2">活动图片详情：</label>
			<div class="formControls col-10">
                <div id="layer-photos-demo">
					<c:forEach items="${IMAGEList}" var="imageList">
                   		<img layer-src="hdxx/${imageList.IMAGE_NAME}" src="hdxx/${imageList.IMAGE_NAME}" width="131" height="84" />
                   </c:forEach>
				</div>				
			</div>
			</div>
</form>

</div>


</body>
</html>