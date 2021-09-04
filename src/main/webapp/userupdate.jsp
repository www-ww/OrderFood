<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>大学食堂外卖点餐平台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">外卖点餐平台</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    ${username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="userupdate.jsp">修改信息</a></dd>
                    <dd><a href="/myaddress.do">我的地址</a></dd>
                    <dd><a href=login.jsp"">退出登录</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/index.do">菜品首页</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/myorder.do">我的订单</a></dd>
                        <dd><a href="/foods.do">菜品列表</a></dd>
                        <%--                        <dd><a href="javascript:;">menu 3</a></dd>--%>
                        <%--                        <dd><a href="">the links</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/complainlist.do">我的投诉</a></li>
                <%--                <li class="layui-nav-item"><a href="">投诉中心</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-body" style="margin-top:100px">
        <center><h1>修改信息</h1></center>
        <!-- 内容主体区域 -->
        <form class="layui-form" action="/upusermg.do" style="margin-top:20px;margin-left:300px;margin-right: 400px;">
            <div class="layui-form-item" width="100px">
                <div class="layui-input-block" >
                    <input type="hidden" name="userid"  class="layui-input" value="${user.userid}">
                </div>
            </div>
            <div class="layui-form-item" width="100px">
                <div class="layui-input-block" >
                    <input type="hidden" name="username"  class="layui-input" value="${user.username}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">用户密码</label>
                <div class="layui-input-block">
                    <input type="password" name="password"  placeholder="请输入用户密码"  class="layui-input" value="${user.password}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-block">
                    <input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input" value="${user.email}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">电话号码</label>
                <div class="layui-input-block">
                    <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" value="${user.phone}">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">输入性别</label>
                <div class="layui-input-block">
                    <input type="text" name="gender"  placeholder="请输入性别"  class="layui-input" value="${user.gender}">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        Copyright © 2021.8.25 @author ww
    </div>
</div>
<script src="./layui/layui.js"></script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function(){
        var element = layui.element
            ,layer = layui.layer
            ,util = layui.util
            ,$ = layui.$;

        //头部事件
        util.event('lay-header-event', {
            //左侧菜单事件
            menuLeft: function(othis){
                layer.msg('展开左侧菜单的操作', {icon: 0});
            }
            ,menuRight: function(){
                layer.open({
                    type: 1
                    ,content: '<div style="padding: 15px;">处理右侧面板的操作</div>'
                    ,area: ['260px', '100%']
                    ,offset: 'rt' //右上角
                    ,anim: 5
                    ,shadeClose: true
                });
            }
        });

    });
</script>

</body>
</html>