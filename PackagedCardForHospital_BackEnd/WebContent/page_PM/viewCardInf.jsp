<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 1/1/2019
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/viewCardInf.css">
    <title>卡片查询管理界面</title>
</head>
<!-- 选择 	ID 	卡号  	卡状态  领用人  就诊人	操作-->
<!-- 查询条件: 卡号、卡状态、领用人-->
<%--1     2    3--%>

<body>
    <div class="table_box">
        <h2>卡片查询管理界面</h2>
        <!-- sno -->
        <div class="Search_box">
            <span>卡号：</span>
            <input id="CNUM" class="searchKeyInput" type="text">
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
        <!-- credit -->
        <div class="Search_box">
            <span>领用人</span>
            <select name="" id="requestor">
                <option value=""></option>
            </select>
        </div>


        <!-- button -->
        <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
        <input id="SearchBtn" type="button" class="button-center" value="Search">
        <div>
            <span class="displayNONE">全选：</span><input class="displayNONE" type="checkbox" name="" id="allCheck">
            <!-- <input id="viewAddBtn" type="button" value="卡入库"> -->
            <input class="displayNONE" id="delAllBtn" type="button" value="删除">
        </div>
        <table id="table" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td class="displayNONE"><span>选择</span></td>
                <td><span>ID</span></td>
                <td><span>卡号</span></td>
                <td><span>卡状态</span></td>
                <td><span>领用人</span></td>
                <td><span>就诊人</span></td>
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
            <h2>查看卡信息</h2>
        </div>
        <table>
            <!-- 选择 	ID 	卡号 	导入日期 	卡状态  	操作-->
            <%-- 开始卡号 截至卡号 前缀  --%>
            <tr>
                <td id="cardNum">卡号：</td>
                <td id="cardAmount">卡余额：</td>
            </tr>
            <tr>
                <td id="cardStatus">卡状态：</td>
                <td id="cardUser">就诊人：</td>
            </tr>
            <tr>
                <td id="cardRequester">领用人：</td>
                <td id="cardReqTime">领用时间：</td>
            </tr>
            <tr>
                <td id="cardVendor">售卡人：</td>
                <td id="cardVendTime">售卡时间：</td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="add_cancel" type="button" value="返回">
                </td>
            </tr>
        </table>
    </div>

    <%--<!--  人员姓名  性别  年龄   账号   密码  角色  	科室 	状态 备注 -->
        <div id="modifyPanel">
            <div class="modifyPanel_title">
                <h2>修改面板</h2>
            </div>
            <table>
                <tr>
                    <td><span>人员账号：</span></td>
                    <td><input id="modify_uAccount" type="text"></td>
                </tr>
                <tr>
                    <td><span>人员姓名：</span></td>
                    <td><input id="modify_uname" type="text"></td>
                </tr>
                <tr>
                    <td><span>科室：</span></td>
                    <td>
                        <select name="" id="modify_user_department">
                            <option value="">暂无</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><span>角色：</span></td>
                    <td>
                        <select name="" id="modify_user_role">
                            <option value="">暂无</option>
                        </select>
                    </td>
                </tr>


                <tr>
                    <td colspan="2">
                        <input id="modify_confirm" type="button" value="确定">
                        <input id="modify_cancel" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </div>--%>

    <div id="cover"></div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/viewCardInf.js"></script>

</html>