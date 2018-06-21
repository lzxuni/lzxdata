$(function () {
$(".content_left").height($(".content").height()-$(".content_top").height())
$(".content_center").height($(".content_left").height())
$(".content_right").height($(".content_left").height())
})
$(function () {
    var a = $(".spjs_title").height()
    var b = $(".spjs_left").height()
    var c = $(".wz_title").height()
    var d = $(".scqyjs_title").height()
    var e = $(".qszq_title").height()
    var f = $(".qszq_click_left_button").height()


    $(".spjs_title").css("line-height", a+'px');
    $(".spjs_left").css("line-height", b+'px');
    $(".spjs_right").css("line-height", b+'px');
    $(".wz_title").css("line-height", c+'px');
    $(".scqyjs_title").css("line-height", d+'px');
    $(".qszq_title").css("line-height", e+'px');
    $(".qszq_click_left_button").css("line-height", f+'px');
    $(".yuan_all").css("line-height", f+'px');
    $(".yuan_all2").css("line-height", f+'px');

})
    // 第一个时间轴
    $(function () {
        $(".yuan_all .yuan1").css("display","none").eq(0).css("display","block");
        $(".yuan_all .yuan2").eq(0).css("display","none");
        $(".qszq_click_left_button").click(function () {

            $(".yuan_all").eq($(this).index()).children(".yuan1").css("display","block");
            $(".yuan_all").eq($(this).index()).children(".yuan2").css("display","none");

            $(".yuan_all").eq($(this).index()).siblings(".yuan_all").children(".yuan1").css("display","none")
            $(".yuan_all").eq($(this).index()).siblings(".yuan_all").children(".yuan2").css("display","block")

        })
        // 第二个时间轴
        $(".yuan_all2 .yuan1").css("display","none").eq(0).css("display","block");
        $(".yuan_all2 .yuan2").eq(0).css("display","none");
        $(".qszq_click_left_button2").click(function () {

            $(".yuan_all2").eq($(this).index()).children(".yuan1").css("display","block");
            $(".yuan_all2").eq($(this).index()).children(".yuan2").css("display","none");

            $(".yuan_all2").eq($(this).index()).siblings(".yuan_all2").children(".yuan1").css("display","none")
            $(".yuan_all2").eq($(this).index()).siblings(".yuan_all2").children(".yuan2").css("display","block")











            // $(this).siblings(".yuan_all").children(".yuan1").css("display","none")
            // $(this).siblings(".yuan_all").children(".yuan2").css("display","block")


        })
    })
