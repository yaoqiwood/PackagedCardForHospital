$(document).ready(function () {
    // 登录检测
    loginOrNot();
    // 初始化左侧面板
    initLeftPanel(0);
});


// 初始化左侧面板
function initLeftPanel(ParentID) {
    $.ajax({
        type: "POST",
        url: "../initLeftPanel",
        data: {"ParentID": ParentID},
        success: function (response) {
            console.log("success");
            console.log(response);
            var obj = JSON.parse(response);
            if (ParentID == 0) {
                CreateFirstLeftPanel(obj);

            } else {
                CreateSecondLeftPanel(obj);
            }

        },
        error: function (msg) {
            console.log("error");
        }
    });
}

function loginOrNot() {
    $.ajax({
        type: "POST",
        url: "../loginOrNot",
        success: function (msg) {
            var obj = JSON.parse(msg);
            if (obj.id == 0) {
                alert(obj.message);
                location.href = obj.location;
            }
        }
    })
}

function CreateFirstLeftPanel(obj) {
    for (var i = 0; i < obj.length; i++) {
        $("#left_ul").append("<li class = 'firstMenu'><span onclick = 'pointView(this)' class = 'left-first'>" + obj[i].name + "</span>" +
            "<ul id = '" + obj[i].id + "' class = 'secondtMenu'></ul></li>");
        initLeftPanel(obj[i].id);
    }
}

// 二级菜单
function CreateSecondLeftPanel(obj) {
    for (var i = 0; i < obj.length; i++) {
        $(".secondtMenu").each(function () {
            $(this).attr("id") == obj[i].uplevelid ?
                $(this).append("<li><span class = 'leftPanelClick' url = '" + obj[i].url + "'>" + obj[i].name + "</span></li>")
                :
                true;
        });
    }
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
    // 左侧面板点击
    clickLeftPanel();
}

function clickLeftPanel() {
    $(".leftPanelClick").each(function () {
        $(this).click(function (event) {
            // console.log(event.target);
            $("#right").attr("src", $(event.target).attr("url"));
        });
    });
}

// 登出
var LogOut = function () {
    // 暂时 以后做servlet
    $.ajax({
        type: "POST",
        url: "../managerLogout",
        success: function (msg) {
            var obj = JSON.parse(msg);
            if (obj.id == 1) {
                alert(obj.message);
                location.href = obj.location;
            } else {
                alert(obj.message);
            }
        }
    });
};