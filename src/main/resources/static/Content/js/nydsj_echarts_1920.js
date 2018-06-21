 // 第一
var myChart = echarts.init(document.getElementById('main'));
option = {
    // title: {
    //     text: '折线图堆叠'
    // },
    tooltip: {
        trigger: 'axis'
    },
    // legend: {
    //     data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
    // },
    grid: {
        x:'0%',
        x2:'5%',

        y:'10%',
        y2:'20%',

        containLabel: true//左侧刻度
    },
    //下载开关
    // toolbox: {
    //     feature: {
    //         saveAsImage: {}
    //     }
    // },

    xAxis: {
        type: 'category',
        // boundaryGap:false,
        data: ['周一','周二','周三','周四','周五','周六','周日'],
        textStyle: {
            color: "red",
        }
    },
    yAxis: {
        type: 'value',
        textStyle: {
            color: '#fff'
        }
    },
    series: [
        {
            name:'邮件营销',
            type:'line',
            stack: '总量',
            data:[12, 12, 21, 14, 9, 20,10]
        },
        {
            name:'联盟广告',
            type:'line',
            stack: '总量',
            data:[12, 12, 21, 14, 9, 20,10]
        },
        {
            name:'视频广告',
            type:'line',
            stack: '总量',
            data:[12, 12, 21, 14, 9, 20,10]
        },
        {
            name:'直接访问',
            type:'line',
            stack: '总量',
            data:[12, 12, 21, 14, 9, 20,10]
        },
        {
            name:'搜索引擎',
            type:'line',
            stack: '总量',
            data:[12, 12, 21, 14, 9, 20,10]
        }
    ],
};

myChart.setOption(option);

