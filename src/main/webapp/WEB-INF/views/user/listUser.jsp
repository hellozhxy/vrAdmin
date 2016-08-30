<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>代理商</title>
    <link href="http://qunarzz.com/flight_fuwu/prd/styles/release/bui/bui.css" rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<div class="pagination-right">
			<c:if test="${permissions6==1}"><a class="btn btn-width4" href="/user/showAddUser?domain=${param.domain}" target="_self"><i></i><b>添加用户</b></a></c:if>
		</div>
		<div class="search-grid-container">
			<div id="grid"></div>
		</div>
	</div>
	<script type="text/javascript">
	var currentUcAccount = "${ucAccount}";
	</script>
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/bui/bui.js"></script>
    <script src="http://qunarzz.com/flight_fuwu/prd/scripts/release/users.js"></script>
</body>
</html>
