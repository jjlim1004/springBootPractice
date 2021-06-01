<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<c:forEach items="${asset}" var="asset">
	<div class="register">
            <label>주식명</label> <input class="form-control" name='stock_name' value='<c:out value="${asset.stock_name}"/>' readonly>
            <label>1주당 가격</label> <input class="form-control" name='stock_price' value='<c:out value="${asset.stock_price}"/>' readonly>
            <label>주식 수량</label> <input class="form-control" name='stock_count' value='<c:out value="${asset.stock_count}"/>' readonly>
	</div>
	<br>
</c:forEach>

<div>
    <canvas id="myChart" width="650" height="650"></canvas>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
<script>
window.onload = function(){

        var result ='${result}';

        if(result != ''){
            alert(result);
            //console.log(result);
            return false;
        }
}

  var register_length = $(".register").length;

            var stockName = [];
            var stockTotal = [];

            for(var i=0; i<5 ; i++){
                var stock_name = $(".register").eq(i).find("input[name='stock_name']").val();
                var stock_count =$(".register").eq(i).find("input[name='stock_count']").val();
                var stock_price = $(".register").eq(i).find("input[name='stock_price']").val();

                total = stock_count * stock_price;
                stockName[i] = stock_name;
                stockTotal[i] = total;
            }

            function forLabels(length){
                var index = 5 - length;
                for(var i = 0 ; i<index ; i++){
                    stockName.pop();
                }
                return stockName;
            }

            //label 에다 배열 요소 넣어줘야함
            var labels =  forLabels(register_length);


            function bgc(length){
                var bgcArr = ['plum',
                              'lightpink',
                              'navajowhite',
                              'yellowgreen',
                              'lightskyblue', ];
                var index = 5 - bgcArr;
                for(var i = 0 ; i<index ; i++){
                    bgcArr.pop();
                }
                return bgcArr;
            }

            var data = {
                labels: labels,
                datasets: [{
                    label: 'My First dataset',
                    backgroundColor: bgc(register_length),
                    borderColor: 'white',
                    data: stockTotal  //배열값 필요
                }]
            };

            const config = {
                type: 'doughnut',
                data,
                options: {
                    responsive: false
                }
            };
            // === include 'setup' then 'config' above ===
            var myChart = new Chart(
              document.getElementById('myChart'),
              config
            );

</script>

<a href="/asset/modify"> 수정 </a>
<a href="/"> 뒤로가기 </a>

</body>
</html>



