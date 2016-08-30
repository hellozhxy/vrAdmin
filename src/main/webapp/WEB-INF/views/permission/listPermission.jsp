<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>权限列表</title>
	<link rel="stylesheet" href="http://qunarzz.com/flight_fuwu/prd/styles/release/ota/power_list.css">
</head>
<body>
	<div class="wrapper">
        <div class="header">
            <a class="btn add-depart" href="/permission/showAddPermission?domain=${param.domain}" target="_self"><i></i><b>添加权限</b></a>
        </div>
        <div class="gridwraper">
            <table class="grid" id="J_Grid">
            	<thead>
            		<tr>
            			<th>序号</th>
            			<th>权限名称</th>
            			<th>操作</th>
            		</tr>
            	</thead>
				<tbody>
					<c:forEach items="${catalogPermissions}" var="cp" varStatus="index">
						<tr <c:if test="${index.count % 2 == 0}">class="even"</c:if>>
							<td>${index.count}</td>
							<td>${cp.catalogName}--${cp.permissionName }</td>
							<td><a href="javascript:;" data-id="${cp.permissionId}" data-title="${cp.permissionName }" data-action="tab" data-url="/authConfig/page?permissionId=${cp.permissionId}">权限配置</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3"></td>
					</tr>
				</tfoot>
            </table>
        </div>
    </div>
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/all.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
