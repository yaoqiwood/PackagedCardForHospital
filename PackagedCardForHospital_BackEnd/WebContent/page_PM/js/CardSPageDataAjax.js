function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 0; //  行总数

    //  参数
    this.CNStart = "";
    this.CNEND = "";
    this.CSatus = "";
    this.StINDateStart = "";
    this.StINDateEND = "";
    this.StINDateEND = "";


    this.makeSearchJSON = function () {
        var tempJSON = {
            "CNStart": PageData.CNStart,
            "CNEND": PageData.CNEND,
            "CSatus": PageData.CSatus,
            "StINDateStart": PageData.StINDateStart,
            "StINDateEND": PageData.StINDateEND,
            "CurrentPage": PageData.CurrentPage,
            "Limit": PageData.Limit
        };
        return tempJSON;
    };
}





