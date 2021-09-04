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
    <script src="https://cdn.bootcss.com/echarts/3.5.4/echarts.js"></script>
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
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
<h3>
    <a class="btn btn-primary" href="/foodlist.do" style="margin-left: 30px">返回</a>
</h3>

<div id="main" style="width:1000px; height:600px;align:center;margin-left: 30px"></div>
        <script type="text/javascript">
            $(function () {
                // 初始化
                var myChart = echarts.init($('#main')[0]); // 注意：这里init方法的参数的javascript对象，使用jQuery获取标签时，要将jQuery对象转成JavaScript对象；

                // 配置图标参数
                var options = {
                    backgroundColor: '#b4daec',//背景色
                    color:['#5793F3'],
                    title: {
                        text: '商品销量柱状图',
                        show: true, // 是否显示标题
                        subtext: '数据',
                        textStyle: {
                            fontSize: 18 // 标题文字大小
                        }
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        }
                    },
                    legend: {
                        data: ['销量']
                    },
                    // X轴
                    xAxis: {
                        data: [] // 异步请求时,这里要置空
                    },
                    // Y轴
                    yAxis: {},
                    series: [{
                        name: '销量',
                        type: 'bar', // 设置图表类型为柱状图
                        data: [] // 设置纵坐标的刻度(异步请求时,这里要置空)
                    }]
                };
                // 给图标设置配置的参数
                myChart.setOption(options);
                myChart.showLoading(); // 显示加载动画
// 异步请求加载数据
                var names = [];//类别数组（实际用来盛放x轴坐标的值）
                var values = []; //销量数组 （实际用来盛放y轴坐标的值）
                //使用异步（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                $.ajax({
                    type: "get",
                    url: "/queryForList",//请求数据的地址
                    dataType: "json", //返回数据形式为json
                    success: function (data) {//后台传的数据  [{"name":"java","value":1038},{"name":"sql","value":1700}]
                        if (data === '') {
                            alert("加载失败");
                        } else {
                            //alert("加载成功");
                            console.log(data);
                            //请求成功时执行该函数内容，result即为服务器返回的json对象
                            for (var i = 0; i < data.length; i++) {
                                names.push(data[i].name);//挨个取出类别并填入类别数组
                            }
                            for (var i = 0; i < data.length; i++) {
                                values.push(data[i].value);//挨个取出销量并填入销量数组
                            }
                            myChart.hideLoading(); //隐藏加载动画
                            myChart.setOption({ //加载数据图表
                                xAxis: {
                                    data: names
                                },
                                series: [{
                                    // 根据名字对应到相应的系列
                                    name: '销量',
                                    data: values
                                }]
                            });
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {//请求的失败的返回的方法
                        alert("出异常了");
                    }
                });
                myChart.hideLoading(); // 隐藏加载动画
                myChart.setOption({
                    legend: {
                        data: ['销量']
                    },
                    xAxis: {
                        data: names
                    },
                    series: [{
                        name: '商品销量',
                        type: 'bar', // 设置图表类型为柱状图
                        data: values // 设置纵坐标的刻度
                    }]
                });
            });
        </script>
    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        Copyright © 2021.8.25 @author ww
    </div>
</div>
</body>
</html>