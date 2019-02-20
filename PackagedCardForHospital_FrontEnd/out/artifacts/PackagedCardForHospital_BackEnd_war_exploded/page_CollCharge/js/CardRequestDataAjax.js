function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 0; //  行总数

    //  参数
    this.RDateStart = "";
    this.RDateEND = "";
    this.AsseSatus = "";

    //  增加参数
    this.add_requester = "";
    this.add_reqDate = "";
    this.add_reqNum = "";

    //  修改参数
    this.modify_reqNum = "";
    this.modify_id = "";


    this.makeTempJSON = function () {
        var tempJSON = {
            "RDateStart": PageData.RDateStart = $("#RDateStart").val(),
            "RDateEND": PageData.RDateEND = $("#RDateEND").val(),
            "AsseSatus": PageData.AsseSatus = $("#AsseSatus").val(),
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit,
        };
        return tempJSON;
    }

    this.makeAddParamsJSON = function () {
        var params = {
            "add_requester": PageData.add_requester,
            "add_reqDate": PageData.add_reqDate,
            "add_reqNum": PageData.add_reqNum
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





