$(function () {
    var i= $(".content_left_1").height();
    $(".content_left_1_content_all").height(i-50 );
    var a= $(".content_data").height();
    var b= $(".content_left_1_title").height();
    var c= $(".content_right_one_title").height();


    //   文字行高
    $(".content_data_left").css("line-height", a+'px');
    $(".content_data_right").css("line-height", a+'px');
    $(".content_left_1_title").css("line-height", b+'px');
    $(".content_right_one_title").css("line-height", c+'px');


});
//content_right_one_content 的高度



//  content_data_left  中的颜色
$(function () {
    $(".content_data").eq(0).css('border', 'solid 1px #0D96F1');
    $(".content_data").eq(1).css('border', 'solid 1px #0ED844');
    $(".content_data").eq(2).css('border', 'solid 1px #FCBC00');
    $(".content_data").eq(3).css('border', 'solid 1px #F77912');
    $(".content_data").eq(4).css('border', 'solid 1px #DF28EC');
    $(".content_data").eq(5).css('border', 'solid 1px #6E03F6');
    $(".content_data").eq(6).css('border', 'solid 1px #019FD4');
    $(".content_data").eq(7).css('border', 'solid 1px #FCBC00');
    $(".content_data").eq(8).css('border', 'solid 1px #0D96F1');
});

//  content_data_left  中的文字
$(function () {
    $(".content_data_left").eq(0).css('background','#0D96F1').html("风向").next(".content_data_right").html("西南风");
    $(".content_data_left").eq(1).css('background','#0ED844').html("风速").next(".content_data_right").html("4m/s");
    $(".content_data_left").eq(2).css('background','#FCBC00').html("雨量").next(".content_data_right").html("500mm/min");
    $(".content_data_left").eq(3).css('background','#F77912').html("空气温度").next(".content_data_right").html("12°C");
    $(".content_data_left").eq(4).css('background','#DF28EC').html("空气湿度").next(".content_data_right").html("45%");
    $(".content_data_left").eq(5).css('background','#6E03F6').html("土壤温度").next(".content_data_right").html("28°C");
    $(".content_data_left").eq(6).css('background','#019FD4').html("土壤湿度").next(".content_data_right").html("45%");
    $(".content_data_left").eq(7).css('background','#FCBC00').html("光照强度").next(".content_data_right").html("5 Klux");
    $(".content_data_left").eq(8).css('background','#0D96F1').html("CO2浓度").next(".content_data_right").html("0 ppm");

});
$(function () {
    $(".content_right_one_content_table tr").eq(0).addClass("content_right_one_content_table_header")
    // $(".content_right_one_content_table tr td").first().addClass("content_right_one_content_table_time")

    $(".content_right_one_content_table tr").each(function(){
        $(this).find("td:first").addClass("content_right_one_content_table_time");
    })
    $("td:not(.content_right_one_content_table_time,.content_right_one_content_table_header td)").addClass("content_right_one_content_table_td_border");


    $(".content_right_one_content_table tr:last").find("td"). removeClass("content_right_one_content_table_td_border")
});
$(function() {

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


