var PageData = new data();
// 数据初始化
var OperationInit = new Operation();
// 操作对象初始化

// 初始化
$(document).ready(function () {
    var tempJSON = {
        "CNStart": PageData.CNStart,
        "CNEND": PageData.CNEND,
        "CSatus": PageData.CSatus,
        "StINDateStart": PageData.StINDateStart,
        "StINDateEND": PageData.StINDateEND,
        "CurrentPage": PageData.CurrentPage,
        "Limit": PageData.Limit
    };
    // 请求刷新表格
    OperationInit.RefreshTable(tempJSON);
    // 请求刷新表页
    OperationInit.FindCountStuTable(tempJSON);


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
        var add_CNStart = $("#add_CNStart").val();
        var add_CNEND = $("#add_CNEND").val();
        var add_Prefix = $("#add_Prefix").val();

        var reg = /^[a-zA-Z0-9\u4E00-\u9FA5]{1,8}$/;
        var regPre = /^[a-zA-Z]{1,4}$/;
        var msg = "填入信息不符合规则(只允许数字，汉字与英文字符)";
        var msgPre = "填入信息不符合规则(只允许英文字符，且限制4位前缀数)";
        if (!checkParams(".addParams",reg,msg) || (!checkParams(".preParams",regPre,msgPre))) {
            return;
        }
        var params = {
            "add_CNStart": add_CNStart,
            "add_CNEND": add_CNEND,
            "add_Prefix": add_Prefix
        };
        OperationInit.AddLineStuTable(params);
    });

    // 搜索按键
    $("#SearchBtn").click(function () {
        PageData.CNStart = $("#CNStart").val();
        PageData.CNEND = $("#CNEND").val();
        PageData.CSatus = $("#CSatus").val();
        PageData.StINDateStart = $("#StINDateStart").val();
        PageData.StINDateEND = $("#StINDateEND").val();
        PageData.CurrentPage = 1;
        PageData.Limit = 5;
        var tempJSON = {
            "CNStart": PageData.CNStart,
            "CNEND": PageData.CNEND,
            "CSatus": PageData.CSatus,
            "StINDateStart": PageData.StINDateStart,
            "StINDateEND": PageData.StINDateEND,
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
        OperationInit.updateInfStu();
    });

});




