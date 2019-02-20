<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 1/4/2019
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/cardlogout.css">
        <title>卡片注销管理界面</title>
    </head>
    <!-- 选择 	ID 	卡号  	卡状态  领用人  就诊人	操作-->
    <!-- 查询条件: 卡号、卡状态、领用人-->
    <%--1     2    3--%>

    <body>
        <div class="table_box">
            <h2>卡片注销管理界面</h2>
            <!-- sno -->
            <div class="Search_box">
                <span>卡号：</span>
                <input id="CNUMStart" class="searchKeyInput" type="text">
                <span>-</span>
                <input id="CNUMEND" class="searchKeyInput" type="text">
            </div>
            <!-- cno -->
            <div class="Search_box">
                <span>卡状态:</span>
                <select name="" class="searchKeyInput" id="CSatus">
                    <option value=""></option>
                    <option value="1">待出售</option>
                    <option value="2">已出售</option>
                </select>
            </div>
  

            <!-- button -->
            <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
            <input id="SearchBtn" type="button" class="button-center" value="Search">
            <table id="table" border="1" cellpadding=0 cellspacing=0>
                <tr>
                    <td><span>ID</span></td>
                    <td><span>卡号</span></td>
                    <td><span>卡状态</span></td>
                    <td><span>操作</span></td>
                </tr>
            </table>
            <div class="pageUnder">
                <input id="previousPage" type="button" value="上一页">
                <span id="pageNum">0/0</span>
                <input id="nextPage" type="button" value="下一页">
            </div>
        </div>

    



        <div id="cover"></div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/cardlogout.js"></script>
</html>
