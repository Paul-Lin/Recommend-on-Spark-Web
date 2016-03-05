//list bills table
function listBills(){
    console($('#host').val());
    $.ajax({
       type:'post',
        url:$('#host').val()+'/shopBills/list-bills.action',
        data:{

        },
        success:function(data){
            console.log(data);
        }
    });
}

function createTable(tableId,data){

}
function drawBillStatistic(){
    var myChart = echarts.init(document.getElementById('main'));

    var option = {
        tooltip: {
            show: true
        },
        legend: {
            data: ['销量']
        },
        xAxis: [
            {
                type: 'category',
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                "name": "销量",
                "type": "bar",
                "data": [5, 20, 40, 10, 10, 20]
            }
        ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);
}
//---------------------------------------------
//  this function following will be auto load...
//---------------------------------------------
$(function(){
    drawBillStatistic();
    listBills();
})