// 第二

 var myChart = echarts.init(document.getElementById('main2'));
 option = {
     // backgroundColor: '#00265f',
     tooltip: {
         trigger: 'axis',
         axisPointer: {
             type: 'shadow'
         }
     },
     legend: {
         data: ['接入率', '在线率', '完好率'],
         align: 'right',
         right: 10,
         textStyle: {
             color: "#fff"
         },
         itemWidth: 10,
         itemHeight: 10,
         itemGap: 35
     },
     grid: {

         x:'0%',
         x2:'5%',

         y:'10%',
         y2:'20%',
         containLabel: true
     },
     xAxis: [{
         type: 'category',
         data: ['喀什市',
             '疏附县',
             '疏勒县',
             '英吉沙县',
             '泽普县',
             '岳普湖县',
             '巴楚县',
             '伽师县',
             '叶城县',
             '莎车县 ',
         ],
         axisLine: {
             show: true,
             lineStyle: {
                 color: "#063374",
                 width: 1,
                 type: "solid"
             }
         },
         axisTick: {
             show: false,
         },
         axisLabel: {
             show: true,
             textStyle: {
                 color: "#00c7ff",
             }
         },
     }],
     yAxis: [{
         type: 'value',
         axisLabel: {
             formatter: '{value} %'
         },
         axisTick: {
             show: false,
         },
         axisLine: {
             show: false,
             lineStyle: {
                 color: "#00c7ff",
                 width: 1,
                 type: "solid"
             },
         },
         splitLine: {
             lineStyle: {
                 color: "#063374",
             }
         }
     }],
     series: [{
         name: '接入率',
         type: 'bar',
         data: [20, 50, 80, 58, 83, 68, 57, 80, 42, 66],
         barWidth: 10, //柱子宽度
         barGap: 1, //柱子之间间距
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#008cff'
                 }, {
                     offset: 1,
                     color: '#005193'
                 }]),
                 opacity: 1,
             }
         }
     }, {
         name: '在线率',
         type: 'bar',
         data: [50, 70, 60, 61, 75, 87, 60, 62, 86, 46],
         barWidth: 10,
         barGap: 1,
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#00da9c'
                 }, {
                     offset: 1,
                     color: '#007a55'
                 }]),
                 opacity: 1,
             }
         }
     }, {
         name: '完好率',
         type: 'bar',
         data: [70, 48, 73, 68, 53, 47, 50, 72, 96, 86],
         barWidth: 10,
         barGap: 1,
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#c4e300'
                 }, {
                     offset: 1,
                     color: '#728400'
                 }]),
                 opacity: 1,
             }
         }
     }]
 };

 myChart.setOption(option);


 // 第三
 var myChart = echarts.init(document.getElementById('main3'));
 option = {
     // backgroundColor: '#00265f',
     tooltip: {
         trigger: 'axis',
         axisPointer: {
             type: 'shadow'
         }
     },
     legend: {
         data: ['接入率', '在线率', '完好率'],
         align: 'right',
         right: 10,
         textStyle: {
             color: "#fff"
         },
         itemWidth: 10,
         itemHeight: 10,
         itemGap: 35
     },
     grid: {

         x:'0%',
         x2:'5%',

         y:'10%',
         y2:'20%',
         containLabel: true
     },
     xAxis: [{
         type: 'category',
         data: ['喀什市',
             '疏附县',
             '疏勒县',
             '英吉沙县',
             '泽普县',
             '岳普湖县',
             '巴楚县',
             '伽师县',
             '叶城县',
             '莎车县 ',
         ],
         axisLine: {
             show: true,
             lineStyle: {
                 color: "#063374",
                 width: 1,
                 type: "solid"
             }
         },
         axisTick: {
             show: false,
         },
         axisLabel: {
             show: true,
             textStyle: {
                 color: "#00c7ff",
             }
         },
     }],
     yAxis: [{
         type: 'value',
         axisLabel: {
             formatter: '{value} %'
         },
         axisTick: {
             show: false,
         },
         axisLine: {
             show: false,
             lineStyle: {
                 color: "#00c7ff",
                 width: 1,
                 type: "solid"
             },
         },
         splitLine: {
             lineStyle: {
                 color: "#063374",
             }
         }
     }],
     series: [{
         name: '接入率',
         type: 'bar',
         data: [20, 50, 80, 58, 83, 68, 57, 80, 42, 66],
         barWidth: 10, //柱子宽度
         barGap: 1, //柱子之间间距
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#008cff'
                 }, {
                     offset: 1,
                     color: '#005193'
                 }]),
                 opacity: 1,
             }
         }
     }, {
         name: '在线率',
         type: 'bar',
         data: [50, 70, 60, 61, 75, 87, 60, 62, 86, 46],
         barWidth: 10,
         barGap: 1,
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#00da9c'
                 }, {
                     offset: 1,
                     color: '#007a55'
                 }]),
                 opacity: 1,
             }
         }
     }, {
         name: '完好率',
         type: 'bar',
         data: [70, 48, 73, 68, 53, 47, 50, 72, 96, 86],
         barWidth: 10,
         barGap: 1,
         itemStyle: {
             normal: {
                 color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                     offset: 0,
                     color: '#c4e300'
                 }, {
                     offset: 1,
                     color: '#728400'
                 }]),
                 opacity: 1,
             }
         }
     }]
 };

 myChart.setOption(option);

 // 第四

 // 基于准备好的dom，初始化echarts实例
 var myChart = echarts.init(document.getElementById('main4'));

 // 指定图表的配置项和数据

 option = {
     tooltip : {
         trigger: 'item',
         formatter: "{a} <br/>{b} : {c} ({d}%)"
     },
     color:['#36e4bb','#ea97dd','#7493e5','#a99cf4','#fd87ab','#34abec','#ebc54a','#fff45c','#b3d465','#cadd9c',],
     series : [


         {
             name: '高血压患病率1',
             type: 'pie',
             radius: ['45%', '60%'],
             center: ['20%', '50%'],
             color:['#36e4bb','#eeeeee'],
             data: [
                 {value: 28, name:'有病'},
                 {value: 72, name: '没病'}
             ],
             itemStyle : {  //图形样式
                 normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                     label : {  //饼图图形上的文本标签
                         show : false  //平常不显示
                     },
                 },
             },
         },
         {
             name: '高血压患病率2',
             type: 'pie',
             radius: ['45%', '60%'],
             center: ['50%', '50%'],
             color:['#36e4bb','#eeeeee'],
             data: [
                 {value: 28, name:'有病'},
                 {value: 72, name: '没病'}
             ],
             itemStyle : {  //图形样式
                 normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                     label : {  //饼图图形上的文本标签
                         show : false  //平常不显示
                     },
                 },
             },
         },
         {
             name: '高血压患病率3',
             title:'aa',
             type: 'pie',
             radius: ['45%', '60%'],
             center: ['80%', '50%'],
             color:['#36e4bb','#eeeeee'],
             data: [
                 {value: 28, name:'有病'},
                 {value: 72, name: '没病'}
             ],
             itemStyle : {  //图形样式
                 normal : { //normal 是图形在默认状态下的样式；emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
                     label : {  //饼图图形上的文本标签
                         show : false  //平常不显示
                     },
                 },
             },
         },


     ]
 };
 // 使用刚指定的配置项和数据显示图表。
 myChart.setOption(option);
