<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/index_CSSA.css">
    <title>后端主页</title>
</head>

<body>
    <div id="header">
        <h1>后台管理系统</h1>

        <div class="header_ul">
            <ul>
                <li><a href="javascript:void(0)" onclick="LogOut()">注销</a></li>
                <!-- <li><a href="">欢迎zhangsan</a></li> -->
                <li><a id="username_roleID" attribute=${userID} href="">欢迎${username}</a></li>
            </ul>
        </div>
    </div>
    <div id="content">
        <div id="left">
            <ul id = "left_ul">
              
                


            </ul>
        </div>
        <!-- < id="right"> -->
        <iframe src="../welcome.jsp" id="right">

        </iframe>
    </div>



</body>
<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/index.js"></script>

</html>