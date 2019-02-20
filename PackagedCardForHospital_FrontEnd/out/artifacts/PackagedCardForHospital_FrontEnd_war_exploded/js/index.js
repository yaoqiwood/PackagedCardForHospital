var operation = new cardOperation();

$(document).ready(function () {
    $("#caption").fadeOut(1000);
    $("#caption").fadeIn(2000);
    var cation = setInterval(function () {
        $("#caption").fadeOut(1000);
        $("#caption").fadeIn(2000);
    }, 4000);


    $("#caption_Start").click(function (event) {
        event.currentTarget.style.display = "none";
        $("#menu_buttons_inner").show(1000);
        clearInterval(cation);
    })

    $("#cardTopUp").click(function () {
        // 充值框
        operation.cardTopUp();
    });

    $("#cardAccCheck").click(function () {
        // 充值框
        operation.cardAccCheck();
    });

    $("#cardReg").click(function () {
        // 挂号框
        operation.cardReg();
    });

    $("#cardGetNum").click(function () {
        // 取号框
        operation.cardGetNum();
    });

    $("#iconClose").click(function () {
        operation.boxFadeOut();
    });
});

function cardOperation() {
    this.cardTopUp = function () {
        operation.boxFadeIn();
        $("#view-box-frame").attr("src","./card_TopUp/cardTopUp.jsp");
    };

    this.cardAccCheck = function () {
        operation.boxFadeIn();
        $("#view-box-frame").attr("src","./card_AccCheck/card_AccCheck.jsp");
    };

    this.cardReg = function () {  
        operation.boxFadeIn();
        $("#view-box-frame").attr("src", "./card_Appointment/card_Appointment.jsp");
    }

    this.cardGetNum = function () {
        operation.boxFadeIn();
        $("#view-box-frame").attr("src", "./cardOfferNumber/cardOfferNumber.jsp");
    };

    //  淡出
    this.boxFadeOut = function () {
        var view_box = $(".view-box");
        $(view_box[0]).fadeOut();
    };

    //  淡入 
    this.boxFadeIn = function () {
        var view_box = $(".view-box");
        $(view_box[0]).fadeIn();
    };

}