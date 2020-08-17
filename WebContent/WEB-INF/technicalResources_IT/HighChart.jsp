<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Gender-wise Pass Percentage</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/highcharts.js"></script>
</head>
<body>
<div>
<table>
        <tr>
                <td align="center">
                <div id="outerDiv" style="width:100%">
                <div  id="placeholder"></div>
                </div>
                 </td>
         </tr>
</table>
</div>
 
<script type="text/javascript">
 $(function() {
    generateChart();
 
  });
 
function passpercentage(json) {
 
    $(function () {
 
        var len = json.passpercentage.length
        i = 0;
 
        var options = {
             chart: {
                    type: 'column'
 
                },
             credits: {
                 enabled: false
                },
                title: {
                    text: 'Gender-wise Pass Percentage'
                 },
                subtitle: {
                    text: 'Source: Test Data',
                    x: -20
                },
              yAxis: {
                min: 0,
                title: {
                    text: 'Pass Percentage'
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            xAxis: {
                categories: []
            },
            series: []
        }
 
            for (i; i < len; i++) {
                if (i === 0) {
                    var dat = json.passpercentage[i].category,
                        lenJ = dat.length,
                        j = 0,
                        tmp;
 
                    for (j; j < lenJ; j++) {
                        options.xAxis.categories.push(dat[j]);
                    }
                } else {
                    options.series.push(json.passpercentage[i]);
                }
            }
 
        $('#placeholder').highcharts(options);
 
    });
 
    }
 
function generateChart()
{
 
chartType="passpercentage";
$("#placeholder").text("");
 
     $.ajax({
            type: "GET",
            url:"http://localhost:8080/SwaziBankIntranetLive/GetChartDetails?jsonp="+chartType,
            dataType: 'jsonp',
            jsonpCallback: chartType, // the function to call
            error: function () {
                   alert("Error is occured");
                    }
            }); 
 
}
 
</script>
 
</body>
</html>