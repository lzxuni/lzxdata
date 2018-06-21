$(function() {
    var html = "";
    // 添加 5 行
    for(var r = 0; r <8; r++) {
        html += "<div class='button_click'></div>";
    }
    $(".footer_all").append(html);
});



$(function () {
    // 导航栏链接

        // 物联网基地
    $(".button_click").eq(0).wrapInner("<a href='index.html?"+(new Date().getTime())+"'>物联网基地</a>")
        // 精准农业
    $(".button_click").eq(1).wrapInner("<a href='jzny.html?"+(new Date().getTime())+"'>精准农业</a>")
        // 质量追溯
    $(".button_click").eq(2).wrapInner("<a href='zlzs.html?"+(new Date().getTime())+"'>质量追溯</a>")
        // 实时视频
    $(".button_click").eq(3).wrapInner("<a href='wlwjd.html?"+(new Date().getTime())+"'>实时视频</a>")
        //专家问答
    $(".button_click").eq(4).wrapInner("<a href='zjwd.html?"+(new Date().getTime())+"'>专家问答</a>")
        //虫情检测
    $(".button_click").eq(5).wrapInner("<a href='cqjc.html?"+(new Date().getTime())+"'>虫情检测</a>")
        // 农业百科
    $(".button_click").eq(6).wrapInner("<a href='nybk.html?"+(new Date().getTime())+"'>农业百科</a>")
        //农业大数据
    $(".button_click").eq(7).wrapInner("<a href='nydsj.html?"+(new Date().getTime())+"'>农业大数据</a>")


});
$(function () {
    
    $(function () {
        $(".button_click a").click(function() {
            var i=$(this).parent().index();/*下标*/
            // alert(i)
            var this_url = $(this).attr("href"); //抓取当前url
            // alert(this_url)

            var New_url = this_url +'&shareid='+ i;  //把当前url后拼接 一个参数shareid
            // alert(New_url)

            $(this).attr("href",New_url);  //改变当前a的href值


        } )

    })
    
})
$(function () {

    var New_url = window.location.href
    var click_number = New_url.charAt(New_url.length - 1)

    $(".button_click").eq(click_number).css({backgroundColor:"#43D3FF"})
    $(".button_click").eq(click_number).children("a").css({color:"#1921BB"})


})
// height
$(function () {
    var i= $(window).height();
    $(".content_all").height(i-$(".top_all").height()-50);
    $(".left_one_echarts").height($(".left_one").height()-50);

});


