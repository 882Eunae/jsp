<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
     

    	 let aryData=[]; //[],[],[]....
    	 fetch('chartData.do')
    	 	.then(result =>result.json()) //자바스크립트 
    	 	.then(result =>{
    	 		aryData.push(['부서명','인원']); 
    	 		result.forEach(item =>{
    	 			aryData.push([item.dept_name,item.dept_count]);
    	 		});
    	 		console.log(aryData); 
    	 		 google.charts.load('current', {'packages':['corechart']});
    	 	     google.charts.setOnLoadCallback(drawChart);
    	 	})
    	 	.catch(err => console.log(err));
    	 
      function drawChart() {//얘가 먼저 실행되는데 aryData 초기선언에 값이 없음
        var data = google.visualization.arrayToDataTable(aryData);
        var options = {
          title: '부서별 이누언현황'
          ,pieHole:0.4,
        };
        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);}
    </script>
</head>
<body>
	<div id="donutchart" style="width: 900px; height: 500px;"></div>
</body>
</html>
