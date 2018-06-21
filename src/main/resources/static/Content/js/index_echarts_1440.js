/*-----------------------------main-----------------------------*/
var myChart = echarts.init(document.getElementById('main'));
// 指定图表的配置项和数据
var option = {
    tooltip : { //提示框组件
        trigger: 'item', //触发类型(饼状图片就是用这个)
        formatter: "{a} <br/>{b} : {c} ({d}%)" //提示框浮层内容格式器
    },
    //手动设置每个图例的颜色
    // legend: {  //图例组件
    //     //right:100,  //图例组件离右边的距离
    //     orient : 'horizontal',  //布局  纵向布局 图例标记居文字的左边 vertical则反之
    //     width:40,      //图行例组件的宽度,默认自适应
    //     x : 'right',   //图例显示在右边
    //     y: 'center',   //图例在垂直方向上面显示居中
    //     itemWidth:10,  //图例标记的图形宽度
    //     itemHeight:10, //图例标记的图形高度
    //     data:['30%','10%','15%','20%','25%'],
    //     textStyle:{    //图例文字的样式
    //         color:'#333',  //文字颜色
    //         fontSize:12    //文字大小
    //     }
    // },
    series : [ //系列列表
        {
            name:'随访次数',  //系列名称
            type:'pie',   //类型 pie表示饼图
            center:['50%','35%'], //设置饼的原心坐标 不设置就会默认在中心的位置
            radius : ['70%', '80%'], //饼图的半径,第一项是内半径,第二项是外半径,内半径为0就是真的饼,不是环形
            color:['#06195F','#83B15A'],
            itemStyle : {  //图形样式
                normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false //平常不显示

                    },
                    labelLine : {     //标签的视觉引导线样式
                        show : false  //平常不显示
                    },


                },
                emphasis : {   //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : true,
                        position : 'center',
                        textStyle : {
                            fontSize : '10',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:50, name:'大豆'},
                {value:50, name:'大2豆'},


            ]

        },
        {
            name:'随访次数',  //系列名称
            type:'pie',   //类型 pie表示饼图
            center:['50%','35%'], //设置饼的原心坐标 不设置就会默认在中心的位置
            radius : ['50%', '60%'], //饼图的半径,第一项是内半径,第二项是外半径,内半径为0就是真的饼,不是环形
            color:['#06195F','#DE9B32'],
            itemStyle : {  //图形样式
                normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false  //平常不显示
                    },
                    labelLine : {     //标签的视觉引导线样式
                        show : true  //平常不显示
                    }
                },
                emphasis : {   //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false,
                        position : 'center',
                        textStyle : {
                            fontSize : '10',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:30, name:'玉米'},
                {value:70, name:'玉2米'},

            ]


        },
        {
            name:'随访次数',  //系列名称
            type:'pie',   //类型 pie表示饼图
            center:['50%','35%'], //设置饼的原心坐标 不设置就会默认在中心的位置
            radius : ['30%', '40%'],  //饼图的半径,第一项是内半径,第二项是外半径,内半径为0就是真的饼,不是环形
            color:['#06195F','#49B4D7'],
            itemStyle : {  //图形样式
                normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false  //平常不显示
                    },
                    labelLine : {     //标签的视觉引导线样式
                        show : true  //平常不显示
                    }
                },
                emphasis : {   //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false,
                        position : 'center',
                        textStyle : {
                            fontSize : '10',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:20, name:'水稻2'},
                {value:80, name:'水稻'},


            ]

        },
        {
            name:'随访次数',  //系列名称
            type:'pie',   //类型 pie表示饼图
            center:['50%','35%'], //设置饼的原心坐标 不设置就会默认在中心的位置
            radius : ['10%', '20%'],  //饼图的半径,第一项是内半径,第二项是外半径,内半径为0就是真的饼,不是环形
            color:['#06195F','#BF4746'],
            itemStyle : {  //图形样式

                normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : false  //平常不显示
                    },
                    labelLine : {     //标签的视觉引导线样式
                        show : true  //平常不显示
                    }
                },
                emphasis : {   //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : true,
                        position : 'center',
                        textStyle : {
                            fontSize : '10',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:10, name:' '},
                {value:90, name:'  '},

            ]

        }
    ]
}
myChart.setOption(option);
/*-----------------------------------------min2----------------------------------------------*/

