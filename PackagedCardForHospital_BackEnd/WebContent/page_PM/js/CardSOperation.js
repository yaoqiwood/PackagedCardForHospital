function Operation() {
    //  刷新表格
    this.RefreshTable = function (Conditions) {
        console.log(Conditions);
        $.ajax({
            type: "POST",
            url: "../refreshCStockTable",
            data: Conditions,
            success: function (response) {
                // console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                // 清空表
                $("#table").empty();
                // 刷新表头
                OperationInit.RefreshTableHead();
                // 增加表行
                OperationInit.AddTableLine(obj);
            },
            error: function (response) {
                console.log("error");
            }
        });
    };

    //  刷新表页
    this.RefreshPage = function () {
        console.log(PageData.Limit);
        console.log(PageData.Count);
        var Limit = PageData.Limit;
        var Count = PageData.Count;
        if (Count % Limit == 0) {
            PageData.TotalPage = parseInt(Count / Limit);
        } else {
            PageData.TotalPage = parseInt(Count / Limit + 1);
        }
        if (Count == 0) {
            PageData.TotalPage = 1;
        }
        $("#pageNum").html(PageData.CurrentPage + "/" +
            PageData.TotalPage);
    };

    //  上一页
    this.PreviousPage = function () {
        if (PageData.CurrentPage > 1) {
            PageData.CurrentPage -= 1;
            OperationInit.RefreshPageAndTable();
        }
    };

    //  下一页
    this.NextPage = function () {
        if (PageData.CurrentPage < PageData.TotalPage) {
            PageData.CurrentPage += 1;
            OperationInit.RefreshPageAndTable();
        }
    };

    // 刷新表和表页
    this.RefreshPageAndTable = function () {
        var tempJSON = {
            "CNStart": PageData.CNStart,
            "CNEND": PageData.CNEND,
            "CSatus": PageData.CSatus,
            "StINDateStart": PageData.StINDateStart,
            "StINDateEND": PageData.StINDateEND,
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        OperationInit.RefreshTable(tempJSON);
        OperationInit.RefreshPage();
    };


    // 添加GOODS数据
    this.AddLineStuTable = function (params) {
        $.ajax({
            type: "POST",
            url: "../addCardStocking",
            data: params,
            success: function (response) {
                console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);

                    $(".addPanel").each(function () {
                        $(this).val("");
                    });

                    PageData.CurrentPage = 1;
                    OperationInit.RefreshPageAndTable();
                    OperationInit.FindCountStuTable(PageData.makeSearchJSON());
                    $("#addPanel").css("display", "none");
                    $("#cover").css("display", "none");

                } else {
                    alert(obj.message);
                    location.href = obj.location;
                }

            },
            error: function (response) {
                console.log("error");
            }
        });
    };


    //  增加表列
    this.AddTableLine = function (obj) {
        // console.log(obj);    用户名（模糊）、年龄、学号、性别（显示男女）
        obj.length == 0 ? alert("当前信息为空") : true;
        for (var i = 0; i < obj.length; i++) {
            $("#table").append("<tr id =" + obj[i].id + " >" +
                "<td class='displayNONE'><input class = 'check' type = 'checkbox'> </td>" +
                "<td><span>" + obj[i].id + "</span></td>" +
                "<td><span>" + obj[i].cardPrefix + obj[i].cardNum + "</span></td>" +
                "<td><span>" + obj[i].stockInDate + "</span></td>" +
                "<td status = '" + obj[i].cardStatus + "'><span>" + (obj[i].cardStatus== 0 ? '待领取':'已领取')  + "</span></td>" +
                "<td><input onclick = 'OperationInit.delStuData(this)' type = 'button' value = '删除'></td> " +
                "</tr>");
        }
    };

    //  查询表行
    this.FindCountStuTable = function (Conditions) {
        $.ajax({
            type: "POST",
            url: "../countCStockTable",
            data: Conditions,
            success: function (response) {
                console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                PageData.Count = obj.count;
                OperationInit.RefreshPage();
            },
            error: function (response) {
                console.log("fail");
            }
        });
    };

    //  删除
    this.delAjax = function (gid) {
        $.ajax({
            type: "POST",
            url: "../delSCardTable",
            data: { "delID": gid },
            success: function (response) {
                console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    OperationInit.RefreshPageAndTable();
                } else {
                    alert(obj.message);
                }
            },
            error: function (response) {
                console.log("fail");
            }
        });
    };

    // 删除
    this.delStuData = function (event) {
        var gid = event.parentElement.parentElement.attributes.id.value;
        // console.log(gid);
        // var cno = event.parentElement.parentElement.attributes.cno.value;
        // console.log(event.parentElement.parentElement.attributes.sno.value);
        if (window.confirm("是否要删除？")) {
            OperationInit.delAjax(gid);
        }
    };


    // 修改
    this.modifyStuData = function (event) {
        $("#modifyPanel").css("display", "block");
        $("#cover").css("display", "block");

        $("#modify_uAccount").attr("disabled", "true");

        $("#modify_uAccount").val(event.parentElement.parentElement.children[2].innerText);
        $("#modify_uname").val(event.parentElement.parentElement.children[3].innerText);
        $("#modify_user_department").val($(event.parentElement.parentElement.children[4]).attr("departmentid"));
        $("#modify_user_role").val($(event.parentElement.parentElement.children[5]).attr("roleid"));

        $("#modifyPanel").attr("uid", event.parentElement.parentElement.children[1].innerText);
        console.log(event.parentElement.parentElement.children[1].innerText);
    };

    //  更新操作
    this.updateInfStu = function () {
        var modify_uAccount = $("#modify_uAccount").val();
        var modify_uname = $("#modify_uname").val();
        var modify_user_department = $("#modify_user_department").val();
        var modify_user_role = $("#modify_user_role").val();
        var id = $("#modifyPanel").attr("uid");

        var json = {
            "modify_uAccount": modify_uAccount,
            "modify_uname": modify_uname,
            "modify_user_department": modify_user_department,
            "modify_user_role": modify_user_role,
            "id": id
        };
        $.ajax({
            type: "POST",
            url: "../updateRoleTable",
            data: json,
            success: function (response) {
                console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    PageData.CurrentPage = 1;
                    PageData.RefreshPageAndTable();
                    $("#modifyPanel").css("display", "none");
                    $("#cover").css("display", "none");
                } else {
                    alert(obj.message);
                }
            },
            error: function (response) {
                console.log("fail");
            }
        });
    };

    //  刷新表数据
    this.RefreshTableHead = function () {
        $("#table").append(
            "<tr>" +
            "<td class='displayNONE'><span>选择</span></td>" +
            "<td><span>ID</span></td>" +
            "<td><span>卡号</span></td>" +
            "<td><span>导入日期</span></td>" +
            "<td><span>卡状态</span></td>" +
            "<td><span>操作</span></td>" +
            "</tr>"
        );
    };

    //  更新科室表信息
    this.updateDepartmentName = function () {
        $.ajax({
            type: "POST",
            url: "../updateDepartmentInf",
            success: function (msg) {
                console.log("success");
                console.log(msg);
                var obj = JSON.parse(msg);
                if (obj.length > 0) {
                    $("#sDepartment").empty();
                    $("#add_user_Department").empty();
                    $("#modify_user_department").empty();
                    $("#sDepartment").append("<option></option>");
                    $("#add_user_Department").append("<option></option>");
                    $("#modify_user_department").append("<option></option>");
                }
                for (var i = 0; i < obj.length; i++) {
                    $("#sDepartment").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>")
                    $("#add_user_Department").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>")
                    $("#modify_user_department").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>")
                }
            },
            error: function (msg) {
                console.log("error");
            }
        });
    };

    //  更新角色下拉框
    this.updateRoleInfName = function () {
        $.ajax({
            type: "POST",
            url: "../updateRoleInf",
            success: function (msg) {
                console.log("success");
                console.log(msg);
                var obj = JSON.parse(msg);
                if (obj.length > 0) {
                    $("#sRole").empty();
                    $("#add_user_role").empty();
                    $("#modify_user_role").empty();
                    $("#sRole").append("<option></option>");
                    $("#add_user_role").append("<option></option>");
                    $("#modify_user_role").append("<option></option>");
                }
                for (var i = 0; i < obj.length; i++) {
                    $("#sRole").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>>");
                    $("#add_user_role").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>>");
                    $("#modify_user_role").append("<option value='" + obj[i].id + "'>" + obj[i].name + "</option>>");
                }
            },
            error: function (msg) {
                console.log("error")
            }
        })
    };

    //  禁用与恢复操作
    this.banOrNot = function (event) {
        // console.log($(event.parentElement.parentElement).attr("id"));
        var ID = $(event.parentElement.parentElement).attr("id");
        if (confirm("确认要如此操作？")) {
            var data = { "ban": event.value == "禁用" ? 0 : 1, "ID": ID };
            $.ajax({
                type: "POST",
                url: "../banornot",
                data: data,
                success: function (msg) {
                    console.log("success");
                    console.log(msg);
                    var obj = JSON.parse(msg);
                    obj.id == 1 ? alert(obj.message) : alert(obj.message);
                    OperationInit.RefreshPageAndTable();
                },
                error: function (msg) {
                    console.log("error");
                }
            });
        }
    }

    // 重置密码操作
    this.resetPWD = function (event) {
        var ID = $(event.parentElement.parentElement).attr("id");
        if (confirm("确认要如此操作？")) {
            var data = { "resetID": ID };
            $.ajax({
                type: "POST",
                url: "../resetPWD",
                data: data,
                success: function (response) {
                    console.log("success");
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
};

//  检测规范
function checkParams(params,reg,msg) {
    var Params = $(params);
    console.log(Params.length);
    for (var i = 0; i < Params.length; i++){
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