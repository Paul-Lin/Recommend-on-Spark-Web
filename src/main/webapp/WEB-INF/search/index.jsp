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
        <a hidefocus="true" href="#"><img src="<%=host+"/img/index.png"%>" width="50px" height="50px" alt="Moon Plan"
                                          border="0">Moon Plan</a>
    </h1>

    <form:form action="#">

    </form:form>
    <button class="btn btn-default login" type="button" data-toggle="modal" data-target="#loginModal">登陆/注册</button>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="login">登陆/注册</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <input type="text" class="form-control login-input" id="name" placeholder="商铺名字"/>
                            <input type="password" class="form-control login-input" id="pass" placeholder="密码"/>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">记住我
                            </label>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-default" id="registerBtn" href="<%=host%>/common/index.action">注册</a>
                    <button type="button" class="btn btn-default" id="loginBtn">登陆</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#loginModal').on('show.bs.modal', function (event) {
        $('#loginBtn').click(function () {
            $.ajax({
                type: "get",
                url: $('#host').val() + '/shop/login.action',
                data: {
                    name: $('#name').val(),
                    pass: $('#pass').val()
                },
                dataType: 'json',
                success: function (data) {
                    if (!data.isSuccess) {
                        if (data.code == 1) {
                            window.location=$('#host').val()+"/shop/index.action";
                        } else if (data.code == 0) {

                        }
                    }
                }
            })
        })
    })
</script>