<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 导入标签必须用这种方式 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<title>用户明细</title>
</head>
<body>

<div class="pd-20">
  <table class="table">
    <tbody>
      <tr>
        <th class="text-r" width="80">用户名：</th>
        <td>${USERINFO.USER_NAME}</td>
      </tr>
      <tr>
        <th class="text-r">用户邮箱：</th>
        <td>${USERINFO.USER_EMAIL}</td>
      </tr>

      <tr>
        <th class="text-r">注册时间：</th>
        <td>${USERINFO.USER_TIME}</td>
      </tr>
      <tr>
        <th class="text-r">用户角色：</th>
        <c:choose>
        	<c:when test="${USERINFO.USER_TYPE eq '2'}"><td>普通用户</td></c:when>
        	<c:when test="${USERINFO.USER_TYPE eq '3'}"><td>校部负责人</td></c:when>
        	<c:when test="${USERINFO.USER_TYPE eq '4'}"><td>系部负责人</td></c:when>
        	<c:when test="${USERINFO.USER_TYPE eq '5'}"><td>社团负责人</td></c:when>
        </c:choose>
      
      </tr>
      <tr>
        <th class="text-r">用户备注：</th>
  		<td>
  		<c:choose>
  			<c:when test="${USERINFO.USER_MARK==null}">
  				  <textarea readonly="true" name="" cols="" rows="" class="textarea">这个人很懒，什么都没留下</textarea>
  			</c:when>
  			<c:otherwise>
  				<textarea readonly="true" name="" cols="" rows="" class="textarea"   dragonfly="true" onKeyUp="textarealength(this,100)">${USERINFO.USER_MARK}</textarea>
  			</c:otherwise>
  		</c:choose>
        </td>
      </tr>
      
    </tbody>
  </table>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
</body>
</html>