<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<input type="hidden" id="host" value="<%=host%>"/>
<style>

</style>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<%=host%>">
                <img alt="Brand" src="<%=host+"/img/index.png"%>" width="50px" height="50px" style="margin:-10px;">
            </a>
        </div>
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=host%>">Moon Plan</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="<%=host%>/shop/index.action?menu=5">账单 <span class="sr-only">(current)</span></a></li>
                <li><a href="<%=host%>/shop/index.action?menu=6">菜式 <span class="sr-only">(current)</span></a></li>
                <li><a href="<%=host%>/shop/index.action?menu=3">图片墙</a></li>
                <li><a href="<%=host%>/shop/index.action?menu=2">评论墙</a></li>
                <li><a href="<%=host%>/shop/index.action?menu=4">公告</a></li>
                <li><a href="<%=host%>/shop/index.action?menu=7">设置 <span class="sr-only">(current)</span></a></li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="美食">
                </div>
                <button type="submit" class="btn btn-default">奔月</button>
            </form>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>