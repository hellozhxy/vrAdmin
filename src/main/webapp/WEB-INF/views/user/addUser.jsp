﻿<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新增用户</title>
    <link href="http://qunarzz.com/flight_fuwu/prd/styles/release/adduser.css" rel="stylesheet" />
</head>
<body>
    <form class="form" id="adduserForm">
    <input name="domain" type="hidden" value="${param.domain }" />
        <div class="item">
            <label class="title"><span class="red">*</span>用户名称</label>
            <div class="text">
                <input type="text" value="${userVo.user.ucAccount}" <c:if test="${! empty userVo }">disabled="disabled"</c:if> class="input" name="ucAccount" data-type="username" autocomplete="off"/></div>
            	<c:if test="${empty userVo }">
            	<div class="info"><a class="vname">校验</a><i class="success"></i>
                <span class="tips tips2">输入去哪儿官网注册的用户名</span>
                </c:if>
            </div>
        </div>
        <div class="item">
            <label class="title"><span class="red">*</span>真实名称</label>
            <div class="text">
            <c:choose>
            <c:when test="${empty userVo}">
                <input type="text" class="input" name="name" data-validate="vname" disabled="disabled" value="请先校验用户名"/></div>
            </c:when>
            <c:otherwise>
                <input type="text" class="input" name="name" data-validate="vname"  value="${userVo.user.name}"/></div>
            </c:otherwise>
            </c:choose>
            <div class="info"><i class="success"></i>
	                <div class="tips tips2">该平台显示的真实姓名</div>
            </div>
        </div>
        <div class="item">
            <label class="title"><span class="red">*</span>部门</label>
            <div class="text">
                <div class="choice" id="selectDept">
                <c:if test="${empty userVo.deptNames }"><div>可多选</div></c:if>
                <c:if test="${!empty userVo.deptNames }"><div>${userVo.deptNames }</div></c:if>
                <i class="choice-icon"></i></div>
                <input type="text" name="deptIds" data-validate="vmust" value="${userVo.deptIds}" class="hide"/>
            </div>
            <div class="info"><i class="success"></i>
                <div class="tips"></div>
            </div>
        </div>
        <div class="item">
            <label class="title"><span class="red">*</span>角色</label>
            <div class="text">
                <div class="choice" id="selectRole">
                <c:if test="${empty userVo.roleNames }"><div>可多选</div></c:if>
                <c:if test="${!empty userVo.roleNames }"><div>${userVo.roleNames }</div></c:if>
                <i class="choice-icon"></i></div>
                <input type="text" name="roleIds" data-validate="vmust" value="${userVo.roleIds}" class="hide"/></div>
            <div class="info"><i class="success"></i>
                <div class="tips"></div>
            </div>
        </div>

        <div class="bottom">
            <button class="btn" type="submit"><i></i><b>提交</b></button>
            <a class="btn btn-cancel"  href="/user/listUser?domain=${param.domain }"><i></i><b>返回</b></a>
        </div>
    </form>

    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/adduser.js"></script>
</body>
</html>
