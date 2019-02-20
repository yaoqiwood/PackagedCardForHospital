var initData = new data();

var initOperation = new Operation();

$(document).ready(function () {
    // 获取籍贯表
    initOperation.getNative();
    // 按键获取监听
    $("#btnSold").click(function() {
        initOperation.newPatient(initData.makeHandInJSON());
    })
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
            "cardNum":$("#cardNum").val()
        }
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
        $.ajax({
            type: "POST",
            url: "../newPatient",
            data: param,
            success: function (response) {
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
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