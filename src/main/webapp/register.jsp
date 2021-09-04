<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>用户注册</title>
        <!--[if lt IE 9]>
        <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
        <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .main-body {top:50%;left:50%;position:absolute;-webkit-transform:translate(-50%,-50%);-moz-transform:translate(-50%,-50%);-ms-transform:translate(-50%,-50%);-o-transform:translate(-50%,-50%);transform:translate(-50%,-50%);overflow:hidden;}
            .login-main .login-bottom .center .item input {display:inline-block;width:227px;height:22px;padding:0;position:absolute;border:0;outline:0;font-size:14px;letter-spacing:0;}
            .login-main .login-bottom .tip .icon-nocheck {display:inline-block;width:10px;height:10px;border-radius:2px;border:solid 1px #9abcda;position:relative;top:2px;margin:1px 8px 1px 1px;cursor:pointer;}
            .login-main .login-bottom .tip .icon-check {margin:0 7px 0 0;width:14px;height:14px;border:none;background:url(${pageContext.request.contextPath}/static/plugins/layui/images/icon-login.png) no-repeat -111px -48px;}
            .login-main .login-bottom .center .item .icon {display:inline-block;width:33px;height:22px;}
            .login-main .login-bottom .center .item {width:288px;height:35px;border-bottom:1px solid #dae1e6;margin-bottom:35px;}
            .login-main {width:428px;position:relative;float:left;}
            .login-main .login-top {height:117px;background-color:#148be4;border-radius:12px 12px 0 0;font-family:SourceHanSansCN-Regular;font-size:30px;font-weight:400;font-stretch:normal;letter-spacing:0;color:#fff;line-height:117px;text-align:center;overflow:hidden;-webkit-transform:rotate(0);-moz-transform:rotate(0);-ms-transform:rotate(0);-o-transform:rotate(0);transform:rotate(0);}
            .login-main .login-top .bg1 {display:inline-block;width:74px;height:74px;background:#fff;opacity:.1;border-radius:0 74px 0 0;position:absolute;left:0;top:43px;}
            .login-main .login-top .bg2 {display:inline-block;width:94px;height:94px;background:#fff;opacity:.1;border-radius:50%;position:absolute;right:-16px;top:-16px;}
            .login-main .login-bottom {width:428px;background:#fff;border-radius:0 0 12px 12px;padding-bottom:53px;}
            .login-main .login-bottom .center {width:288px;margin:0 auto;padding-top:40px;padding-bottom:15px;position:relative;}
            .login-main .login-bottom .tip {clear:both;height:16px;line-height:16px;width:288px;margin:0 auto;}
            input::-webkit-input-placeholder {color:#a6aebf;}
            input::-moz-placeholder {/* Mozilla Firefox 19+ */            color:#a6aebf;}
            input:-moz-placeholder {/* Mozilla Firefox 4 to 18 */            color:#a6aebf;}
            input:-ms-input-placeholder {/* Internet Explorer 10-11 */            color:#a6aebf;}
            input:-webkit-autofill {/* 取消Chrome记住密码的背景颜色 */            -webkit-box-shadow:0 0 0 1000px white inset !important;}
            html {height:100%;}
            .login-main .login-bottom .tip {clear:both;height:16px;line-height:16px;width:288px;margin:0 auto;}
            .login-main .login-bottom .tip .login-tip {font-family:MicrosoftYaHei;font-size:12px;font-weight:400;font-stretch:normal;letter-spacing:0;color:#9abcda;cursor:pointer;}
            .login-main .login-bottom .tip .forget-password {font-stretch:normal;letter-spacing:0;color:#1391ff;text-decoration:none;position:absolute;right:62px;}
            .login-main .login-bottom .login-btn {width:288px;height:40px;background-color:#1E9FFF;border-radius:16px;margin:24px auto 0;text-align:center;line-height:40px;color:#fff;font-size:14px;letter-spacing:0;cursor:pointer;border:none;}
            .login-main .login-bottom .center .item .validateImg {position:absolute;right:1px;cursor:pointer;height:36px;border:1px solid #e6e6e6;}
            .footer {left:0;bottom:0;color:#fff;width:100%;position:absolute;text-align:center;line-height:30px;padding-bottom:10px;text-shadow:#000 0.1em 0.1em 0.1em;font-size:14px;}
            .padding-5 {padding:5px !important;}
            .footer a,.footer span {color:#fff;}
            .toLogin {font-stretch:normal;letter-spacing:0;color:#1391ff;text-decoration:none;}
            .tip>a:hover{color: #777777}
            @media screen and (max-width:428px) {.login-main {width:360px !important;}
                .login-main .login-top {width:360px !important;}
                .login-main .login-bottom {width:360px !important;}
            }
        </style>
    </head>
    <body background="image/bg.jpg" background-size:100%>
        <div class="main-body">
            <div class="login-main">
                <div class="login-top">
                    <span>用户注册</span>
                    <span class="bg1"></span>
                    <span class="bg2"></span>
                </div>
                <form class="layui-form login-bottom" action="/register.do" method="post" onsubmit="return pd()">
                    <div class="center">
                        <div class="item">
                            <input type="text" name="username" lay-verify="required|username"  placeholder="请设置用户名" maxlength="24" id="username" value=${user.username}>
                        </div>
                        <div class="item">
                            <input type="password" name="password" lay-verify="required|password"  placeholder="请设置6-12位的密码" maxlength="20" id="password" value=${user.password}>
                            <span class="bind-password icon icon-4" id="bind-password"></span>
                        </div>
                        <div class="item">
                            <input type="password" name="repassword" lay-verify="required|repassword"  placeholder="请再次输入密码" maxlength="20" id="repassword">
                            <span class="bind-password icon icon-4" id="bind-repassword"></span>
                        </div>
                        <div class="item">
                            <input type="text" name="phone" lay-verify="required|phone" placeholder="请输入手机号" maxlength="24" value="${user.phone}" id="phone">
                        </div>
                    </div>
                    <div class="tip">
                        <a href="login.jsp" class="toLogin">已有账号？立即登录</a>
                        <a href="javascript:" class="forget-password">忘记密码？</a>
                    </div>
                    <div class="layui-form-item" style="text-align:center; width:100%;height:100%;margin:0px;">
                        <input type="submit" class="login-btn" lay-submit="" lay-filter="register" value="立即注册">
                    </div>
                </form>
            </div>
        </div>
    </body>
<script>
    function pd() {
        var pass=document.getElementById("password");
        var repass=document.getElementById("repassword");
        var phone=document.getElementById("phone");
        var username=document.getElementById("username");
        if (pass.value==""||repass.value==""||phone.value==""||username.value=="")
        {
            alert("不能为空");
            return false;
        }
        if (pass.value.length<6||pass.value.length>12){
            alert("密码长度为6-12位");
            return false;
        }
        if (pass.value!=repass.value){
            alert("两次密码不一致，请重新输入！");
            return false;
        }
        if (phone.value.length!=11)
        {
            alert("手机格式错误,请重新输入!");
            return false;
        }
        return true;
    }
</script>