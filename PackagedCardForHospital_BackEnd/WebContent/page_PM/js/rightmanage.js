var funsOP = new UserFuns();
var data = new submitData();

$(document).ready(function () {
    //  初始化左面板
    funsOP.initLeftMenu(0);

    // 读取权限按键设置
    funsOP.readPwBtnSet();

    // 保存权限按键设置
    funsOP.saveBtnSet();

    funsOP.powerReader(4);
    // 下方点击
    funsOP.childClick();
});


function UserFuns() {
    this.initLeftMenu = function (ParentID) {
        var url = "../initLeftMenu";
        var data = { "ParentID": ParentID };
        var msg = funsOP.getJSONAjax(url, data);
        var json = JSON.parse(msg);
        if (ParentID == 0) {
            funsOP.CreateFirstLeftPanel(json);
        } else {
            funsOP.CreateSecondLeftPanel(json);
        }
    };

    this.readPwBtnSet = function () {
        $("#roleReadBtn").click(function () {
            $(".pwcbx").each(function () {
                $(this).prop("checked", false);
            });
            data.selectedID = $("#roleRead").val();
            funsOP.powerReader($("#roleRead").val());
        });
    };

    this.saveBtnSet = function () {
        $("#SaveSubBtn").click(function () {
            var UserData = data.makeJSON();
            var url = "../setPWConfig";
            var msg = funsOP.getJSONAjax(url, UserData);
            var obj = JSON.parse(msg);
            if (obj.id == 1) {
                alert(obj.message);
            } else {
                alert(obj.message);
            }
        });
    };

    this.getJSONAjax = function (url, data) {
        var res;
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            async: false,
            success: function (msg) {
                console.log(msg);
                res = msg;
            },
            error: function () {
                console.log("error");
            }
        })
        return res;
    };

    this.CreateFirstLeftPanel = function (obj) {
        for (var i = 0; i < obj.length; i++) {
            $("#left_ul").append("<li class = 'firstMenu'><input type = 'checkbox' mid = " + obj[i].id + " class = 'pwcbxPars pwcbx'><span onclick = 'pointView(this)' class = 'left-first'> " + obj[i].name + "</span>" +
                "<ul id = '" + obj[i].id + "' class = 'secondtMenu'></ul></li>");
            funsOP.initLeftMenu(obj[i].id);
        }
    }
    // 二级菜单
    this.CreateSecondLeftPanel = function (obj) {
        for (var i = 0; i < obj.length; i++) {
            $(".secondtMenu").each(function () {
                $(this).attr("id") == obj[i].uplevelid ?
                    $(this).append("<li><span class = 'leftPanelClick' url = '"
                        + obj[i].url +
                        "'><input type = 'checkbox' mid = "
                        + obj[i].id +
                        "  class = 'pwcbx pwcbxch'>" + obj[i].name + "</span></li>")
                    :
                    true;
            });
        }
    }

    this.powerReader = function (UserID) {
        var url = "../powerReader";
        var data = { "UserID": UserID };
        var msg = funsOP.getJSONAjax(url, data);
        var obj = JSON.parse(msg);
        for (var i = 0; i < obj.length; i++) {
            $(".pwcbx").each(function () {
                if ($(this).attr("mid") == obj[i].idm) {
                    $(this).prop("checked", "true");
                }
            });
        }
    };

    this.childClick = function () {
        $(".pwcbxch").each(function () {
            $(this).click(function () {
                if ($(this).prop("checked")) {
                    var checkBox = this.parentElement.parentElement.parentElement.parentElement.children[0];
                    $(checkBox).prop("checked", true);
                    console.log();
                }
            });
        });

        $(".pwcbxPars").each(function () {
            $(this).click(function () {
                var children = this.parentElement.children[2].children;
                if ($(this).prop("checked") == false) {
                    for (var i = 0; i < children.length; i++) {
                        $(children[i].children[0].children[0]).prop("checked", false);
                    }
                }
            });
        });
    }
}

function submitData() {
    this.selectedID = 4;

    this.makeJSON = function () {
        var json = [];
        $(".pwcbx").each(function () {
            if ($(this).prop("checked")) {
                json.push($(this).attr("mid"));
            }
        });
        var tempJSON = { "roleID": data.selectedID, "jsons": json };
        console.log(tempJSON);
        return tempJSON;
    };
}


// 一级菜单点击显示
function pointView(event) {
    // console.log($(event.children));
    for (var i = 0; i < event.parentElement.children.length; i++) {
        if ($(event.parentElement.children[i]).attr("class") == "secondtMenu") {
            $(event.parentElement.children[i]).css("display") == "none" ? $(event.parentElement.children[i]).css("display", "block")
                : $(event.parentElement.children[i]).css("display", "none");
        }
    }
}