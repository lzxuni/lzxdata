$(function () {
    $(".content img").click(function () {
        $(".video_mask").css("display","block")

    });
    $(".clos").click(function () {
        $(".video_mask").css("display","none")

    })
    $(".content_img_postion").click(function () {
        $(".float_text").css("display","block")
    })
    $(".close").click(function () {
        $(".float_text").css("display","none")
    })


    $(".content_img_postion").eq(0).css("top","43%");
    $(".content_img_postion").eq(0).css("left","55%");

    $(".content_img_postion").eq(1).css("top","35%");
    $(".content_img_postion").eq(1).css("left","59%");

    $(".content_img_postion").eq(2).css("top","62%");
    $(".content_img_postion").eq(2).css("left","56%");

})