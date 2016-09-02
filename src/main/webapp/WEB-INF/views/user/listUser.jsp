<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>用户列表</title>
	<link type="text/css" rel="stylesheet" href="/"/>
</head>
<body>
	<table id="user-table">
		<thead>
			<tr>
				<th field="name" width="100">用户名</th>
				<th field="mobile" width="100">电话</th>
				<th field="email" width="100">邮箱</th>
				<th field="status" width="100">状态</th>
				<th field="registerDate" width="100">注册时间</th>
				<th field="loginDate" width="100">登录时间</th>
				<th field="loginIp" width="100">登录IP</th>
			</tr>
		</thead>
	</table>
	<div style="text-align: center;padding: 5px;">
		<a href="javascript:void(0)" onclick="saveUser()" id="btn-save" icon="icon-save">保存</a>
		<a href="javascript:void(0)" onclick="closeWindow()" id="btn-cancel" icon="icon-cancel">取消</a>
	</div>
	<div id="user-window" title="用户窗口" style="width: 400px;height:250px; ">
		<div style="padding: 20px 20px 40px 80px">
			<form method="post">
				<table>
					<tr>
						<td>用户名</td>
						<td><input name="name"></input></td>
					</tr>
					<tr>
						<td>电话</td>
						<td><input name="mobile"/></td>
					</tr>
					<tr>
						<td>邮箱</td>
						<td><input name="email"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
