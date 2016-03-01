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
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />


<title>兼职信息明细</title>
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
			<label class="form-label col-2"><span class="c-red">*</span>兼职标题：</label>
			<div class="formControls col-10">
				<input type="text" class="input-text" value="${XXINFO.XX_TITLE}"  id="" name="" readonly>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>兼职类型：</label>
			<div class="formControls col-2">
			<c:choose>
					<c:when test="${XXINFO.XXMX_TYPE eq '1'}"><input type="text" class="input-text" value="教育家教" readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '2'}"><input type="text" class="input-text" value="宣传促销" readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '3'}"><input type="text" class="input-text" value="餐饮服务" readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '4'}"><input type="text" class="input-text" value="网络兼职" readonly></c:when>
					<c:when test="${XXINFO.XXMX_TYPE eq '5'}"><input type="text" class="input-text" value="其他兼职" readonly></c:when>
				</c:choose>
				
			</div>
			<label class="form-label col-2"><span class="c-red">*</span>兼职工资：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${JZMXINFO.JZ_SALARY}" id="" name="" readonly>
			</div>
            
            <label class="form-label col-2"><span class="c-red">*</span>兼职结算类型：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${JZMXINFO.JZJS_TYPE}" id="" name="" readonly>
			</div>
		</div>
		<div class="row cl">
         <label class="form-label col-2"><span class="c-red">*</span>兼职发布时间：</label>
			<div class="formControls col-2">
			<input type="text" class="input-text" value="${XXINFO.XX_TIME}"  id="" name="" readonly>
			</div>
            <label class="form-label col-2"><span class="c-red">*</span>兼职工作时间：</label>
			<div class="formControls col-6">
			<input type="text" class="input-text" value="${JZMXINFO.JZGZ_TIME}" id="" name="" readonly>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>招聘人数：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${JZMXINFO.JZZP_NUMBER}" id="" name="" readonly>
			</div>
			<label class="form-label col-2"><span class="c-red">*</span>工作区域：</label>
			<div class="formControls col-6">
				<input type="text" class="input-text" value="${JZMXINFO.JZGZ_FIELD}"  id="" name="" readonly>
			</div>
		</div>
        
        <div class="row cl">
        
			<label class="form-label col-2" ><span class="c-red">*</span>联系电话：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${JZMXINFO.JZ_PHONE}"  id="" name="" readonly>
                </div>
                
                <label class="form-label col-2" >QQ号：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${JZMXINFO.JZ_QQ}"  id="" name="" readonly>
                </div>

            </div> 
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>职位描述：</label>
			<div class="formControls col-10">
<textarea name="" cols="" rows="" class="textarea"   readonly  >${JZMXINFO.JZZW_MARK}</textarea>
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>公司描述：</label>
			<div class="formControls col-10">
				<textarea name="" cols="" rows="" class="textarea"   readonly  >${JZMXINFO.JZGS_MARK}</textarea>
			</div>
		</div>
        
       <div class="row cl">
			<label class="form-label col-2">兼职图片详情：</label>
			<div class="formControls col-10">
            
                  	<div id="layer-photos-demo">
                   		<c:forEach items="${IMAGEList}" var="imageList">
                   			<img layer-src="jzxx/${imageList.IMAGE_NAME}" src="jzxx/${imageList.IMAGE_NAME}" width="131" height="84" />
                   		</c:forEach>
                  	</div>
			</div>			
		</div>
</form>
</div>

</body>
</html>