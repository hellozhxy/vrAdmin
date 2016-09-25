<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/default/easyui.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/resource.js"></script>
</head>


<body class="easyui-layout" data-options="border:false">
	<div data-options="region:'north',border:false" style="height: 35px; overflow: hidden;background-color: #fff">
		<form id="videoSearchForm">
			<table>
				<tr>
					<th>标题:</th>
					<td><input id="video_title" name="title" placeholder="请输入视频标题"/></td>
					
					<th>分类:</th>
					<td>
					<select id="video_category" name="category">
						<c:forEach var="item" items="${videoCategorys}">
							<option value="${item.id}" selected>${item.categoryName}</option>
						</c:forEach>
					</select>
					</td>
					
					<th>状态:</th>
					<td>
					<select id="video_status" name="status">
					  <option value ="1">审核通过</option>
					  <option value="0">审核不通过</option>
					</select>
					</td>
					
					<td><a href="javascript:findResource();" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div data-options="region:'center',border:true" >
		<table id="resource-table" data-options="border:false"></table>
	</div>
	
	<div id="video-window" title="视频窗口" style="width:400px;height:250px;">
		<div style="padding:20px 20px 40px 80px;">
			<form id='form' method="post">
				<table>
					<tr>
						<td>ID：</td>
						<td><input name="videoId"></input></td>
					</tr>
					<tr>
						<td>作者：</td>
						<td><input name="userName"></input></td>
					</tr>
					<tr>
						<td>标题：</td>
						<td><input name="title"></input></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td><input name="description"></input></td>
					</tr>
					<tr>
						<td>状态：</td>
						<td><input name="status"></input></td>
					</tr>
					<tr>
						<td>分类：</td>
						<td><input name="categoryName"></input></td>
					</tr>
					<tr>
						<td>关键字：</td>
						<td><input name="keywords"></input></td>
					</tr>
					<tr>
						<td>路径：</td>
						<td><input name="path"></input></td>
					</tr>
					<tr>
						<td>播放次数：</td>
						<td><input name="playTimes"></input></td>
					</tr>
					<tr>
						<td>上传时间：</td>
						<td><input name="createTime"></input></td>
					</tr>
					<tr>
						<td>发布时间：</td>
						<td><input name="publishTime"></input></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align:center;padding:5px;">
			<a href="javascript:void(0)" onclick="saveVideo()" id="btn-save" icon="icon-save">保存</a>
			<a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" icon="icon-cancel">取消</a>
		</div>
	</div>
</body>
</html>
