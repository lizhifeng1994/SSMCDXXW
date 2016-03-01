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
<title>二手信息明细</title>
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
			<label class="form-label col-2"><span class="c-red">*</span>二手标题：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${XXINFO.XX_TITLE}"  readonly>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>二手类型：</label>
			<div class="formControls col-2">
				<c:choose>
					<c:when test="${XXINFO.XXMX_TYPE eq '1'}"><input type="text" class="input-text" value="手机数码"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '2'}"><input type="text" class="input-text" value="书籍教材"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '3'}"><input type="text" class="input-text" value="生活用品"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '4'}"><input type="text" class="input-text" value="二手文体"  readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '5'}"><input type="text" class="input-text" value="其他二手" readonly></c:when>
				</c:choose>
				
			</div>
			<label class="form-label col-2"><span class="c-red">*</span>二手价格：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${ESMXINFO.ES_PRICE}"  readonly>
			</div>
            
            <label class="form-label col-2"><span class="c-red">*</span>成色：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${ESMXINFO.ES_CS}"  readonly>
			</div>
		</div>
		
		<div class="row cl">
         <label class="form-label col-2"><span class="c-red">*</span>二手发布时间：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${XXINFO.XX_TIME}" readonly>
			</div>
            <label class="form-label col-2"><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${ESMXINFO.ES_PHONE}"  readonly>
			</div>
            <label class="form-label col-2">QQ号：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${ESMXINFO.ES_QQ}" readonly>
			</div>
		<div class="row cl">
			<label style="margin-top: 20px;" class="form-label col-2"><span class="c-red">*</span>二手物品描述：</label>
			<div class="formControls col-10">
				<textarea style="margin-top: 20px;" name="" cols="" rows="" class="textarea"   readonly>${ESMXINFO.ES_CONTENT}</textarea>
			</div>
		</div>
		
       <div class="row cl">
			<label class="form-label col-2">二手图片详情：</label>
			<div class="formControls col-10">
            
               <div  id="layer-photos-demo">
				<c:forEach items="${IMAGEList}" var="imageList">
                   <img layer-src="esxx/${imageList.IMAGE_NAME}"  src="esxx/${imageList.IMAGE_NAME}" width="131" height="84" />
                </c:forEach>
			</div>		
			</div>
	</div>
	</form>
</div>

</body>
</html>