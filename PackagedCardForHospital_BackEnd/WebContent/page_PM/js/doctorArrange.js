var PageData = new data();
// 数据初始化
var OperationInit = new Operation();
// 操作对象初始化

// 初始化
$(document).ready(function () {

    // 请求刷新表格
    OperationInit.RefreshTable(PageData.makeTempJSON());
    // 请求刷新表页
    OperationInit.FindCountStuTable(PageData.makeTempJSON());
    // 请求获取当前用户名
    OperationInit.viewRequestorName();
    // 填充可选医生名
    OperationInit.getSelectDoctorsName();

    // 下一页
    $("#nextPage").click(function () {
        OperationInit.NextPage();
    });
    // 上一页
    $("#previousPage").click(function () {
        OperationInit.PreviousPage();
    });

    // 全选
    $("#allCheck").click(function () {
        $(".check").each(function () {
            console.log($(this).prop('checked'));
            $(this).prop('checked', $("#allCheck").prop('checked'));
        });
    });
    // 增加显示面板
    $("#viewAddBtn").click(function () {
        // OperationInit.showAddPanel();
        $("#addPanel").css("display", "block");
        $("#cover").css("display", "block");
        $("#add_reqDate").val(OperationInit.getDateNow());
    });
    // 取消显示面板
    $("#add_cancel").click(function () {
        $("#addPanel").css("display", "none");
        $("#cover").css("display", "none");
    });

    // <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
    $("#add_confirm").click(function () {
        OperationInit.AddLineStuTable(PageData.makeAddParamsJSON());
    });

    // 搜索按键
    $("#SearchBtn").click(function () {
        PageData.CurrentPage = 1;
        // 请求刷新表格
        OperationInit.RefreshTable(PageData.makeTempJSON());
        // 请求刷新表页
        OperationInit.FindCountStuTable(PageData.makeTempJSON());
    });

    // 隐藏修改框
    $("#modify_cancel").click(function () {
        $("#modifyPanel").css("display", "none");
        $("#cover").css("display", "none");
    });

    // 修改提交
    $("#modify_confirm").click(function () {
        OperationInit.updateInfStu();
    });

});




function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 0; //  行总数

    //  参数
    this.S_Requester = "";
    this.S_Status = "";
    this.S_Date_Start = "";
    this.S_Date_End = "";

    //  增加参数
    this.doctorName = "";
    this.arrange_date = "";



    this.makeTempJSON = function () {
        var tempJSON = {
            "sName": $("#sName").val(),
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        return tempJSON;
    }

    this.makeAddParamsJSON = function () {
        var params = {
            "doctorName": PageData.doctorName = $("#doctorName").val(),
            "arrange_date": PageData.arrange_date = $("#arrange_date").val(),
        };
        console.log(params);
        if ($("#doctorName").val() == "" || $("#arrange_date").val() == "") {
            alert("信息不可为空");
            return;
        }
        return params;
    }

    this.makeModifyParamsJSON = function () {
        var json = {
            "aid": $("#modifyPanel").attr("aid"),
            "modify_date": $("#modify_date").val()
        };
        return json;
    }
}



