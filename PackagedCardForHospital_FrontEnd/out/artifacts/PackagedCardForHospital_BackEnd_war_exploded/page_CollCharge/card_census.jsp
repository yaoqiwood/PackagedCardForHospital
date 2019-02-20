<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 1/3/2019
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="./css/card_census.css">
        <title>领卡统计查询</title>
    </head>
    <body>
        <div class="table_box">
            <h2>领卡统计查询</h2>
            <!-- sno -->
            <div class="Search_box">
                <span>申请时间：</span>
                <input id="timeDateStart" class="searchKeyInput" type="date">
                <span>至</span>
                <input id="timeDateEND" class="searchKeyInput" type="date">
            </div>
            <!-- cno -->
            <div class="Search_box">
                <span>卡号:</span>
                <input id="cnoStart" class="searchKeyInput" type="text">
                <span>至</span>
                <input id="cnoEND" class="searchKeyInput" type="text">
            </div>
            <!-- credit -->

            <!-- button -->
            <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
            <input id="SearchBtn" type="button" class="button-center" value="Search">
            <table id="table" border="1" cellpadding=0 cellspacing=0>
                <tr>
                    <td><span>卡号</span></td>
                    <td><span>申请时间</span></td>
                    <td><span>审批时间</span></td>
                    <td><span>审批人</span></td>
                    <td><span>卡绑定病人</span></td>
                    <td><span>卡余额</span></td>
                    <td><span>卡状态</span></td>
                </tr>
            </table>
            <div class="pageUnder">
                <input id="previousPage" type="button" value="上一页">
                <span id="pageNum">0/0</span>
                <input id="nextPage" type="button" value="下一页">
            </div>
        </div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/card_census.js"></script>
</html>
