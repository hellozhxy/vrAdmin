<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>菜单列表</title>
	<link rel="stylesheet" href="http://qunarzz.com/flight_fuwu/prd/styles/release/ota/menus_list.css">
</head>
<body>
	<div class="wrapper">
        <div class="header">
            <a class="btn add-depart" target="_self" id="addSuperMenu"><i></i><b>添加一级菜单</b></a>
        </div>
        <div class="gridwraper">
            <table id="menus_list" style="display:none"></table>
        </div>
    </div>
    <div style='display:none'>
        <div id="menuHtml">
            <input type="hidden" name="pid" value='0'/>
            <input type="hidden" name="id" value='0'/>
            <div class="item">
                <label class="i-label"><span class="i-red">*</span>菜单名称</label>
                <div class="i-right">
                    <input type="text" name="name" maxlength="20" class="i-input" data-validate="vname" autocomplete="off"/>
                    <span class="i-tips"></span>
                </div>
            </div>
            <div class="item">
                <label class="i-label">链接URL</label>
                <div class="i-right">
                    <input type="text" name="url" class="i-input" autocomplete="off" maxlength="80" />
                </div>
            </div>
             <div class="item">
                <label class="i-label">排序</label>
                <div class="i-right">
                    <input type="text" name="sort" class="i-input" autocomplete="off" maxlength="80" />
                </div>
            </div>
             <div class="item">
                <label class="i-label">KEY_WORD</label>
                <div class="i-right">
                    <input type="text" name="keyWord" class="i-input" autocomplete="off" maxlength="80" />
                </div>
            </div>
        </div>
    </div>
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/ota/menus_list.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
