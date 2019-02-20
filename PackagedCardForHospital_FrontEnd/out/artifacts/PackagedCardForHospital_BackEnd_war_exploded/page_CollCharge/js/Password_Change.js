var data = new user_DATA();
var Funs = new User_FUNS();


$(document).ready(function () {
    $("#submit").click(function () {
        var new_PWD = $("#new_PWD").val();
        var new_PWDCON = $("#new_PWDCON").val();
        new_PWD == new_PWDCON ? Funs.changePWD() : alert("新密码不相同，请确认后输入");


    });
});

function user_DATA() {
    this.submitFun = function () {
        var data = {
            "used_PWD": $("#used_PWD").val(),
            "new_PWD": $("#new_PWD").val()
        };
        return data;
    }
}

function User_FUNS() {
    this.ajaxSendData = function (url, data) {
        var msg;
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            async: false,
            success: function (response) {
                console.log(response);
                msg = response;
            },
            error: function (msg) {
                console.log("error");
            }
        });
        return msg;
    }

    this.changePWD = function () {
        var url = "../changePWD";
        var msg = Funs.ajaxSendData(url,data.submitFun());
        var obj = JSON.parse(msg);
        if (obj.id == 0) {
            alert(obj.message);
        } else {
            alert(obj.message);
        }
    }
};