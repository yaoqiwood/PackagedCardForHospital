var PageData = new data();
// 数据初始化
var OperationInit = new Operation();
// 操作对象初始化

// 初始化
$(document).ready(function () {
    // 请求刷新表格
    OperationInit.RefreshTable(PageData.makeRefreshJSON());
    // 请求刷新表页
    OperationInit.FindCountStuTable(PageData.makeRefreshJSON());
    // 请求获取当前用户名
    OperationInit.viewRequestorName();
    // 获取申请人下拉框信息
    OperationInit.getRequestorInf();


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

    // 增加行确认                <!--  人员姓名    密码  确认密码  科室  角色   -->
    $("#add_confirm").click(function () {
        var reg = /^[0-9]{1,4}$/;
        var msg = "仅限数字(1-4位)";
        if (!checkParams(".addParams", reg, msg)) {
            return;
        } else if (parseInt($("#app_reqNum").val()) < parseInt($("#app_appNum").val())) {
            alert("数量不可大过申请数量");
            return;
        }
        console.log(PageData.makeAddParamsJSON());
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




