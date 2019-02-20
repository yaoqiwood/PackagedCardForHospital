<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 1/2/2019
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="./css/Password_Change.css">
</head>

<body>
    <div class="table_box">
        <h2>修改密码</h2>
        <table id="table" border="0" cellpadding=0 cellspacing=0>
            <tr>
                <td>旧密码：</td>
                <td><input type="password" id="used_PWD" class="PWD"></td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" id="new_PWD" class="PWD"></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" id="new_PWDCON" class="PWD"></td>
            </tr>
            <tr>
                <td colspan="4"><input type="button" id="submit" value="提交"></td>
            </tr>
        </table>
        <div id="cover"></div>
    </div>

</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/Password_Change.js"></script>

</html>