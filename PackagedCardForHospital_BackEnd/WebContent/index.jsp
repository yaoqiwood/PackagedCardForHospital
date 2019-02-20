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
        <title>智能一卡通系统</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="Login_Box">
                <div class="Login_title">智能一卡通系统</div>
                <table class="wrapper_table">
                    <tr>
                        <td>用户名：</td>
                        <td><input id="username" class="wrapper_table_Widht" type="text" placeholder="请输入用户名："></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input id="password" class="wrapper_table_Widht" type="password" placeholder="请输入密码:"></td>
                    </tr>
                    <tr>
                        <td>验证码：</td>
                        <td><input id="code" class="wrapper_table_Widht" type="text" placeholder="验证码："></td>
                    </tr>
                    <tr>
                        <td colspan="2"><img id = "verifyIMG" src="./code" title="点击刷新" alt="点击刷新"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="LoginBtn"><input id="LoginButton" class="btn btn-primary" type="button"
                                                                value="登录"></td>
                    </tr>
                </table>
            </div>
        </div>

        <div id = "slideShow">
            <h1 id = "slideShowH1">后台管理系统</h1>
        </div>

    </body>
    <!-- ZUI Javascript 依赖 jQuery -->
    <script src="./dist/lib/jquery/jquery.js"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script src="./dist/js/zui.min.js"></script>
    <!-- 自用js -->
    <script src="./js/index.js"></script>
</html>