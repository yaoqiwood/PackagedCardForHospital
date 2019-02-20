var PageData = new data();
// 数据初始化
var OperationInit = new Operation();
// 操作对象初始化

// 初始化
$(document).ready(function () {
    var tempJSON = {
        "sName": PageData.sName,
        "sDepartment": PageData.sDepartment,
        "sRole": PageData.sRole,
        "sState": PageData.sState,
        "CurrentPage": PageData.CurrentPage,
        "Limit": PageData.Limit
    };
    // 请求刷新表格
    OperationInit.RefreshTable(tempJSON);
    // 请求刷新表页
    OperationInit.FindCountStuTable(tempJSON);
    // 请求刷新科室信息
    OperationInit.updateDepartmentName();
    // 请求刷新角色信息
    OperationInit.updateRoleInfName();

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
        $("#addPanel").css("display", "block");
        $("#cover").css("display", "block");
    });
    // 取消显示面板
    $("#add_cancel").click(function () {
        $("#addPanel").css("display", "none");
        $("#cover").css("display", "none");
    });

    // 增加行确认                <!--  人员姓名    密码  确认密码  科室  角色   -->
    $("#add_confirm").click(function () {
        var add_uAccount = $("#add_uAccount").val();
        var add_uname = $("#add_uname").val();
        var add_user_Password = $("#add_user_Password").val();
        var add_user_PasswordDouble = $("#add_user_PasswordDouble").val();
        var add_user_Department = $("#add_user_Department").val();
        var add_user_role = $("#add_user_role").val();

        if (!checkParams(".addParams")) { 
            return;
        }
        if (add_user_Password != add_user_PasswordDouble) {
            alert("密码与确认密码不一致");
            return;
        }
        var params = {
            "add_uAccount": add_uAccount,
            "add_uname": add_uname,
            "add_user_Password": add_user_Password,
            "add_user_PasswordDouble": add_user_PasswordDouble,
            "add_user_Department": add_user_Department,
            "add_user_role": add_user_role
        };
        OperationInit.AddLineStuTable(params);
    });

    // 搜索按键
    $("#SearchBtn").click(function () {
        PageData.sName = $("#sName").val();
        PageData.sDepartment = $("#sDepartment").val();
        PageData.sRole = $("#sRole").val();
        PageData.sState = $("#sState").val();

        PageData.CurrentPage = 1;
        var tempJSON = {
            "sName": PageData.sName,
            "sDepartment": PageData.sDepartment,
            "sRole": PageData.sRole,
            "sState": PageData.sState,
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        // 请求刷新表格
        OperationInit.RefreshTable(tempJSON);
        // 请求刷新表页
        OperationInit.FindCountStuTable(tempJSON);
    });

    // 隐藏修改框
    $("#modify_cancel").click(function () {
        $("#modifyPanel").css("display", "none");
        $("#cover").css("display", "none");
    });

    // 修改提交
    $("#modify_confirm").click(function () {
        var check = $(".moParams");
        for (var i = 0; i < check.length; i++) {
            if ($(check[i]).val().length == 0) {
                alert("信息不可为空");
                return;
            }
        }
        OperationInit.updateInfStu();
    });

});




