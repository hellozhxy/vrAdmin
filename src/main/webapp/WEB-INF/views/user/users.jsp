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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>
</head>


<body class="easyui-layout" data-options="border:false">
	<div data-options="region:'north',border:false" style="height: 35px; overflow: hidden;background-color: #fff">
		<form id="searchForm">
			<table>
				<tr>
					<th>姓名:</th>
					<td><input id="name" placeholder="请输入用户姓名"/></td>
					<td><a href="javascript:findUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div data-options="region:'center',border:true" >
		<table id="user-table" data-options="border:false"></table>
	</div>
	
	<div id="user-window" title="用户窗口" style="width:400px;height:250px;">
		<div style="padding:20px 20px 40px 80px;">
			<form id='form' method="post">
				<table>
					<tr>
						<td><input name="userId" type="hidden"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input name="userName"></input></td>
					</tr>
					<tr>
						<td>电话：</td>
						<td><input name="mobile"></input></td>
					</tr>
					<tr>
						<td>邮件：</td>
						<td><input name="email"></input></td>
					</tr>
					<tr>
						<td>状态：</td>
						<td><input name="status"></input></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="text-align:center;padding:5px;">
			<a href="javascript:void(0)" onclick="saveUser()" id="btn-save" icon="icon-save">保存</a>
			<a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" icon="icon-cancel">取消</a>
		</div>
	</div>
</body>
</html>