var myChart = echarts.init(document.getElementById('main2'));
// 指定图表的配置项和数据
var option = {
    tooltip : { //提示框组件
        trigger: 'item', //触发类型(饼状图片就是用这个)
        formatter: "{a} <br/>{b} : {c} ({d}%)" //提示框浮层内容格式器
    },
    color:['#009DE6','#8C4CE2','#E24C68','#E2B94C','#19C00D'],  //手动设置每个图例的颜色
    // legend: {  //图例组件
    //     //right:100,  //图例组件离右边的距离
    //     orient : 'horizontal',  //布局  纵向布局 图例标记居文字的左边 vertical则反之
    //     width:40,      //图行例组件的宽度,默认自适应
    //     x : 'right',   //图例显示在右边
    //     y: 'center',   //图例在垂直方向上面显示居中
    //     itemWidth:10,  //图例标记的图形宽度
    //     itemHeight:10, //图例标记的图形高度
    //     data:['30%','10%','15%','20%','25%'],
    //     textStyle:{    //图例文字的样式
    //         color:'#333',  //文字颜色
    //         fontSize:12    //文字大小
    //     }
    // },
    series : [ //系列列表
        {
            name:'随访次数',  //系列名称
            type:'pie',   //类型 pie表示饼图
            center:['50%','40%'], //设置饼的原心坐标 不设置就会默认在中心的位置
            radius : ['30%', '60%'],  //饼图的半径,第一项是内半径,第二项是外半径,内半径为0就是真的饼,不是环形
            itemStyle : {  //图形样式
                normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : true  //平常不显示
                    },
                    labelLine : {     //标签的视觉引导线样式
                        show : true  //平常不显示
                    }
                },
                emphasis : {   //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                    label : {  //饼图图形上的文本标签
                        show : true,
                        position : 'center',
                        textStyle : {
                            fontSize : '10',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:80, name:'大豆'},
                {value:30, name:'大2豆'},
                {value:9, name:'大1豆'},
                {value:5, name:'大4豆'},
                {value:3, name:'大5豆'}


            ]

        }
    ]
}
myChart.setOption(option);

/*----------------------------------------mine3----------------------------------*/
var myChart = echarts.init(document.getElementById('main3'));

// 指定图表的配置项和数据
var option = {
    tooltip: {},
    grid:{
        x: '5%',
        x2:'5%',



        y:'10%',
        y2:'40%',

    },


    legend: {
        data:['销量'],
        x: 'right', // 'center' | 'left' | {number},
        y: 'top', // 'center' | 'bottom' | {number}
        textStyle:{    //图例文字的样式
            color:'white',  //文字颜色
        },


    },



    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月',],
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    color:'#ffffff',
                    width:1,//这里是为了突出显示加上的
                }
            }
        }
    ],





    yAxis: {
        axisLine:{
            lineStyle:{
                color:'#ffffff',
                width:1,   //这里是为了突出显示加上的
            },

        }
    },

    series : [
        {
            "name":"销量",
            "type":"bar",
            "data":[25, 10, 20, 10, 10, 20, 10, 20],

            itemStyle:{
                normal:{
                    color:'#4ad2ff'
                }
            },
        },

    ],
    label : {
        show : true,  //柱头数字
        position : 'top',
        textStyle : {
            fontSize : '10',
            fontFamily : '微软雅黑',
            fontWeight : 'bold',
            color:'white'
        }
    }
}

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

/*-----------------------------------------main4------------------------------------------------*/

// 基于准备好的dom，初始化echarts实例
var myChart = echarts.init(document.getElementById('main4'));

// 指定图表的配置项和数据
var option = {
    tooltip: {},
    grid:{
        x: '5%',
        x2:'5%',

        y:'10%',
        y2:'40%',

    },


    legend: {
        data:['销量'],
        x: 'right', // 'center' | 'left' | {number},
        y: 'top', // 'center' | 'bottom' | {number}
        textStyle:{    //图例文字的样式
            color:'white',  //文字颜色
        },


    },



    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月',],
            //设置轴线的属性
            axisLine:{
                lineStyle:{
                    color:'#ffffff',
                    width:1,//这里是为了突出显示加上的
                }
            }
        }
    ],





    yAxis: {
        axisLine:{
            lineStyle:{
                color:'#ffffff',
                width:1,   //这里是为了突出显示加上的
            },

        }
    },

    series : [
        {
            "name":"销量",
            "type":"bar",
            "data":[25, 10, 20, 10, 10, 20, 10, 20],

            itemStyle:{
                normal:{
                    color:'#4ad2ff'
                }
            },
        },

    ],
    label : {
        show : true,  //柱头数字
        position : 'top',
        textStyle : {
            fontSize : '10',
            fontFamily : '微软雅黑',
            fontWeight : 'bold',
            color:'white'
        }
    }
}

// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

