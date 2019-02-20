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
        $("#add_reqDate").val(OperationInit.getDateNow());
    });
    // 取消显示面板
    $("#add_cancel").click(function () {
        $("#addPanel").css("display", "none");
        $("#cover").css("display", "none");
    });

    // 增加行确认                <!--  人员姓名    密码  确认密码  科室  角色   -->
    $("#add_confirm").click(function () {
        PageData.add_requester = $("#add_requester").val();
        PageData.add_reqDate = $("#add_reqDate").val();
        PageData.add_reqNum = $("#add_reqNum").val();

        if (PageData.add_requester == "" || PageData.add_reqDate == "" || PageData.add_reqNum == "" ) {
            alert("信息不可为空");
            return;
        }
        console.log(PageData.makeAddParamsJSON());
        OperationInit.AddLineStuTable(PageData.makeAddParamsJSON());

    });

    // 搜索按键
    $("#SearchBtn").click(function () {       
        PageData.CurrentPage = 1;
        PageData.Limit = 5;
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




