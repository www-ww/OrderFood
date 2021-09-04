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
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">外卖点餐平台后台</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>

            <li class="layui-nav-item layui-hide-xs"><a href="/userlist.do">用户面板</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="/mafoods.do">展示面板</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                    admin
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="login.jsp">退出登录</a></dd>
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
                <li class="layui-nav-item layui-nav-itemed" >
                    <a class="" href="/foodlist.do">商品中心</a>
                    <dl class="layui-nav-child" style="margin-bottom: 0">
                        <dd><a href="addfood.jsp">添加商品</a></dd>
                        <dd><a href="/foodlist.do">删除/修改商品</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/orderlist.do">订单中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/orderlist.do">修改订单</a></dd>
                        <dd><a href="/orderlist.do">删除订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="/userlist.do">用户管理</a></li>
                <li class="layui-nav-item"><a href="/m-comlist.do">投诉中心</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 30px;">
            <div style="float: left;margin-right: 30px">
                <form action="${pageContext.request.contextPath}/findorder.do" method="get">
                    <span style="color: red;font-weight: bold">${error}</span>
                    <input type="text" name="findcaete" class="form-inline" class="form-control" placeholder="请输入订单编号">
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>

            </div>
            <a  class="btn btn-primary" href="/queryExportUser">下载订单</a>

            <form action="" name="myForm" style="margin-top:50px">
                <table class="layui-table" lay-data="{width: 1200, height:500, page:true, id:'idTest'}" name="idTest">
                    <thead>
                    <tr>
                        <th lay-data="{field:'foodid', width:120, sort: true}">订单ID</th>
                        <th lay-data="{field:'foodname', width:120, sort: true}">用户id</th>
                        <th lay-data="{field:'number', width:120, sort: true}">状态</th>
                        <th lay-data="{field:'price', width:120, sort: true}">价格</th>
                        <th lay-data="{field:'sort', width:200}">配送地址</th>
                        <th lay-data="{field:'src', width:300, sort: true}">下单时间</th>
                        <%--                    <th lay-data="{field:'wealth', width:135, sort: true}">财富</th>--%>
                        <%--                    <th lay-data="{field:'score', width:80, sort: true, fixed: 'right'}">评分</th>--%>
                        <th lay-data="{field:'do', width:300}">操作</th>
                    </tr>
                    </thead>
                    <!--循环读取值-->
                    <c:forEach items="${list}" var="order">
                        <tr>
                            <td>${order.orderid}</td>
                            <td>${order.userid}</td>
                            <td>${order.state}</td>
                            <td>${order.allprice}</td>
                            <td>${order.to}</td>
                            <td>${order.time}</td>

                            <td>
                                <a href="/orderup.do?orderid=${order.orderid}" class="layui-btn layui-btn-sm layui-btn-normal">修改状态</a>
                                <a href="/orderdel.do?orderid=${order.orderid}" class="layui-btn layui-btn-sm">删除订单</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>
    </div>

    <div class="layui-footer">
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