// 化肥  第五

 var myChart = echarts.init(document.getElementById('main5'));
 option = {

     tooltip : {
         trigger: 'item',
         formatter: "{a} <br/>{b} : {c} ({d}%)"
     },
     // legend: {
     //     orient: 'vertical',
     //     left: 'right',
     //     data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
     // },
     //      grid:{
     //         x:5,
     //         y:5,
     //         x2:5,
     //         y2:0,
     //         borderWidth:1
     // },
     series : [
         {
             name: '访问来源',
             type: 'pie',
             radius : '55%',
             center: ['50%', '40%'],
             data:[
                 {value:735, name:'复合肥',itemStyle: {color: '#1D9FF2'}},
                 {value:335, name:'叶面肥',itemStyle: {color: '#ED5655'}},
                 {value:235, name:'有机肥',itemStyle: {color: '#55D7FF'}},


             ],
             itemStyle: {
                 emphasis: {
                     shadowBlur: 10,
                     shadowOffsetX: 0,
                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                 }
             }
         }
     ]
 };
 myChart.setOption(option);

// 第六
   var myChart = echarts.init(document.getElementById('main6'));
 // 指定图表的配置项和数据
 var option = {
     tooltip : { //提示框组件
         trigger: 'item', //触发类型(饼状图片就是用这个)
         formatter: "{a} <br/>{b} : {c} ({d}%)" //提示框浮层内容格式器
     }, legend: {
         orient: 'vertical',
         left: 'right',
         data: ['大豆','玉米','水稻','123']
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
             center:['40%','45%'], //设置饼的原心坐标 不设置就会默认在中心的位置
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
             center:['40%','45%'], //设置饼的原心坐标 不设置就会默认在中心的位置
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
             center:['40%','45%'], //设置饼的原心坐标 不设置就会默认在中心的位置
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
             center:['40%','45%'], //设置饼的原心坐标 不设置就会默认在中心的位置
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
                 {value:10, name:'132'},
                 {value:90, name:'123'},

             ]

         }
     ]
 }
 myChart.setOption(option);

