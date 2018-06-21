$(function () {
    $(".nybk_click").eq(0).children(".three").css("display","block");
    $(".nybk_click").click(function () {
        $(".three").css("display","none")
        $(this).children(".three").css("display","block");

    })
        $(".nybk_click").eq(0).css("background","#0b7bd1").children(".three").css("border-color","rgba(255,255,255,0) rgba(255,255,255,0)   rgba(255,255,255,0)  #0b7bd1");
        $(".nybk_click").eq(1).css("background","#d1a00b").children(".three").css("border-color","rgba(255,255,255,0) rgba(255,255,255,0)   rgba(255,255,255,0)  #d1a00b");
        $(".nybk_click").eq(2).css("background","#15a41f").children(".three").css("border-color","rgba(255,255,255,0) rgba(255,255,255,0)   rgba(255,255,255,0)  #15a41f");
        $(".nybk_click").eq(3).css("background","#e74c3c").children(".three").css("border-color","rgba(255,255,255,0) rgba(255,255,255,0)   rgba(255,255,255,0)  #e74c3c");

})