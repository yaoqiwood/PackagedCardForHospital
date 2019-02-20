<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 12/30/2018
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./css/doctorArrange.css">
    <title>医生排班管理界面</title>
</head>
<!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
<!-- 查询条件: 人员姓名、科室 -->
<%--1     2    3--%>

<body>
    <div class="table_box">
        <h2>医生排班管理界面</h2>
        <!-- sno -->
        <div class="Search_box">
            <span>医生姓名：</span>
            <input id="sName" class="searchKeyInput" type="text">
        </div>
        <!-- cno -->
        <!-- <div class="Search_box">
                <span>科室:</span>
                <select name="" class="searchKeyInput" id="sDepartment">
                    <option value="">暂无</option>
                </select>
            </div> -->

        <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
        <!-- button -->
        <input id="SearchBtn" type="button" class="button-center" value="Search">
        <div>
            <span class = "displayNONE">全选：</span><input class = "displayNONE" type="checkbox" name="" id="allCheck">
            <input id="viewAddBtn" type="button" value="增加">
            <input class = "displayNONE" id="delAllBtn" type="button" value="删除">
        </div>
        <table id="table" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td class = "displayNONE"><span>选择</span></td>
                <td><span>ID</span></td>
                <td><span>医生</span></td>
                <td><span>科室</span></td>
                <td><span>排班时间</span></td>
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
            <h2>添加面板</h2>
        </div>
        <table>
            <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
            <tr>
                <td><span>医生姓名：</span></td>
                <td><select name="" id="doctorName"  class="addPanel"></select></td>
            </tr>
            <!-- <tr>
                <td><span>科室：</span></td>
                <td>
                    <select name="" id="add_user_Department" class="addPanel">
                        <option value="">暂无</option>
                    </select>
                </td>
            </tr> -->
            <!-- <tr>
                <td><span>角色：</span></td>
                <td>
                    <select name="" id="add_user_role" class="addPanel">
                        <option value="">暂无</option>
                    </select>
                </td>
            </tr> -->
            <tr>
                <td><span>日期：</span></td>
                <td><input type="date" id="arrange_date"  class="addPanel"></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input id="add_confirm" type="button" value="确定">
                    <input id="add_cancel" type="button" value="取消">
                </td>
            </tr>
        </table>
    </div>

    <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
    <div id="modifyPanel">
        <div class="modifyPanel_title">
            <h2>修改面板</h2>
        </div>
        <table>
            <tr>
                <td><span>人员姓名：</span></td>
                <td><input id="modify_uname" disabled = "true" type="text"></td>
            </tr>
            <tr>
                <td><span>科室：</span></td>
                <td>
                    <input type="text" disabled = "true" id = "modify_department">
                </td>
            </tr>
            <tr>
                <td><span>时间:</span></td>
                <td><input type="date" id = modify_date></td>
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
<script src="./js/doctorArrange.js"></script>


</html>