//有效磷  第七

 var myChart = echarts.init(document.getElementById('main7'));
 option = {

     tooltip : {
         trigger: 'item',
         formatter: "{a} <br/>{b} : {c} ({d}%)"
     },
     // legend: {
     //     orient: 'vertical',
     //     left: 'right',
     //     data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
     // },
     //      grid:{
     //         x:5,
     //         y:5,
     //         x2:5,
     //         y2:0,
     //         borderWidth:1
     // },
     series : [
         {
             name: '访问来源',
             type: 'pie',
             radius : ['60%', '50%'],
             center: ['50%', '40%'],
             data:[
                 {value:735, name:'复合肥',itemStyle: {color: '#1D9FF2'}},
                 {value:335, name:'叶面肥',itemStyle: {color: '#ED5655'}},
                 {value:235, name:'有机肥2',itemStyle: {color: '#DE9B32'}},
                 {value:235, name:'有机肥2',itemStyle: {color: '#83B15A'}},
                 {value:235, name:'有机肥2',itemStyle: {color: '#55D7FF'}},


             ],
             itemStyle: {
                 emphasis: {
                     shadowBlur: 10,
                     shadowOffsetX: 0,
                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                 }
             }
         }
     ]
 };
 myChart.setOption(option);

 // 第八  right_bottom

 var myChart = echarts.init(document.getElementById('main8'));
 // 指定图表的配置项和数据
 option = {

     tooltip: {
         trigger: 'axis'
     },
     grid:{
         x:'10%',
         y:'20%',
         x2:'10%',
         y2:'20%',
         borderWidth:1
     },
     legend: {
         data:['最高气温','最低气温','最低气温2'],
         orient: 'horizontal',      // 布局方式，默认为水平布局，可选为：
         // 'horizontal' ¦ 'vertical'
         x: 'right',               // 水平安放位置，默认为全图居中，可选为：
         // 'center' ¦ 'left' ¦ 'right'
         // ¦ {number}（x坐标，单位px）
         y: '10px',                  // 垂直安放位置，默认为全图顶端，可选为：
         // 'top' ¦ 'bottom' ¦ 'center'
         // ¦ {number}（y坐标，单位px）
         // backgroundColor: 'rgba(0,0,0,0)',
         borderColor: '#ccc',       // 图例边框颜色
         borderWidth: 0,            // 图例边框线宽，单位px，默认为0（无边框）
         padding: 15,                // 图例内边距，单位px，默认各方向内边距为5，
         // 接受数组分别设定上右下左边距，同css
         itemGap: 10,               // 各个item之间的间隔，单位px，默认为10，
                                    // 横向布局时为水平间隔，纵向布局时为纵向间隔
         itemWidth: 20,             // 图例图形宽度
         itemHeight: 14,            // 图例图形高度
         textStyle: {
             color: '#91F3FF'          // 图例文字颜色
         }
     },
     toolbox: {
         show: false,
         feature: {
             dataZoom: {
                 yAxisIndex: 'none'
             },
             dataView: {readOnly: false},
             magicType: {type: ['line', 'bar']},
             restore: {},
             saveAsImage: {}
         }
     },
     xAxis:  {
         type: 'category',
         boundaryGap: false,
         data: ['周一','周二','周三','周四','周五','周六','周日']
     },
     yAxis: {
         type: 'value',
         axisLabel: {
             formatter: '{value} °C'
         }
     },
     series: [
         {
             name:'最高气温',
             type:'line',
             data:[11, 11, 15, 13, 12, 13, 10],
             markPoint: {
                 data: [
                     {type: 'max', name: '最大值'},
                     {type: 'min', name: '最小值'}
                 ]
             },
             markLine: {
                 data: [
                     {type: 'average', name: '平均值'}
                 ]
             }
         },
         {
             name:'最低气温',
             type:'line',
             data:[1, -2, 2, 5, 3, 2, 0],
             markPoint: {
                 data: [
                     {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                 ]
             },
             markLine: {
                 data: [
                     {type: 'average', name: '平均值'},
                     [{
                         symbol: 'none',
                         x: '90%',
                         yAxis: 'max'
                     }, {
                         symbol: 'circle',
                         label: {
                             normal: {
                                 position: 'start',
                                 formatter: '最大值'
                             }
                         },
                         type: 'max',
                         name: '最高点'
                     }]
                 ]
             }
         },
         {
             name:'最低气温2',
             type:'line',
             data:[2, -5, 7, 8,2, 1, 5],
             markPoint: {
                 data: [
                     {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                 ]
             },
             markLine: {
                 data: [
                     {type: 'average', name: '平均值'},
                     [{
                         symbol: 'none',
                         x: '90%',
                         yAxis: 'max'
                     }, {
                         symbol: 'circle',
                         label: {
                             normal: {
                                 position: 'start',
                                 formatter: '最大值'
                             }
                         },
                         type: 'max',
                         name: '最高点'
                     }]
                 ]
             }
         }
     ]
 };

 myChart.setOption(option);

