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
    <script type="text/javascript" src="layui/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

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
        <!-- 内容主体区域 -->
        <div style="margin-bottom:50px">
            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <div class="page-header">
                            <h1>
                                <small>菜品信息</small>
                            </h1>
                        </div>

                    </div>
                </div>

                <div class="row">
                    <a   class="btn btn-primary" href="/foods.do">返回</a>
                    <script>
                        function order() {
                            console.log("????");
                            document.orderForm.action="${pageContext.request.contextPath}/order.do";
                            document.orderForm.submit();
                        }
                            // var formObject = {};
                            // var formArray =$("#orderForm").serializeArray();
                            // $.each(formArray,function(i,item){
                            //     formObject[item.name] = item.value;
                            // });
                            // $("#ToOrder").click(function() {
                            //     console.log("mmmmmm");
                            //     var strdata = $("#orderForm").serializeArray();
                            //     var obj={};//给obj分配内存
                            //     for(var i =0;i<strdata .length;i++){
                            //
                            //         obj[strdata [i].name]=strdata [i]['value'];
                            //     }
                            //     var str=  JSON.stringify(obj );//转换成string数据
                            //     $.ajax({
                            //         url:"/order.do",
                            //         type:"get",
                            //         data: str,
                            //         dataType: "json",
                            //         success:function(data){
                            //             alert(data.msg);
                            //         },
                            //         error:function(e){
                            //             alert("错误！！");
                            //         }
                            //     });
                            // });

                    </script>
                    <input type="button" onclick="order()" class="btn btn-primary" style="float: right" value="确认下单"></input>

                </div>

                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form name="orderForm" method="post" id="orderForm">
                            <table  class="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th >菜品id</th>
                                    <th >菜名</th>
                                    <th >库存</th>
                                    <th>价格</th>
                                    <th >分类</th>
                                    <th>卖家</th>
                                    <th>数量</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="food" items="${map}">
                                    <tr>
                                        <td>${food.key.foodid}</td>
                                        <td>${food.key.foodname}</td>
                                        <td>${food.key.number}</td>
                                        <td>${food.key.price}</td>
                                        <td>${food.key.sort}</td>
                                        <td>${food.key.storeid}</td>
                                        <td>
                                            <input type="text" disabled value=${food.value} name="count" style="width: 20px">
                                        </td>
                                    </tr>
                                </c:forEach>
                                <tr></tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>总计:</td>
                                    <td><input hidden name="price" value="${price}">${price}</td>
                                </tr>
                                </tbody>
                            </table>
                        <button class="btn btn-primary" value="">选择配送地址: </button>
                        <select class="layui-btn layui-btn-primary demo1" name="useradd">
                            <c:forEach var="adlist" items="${adlist}">
                                <option>${adlist.address}
                                </option>
                            </c:forEach>
                        </select>
                        </form>
                </div>
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