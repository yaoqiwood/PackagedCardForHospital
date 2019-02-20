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
        <title>换卡界面</title>
        <link rel="stylesheet" href="./css/card_Change.css">
    </head>

    <body>
        <div class="table_box">
            <h2>换卡界面</h2>

            <table id="table" border="1" cellpadding=0 cellspacing=0>
                <tr>
                    <td>请输入原卡号/手机号/证件号：</td>
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
                <tr>
                    <td>请输入新卡号：</td>
                    <td><input type="text" id="ChangeCardNum"></td>
                    <td colspan="2"><input type="button" id="ChangeCardBtn" value="换卡"></td>
                </tr>
            </table>

            <div id="cover"></div>
        </div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/card_Change.js"></script>

</html>