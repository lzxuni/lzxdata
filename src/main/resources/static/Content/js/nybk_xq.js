$(function () {
    var h=$(".xq_title").height()
    $(".xq_title").css("line-height",h+"px")

    var a=$(".xq_other").height()
    $(".xq_other").css("line-height",a+"px")

    var b=$(".xq_content").width()

    var c=b-50


    $(".xq_content_hidden").width(c)
})