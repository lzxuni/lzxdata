$(function () {
    $(".zj_img_left").css("margin-top","-50px")
    $(".zj_img_right").css("margin-top","-50px");
    $(".zj_bottom_right img").click(function () {
        $(this).parent().next("div").css("color","red")
    })
    var q=$(".zj_img_box").width()+20
    var w=$(".zj_img_box").last().index()+2
    // alert(q)
    // alert(w)
    // alert()
    $(".zj_img_box_all").width(q*w)
    // alert($(".zj_img_box_all").width( ))






    var a=$(".zj_img_box").last().index()+1;
    // alert(a)
    var b=a*2
    var c=a-b+6
    var x= $(".zj_img_box").width()
    var i=0;

    $('.zj_img_left').click(function(){
        i++;
        left();
    });
    $('.zj_img_right').click(function(){
        i--;
        right();

    });

    function left(){
        if(i > 0){
            i=0;
            alert("没有专家了")

        }
        else{
            $(".zj_img_box_all").css("margin-left",i*x+10)

        }
    }
    function right(){
        if(i<c){
            i=c;
            alert("没有专家了")

        }
        else{

            $(".zj_img_box_all").css("margin-left",i*x+10)

        }
    }






})
// --------------------------分页----------------------------------------


$(function() {
    $("#pagination1").pagination({
        currentPage: 1,
        totalPage: 12,
        callback: function(current) {
            $("#current1").text(current)
        }
    });

    $("#pagination2").pagination({
        currentPage: 3,
        totalPage: 12,
        isShow: false,
        count: 6,
        prevPageText: "< 上一页",
        nextPageText: "下一页 >",
        callback: function(current) {
            $("#current2").text(current)
        }
    });

    $("#pagination3").pagination({
        currentPage: 4,
        totalPage: 16,
        isShow: true,
        count: 7,
        homePageText: "首页",
        endPageText: "尾页",
        prevPageText: "上一页",
        nextPageText: "下一页",
        callback: function(current) {
            $("#current3").text(current)
        }
    });

    $("#getPage").on("click", function() {
        var info = $("#pagination3").pagination("getPage");
        alert("当前页数：" + info.current + ",总页数：" + info.total);
    });

    $("#setPage").on("click", function() {
        $("#pagination3").pagination("setPage", 1, 10);
    });
});


