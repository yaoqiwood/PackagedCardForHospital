<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 1/5/2019
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>权限管理</title>
        <link rel="stylesheet" href="./css/rightmanage.css">
    </head>
    <body>
        <div id="content">
            <div id = readBtn>
                <select name="" id="roleRead">
                    <option value="4">管理员</option>
                    <option value="3">收费员</option>
                </select>
                <input type="button" id = "roleReadBtn" value="读取">
            </div>
            <div id="left">
                <ul id = "left_ul">
                </ul>
            </div>
            <div id = saveBTN><input type="button" id = "SaveSubBtn" value="保存"></div>
        </div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/rightmanage.js"></script>
</html>
