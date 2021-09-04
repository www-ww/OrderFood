<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>大学食堂外卖点餐平台</title>
    <link  rel="stylesheet" type="text/css" href="layui/css/index.css"/>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="layui/css/font-awesome.min.css" />
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

    <div class="layui-body">
        <div class="guess">
            <div class="guess-like">
                <h1>今日菜品</h1>
            </div>
            <div class="category">
                <div class="wrapper">
                    <ul>
                        <c:forEach var="food" items="${list}">
                            <li>
                                <a href="/foods.do">
                                    <div>
                                        <img src="/image/${food.img}" style="width: 180px;height: 180px">
                                    </div>
                                    <div >
                                        来自${food.storeid}
                                    </div>
                                    <div>
                                        ${food.foodname}
                                    </div>
                                    <div>
                                        今日售:${food.price}元
                                    </div>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
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
