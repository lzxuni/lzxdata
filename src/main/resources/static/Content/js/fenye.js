
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
