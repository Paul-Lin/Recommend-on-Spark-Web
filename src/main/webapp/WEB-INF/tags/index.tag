<%@tag pageEncoding="utf-8" %>
<%@ attribute name="title"%>
<%@ attribute name="search" fragment="true" required="true"%>
<%@ attribute name="navbar" fragment="true" required="true"%>
<%@ attribute name="recommend" fragment="true" required="true"%>
<%@ attribute name="script" %>
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
<style>
    body{
        font-size:12px;
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        color:#ccc;
    }
    a{
        text-decoration: none;
        color: #ccc;
    }
    a:focus{
        text-decoration: none;
        color: #ccc;
    }
    a:hover{
        text-decoration: none;
        color: #ccc;
    }
    a:active{
        text-decoration: none;
        color: #ccc;
    }
    .m-search{
        position:relative;
        height:70px;
        background-position:0 -80px;
        background:#333;
    }
    .m-navbar {
        position:relative;
        height:30px;
        background-position: 0 -230px;
        background:#ba0b0b;
    }
    .m-recommend{
        min-width:982px;
        background:#333;
        min-height:900px;
    }
</style>
<body>
    <div id="search" class="m-search">
        <jsp:invoke fragment="search"/>
    </div>
    <div id="navbar" class="m-navbar">
        <jsp:invoke fragment="navbar"/>
    </div>
    <div id="recommend" class="m-recommend">
        <jsp:invoke fragment="recommend"/>
    </div>
</body>