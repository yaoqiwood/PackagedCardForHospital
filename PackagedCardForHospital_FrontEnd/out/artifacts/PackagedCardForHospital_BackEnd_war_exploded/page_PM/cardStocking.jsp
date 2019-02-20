<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 12/27/2018
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/cardStocking.css">
        <title>卡片入库管理界面</title>
    </head>
    <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
    <!-- 查询条件: 卡号区间、卡状态、导入日期区间-->
    <%--1     2    3--%>
    <body>
        <div class="table_box">
            <h2>卡片入库管理界面</h2>
            <!-- sno -->
            <div class="Search_box">
                <span>卡号：</span>
                <input id="CNStart" class="searchKeyInput" type="text">
                <span>-</span>
                <input id="CNEND" class="searchKeyInput" type="text">
            </div>
            <!-- cno -->
            <div class="Search_box">
                <span>卡状态:</span>
                <select name="" class="searchKeyInput" id="CSatus">
                    <option value=""></option>
                    <option value="0">待领用</option>
                    <option value="1">已领用</option>
                </select>
            </div>
            <!-- credit -->
            <div class="Search_box">
                <span>导入日期区间：</span>
                <input type="date" id=StINDateStart>
                <span>-</span>
                <input type="date" id=StINDateEND>
            </div>


            <!-- button -->
            <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
            <input id="SearchBtn" type="button" class="button-center" value="Search">
            <div>
                <span class="displayNONE">全选：</span><input type="checkbox" name="" class="displayNONE" id="allCheck">
                <input id="viewAddBtn" type="button" value="卡入库">
                <input id="delAllBtn" class="displayNONE" type="button" value="删除">
            </div>
            <table id="table" border="1" cellpadding=0 cellspacing=0>
                <tr>
                    <td class="displayNONE"><span>选择</span></td>
                    <td><span>ID</span></td>
                    <td><span>卡号</span></td>
                    <td><span>导入日期</span></td>
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

        <div id="addPanel">
            <div class="addPanel_title">
                <h2>卡入库</h2>
            </div>
            <table>
                <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
                <%-- 开始卡号 截至卡号 前缀  --%>
                <tr>
                    <td><span>开始卡号：</span></td>
                    <td><input id="add_CNStart" class="addPanel" type="text"></td>
                </tr>
                <tr>
                    <td><span>截至卡号：</span></td>
                    <td><input id="add_CNEND" class="addPanel" type="text"></td>
                </tr>
                <tr>
                    <td><span>前缀：</span></td>
                    <td><input id="add_Prefix" class="addPanel" type="text"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="add_confirm" type="button" value="确定">
                        <input id="add_cancel" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </div>



        <div id="cover"></div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/CardSPageDataAjax.js"></script>
    <script src="./js/CardSOperation.js"></script>
    <script src="./js/CardpersonnelManagement.js"></script>

</html>
