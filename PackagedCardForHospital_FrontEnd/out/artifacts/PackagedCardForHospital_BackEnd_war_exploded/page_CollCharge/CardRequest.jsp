<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 12/27/2018
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/CardRequest.css">
    <title>收费端领卡</title>
</head>
<!-- 选择 	ID 	申请日期 	申请卡数量 	申请人     申请状态  审核人   审核时间  	操作-->
<!-- 查询条件: 申请日期（区间）、审核状态   -->
<%--1     2    3--%>

<body>
    <div class="table_box">
        <h2>收费端领卡管理界面</h2>
        <!-- sno -->
        <div class="Search_box">
            <span>申请日期：</span>
            <input id="RDateStart" class="searchKeyInput" type="date">
            <span>-</span>
            <input id="RDateEND" class="searchKeyInput" type="date">
        </div>
        <!-- cno -->
        <div class="Search_box">
            <span>审核状态:</span>
            <select name="" class="searchKeyInput" id="AsseSatus">
                <option value=""></option>
                <option value="0">待审核</option>
                <option value="1">已审核</option>
            </select>
        </div>



        <!-- button -->
        <!-- 选择 	ID 	申请日期 	申请卡数量 	申请人     申请状态  审核人   审核时间  	操作-->
        <input id="SearchBtn" type="button" class="button-center" value="Search">
        <div>
            <span class="displayNONE">全选：</span><input class="displayNONE" type="checkbox" name="" id="allCheck">
            <input id="viewAddBtn" type="button" value="新申请">
            <input id="delAllBtn" class="displayNONE" type="button" value="删除">
        </div>
        <table id="table" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td class="displayNONE"><span>选择</span></td>
                <td><span>ID</span></td>
                <td><span>申请日期</span></td>
                <td><span>申请卡数量</span></td>
                <td><span>申请人</span></td>
                <td><span>申请状态</span></td>
                <td><span>审核人</span></td>
                <td><span>审核时间</span></td>
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
            <h2>申请单</h2>
        </div>
        <table>
            <!-- 申请人 申请时间    申请卡数量 -->
            <tr>
                <td><span>申请人：</span></td>
                <td><input id="add_requester" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td><span>申请时间：</span></td>
                <td><input id="add_reqDate" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td><span>申请卡数量：</span></td>
                <td><input id="add_reqNum" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="add_confirm" type="button" value="确定">
                    <input id="add_cancel" type="button" value="取消">
                </td>
            </tr>
        </table>
    </div>

    <!--  申请人    申请时间    申请卡数量  -->
    <div id="modifyPanel">
        <div class="modifyPanel_title">
            <h2>修改面板</h2>
        </div>
        <table>
            <tr>
                <td><span>申请人：</span></td>
                <td><input id="modify_requester" type="text"></td>
            </tr>
            <tr>
                <td><span>申请时间：</span></td>
                <td><input id="modify_reqDate" type="text"></td>
            </tr>
            <tr>
                <td><span>申请卡数量：</span></td>
                <td><input id="modify_reqNum" type="text"></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input id="modify_confirm" type="button" value="确定">
                    <input id="modify_cancel" type="button" value="取消">
                </td>
            </tr>
        </table>
    </div>

    <div id="cover"></div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/CardRequestDataAjax.js"></script>
<script src="./js/CardRequestOperation.js"></script>
<script src="./js/CardRequest.js"></script>

</html>