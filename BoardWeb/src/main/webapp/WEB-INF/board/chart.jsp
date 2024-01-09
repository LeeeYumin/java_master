<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);
      
      let chartData = [['Name', 'countPerName']]; //[[],[],[]] 배열안에 배열
      const xhtp = new XMLHttpRequest();
      xhtp.open('get', 'replyCountJson.do');
      xhtp.send();
      xhtp.onload = function(){
    	  let result = JSON.parse(xhtp.responseText);
    	  result.forEach(item => {
    		  chartData.push([item.name, item.cnt]);
    	  })
    		google.charts.setOnLoadCallback(drawChart);
    	  	//비동기방식.. 실행되는 시점을 알아야됨. 로딩될때 차트를 가져와서 이게 콜백function밖에 있으면 차트안보임	  
      }

      function drawChart() {

        var data = google.visualization.arrayToDataTable(chartData);

        var options = {
          title: 'My Daily Activities'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
