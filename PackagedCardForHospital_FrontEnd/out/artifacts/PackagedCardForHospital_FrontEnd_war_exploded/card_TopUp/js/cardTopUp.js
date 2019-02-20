var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {
    //  读卡操作
    $("#cardINBtn").click(function () {
        initOperation.readCardNum();
    });

    $("#TopUpBtn").click(function () {
        initData.TopUpMoney = $("#TopUpMoney").val();
        initOperation.TopUpOperation();
    });

});


function data() {
    this.CardNum = "";
    this.TopUpMoney = "";
    this.obj = "";
}

function Operation() {
    this.readCardNum = function () {
        initData.CardNum = $("#cardIDNUM").val();
        initOperation.readCardServer(initData.CardNum);
    };

    this.readCardServer = function (cardIDNUM) {
        $.ajax({
            type: "POST",
            url: "../readCardNum",
            data: {"cardIDNUM": cardIDNUM},
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
    };

    this.TopUpOperation = function () {
        $.ajax({
            type: "POST",
            url: "../topUpCard",
            data: {
                "CardNum": initData.CardNum,
                "TopUpMoney": initData.TopUpMoney
            },
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    initOperation.readCardServer(initData.CardNum);
                } else {
                    alert(obj.message);
                }
            },
            error: function (msg) {
                console.log("error");
            }
        });
    }

}