var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {


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
            console.log($(this).attr("point"));
            if ($(this).attr("point") == "false") {
                alert("该时段已被预约");
                initData.timeRangeSelected = "";
                return;
            }
            console.log($(event.target).html());
            initData.timeRangeSelected = $(event.target).html();
            $(event.target).css("background-color", "green");
        });
    });

    $("#add_confirm").click(function () {
        if (initData.timeRangeSelected == "") {
            alert("请先选择时段");
            return;
        }
        var url = "../addAppoint";
        var msg = initOperation.getAjaxJSON(url, initData.makeAppJSON());
        var obj = JSON.parse(msg);
        if (obj.id == 1) {
            alert(obj.message);
            initData.timeRangeSelected = "";
            $("#addPanel").css("display", "none");
            $("#cover").css("display", "none");
            initData.timeRangeSelected = "";
            initOperation.clearAppBox();
        } else {
            alert(obj.message);
            initData.timeRangeSelected = "";
        }
    });

    $("#add_cancel").click(function () {
        $("#addPanel").css("display", "none");
        $("#cover").css("display", "none");
        initData.timeRangeSelected = "";
        initOperation.clearAppBox();
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
            "sName": "",
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
            "CardNum": initData.CardNum
        };
        return addJSON;
    }
}

function Operation() {
    this.readCardNum = function () {
        initData.CardNum = $("#cardIDNUM").val();
        if (initData.CardNum == "") {
            alert("请先填写卡号");
            return;
        }
        initOperation.readCardServer(initData.CardNum);
    };

    this.showAppointBox = function (event) {
        if (initData.CardNum == "") {
            alert("请先读卡");
            return;
        }

        $("#addPanel").css("display", "block");
        $("#cover").css("display", "block");
        initData.tempID = $(event.parentElement.parentElement).attr("id");
        $(".timeRange").each(function () {
            var url = "../findAppoint"
            var data = { "appID": initData.tempID, "timeRange": $(this).html() };
            var msg = initOperation.getAjaxJSON(url, data);
            var obj = JSON.parse(msg);
            if (obj.id == 1) {
                // $(this).append("<td>"+obj.message+"</td>")
                $(this.parentElement).append("<td class = 'appointor'>" + obj.message + "</td>");
                $(this).attr("point", false);
            } else {
                $(this).attr("point", true);
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
                if (obj.length == 0) {
                    alert("没有这张卡或卡不可用");
                    initOperation.clearInputBox();
                    initOperation.clearAppBox();
                    return;
                }
                // 刷新表
                initOperation.RefreshTable(initData.makeTempJSON());
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
            $("#appointTable").append("<tr id =" + obj[i].id + " class = 'appointor' >" +
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

    this.clearInputBox = function () {
        $("#name").html("");
        $("#age").html("");
        $("#sex").html("");
        $("#native").html("");
        $("#IDNum").html("");
        $("#phone").html("");
        $("#address").html("");
        $("#cardAMount").html("");
        $("#deposit").html("");
    }

    this.clearAppBox = function () {
        $(".appointor").each(function () {
            $(this).remove();
        })
    }


}