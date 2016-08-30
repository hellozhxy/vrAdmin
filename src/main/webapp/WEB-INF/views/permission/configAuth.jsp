<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>权限配置</title>
	<link rel="stylesheet" href="http://qunarzz.com/flight_fuwu/prd/styles/release/ota/action_list.css">
</head>
<body>
	<input type="hidden" name="permissionId" id="permissionId" value="${permissionId}"/>
	<div class="wrapper">
        <div class="header">
            <a class="btn add-depart" target="_self" id="J_Add"><i></i><b>添加</b></a>
        </div>
        <div class="gridwraper">
            <table id="J_Grid" style="display:none"></table>
        </div>
    </div>
    <div style='display:none'>
        <div id="actionHtml">
            <div class="item">
                <label class="i-label"><span class="i-red">*</span>URL</label>
                <div class="i-right">
                    <input type="text" name="url" class="i-input" data-validate="vmust" autocomplete="off"/>
                    <span class="i-tips"></span>
                </div>
            </div>
            <div class="item">
                <label class="i-label"><span class="i-red">*</span>keyWord</label>
                <div class="i-right">
                    <input type="text" name="keyword" maxlength="50" class="i-input" data-validate="vmust" autocomplete="off"/>
                    <span class="i-tips"></span>
                </div>
            </div>
             <div class="item">
                <label class="i-label">备注</label>
                <div class="i-right">
                   <textarea name="comments" class="textarea gray" data-toggle="popover" data-content="请输入不超过255字的问题描述" data-maxlength="255">请输入不超过255字的问题描述</textarea>
                   <span class="i-tips"></span>
                </div>
            </div>
        </div>
    </div>
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/ota/action_list.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
