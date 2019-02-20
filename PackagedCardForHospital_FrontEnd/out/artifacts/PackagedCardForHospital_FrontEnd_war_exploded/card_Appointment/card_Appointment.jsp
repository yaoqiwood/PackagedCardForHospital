<%--
  Created by IntelliJ IDEA.
  User: KuroCat
  Date: 12/28/2018
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>预约界面</title>
    <link rel="stylesheet" href="./css/card_Appointment.css">
</head>

<body>
    <div class="table_box">
        <h2>预约界面</h2>
        <table id="table" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td>请输入卡号：</td>
                <td colspan="2"><input type="text" id="cardIDNUM"></td>
                <td><input type="button" id="cardINBtn" value="读卡"></td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td><span id="name"></span></td>
                <%--<td id="sex">性别:</td>--%>
                <td>年龄：</td>
                <td><span id="age"></span></td>
                <%--<td id="native">籍贯：</td>--%>
            </tr>
            <tr>
                <td>籍贯：</td>
                <td><span id="native"></span></td>
                <td>证件号码：</td>
                <td><span id="IDNum"></span></td>
                <%--<td ></td>--%>
                <%--<td id="phone">联系电话：</td>--%>
                <%--<td></td>--%>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td id="phone"><span></span></td>
                <td>现住址：</td>
                <td><span id="address"></span></td>
            </tr>
            <tr>
                <td>卡金额：</td>
                <td><span id="cardAMount"></span></td>
                <td>押金：</td>
                <td id="deposit"></td>
            </tr>
        </table>

        <h2>门诊排班表</h2>
        <table id="appointTable" border="1" cellpadding=0 cellspacing=0>
            <tr>
                <td>科室</td>
                <td>医生名</td>
                <td>时间</td>
                <td>操作</td>
            </tr>
        </table>

        <div id="cover"></div>

        <div id="addPanel">
            <div class="addPanel_title">
                <h2>医生门诊时间</h2>
            </div>
            <table>
                <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
                <tr>
                    <td><span>门诊时间</span></td>
                    <td><span>预约人</span></td>
                </tr>
                <!-- 9-10 10-11 11-12 2-3 3-4 4-5 -->
                <tr>
                    <td class="timeRange">9:00-10:00</td>
                </tr>
                <tr>
                    <td class="timeRange">10:00-11:00</td>
                </tr>
                <tr>
                    <td class="timeRange">11:00-12:00</td>
                </tr>
                <tr>
                    <td class="timeRange">14:00-15:00</td>
                </tr>
                <tr>
                    <td class="timeRange">15:00-16:00</td>
                </tr>
                <tr>
                    <td class="timeRange">16:00-17:00</td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input id="add_confirm" type="button" value="预约">
                        <input id="add_cancel" type="button" value="取消">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/card_Appointment.js"></script>

</html>