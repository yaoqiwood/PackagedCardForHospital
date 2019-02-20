var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {
    // 获取籍贯表
    initOperation.getNative();
    // 按键获取监听
    $("#btnSold").click(function () {
        // var NameReg = /^[\u4E00-\u9FA5]{1,4}$/;
        initOperation.newPatient(initData.makeHandInJSON());
    })
    // 获取卡号下拉框
    initOperation.getCardNumData();
});


function data() {
    this.makeHandInJSON = function () {
        var tempJSON = {
            "sold_name": $("#sold_name").val(),
            "sold_age": $("#sold_age").val(),
            "sex": $("#sex").val(),
            "native": $("#native").val(),
            "idNum": $("#idNum").val(),
            "phone": $("#phone").val(),
            "address": $("#address").val(),
            "preStore": $("#preStore").val(),
            "cardNum": ($("#cardNum").val()).toUpperCase()
        }
        console.log(tempJSON);
        return tempJSON;
    };

}

function Operation() {
    //  获得省份obj
    this.getNative = function () {
        $.ajax({
            type: "POST",
            url: "../getNative",
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                initOperation.fillNativeBox(obj);
            },
            error: function (msg) {
                console.log("error");
            }
        });
    }
    //  填入下拉框
    this.fillNativeBox = function (obj) {
        for (var i = 0; i < obj.length; i++) {
            $("#native").append("<option value = '" + obj[i].id + "'>" + obj[i].nativeName + "</option>")
        }
    }
    // 提交数据至服务端
    this.newPatient = function (param) {
        if (!checkInput()) {
            return;
        }
        $.ajax({
            type: "POST",
            url: "../newPatient",
            data: param,
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    $(".space").each(function () {
                        $(this).val("");
                    })
                } else {
                    alert(obj.message);
                }
            },
            error: function (msg) {
                console.log("error");
            }
        });
    }

    this.getCardNumData = function () {
        $.ajax({
            type: "POST",
            url: "../getCardNumData",
            success: function (response) {
                // console.log(response);
                var obj = JSON.parse(response);
                for (var i = 0; i < obj.length; i++) {
                    $("#cardNum").append("<option value = " + obj[i].card_NUM + ">" + obj[i].card_NUM + "</option>");
                }
            }
        });
    }
}

function checkInput() {
    var IDNumReg = /^[0-9X]{18}$/;
    var PhoneReg = /^[0-9]{1,11}$/
    var NumReg = /^[0-9]{1,8}$/
    // var CardNumReg = /^
    var space = $(".space");
    for (var i = 0; i < space.length; i++) {
        if ($(space[i]).val().length == 0) {
            alert("填入数不可为空");
            return false;
        }
    }
    if (!IDNumReg.test($("#idNum").val())) {
        alert("证件号码输入需要符合规则（18位，除X和数字，其余非法）")
        return false;
    }
    if (!PhoneReg.test($("#phone").val())) {
        alert("练习电话需符合规则输入(只能输入数字)");
        return false;
    }

    if (!NumReg.test($("#preStore").val())) {
        alert("金额输入需要符合规则(纯数字1-8位)");
        return false;
    }
    return true;
}


//  检测规范
function checkParams(params, reg, msg) {
    var Params = $(params);
    console.log(Params.length);
    for (var i = 0; i < Params.length; i++) {
        console.log($(Params[i]).val());
        if ($(Params[i]).val().length == 0) {
            alert("信息不可为空");
            return false;
        }
        console.log(i);
        if (!reg.test($(Params[i]).val())) {
            alert(msg);
            return false;
        }
    }
    return true;
}