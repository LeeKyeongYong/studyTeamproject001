<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/inc.jspf"%>
<meta charset="utf-8">
<title>지도검색!</title>
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>
<%@ include file="/WEB-INF/inc/es6Library.jspf"%>
</body>
</html>