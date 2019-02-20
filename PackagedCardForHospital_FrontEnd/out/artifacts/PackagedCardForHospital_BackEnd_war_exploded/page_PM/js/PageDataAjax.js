function data() {
    this.CurrentPage = 1;
    this.TotalPage = 0;
    this.Limit = 5;
    this.Count = 0; //  行总数

    //  参数  
    this.sName = "";
    this.sDepartment = "";
    this.uregisterTime = "";
    this.sRole = "";
    this.sState = "";


}


function IsString(str) {
    if (str.length != 0) {
        reg = /^[a-zA-Z0-9_]+$/;
        if (!reg.test(str)) {
            alert("请输入英文或者数字!");//请将“字符串类型”要换成你要验证的那个属性名称！
            return false
        } else {
            return true;
        }
    }
}




