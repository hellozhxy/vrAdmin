<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.Set"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>视频资源列表</title>
    <!-- 
    <link href="http://qunarzz.com/flight_fuwu/prd/styles/release/role.css" rel="stylesheet" />
    -->
</head>
<body>
    <div class="wraper">
        <div class="header">
        	<!--
            <c:if test="${permissions2==1}"><button class="btn add-depart" id="addRole"><i></i><b>添加角色</b></button></c:if>
            <input type="text" id="searchValue" class="t-search t-gray" value="请输入搜索的关键字..."/>
            <button class="btn" id="search"><i></i><b>搜&nbsp;索</b></button>
            <a id="clearSearch">清空</a>
            <span class="tips"></span>-->
        </div>
        <div class="gridwraper">
            <table id="rolelist"></table>
        </div>
    </div>

	<!--  
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/role.js"></script>
    -->
</body>
</html>
	