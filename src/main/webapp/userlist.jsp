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
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="/foodlist.do">商品中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="addfood.jsp">添加商品</a></dd>
                        <dd><a href="/foodlist.do">删除/修改商品</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="/orderlist.do">订单中心</a>
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
        <script>

                function queryMyUser() {
                    console.log("????")
                    document.myForm.action="${pageContext.request.contextPath}/queryUsers.do";
                    document.myForm.submit();
                }
                function deleteMyUser() {
                    document.myForm.action="${pageContext.request.contextPath}/deleteUsers.do";
                    document.myForm.submit();
                }
        </script>
        <!-- 内容主体区域 -->
        <div style="padding: 30px;">
            <div class="layui-btn-group demoTable">
<%--                <input class="layui-btn" type="button" value="批量查询" >--%>
<%--                <input class="layui-btn" type="button" value="批量删除" onclick="deleteUser()">--%>
                <button class="layui-btn" data-type="getCheckData" onclick="queryMyUser()">批量查询</button>
                <button class="layui-btn" data-type="getCheckDel" onclick="deleteMyUser()">批量删除</button>
            </div>
            <div style="float: right;padding-right: 80px;">
                <button class="layui-btn layui-btn-warm"><a href="useradd.jsp">添加用户</a></button>
            </div>
            <form action="" name="myForm">
            <table class="layui-table" lay-data="{width: 1200, height:500, page:true, id:'idTest'}" name="idTest">
                <thead>
                <tr>
                    <th lay-data="{field:'src',width:80}">多选</th>
                    <th lay-data="{field:'userid', width:100, sort: true}">用户ID</th>
                    <th lay-data="{field:'username', width:150, sort: true}">用户名</th>
                    <th lay-data="{field:'phone', width:150}">手机号码</th>
                    <th lay-data="{field:'email', width:180}">邮箱</th>
                    <th lay-data="{field:'gender', width:90}">性别</th>
                    <th lay-data="{field:'score', width:100, sort: true}">积分</th>
                    <th lay-data="{field:'vip', width:130}">是否vip客户</th>
                    <%--                    <th lay-data="{field:'wealth', width:135, sort: true}">财富</th>--%>
                    <%--                    <th lay-data="{field:'score', width:80, sort: true, fixed: 'right'}">评分</th>--%>
                    <th lay-data="{field:'do', width:260}">操作</th>
                </tr>
                </thead>
                <!--循环读取值-->
                <c:forEach items="${list}" var="user">
                    <tr>
                        <td><input type="checkbox" value="${user.userid}" name="check"></td>
                        <td>${user.userid}</td>
                        <td>${user.username}</td>
                        <td>${user.phone}</td>
                        <td>${user.email}</td>
                        <td>${user.gender}</td>
                        <td>${user.score}</td>
                        <td>${user.vip}</td>
                        <td><a href="/usertovip.do?userid=${user.userid}" class="layui-btn layui-btn-sm">设置为VIP用户</a>
                            <a href="/userdel.do?userid=${user.userid}" class="layui-btn layui-btn-sm layui-btn-normal">删除用户</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            </form>

            <script src="layui/layui.js" charset="utf-8"></script>
            <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
<%--            <script>--%>
<%--                layui.use('table', function(){--%>
<%--                    var table = layui.table;--%>
<%--                    //监听表格复选框选择--%>
<%--                    table.on('checkbox(demo)', function(obj){--%>
<%--                        console.log(obj)--%>
<%--                    });--%>
<%--                    //监听工具条--%>
<%--                    table.on('tool(demo)', function(obj){--%>
<%--                        var data = obj.data;--%>
<%--                        if(obj.event === 'detail'){--%>
<%--                            layer.msg('ID：'+ data.id + ' 的查看操作');--%>
<%--                        } else if(obj.event === 'del'){--%>
<%--                            layer.confirm('真的删除行么', function(index){--%>
<%--                                obj.del();--%>
<%--                            });--%>
<%--                        } else if(obj.event === 'edit'){--%>
<%--                            layer.alert('编辑行：<br>'+ JSON.stringify(data))--%>
<%--                        }--%>
<%--                    });--%>

<%--                    var $ = layui.$, active = {--%>
<%--                        getCheckData: function(){ //获取选中数据--%>
<%--                            var checkStatus = table.checkStatus('idTest')--%>
<%--                                ,data = checkStatus.data;--%>
<%--                            $.ajax({--%>
<%--                                data:{data:JSON.stringify(data)},--%>
<%--                                url:'/queryUsers.do',--%>
<%--                                async:true,--%>
<%--                                type:'post',--%>
<%--                                dateType:'json',--%>
<%--                                success:function (data) {--%>
<%--                                    if (data === true) {--%>
<%--                                        layer.alert("修改成功", {icon: 6}, function () {--%>
<%--// 得到frame索引--%>
<%--                                            var index = parent.layer.getFrameIndex(window.name);--%>

<%--//关闭当前frame--%>
<%--                                            parent.layer.close(index);--%>

<%--//修改为功后刷新父界面--%>
<%--                                            window.parent.location.reload();--%>
<%--                                        });--%>
<%--                                    }--%>
<%--                                }--%>
<%--                            });--%>
<%--                        }--%>
<%--                        ,getCheckDel: function(){ //获取选中数目--%>
<%--                            var checkStatus = table.checkStatus('idTest')--%>
<%--                                ,data = checkStatus.data;--%>
<%--                            $.ajax({--%>
<%--                                data:{data:JSON.stringify(data)},--%>
<%--                                url:'/deleteUsers.do',--%>
<%--                                async:true,--%>
<%--                                type:'post',--%>
<%--                                dateType:'json',--%>
<%--                                success:function (data) {--%>
<%--                                    console.log(data);--%>
<%--                                    layer.msg(data.msg);--%>
<%--                                },--%>
<%--                                error:function (json) {--%>
<%--                                    console.log(json.status);--%>
<%--                                }--%>
<%--                            });--%>
<%--                        }--%>
<%--                        ,isAll: function(){ //验证是否全选--%>
<%--                            var checkStatus = table.checkStatus('idTest');--%>
<%--                            layer.msg(checkStatus.isAll ? '全选': '未全选')--%>
<%--                        }--%>
<%--                    };--%>

<%--                    $('.demoTable .layui-btn').on('click', function(){--%>
<%--                        var type = $(this).data('type');--%>
<%--                        active[type] ? active[type].call(this) : '';--%>
<%--                    });--%>
<%--                });--%>

<%--            </script>--%>
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