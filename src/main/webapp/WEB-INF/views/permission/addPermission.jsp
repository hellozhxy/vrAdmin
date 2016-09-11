<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>权限设置</title>
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="wrapper">
		<form class="forms" id="forms">
		<input name="domain" type="hidden" value="${param.domain }" />
			<div class="field">
				<label class="title">父级权限名称</label>
				<div class="select" id="select_ctg">
                    <a class="select-icon"><span class="select-caret"></span></a>
                    <input type="text" name="catalogName" id="catalogName"  class="select-input" data-validate="vname" autocomplete="off"/>
                    <input type="hidden" name="catalogId" />
                </div>
                <span class="tips"></span>
			</div>
			<div class="field">
				<label class="title">权限名称</label>
				<input type="text" name="permissionName" id="permissionName" data-validate="vname" autocomplete="off"/>
				<span class="tips"></span>
			</div>
			<div class="bottom">
				<button class="btn" type="submit"><i></i><b>确定</b></button>
				<a class="btn btn-cancel"  href="/permission/listPermission?domain=${param.domain }"><i></i><b>返回</b></a>
			</div>
        </form>
    </div>
</body>
</html>