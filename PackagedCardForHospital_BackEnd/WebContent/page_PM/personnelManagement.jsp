<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="./css/index.css">
        <title>人员管理界面</title>
    </head>
    <!-- 选择 	ID 	人员姓名 	科室 	角色 	状态 	操作-->
    <!-- 查询条件: 人员姓名、科室、角色(系统管理员、收费科室人员)、状态(启用，禁用)-->
    <%--1     2    3--%>
    <body>
        <div class="table_box">
            <h2>人员管理界面</h2>
            <!-- sno -->
            <div class="Search_box">
                <span>人员姓名：</span>
                <input id="sName" class="searchKeyInput" type="text">
            </div>
            <!-- cno -->
            <div class="Search_box">
                <span>科室:</span>
                <select name="" class="searchKeyInput" id="sDepartment">
                    <option value="">暂无</option>
                </select>
            </div>
            <!-- credit -->
            <div class="Search_box">
                <span>角色：</span>
                <select name="" class="searchKeyInput" id="sRole">
                    <option value="">暂无</option>
                </select>
            </div>
            <div class="Search_box">
                <span>状态：</span>
                <select id="sState" class="searchKeyInput" type="text">
                    <option value=""></option>
                    <option value="0">禁用</option>
                    <option value="1">启用</option>
                </select>
            </div>

            <!-- button -->
            <input id="SearchBtn" type="button" class="button-center" value="Search">
            <div>
                <input id="viewAddBtn" type="button" value="增加">
            </div>
            <table id="table" border="1" cellpadding=0 cellspacing=0>
                <tr>
                    <td><span>ID</span></td>
                    <td><span>人员账号</span></td>
                    <td><span>人员姓名</span></td>
                    <td><span>科室</span></td>
                    <td><span>角色</span></td>
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
                <h2>添加面板</h2>
            </div>
            <table>
                <!--  账号  人员姓名    密码  确认密码  科室  角色   -->
                <tr>
                    <td><span>账号：</span></td>
                    <td><input id="add_uAccount" class="addPanel addParams" type="text"></td>
                </tr><tr>
                    <td><span>人员姓名：</span></td>
                    <td><input id="add_uname" class="addPanel addParams" type="text"></td>
                </tr>
                <tr>
                    <td><span>密码：</span></td>
                    <td><input id="add_user_Password" class="addPanel addParams" type="password"></td>
                </tr>
                <tr>
                    <td><span>确认密码：</span></td>
                    <td><input id="add_user_PasswordDouble" class="addPanel addParams" type="password"></td>
                </tr>
                <tr>
                    <td><span>科室：</span></td>
                    <td>
                        <select name="" id="add_user_Department" class="addPanel addParams">
                            <option value="">暂无</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><span>角色：</span></td>
                    <td>
                            <select name="" id="add_user_role" class="addPanel addParams">
                            <option value="">暂无</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input id="add_confirm" type="button" value="确定">
                        <input id="add_cancel" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </div>

        <!--  人员姓名  性别  年龄   账号   密码  角色  	科室 	状态 备注 -->
        <div id="modifyPanel">
            <div class="modifyPanel_title">
                <h2>修改面板</h2>
            </div>
            <table>
                <tr>
                    <td><span>人员账号：</span></td>
                    <td><input id="modify_uAccount" class = "moParams" type="text"></td>
                </tr>
                <tr>
                    <td><span>人员姓名：</span></td>
                    <td><input id="modify_uname" class = "moParams" type="text"></td>
                </tr>
                <tr>
                    <td><span>科室：</span></td>
                    <td>
                        <select name="" id="modify_user_department" class = "moParams">
                            <option value="">暂无</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><span>角色：</span></td>
                    <td>
                        <select name="" id="modify_user_role" class = "moParams">
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
        </div>

        <div id="cover"></div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/PageDataAjax.js"></script>
    <script src="./js/Operation.js"></script>
    <script src="./js/personnelManagement.js"></script>

</html>