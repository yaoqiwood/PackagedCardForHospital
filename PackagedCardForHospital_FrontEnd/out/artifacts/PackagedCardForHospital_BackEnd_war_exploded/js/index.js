var data = new User_data();

$(document).ready(function () {
    $("#LoginButton").click(function (event) {
        var username = $("#username").val();
        var password = $("#password").val();
        var code = $("#code").val();
        if (username == "" || password == "" || code == "") {
            alert("信息不可为空");
            return;
        }
        var data = { "username": username, "password": password, "code": code };
        $.ajax({
            type: "POST",
            url: "./loginRequest",
            data: data,
            success: function (msg) {
                console.log("success");
                console.log(msg);
                var obj = JSON.parse(msg);
                if (obj.id == 1) {
                    RefreshVerifyIMG();
                    alert(obj.message);
                    location.href = obj.location;
                } else {
                    alert(obj.message);
                    RefreshVerifyIMG();
                }
            },
            error: function (msg) {
                console.log("error");
            }
        });
    });

    //  刷新验证码
    $("#verifyIMG").click(function (event) {
        RefreshVerifyIMG();
    })

    $("#slideShowH1").fadeIn(2000);
    var UserInterval = setInterval(function () {
        $("#slideShowH1").fadeOut(2000);
        setTimeout(function () {
            $("#slideShowH1").html(data.lineData[data.times]);
            $("#slideShowH1").fadeIn();
        }, 2000);
        data.times = data.times++ == data.lineData.length - 1 ? 0 : data.times;
    },4000);
});

function RefreshVerifyIMG() {
    $("#verifyIMG").attr("src", "./code?data = " + new Date());
}

function User_data() {
    this.lineData = new Array("欢迎使用后台管理系统", "注意验证码的输入区分", "登录前请检查信息是否正确");
    this.times = 0;
};