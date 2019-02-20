var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {
    // 刷新表
    initOperation.RefreshTable(initData.makeTempJSON());

    // 读卡操作
    $("#cardINBtn").click(function () {
        initOperation.readCardNum();
    });

    $("#TopUpBtn").click(function () {
        initData.TopUpMoney = $("#TopUpMoney").val();
        initOperation.TopUpOperation();
    });

    // 按钮监听
    $(".timeRange").each(function () {
        $(this).click(function (event) {
            $(".timeRange").each(function (event) {
                $(this).css("background-color", "white");
            });
            console.log($(event.target).html());
            initData.timeRangeSelected = $(event.target).html();
            $(event.target).css("background-color", "green");
        });
    });

    $("#add_confirm").click(function () {
        var url = "../addAppoint";
        var msg = initOperation.getAjaxJSON(url, initData.makeAppJSON());
        var obj = JSON.parse(msg);

    });

});


function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 0; //  行总数

    this.CardNum = "";
    this.TopUpMoney = "";
    this.obj = "";

    // 预约参数
    this.timeRangeSelected = "";
    this.tempID = "";
    this.p_ID = "";

    this.makeTempJSON = function () {
        var tempJSON = {
            "sName": null,
            "CurrentPage": initData.CurrentPage,
            "Limit": initData.Limit
        };
        return tempJSON;
    }

    this.makeAppJSON = function () {
        var addJSON = {
            "timeRangeSelected": initData.timeRangeSelected,
            "tempID": initData.tempID,
            "p_ID": initData.p_ID,
            "CardNum":initData.CardNum
        };
        return addJSON;
    }
}

function Operation() {
    this.readCardNum = function () {
        initData.CardNum = $("#cardIDNUM").val();
        initOperation.readCardServer(initData.CardNum);
    };

    this.showAppointBox = function (event) {
        $("#addPanel").css("display", "block");
        initData.tempID = $(event.parentElement.parentElement).attr("id");
        $(".timeRange").each(function () {
            var url = "../findAppoint"
            var data = { "appID": initData.tempID, "timeRange": $(this).html() };
            var msg = initOperation.getAjaxJSON(url, data);
            var obj = JSON.parse(msg);
            if (obj.id == 1) {
                // $(this).append("<td>"+obj.message+"</td>")
                console.log($(this.parentElement).append("<td>" + obj.message + "</td>"));
            }

        });
    };



    this.readCardServer = function (cardIDNUM) {
        $.ajax({
            type: "POST",
            url: "../readCardNum",
            data: { "cardIDNUM": cardIDNUM },
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                initData.obj = obj;
                initOperation.fillTable(initData.obj);
            },
            error: function (param) {
                console.log("error");
            }
        });
    }

    this.fillTable = function (obj) {
        for (var i = 0; i < obj.length; i++) {
            $("#name").html(obj[i].sold_name);
            $("#age").html(obj[i].sold_age);
            $("#sex").html(obj[i].sex);
            $("#native").html(obj[i].u_native);
            $("#IDNum").html(obj[i].idNum);
            $("#phone").html(obj[i].phone);
            $("#address").html(obj[i].address);
            $("#cardAMount").html(obj[i].preStore);
            $("#deposit").html(obj[i].deposit);
            //  读取p_ID
            initData.p_ID = obj[i].p_ID;
        }
    };

    // 刷新表格
    this.RefreshTable = function (Conditions) {
        console.log(Conditions);
        var url = "../refreshArrTable";
        var msg = initOperation.getAjaxJSON(url, Conditions);
        var obj = JSON.parse(msg);
        // 清空表
        $("#appointTable").empty();
        // 刷新表头
        initOperation.RefreshTableHead()
        // 增加表行
        initOperation.AddTableLine(obj);
    };



    //  刷新表数据
    this.RefreshTableHead = function () {
        $("#appointTable").append(
            "<tr>" +
            "<td><span>科室</span></td>" +
            "<td><span>医生名</span></td>" +
            "<td><span>时间</span></td>" +
            "<td><span>操作</span></td>" +
            "</tr>"
        );
    };

    //  增加表列
    this.AddTableLine = function (obj) {
        // console.log(obj);    用户名（模糊）、年龄、学号、性别（显示男女）
        for (var i = 0; i < obj.length; i++) {
            $("#appointTable").append("<tr id =" + obj[i].id + " >" +
                // "<td><input class = 'check' type = 'checkbox'> </td>" +
                // "<td><span>" + obj[i].id + "</span></td>" +
                "<td><span>" + obj[i].department + "</span></td>" +
                "<td><span>" + obj[i].doctor + "</span></td>" +
                "<td><span>" + obj[i].atime + "</span></td>" +
                "<td>" +
                "<input onclick = 'initOperation.showAppointBox(this)' type = 'button' value = '预约' >" +
                // "<input onclick = 'OperationInit.modifyStuData(this)' type = 'button' value = '修改' >" +
                "</td > " +
                "</tr>");
        }
    };

    this.getAjaxJSON = function (url, data) {
        var msg;
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            async: false,
            success: function (response) {
                msg = response;
                console.log(msg);
            },
            error: function (msg) {
                console.log("error");
            }
        });
        return msg;
    };



}