<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <%--ZUI CSS外部引用Start--%>
    <link rel="stylesheet" href="./dist/css/zui.min.css">
    <%--ZUI CSS外部引用End--%>

    <%--其余自写CSS--%>
    <link rel="stylesheet" href="./css/index.css">

    <title>一卡通自助终端</title>
</head>

<body>
    <div class="content-inner">
        <div>
            <h1 id="caption">欢迎使用一卡通自助终端</h1>
        </div>
        <div class="btn-middle">
            <input id="caption_Start" type="button" class="btn btn-lg btn-primary" value="点击开始使用">
        </div>
    </div>

    <div class="menu-button-self" id="menu_buttons_inner">
        <div><input class="btn btn-block btn-primary btn-margin-bottom" id="cardTopUp" type="button" value="卡充值"></div>
        <div><input class="btn btn-block btn-primary btn-margin-bottom" id="cardAccCheck" type="button" value="卡对账"></div>
        <div><input class="btn btn-block btn-primary btn-margin-bottom" id="cardReg" type="button" value="预约挂号"></div>
        <div><input class="btn btn-block btn-primary btn-margin-bottom" id="cardGetNum" type="button" value="预约取号"></div>
    </div>

    <div class="view-box panel">
        <ul class="icon-ul">
            <li><i id = "iconClose" class="icon icon-eye-close"></i></li>
        </ul>
        <iframe src="" id="view-box-frame" class="panel-body" frameborder="0"></iframe>
    </div>

</body>
<!-- ZUI Javascript 依赖 jQuery -->
<script src="./dist/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="./dist/js/zui.min.js"></script>
<!-- 自用js -->
<script src="./js/index.js"></script>

</html>