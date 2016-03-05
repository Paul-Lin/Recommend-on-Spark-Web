<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
    String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<style>
    .wrap {
        width: 1100px;
        margin: 0 auto;
        display: block;
    }

    .logo {
        float: left;
        width: 250px;
    }

    .login {
        float: right;
        width: 100px;
        background: #ba0b0b;
        margin: 20px;
        border-color: transparent;
        color: #ccc;
    }

    .login-input {
        margin-bottom: 10px;
    }
</style>
<div class="wrap">
    <h1 class="logo">
        <a hidefocus="true" href="<%=host%>"><img src="<%=host+"/img/index.png"%>" width="50px" height="50px" alt="Moon Plan"
                                          border="0">Moon Plan</a>
    </h1>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</div>
</script>