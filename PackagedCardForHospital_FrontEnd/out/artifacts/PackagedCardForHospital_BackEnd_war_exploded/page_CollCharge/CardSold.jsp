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
        <title>收费端售卡</title>
        <link rel="stylesheet" href="./css/CardSold.css">
    </head>
    <body>
        <div class="table_box">
            <h2>收费端售卡界面</h2>

            <table id="table" border="0" cellpadding=0 cellspacing=0>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" id="sold_name"></td>
                    <td>年龄：</td>
                    <td>
                        <input type="text" id="sold_age">
                        <span>岁</span>
                    </td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><select name="" id="sex">
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select></td>
                    <td>籍贯：</td>
                    <td>
                        <select name="native" id="native">
                            <option value=""></option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>证件号码：</td>
                    <td><input type="text" id="idNum"></td>
                    <td>联系电话：</td>
                    <td><input type="text" id=phone></td>
                </tr>
                <tr>
                    <td>现住址：</td>
                    <td colspan="3"><input type="text" id="address"></td>
                </tr>
                <tr>
                    <td>预存金额：</td>
                    <td><input type="text" id="preStore"></td>
                    <td>卡号：</td>
                    <td><input type="text" id="cardNum"></td>
                </tr>
                <tr>
                    <td colspan="4"><input type="button" id = "btnSold" value="出售"></td>
                </tr>
            </table>

            <div id="cover"></div>
        </div>
    </body>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/CardSold.js"></script>
</html>
