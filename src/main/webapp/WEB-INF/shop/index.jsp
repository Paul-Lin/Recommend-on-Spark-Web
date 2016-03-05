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
    <meta name="keywords" content="美食社交,美食商店,Moon Plan,收藏,精选" />
    <meta name="description" content="Moon Plan 是一款专注于美食发现,分享,购买的软件产品." />
    <title>${title}</title>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/img/index.png" rel="shortcut icon" type="image/vnd.microsoft.icon">
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<jsp:include page="/WEB-INF/shop/navbar.jsp"/>
<c:if test="${menu.equals(ShopMenu.COMMENT_WALL)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/comment-wall"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"height="768px"/>
</c:if>
<c:if test="${menu.equals(ShopMenu.PHOTO_WALL)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/photo-wall"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"height="768px"/>
</c:if>
<c:if test="${menu.equals(ShopMenu.NOTICE)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/notice"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"height="768px"/>
</c:if>
<c:if test="${menu.equals(ShopMenu.MENU_MANAGE)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/menu-manage"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"height="768px"/>
</c:if>
<c:if test="${menu.equals(ShopMenu.BILL_MANAGE)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/bill-manage"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%" height="768px"/>
</c:if>
<c:if test="${menu.equals(ShopMenu.SHOP_SETTING)}">
    <iframe src="<%=host+"/shop/url.action?path=/shop/shop-setting"%>" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" width="100%"height="768px"/>
</c:if>
<script type="text/javascript" language="javascript">

</script>
</body>
