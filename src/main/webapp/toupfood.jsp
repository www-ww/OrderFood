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

    <div class="layui-body" style="margin-top:100px">
        <center><h1>修改商品</h1></center>
        <!-- 内容主体区域 -->
        <form class="layui-form" action="/tofoodup.do" style="margin-top:70px;margin-left:250px;margin-right: 500px;">
            <div style="float: left;">
                <input type="hidden" name="foodid" value=${food.foodid}>
                <div class="layui-form-item" width="100px">
                    <label class="layui-form-label">商品名</label>
                    <div class="layui-input-block">
                        <input type="text" name="foodname"  placeholder="请输入商品名"  class="layui-input" value=${food.foodname}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">商品数量</label>
                    <div class="layui-input-block">
                        <input type="number" name="number" required  lay-verify="required" placeholder="请输入数量"  class="layui-input" value=${food.number}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">价格</label>
                    <div class="layui-input-block">
                        <input type="number" name="price" required  lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input" value=${food.price}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">类别</label>
                    <div class="layui-input-block">
                        <input type="text" name="sort"  placeholder="请输入分类" autocomplete="off" class="layui-input" value=${food.sort}>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">卖家</label>
                    <div class="layui-input-block">
                        <input type="text" name="storeid"  placeholder="请输入卖家" autocomplete="off" class="layui-input" value=${food.storeid}>
                    </div>
                </div>
            </div>
            <div style="float: right">
                <div class="layui-upload" style="width: 80px;height: 180px">
                    <button type="button" class="layui-btn" id="test1" >上传图片</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1" style="width:100px;height: 160px">
                        <p id="demoText"></p>
                    </div>
                    <div style="width: 95px;">
                        <div class="layui-progress layui-progress-big" lay-showpercent="yes" lay-filter="demo">
                            <div class="layui-progress-bar" lay-percent=""></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
        <script src="layui/layui.js" charset="utf-8"></script>
        <!-- 注意：如果你直接复制所有代码到本地，上述 JS 路径需要改成你本地的 -->
        <script>
            layui.use(['upload', 'element', 'layer'], function() {
                var $ = layui.jquery
                    , upload = layui.upload
                    , element = layui.element
                    , layer = layui.layer;

                //常规使用 - 普通图片上传
                var uploadInst = upload.render({
                    elem: '#test1'
                    , url: '/upload.do' //此处用的是第三方的 http 请求演示，实际使用时改成您自己的上传接口即可。
                    , before: function (obj) {
                        //预读本地文件示例，不支持ie8
                        obj.preview(function (index, file, result) {
                            $('#demo1').attr('src', result); //图片链接（base64）
                        });

                        element.progress('demo', '0%'); //进度条复位
                        layer.msg('上传中', {icon: 16, time: 0});
                    }
                    , done: function (res) {
                        //如果上传失败
                        if (res.code > 0) {
                            return layer.msg('上传失败');
                        }
                        //上传成功的一些操作
                        //……
                        if(res.code==0){
                            $('.layui-btn-img').text("上传成功,重新上传");
                            return layer.msg('上传成功',{time:700});
                        }
                        // $('#demoText').html(''); //置空上传失败的状态
                    }
                    // , error: function () {
                    //     //演示失败状态，并实现重传
                    //     var demoText = $('#demoText');
                    //     demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    //     demoText.find('.demo-reload').on('click', function () {
                    //         uploadInst.upload();
                    //     });
                    // }
                    //进度条
                    , progress: function (n, elem, e) {
                        element.progress('demo', n + '%'); //可配合 layui 进度条元素使用
                        if (n == 100) {
                            layer.msg('上传完毕', {icon: 1});
                        }
                    }
                });
            });
        </script>
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