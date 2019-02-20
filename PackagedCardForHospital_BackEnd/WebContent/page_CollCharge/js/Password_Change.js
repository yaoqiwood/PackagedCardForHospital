var data = new user_DATA();
var Funs = new User_FUNS();


$(document).ready(function () {
    $("#submit").click(function () {
        var reg = /^[0-9a-zA-Z]{1,12}$/
        if ($("#used_PWD").val().length == 0 || $("#new_PWD").val().length == 0 || $("#new_PWDCON").val().length == 0) {
            alert("填入信息不可为空");
            return
        }
        if ((!reg.test($("#used_PWD").val())) || (!reg.test($("#new_PWD").val())) || (!reg.test($("#new_PWDCON").val()))) {
            alert("填入信息需符合规范（仅数字，英文大小写以及1-12位）");
            return;
        }

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
        var msg = Funs.ajaxSendData(url, data.submitFun());
        var obj = JSON.parse(msg);
        if (obj.id == 0) {
            alert(obj.message);
            $(".PWD").each(function () {
                $(this).val("");
            });
        } else {
            alert(obj.message);
            $(".PWD").each(function () {
                $(this).val("");
            });
        }
    }


};