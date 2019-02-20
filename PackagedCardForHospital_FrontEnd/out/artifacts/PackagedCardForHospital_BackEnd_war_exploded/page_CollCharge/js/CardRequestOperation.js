function Operation() {
    //  刷新表格
    this.RefreshTable = function (Conditions) {
        console.log(Conditions);
        $.ajax({
            type: "POST",
            url: "../refreshReqCardTable",
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
            "sName": PageData.sName,
            "sDepartment": PageData.sDepartment,
            "uregisterTime": PageData.uregisterTime,
            "sRole": PageData.sRole,
            "sState": PageData.sState,
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        OperationInit.RefreshTable(PageData.makeTempJSON());
        OperationInit.RefreshPage();
    };


    // 添加GOODS数据
    this.AddLineStuTable = function (params) {
        $.ajax({
            type: "POST",
            url: "../addRequestData",
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
                    $("#addPanel").css("display", "none");
                    $("#cover").css("display", "none");
                    // 请求获取当前用户名
                    OperationInit.viewRequestorName();
                } else {
                    alert(obj.message);
                    // location.href = obj.location;
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
        for (var i = 0; i < obj.length; i++) {
            var str = obj[i].arvl_STATE == 0 ? "<input onclick = 'OperationInit.modifyStuData(this)' type = 'button' value = '修改'>" :
                "";
            $("#table").append("<tr id =" + obj[i].arvl_ID + " >" +
                "<td class='displayNONE'><input class = 'check' type = 'checkbox'> </td>" +
                "<td><span>" + obj[i].arvl_ID + "</span></td>" +
                "<td><span>" + obj[i].arvl_CTIME + "</span></td>" +
                "<td><span>" + obj[i].arvl_REQUESTNUM + "</span></td>" +
                "<td><span>" + obj[i].arvl_CORID + "</span></td>" +
                "<td status = '" + obj[i].arvl_STATE + "'><span>" + (obj[i].arvl_STATE == 0 ? '待审核' : '已审核') + "</span></td>" +
                "<td status = '" + (obj[i].arvl_MID == "null" ? "" : obj[i].arvl_MID) + "'></td>" +
                "<td><span>"+obj[i].arvl_MID+"</span></td>" +
                "<td status = '" + obj[i].arvl_ATIME + "'>+ obj[i].arvl_ATIME +</td>" +
                "<td>" + str + "</td> " +
                "</tr>");
        }
    };

    //  查询表行
    this.FindCountStuTable = function (Conditions) {
        $.ajax({
            type: "POST",
            url: "../countReqCardTable",
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
            data: {"delID": gid},
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

        $("#modify_reqDate").val(event.parentElement.parentElement.children[2].innerText);

        $("#modify_reqNum").val(event.parentElement.parentElement.children[3].innerText);

        $("#modifyPanel").attr("uid", event.parentElement.parentElement.children[1].innerText);
        console.log(event.parentElement.parentElement.children[1].innerText);
    };

    //  更新操作
    this.updateInfStu = function () {
        PageData.modify_reqNum = $("#modify_reqNum").val();
        PageData.modify_id = $("#modifyPanel").attr("uid");
        var json = PageData.makeModifyParamsJSON();
        $.ajax({
            type: "POST",
            url: "../updateReqCardTable",
            data: json,
            success: function (response) {
                console.log("success");
                console.log(response);
                var obj = JSON.parse(response);
                if (obj.id == 1) {
                    alert(obj.message);
                    PageData.CurrentPage = 1;
                    OperationInit.RefreshPageAndTable();
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
            "<td><span>申请日期</span></td>" +
            "<td><span>申请卡数量</span></td>" +
            "<td><span>申请人</span></td>" +
            "<td><span>申请状态</span></td>" +
            "<td><span>审核人</span></td>" +
            "<td><span>审核时间</span></td>" +
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
            var data = {"ban": event.value == "禁用" ? 0 : 1, "ID": ID};
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
            var data = {"resetID": ID};
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

    //  查询当前申请人姓名
    this.viewRequestorName = function (param) {
        $("#add_requester").attr("disabled", "true");
        $("#add_reqDate").attr("disabled", "true");
        $("#add_requester").val("");

        $("#modify_requester").attr("disabled", "true");
        $("#modify_reqDate").attr("disabled", "true");
        $("#modify_requester").val("");


        $.ajax({
            type: "POST",
            url: "../viewRequestorName",
            success: function (response) {
                console.log("success");
                var obj = JSON.parse(response);
                console.log(obj);
                if (obj.id == 1) {
                    $("#add_requester").val(obj.username);
                    $("#modify_requester").val(obj.username);
                } else {
                    alert(obj.message);
                    // location.href = "../index.jsp";
                }
            },
            error: function (response) {
                console.log("error");
            }
        });
    };

    //  获取当前时间
    this.getDateNow = function () {
        var myDate = new Date();
        var nowDate = myDate.getFullYear() + "年" + (myDate.getMonth() + 1) + "月" + (myDate.getDate()) + "日";
        return nowDate;
    }


}