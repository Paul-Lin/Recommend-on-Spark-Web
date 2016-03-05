<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="moon" %>
<%
    String host = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<input type="hidden" id="host" value="<%=host%>"/>
<style>
    .register {
        margin-left: 20px;
    }

    .register-form {
        padding-left: 240px;
    }

    .alert-register{
        width:400px;
        position:absolute;
        z-index:1000;
        margin-left:380px
    }
</style>
<moon:common>
    <jsp:attribute name="title">Moon Plan-不止美好 注册</jsp:attribute>
    <jsp:attribute name="head">
        <jsp:include page="head.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="navbar">
        <jsp:include page="navbar.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="body">
        <div class="container">
            <div id="registerProblem1" class="alert alert-warning alert-dismissable fade in alert-register" style="display: none;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <p>^_^  请把店铺名字跟密码都填写好吧  ^_^</p>
            </div>
            <div id="registerProblem" class="alert alert-warning alert-dismissable fade in alert-register" style="display:none;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <p>O(∩_∩)O  工程师正在拯救它们,请耐心等一下好吗  O(∩_∩)O</p>
            </div>
            <div id="registerProblem3" class="alert alert-warning alert-dismissable fade in alert-register" style="display:none;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <p>O(∩_∩)O  换个名字吧,这名称太火了  O(∩_∩)O</p>
            </div>
            <div id="registerProblem0" class="alert alert-warning alert-dismissable fade in alert-register" style="display:none;">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <p>O(∩_∩)O  目前该用户被禁用了,请联系本公司吧  O(∩_∩)O</p>
            </div>
            <button type="button" class="btn btn-default" style="margin-top: 20px;margin-bottom:20px;" onclick="switchType()">我不是这用户类型.....
            </button>
            <input type="text" style="display:none" value="0" id="userType"/>
            <form id="user" style="margin-top: 20px;display:none;" class="register-form">
                <div class="form-group  form-inline">
                    <label for="inputUserEmail">邮箱</label>
                    <input type="email" class="form-control register" style="width:522px" id="inputUserEmail"
                           placeholder="邮箱">
                </div>
                <div class="form-group  form-inline">
                    <label for="inputUserPassword1">密码</label>
                    <input type="password" class="form-control register" style="width:522px" id="inputUserPassword1"
                           placeholder="密码">
                </div>
                <div class="form-group  form-inline">
                    <label for="inputUserPassword2">密码</label>
                    <input type="password" class="form-control register" style="width:522px" id="inputUserPassword2"
                           placeholder="请再一次输入密码">
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default" style="width:570px;" onclick="doRegister()">注册</button>
                </div>
            </form>
            <form id="shop" style="margin-top: 20px;" class="register-form">
                <div class="form-group form-inline">
                    <label for="inputShopName">店铺名称</label>
                    <input type="text" class="form-control register" style="width:500px;" id="inputShopName"
                           placeholder="店铺名称">
                </div>
                <div class="form-group form-inline">
                    <label for="inputShopAddress">店铺地址</label>
                    <input type="text" class="form-control register" style="width:500px;" id="inputShopAddress"
                           placeholder="店铺地址">
                </div>
                <div class="form-group form-inline">
                    <label for="inputShopTel">店铺电话</label>
                    <input type="tel" class="form-control register" style="width:500px;" id="inputShopTel"
                           placeholder="店铺电话">
                </div>
                <div class="form-group form-inline">
                    <label for="inputShopBoss">店铺管理员名字</label>
                    <input type="text" class="form-control register" style="width:462px;" id="inputShopBoss"
                           placeholder="店铺管理员名字">
                </div>
                <div class="form-group form-inline">
                    <textarea id="inputShopIntro" class="form-control" placeholder="介绍你的店铺吧" style="width:570px;"
                              rows="3"></textarea>
                </div>
                <div class="form-group form-inline">
                    <label for="inputShopPassword1">密码</label>
                    <input type="password" class="form-control register" style="width:522px" id="inputShopPassword1"
                           placeholder="密码">
                </div>
                <div class="form-group form-inline">
                    <label for="inputShopPassword2">密码</label>
                    <input type="password" class="form-control register" style="width:522px" id="inputShopPassword2"
                           placeholder="请再一次输入密码">
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default" style="width:570px;" onclick="doRegister()">注册</button>
                </div>
            </form>
        </div>
    </jsp:attribute>
    <jsp:attribute name="foot">
        <script>

            function switchType() {
                if ($('#userType').val() == 0) {
                    $('#user').show();
                    $('#shop').hide();
                    $('#userType').val(1);
                } else {
                    $('#user').hide();
                    $('#shop').show();
                    $('#userType').val(0);
                }
            }
            function doRegister(){
                if($('#userType').val()==0){
                    $.ajax({
                        type:"post",
                        url:$('#host').val()+"/common/registerShop.action",
                        data:{
                            name:$('#inputShopName').val(),
                            address:$('#inputShopAddress').val(),
                            tel:$('#inputShopTel').val(),
                            boss:$('#inputShopBoss').val(),
                            intro:$('#inputShopIntro').val(),
                            pass:$('#inputShopPassword2').val()
                        },
                        success:function(data){
                            console.log(data);
                            if(data.success==true){
                                location.href=$('#host').val();
                            }else if(data.code==3){
                                $('#registerProblem3').show();
                                setTimeout("closeNotice()",3000);
                            }else if(data.code==0){
                                $('#registerProblem0').show();
                                setTimeout("closeNotice()",3000);
                            }else if(data.code==-1){
                                $('#registerProblem1').show();
                                setTimeout("closeNotice()",3000);
                            }
                        }

                    });
                }else{
                    console.log("user registered successful");
                }

            }

            function closeNotice(){
                $('#registerProblem0').hide();
                $('#registerProblem').hide();
                $('#registerProblem1').hide();
                $('#registerProblem3').hide();
            }
        </script>
    </jsp:attribute>
</moon:common>
