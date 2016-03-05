<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.moon.enums.ShopMenu" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="keywords" content="美食社交,美食商店,Moon Plan,收藏,精选"/>
    <meta name="description" content="Moon Plan 是一款专注于美食发现,分享,购买的软件产品."/>
    <title>${title}</title>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/img/index.png"
          rel="shortcut icon" type="image/vnd.microsoft.icon">
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/bootstrap.min.css"
          type="text/css" rel="stylesheet"/>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/echarts-all.js"
            type="text/javascript"></script>
</head>
<body class="container">
<input id="host" value="<%=host%>" style="display:none;">
<div >
    <table class="table table-striped" id="bills">

    </table>
</div>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height:400px"></div>

<script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bill-manage.js"
        type="text/javascript"></script>
</body>
