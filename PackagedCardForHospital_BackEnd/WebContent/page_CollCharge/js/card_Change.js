var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {
    //  读卡操作
    $("#cardINBtn").click(function () {
        initOperation.readCardNum();
    });

    $("#ChangeCardBtn").click(function () {
        initData.ChangeCardNum = $("#ChangeCardNum").val();
        initOperation.ChangeCardtion();
    });

});


function data() {
    this.CardNum = "";
    this.ChangeCardNum = "";
    this.obj = "";
}

function Operation() {
    this.readCardNum = function () {
        if ($("#cardIDNUM").val().length == 0) {
            alert("填入信息不可为空");
            return;
        }
        initData.CardNum = $("#cardIDNUM").val();
        initOperation.readCardServer(initData.CardNum);
    };

    this.readCardServer = function (cardIDNUM) {
        $.ajax({
            type: "POST",
            url: "../readCardNumToCCARD",
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
        }

        if (obj.length == 0) {
            alert("没有这张卡或卡不可用");
            initOperation.clearInputBox();
        }
    };

    this.ChangeCardtion = function () {
        if (initData.CardNum == "") {
            alert("当前卡尚未读取！");
            return;
        }
        var reg = /^[0-9a-zA-Z]{1,12}$/;
        if (!reg.test($("#ChangeCardNum").val())) {
            alert("输入卡号不符合规则(仅限数字1-12位)");
            return;
        }

        $.ajax({
            type: "POST",
            url: "../changeCard",
            data: {
                "CardNum": initData.CardNum,
                "ChangeCardNum": initData.ChangeCardNum
            },
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    $("#cardIDNUM").val("");
                    initData.CardNum = "";
                    initOperation.clearInputBox();
                    // initOperation.readCardServer(initData.CardNum);
                } else {
                    alert(obj.message);
                }
            },
            error: function (msg) {
                console.log("error");
            }
        });
    }

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

}