function Operation() {
    // 通用ajax
    this.ajaxGetJSON = function (url, data) {
        var msg;
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            async: false,
            success: function (response) {
                msg = response;
                console.log(response);
            },
            error: function (msg) {
                console.log("error");
            }
        });
        return msg;
    }



    this.getSelectDoctorsName = function () {
        var url = "../getSelectDoctorsName";
        var obj = JSON.parse(OperationInit.ajaxGetJSON(url, null));
        for (var i = 0; i < obj.length; i++) {
            $("#doctorName").append("<option value = " + obj[i].id + ">" + obj[i].name + "</option>");
        }
    }

    // 刷新表格
    this.RefreshTable = function (Conditions) {
        console.log(Conditions);
        var url = "../refreshArrTable";
        var msg = OperationInit.ajaxGetJSON(url, Conditions);
        var obj = JSON.parse(msg);
        // 清空表
        $("#table").empty();
        // 刷新表头
        OperationInit.RefreshTableHead();
        // 增加表行
        OperationInit.AddTableLine(obj);

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
        OperationInit.RefreshTable(tempJSON);
        OperationInit.RefreshPage();
    };


    // 添加GOODS数据
    this.AddLineStuTable = function (params) {
        var url = "../addArrData";
        var msg = OperationInit.ajaxGetJSON(url, params);
        var obj = JSON.parse(msg);
        if (obj.id == 1) {
            alert(obj.message);

            $(".addPanel").each(function () {
                $(this).val("");
            });

            PageData.CurrentPage = 1;
            OperationInit.RefreshPageAndTable();
            $("#addPanel").css("display", "none");
            $("#cover").css("display", "none");

        } else {
            alert(obj.message);
            // location.href = obj.location;
        }
    };


    //  增加表列
    this.AddTableLine = function (obj) {
        obj.length == 0 ? alert("当前信息为空") : true;
        // console.log(obj);    用户名（模糊）、年龄、学号、性别（显示男女）
        for (var i = 0; i < obj.length; i++) {
            $("#table").append("<tr id =" + obj[i].id + " >" +
                "<td class='displayNONE'><input type = 'checkbox'> </td>" +
                "<td><span>" + obj[i].id + "</span></td>" +
                "<td><span>" + obj[i].doctor + "</span></td>" +
                "<td><span>" + obj[i].department + "</span></td>" +
                "<td><span>" + obj[i].atime + "</span></td>" +
                "<td>" +
                "<input onclick = 'OperationInit.delStuData(this)' type = 'button' value = '删除' >" +
                "<input onclick = 'OperationInit.modifyStuData(this)' type = 'button' value = '修改' >" +
                "</td > " +
                "</tr>");
        }
    };

    //  查询表行
    this.FindCountStuTable = function (Conditions) {
        var url = "../countArrTable";
        var msg = OperationInit.ajaxGetJSON(url, Conditions);
        var obj = JSON.parse(msg);
        PageData.Count = obj.count;
        OperationInit.RefreshPage();
    };

    //  删除
    this.delAjax = function (gid) {
        var url = "../delArrTable";
        var data = { "aid": gid };
        var msg = OperationInit.ajaxGetJSON(url, data);
        var obj = JSON.parse(msg);
        if (obj.id == 1) {
            alert(obj.message);
            OperationInit.RefreshPageAndTable();
        } else {
            alert(obj.message);
        }
    };

    // 删除
    this.delStuData = function (event) {
        var gid = event.parentElement.parentElement.attributes.id.value;
        console.log(gid);
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

        $("#modify_uname").val($(event.parentElement.parentElement.children[2].children[0]).html());
        $("#modify_uname").attr("disabled", "true");
        $("#modify_department").val($(event.parentElement.parentElement.children[3].children[0]).html());
        $("#modify_department").attr("disabled", "true");
        $("#modify_date").val($(event.parentElement.parentElement.children[4].children[0]).html());
        $("#modifyPanel").attr("aid", $(event.parentElement.parentElement.children[1].children[0]).html());
        // //  获取卡号
        // OperationInit.viewCardNumGroup($(event.parentElement.parentElement.children[1].children[0]).html());

        // $("#modify_reqDate").val(OperationInit.getDateNow());

        // $("#modify_reqNum").val(event.parentElement.parentElement.children[3].innerText);


        // $("#modifyPanel").attr("uid", event.parentElement.parentElement.children[1].innerText);
        // console.log(event.parentElement.parentElement.children[1].innerText);
    };

    //  更新操作
    this.updateInfStu = function () {
        // PageData.modify_reqNum = $("#modify_reqNum").val();
        // PageData.modify_id = $("#modifyPanel").attr("uid");
        var json = PageData.makeModifyParamsJSON();
        var url = "../updateArrTable";
        var msg = OperationInit.ajaxGetJSON(url, json);
        var obj = JSON.parse(msg);
        if (obj.id == 1) {
            alert(obj.message);
            PageData.CurrentPage = 1;
            OperationInit.RefreshPageAndTable();
            $("#modifyPanel").css("display", "none");
            $("#cover").css("display", "none");
        } else {
            alert(obj.message);
        }
    };

    // <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->

    //  刷新表数据
    this.RefreshTableHead = function () {
        $("#table").append(
            "<tr>" +
            "<td class = 'displayNONE'><span>选择</span></td>" +
            "<td><span>ID</span></td>" +
            "<td><span>医生</span></td>" +
            "<td><span>科室</span></td>" +
            "<td><span>排班时间</span></td>" +
            "<td><span>操作</span></td>" +
            "</tr>"
        );
    };



    //  查询当前申请人姓名
    this.viewRequestorName = function (param) {
        var url = "../viewRequestorName";
        var msg = OperationInit.ajaxGetJSON(url, null);
        var obj = JSON.parse(msg);
        if (obj.id == 1) {
            // $("#add_requester").val(obj.username);
            // $("#modify_requester").val(obj.username);
        } else {
            alert(obj.message);
            // location.href = "../index.jsp";
        }
    }

    //  显示增加面板
    this.showAddPanel = function (event) {
        $("#app_requester").val($(event.parentElement.parentElement.children[3].children[0]).html());
        $("#app_requester").attr("disabled", "true");
        $("#app_reqDate").val($(event.parentElement.parentElement.children[2].children[0]).html());
        $("#app_reqDate").attr("disabled", "true");
        $("#app_reqNum").val($(event.parentElement.parentElement.children[4].children[0]).html());
        $("#app_reqNum").attr("disabled", "true");
        $("#addPanel").attr("aid", $(event.parentElement.parentElement.children[1].children[0]).html());
        $("#addPanel").css("display", "block");
        $("#cover").css("display", "block");
        $("#add_reqDate").val(OperationInit.getDateNow());
    }


    //  获取当前时间
    this.getDateNow = function () {
        var myDate = new Date();
        var nowDate = myDate.getFullYear() + "年" + (myDate.getMonth() + 1) + "月" + (myDate.getDate()) + "日";
        return nowDate;
    }




};



