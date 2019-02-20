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
    this.app_requester = "";
    this.app_reqDate = "";
    this.app_reqNum = "";
    this.app_appNum = "";

    //  修改参数
    // this.app_requester = "";
    // this.app_reqDate = "";
    // this.app_reqNum = "";
    // this.app_requester = "";
    // this.app_date = "";
    // this.app_cardNums = "";

    this.makeTempJSON = function () {
        var tempJSON = {
            "S_Requester": PageData.S_Requester = $("#S_Requester").val(),
            "S_Status": PageData.S_Status = $("#S_Status").val(),
            "S_Date_Start": PageData.S_Date_Start = $("#S_Date_Start").val(),
            "S_Date_End": PageData.S_Date_End = $("#S_Date_End").val(),
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        return tempJSON;
    }

    this.makeAddParamsJSON = function () {
        var params = {
            "app_requester": PageData.app_requester = $("#app_requester").val(),
            "app_reqDate": PageData.app_reqDate = $("#app_reqDate").val(),
            "app_reqNum": PageData.app_reqNum = $("#app_reqNum").val(),
            "app_appNum": PageData.app_appNum = $("#app_appNum").val(),
            "app_IDNUM": $("#addPanel").attr("aid")
        };
        return params;
    }

    this.makeModifyParamsJSON = function () {
        var json = {
            "modify_reqNum": PageData.modify_reqNum,
            "modify_id": PageData.modify_id
        };
        return json;
    }
}





