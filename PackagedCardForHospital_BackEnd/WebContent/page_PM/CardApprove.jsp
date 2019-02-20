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
    <link rel="stylesheet" href="css/CardApprove.css">
    <title>管理端领卡审批</title>
</head>
<!-- 选择 	ID 	申请时间 	申请人     申请数量  审核人   审核时间  状态	操作-->
<!-- 查询条件: 申请人（下拉框） 审批状态：下拉框  申请时间区间    -->
<%--1     2    3--%>

<body>
    <div class="table_box">
        <h2>管理端领卡管理界面</h2>
        <!-- sno -->
        <div class="Search_box">
            <span>申请人：</span>
            <select name="" id="S_Requester">
                <option value=""> </option>
            </select>
        </div>
        <!-- cno -->
        <div class="Search_box">
            <span>审批状态:</span>
            <select name="" class="searchKeyInput" id="S_Status">
                <option value=""></option>
                <option value="0">待审核</option>
                <option value="1">已审核</option>
            </select>
        </div>

        <div class="Search_box">
            <span>申请时间区间:</span>
            <input type="date" id="S_Date_Start">
            <span>-</span>
            <input type="date" id="S_Date_End">
        </div>



        <!-- button -->
        <!-- 选择 	ID 	申请时间 	申请人     申请数量  审核人   审核时间  状态	操作-->
        <input id="SearchBtn" type="button" class="button-center" value="Search">
        <div class = "displayNONE">
            <span>全选：</span><input type="checkbox" name="" id="allCheck">
            <!-- <input id="viewAddBtn" type="button" value="新申请"> -->
            <!-- <input id="delAllBtn" type="button" value="删除"> -->
        </div>
        <table id="table" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td class = "displayNONE"><span>选择</span></td>
                <td><span>ID</span></td>
                <td><span>申请时间</span></td>
                <td><span>申请人</span></td>
                <td><span>申请数量</span></td>
                <td><span>审核人</span></td>
                <td><span>审核时间</span></td>
                <td><span>状态</span></td>
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
            <h2>领卡审核</h2>
        </div>
        <table>
            <!-- 申请人 申请时间    申请卡数量  审批数量 -->
            <tr>
                <td><span>申请人：</span></td>
                <td><input id="app_requester" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td><span>申请时间：</span></td>
                <td><input id="app_reqDate" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td><span>申请卡数量：</span></td>
                <td><input id="app_reqNum" class="addPanel" type="text"></td>
            </tr>
            <tr>
                <td><span>审批数量：</span></td>
                <td><input id="app_appNum" class="addPanel addParams" type="text"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="add_confirm" type="button" value="确定">
                    <input id="add_cancel" type="button" value="取消">
                </td>
            </tr>
        </table>
    </div>

    <!--  申请人    申请时间    申请卡数量  审核人  审核时间    领用卡号  -->
    <div id="modifyPanel">
        <div class="modifyPanel_title">
            <h2>查看</h2>
        </div>
        <table>
            <tr>
                <td><span>申请人:</span></td>
                <td><input id="v_app_requester" type="text"></td>
            </tr>
            <tr>
                <td><span>申请时间：</span></td>
                <td><input id="v_app_reqDate" type="text"></td>
            </tr>
            <tr>
                <td><span>申请卡数量：</span></td>
                <td><input id="v_app_reqNum" type="text"></td>
            </tr>
            <tr>
                <td><span>审核人：</span></td>
                <td><input id="v_app_apper" type="text"></td>
            </tr>
            <tr>
                <td><span>审核时间：</span></td>
                <td><input id="v_app_date" type="text"></td>
            </tr>
            <tr>
                <td><span>领用卡号</span></td>
                <td><div id="v_app_cardNums" type="text"></div></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input id="modify_cancel" type="button" value="返回">
                </td>
            </tr>
        </table>
    </div>

    <div id="cover"></div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/CardApproveDataAjax.js"></script>
<script src="./js/CardApproveOperation.js"></script>
<script src="./js/CardApprove.js"></script>

</html>