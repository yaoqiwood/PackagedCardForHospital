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

    // 下一页
    $("#nextPage").click(function () {
        initOperation.NextPage();
    });
    // 上一页
    $("#previousPage").click(function () {
        initOperation.PreviousPage();
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
            "ID": initData.p_ID,
            "CurrentPage": initData.CurrentPage,
            "Limit": initData.Limit
        };
        return tempJSON;
    }

    this.makeAppJSON = function () {
        var addJSON = {
            "timeRangeSelected": initData.timeRangeSelected,
            "tempID": initData.tempID,
            "p_ID": initData.p_ID
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
                // 刷新表
                initOperation.RefreshTable(initData.makeTempJSON());
                // 读监听
                initOperation.arrangeNum();
                $("#pageUnderLine").css("display", "block");
                // 查找总页数
                initOperation.FindCountStuTable(initData.makeTempJSON());
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
        if (obj.length == 0) {
            alert("没有这张卡或卡不可用");
            initOperation.clearInputBox();
        }
    };

    // 刷新表格
    this.RefreshTable = function (Conditions) {
        console.log(Conditions);
        var url = "../refreshAccCheckTable";
        var msg = initOperation.getAjaxJSON(url, Conditions);
        var obj = JSON.parse(msg);
        // 清空表
        $("#appointTable").empty();
        // 刷新表头
        initOperation.RefreshTableHead()
        // 增加表行
        initOperation.AddTableLine(obj);
    };


    //  查询表行
    this.FindCountStuTable = function (Conditions) {
        var url = "../countAccCheckTable";
        var msg = initOperation.getAjaxJSON(url, Conditions);
        var obj = JSON.parse(msg);
        initData.Count = obj.count;
        initOperation.RefreshPage();
    };

    //  刷新表页
    this.RefreshPage = function () {
        console.log(initData.Limit);
        console.log(initData.Count);
        var Limit = initData.Limit;
        var Count = initData.Count;
        if (Count % Limit == 0) {
            initData.TotalPage = parseInt(Count / Limit);
        } else {
            initData.TotalPage = parseInt(Count / Limit + 1);
        }
        if (Count == 0) {
            initData.TotalPage = 1;
        }
        $("#pageNum").html(initData.CurrentPage + "/" +
            initData.TotalPage);
    };

    //  刷新表数据
    this.RefreshTableHead = function () {
        $("#appointTable").append(
            "<tr>" +
            "<td><span>发生时间</span></td>" +
            "<td><span>发生事务</span></td>" +
            "<td><span>发生金额</span></td>" +
            "<td><span>执行人</span></td>" +
            "</tr>"
        );
    };

    //  增加表列
    this.AddTableLine = function (obj) {
        // console.log(obj);    用户名（模糊）、年龄、学号、性别（显示男女）
        for (var i = 0; i < obj.length; i++) {
            $("#appointTable").append("<tr class = 'appointor'>" +
                "<td><span>" + obj[i].whenTime + "</span></td>" +
                "<td><span>" + obj[i].event + "</span></td>" +
                "<td><span>" + obj[i].amount + "</span></td>" +
                "<td><span>" + (obj[i].executor == null ? "系统" : obj[i].executor) + "</span></td>" +
                "</tr>");
        }
    };

    this.arrangeNum = function () {
        $("#getNum").click(function () {
            $(".check").each(function () {
                console.log($(this).prop("checked"));
                if ($(this).prop("checked") == true) {
                    var ID = $(this.parentElement.parentElement).attr("id");
                    var url = "../delAppNum";
                    var data = { "ID": ID };
                    var msg = initOperation.getAjaxJSON(url, data);
                    var obj = JSON.parse(msg);
                    if (obj.id == 1) {
                        alert(obj.message);
                    } else {
                        alert(obj.message);
                    }
                }
            });
        });
    }

    //  上一页
    this.PreviousPage = function () {
        if (initData.CurrentPage > 1) {
            initData.CurrentPage -= 1;
            initOperation.RefreshPageAndTable();
        }
    };

    //  下一页
    this.NextPage = function () {
        if (initData.CurrentPage < initData.TotalPage) {
            initData.CurrentPage += 1;
            initOperation.RefreshPageAndTable();
        }
    };

    this.RefreshPageAndTable = function () {
        initOperation.RefreshTable(initData.makeTempJSON());
        initOperation.RefreshPage(initData.makeTempJSON());
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

    // this.clearAppBox = function () {  
    //     $(".appointor").each(function () {  
    //         $(this).remove();
    //     })
    // }

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