<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <meta charset="UTF-8">
	<title>투자성향 테스트</title>
</head>
<body>
<form name="test">
	<h1>투자성향 테스트</h1>
	<h3>1. 당신의 연령대는 어떻게 됩니까?</h3>
	<div>
		<p><input type="radio" name="age" value="12.5" onClick="ScoreSum(this.form);">19세 이하</p>
		<p><input type="radio" name="age" value="12.5" onClick="ScoreSum(this.form);">20세 ~ 40세</p>
		<p><input type="radio" name="age" value="9.3" onClick="ScoreSum(this.form);">41세 ~ 50세</p>
		<p><input type="radio" name="age" value="6.2" onClick="ScoreSum(this.form);">51세 ~ 60세</p>
		<p><input type="radio" name="age" value="3.1" onClick="ScoreSum(this.form);">60세 이상 </p>
	</div>
	</br>
	<h3>2. 투자하고자 하는 자금의 투자가능 기간은 얼마나 됩니까?</h3>
    	<div>
    		<p><input type="radio" name="period" value="3.1" onClick="ScoreSum(this.form);">6개월 이내</p>
    		<p><input type="radio" name="period" value="6.2" onClick="ScoreSum(this.form);">6개월 이상 ~ 1년 이내</p>
    		<p><input type="radio" name="period" value="9.3" onClick="ScoreSum(this.form);">1년 이상 ~ 2년 이내</p>
    		<p><input type="radio" name="period" value="12.5" onClick="ScoreSum(this.form);">2년 ~ 3년 이내</p>
    		<p><input type="radio" name="period" value="15.6" onClick="ScoreSum(this.form);">3년 이상</p>
    	</div>
      </br>
        <h3>3. 다음 중 투자경험과 가장 가까운 것은 어느 것입니까? (중복가능)</h3>
        	<div>
        		<p><input type="radio" name="experience1" value="3.1" onClick="ScoreSum(this.form);"> 은행 예금/적금, 국채, 지방채, 보증채, MMF, CMA 등</p>
        		<p><input type="radio" name="experience2" value="6.2" onClick="ScoreSum(this.form);">
                	금융채, 신용도가 높은 회사채, 채권형펀드, 원금보장형 ELS 등</p>
        		<p><input type="radio" name="experience3" value="9.3" onClick="ScoreSum(this.form);"> 신용도 중간 등급의 회사채, 원금의 일부만 보장되는 ELS, 혼합형 펀드 등</p>
        		<p><input type="radio" name="experience4" value="12.5" onClick="ScoreSum(this.form);"> 신용도가 낮은 회사채, 주식, 원금이 보장되지 않는 ELS, 시장수익률 수준의 수익을 추구하는 주식형 펀드 등</p>
        		<p><input type="radio" name="experience5" value="15.6" onClick="ScoreSum(this.form);"> ELW, 선물옵션, 시장수익률 이상의 수익을 추구하는 주식형펀드, 파생상품에 투자하는 펀드, 주식 신용거래 등</p>
        	</div>
    </br>
    <h3>4. 금융상품 투자에 대한 본인의 수준은 어느 정도라고 생각하십니까?</h3>
    	<div>
    		<p><input type="radio" name="level" value="3.1" onClick="ScoreSum(this.form);"> [매우 낮은 수준] 금융투자상품에 투자해 본 경험이 없음</p>
    		<p><input type="radio" name="level" value="6.2" onClick="ScoreSum(this.form);">
            	 [낮은 수준] 널리 알려진 금융투자상품 (주식, 채권 및 펀드 등)의 구조 및 위험을 일정부분 이해하고 있는 정도</p>
    		<p><input type="radio" name="level" value="9.3" onClick="ScoreSum(this.form);"> [높은 수준] 투자할 수 있는 대부분의 금융상품의 차이를 구별할 수 있는 정도</p>
    		<p><input type="radio" name="level" value="12.5" onClick="ScoreSum(this.form);">[매우 높은 수준] 금융상품을 비롯하여 모든 투자대상 상품의 차이를 이해할 수 있는 정도</p>
    	</div>
    </br>
            <h3>5. 현재 투자하고자 하는 자금은 전체 금융자산(부동산 등을 제외) 중 어느 정도의 비중을 차지합니까?</h3>
            	<div>
            		<p><input type="radio" name="weight" value="15.6" onClick="ScoreSum(this.form);"> 10% 이내</p>
            		<p><input type="radio" name="weight" value="12.5" onClick="ScoreSum(this.form);"> 10% ~ 20% 이내</p>
            		<p><input type="radio" name="weight" value="9.3" onClick="ScoreSum(this.form);"> 20% ~ 30% 이내</p>
            		<p><input type="radio" name="weight" value="6.2" onClick="ScoreSum(this.form);"> 30% ~ 40% 이내</p>
            		<p><input type="radio" name="weight" value="3.1" onClick="ScoreSum(this.form);"> 40% 초과</p>
            	</div>
    </br>
            <h3>6. 다음 중 당신의 수입원을 가장 잘 나타내고 있는 것은 어느 것입니까?</h3>
            	<div>
            		<p><input type="radio" name="income" value="9.3" onClick="ScoreSum(this.form);"> 현재 일정한 수입이 발생하고 있으며, 향후 현재 수준을 유지하거나 증가할 것으로 예상</p>
            		<p><input type="radio" name="income" value="6.2" onClick="ScoreSum(this.form);"> 현재 일정한 수입이 발생하고 있으나, 향후 감소하거나 불안정할 것으로 예상</p>
            		<p><input type="radio" name="income" value="3.1" onClick="ScoreSum(this.form);"> 현재 일정한 수입원이 없으며, 연금이 주 수입원임</p>

            	</div>
    </br>
            <h3>7. 만약 투자원금에 손실이 발생할 경우 다음 중 감수할 수 있는 손실 수준은 어느 것입니까?</h3>
            	<div>
            		<p><input type="radio" name="loss" value="-6.2" onClick="ScoreSum(this.form);"> 무슨 일이 있어도 투자원금은 보전되어야 한다.</p>
            		<p><input type="radio" name="loss" value="6.2" onClick="ScoreSum(this.form);"> 10% 미만까지는 손실을 감수 할 수 있을 것 같다.</p>
            		<p><input type="radio" name="loss" value="12.5" onClick="ScoreSum(this.form);"> 20% 미만까지는 손실을 감수 할 수 있을 것 같다.</p>
            		<p><input type="radio" name="loss" value="18.7" onClick="ScoreSum(this.form);"> 기대수익이 높다면 위험이 높아도 상관하지 않겠다.</p>
            	</div>
    </br>
    <p>합계 (테스트용):&nbsp;<input name="total_sum" type="text" size="20" readonly></p>

</form>
</body>
<script>
    function ScoreSum(frm){
        var sum = 0;
        var count = frm.radio.length;
        for(var i=0; i < count; i++){
            if(frm.radio[i].checked == true){
                sum += parseInt(frm.radio[i].value);
            }
        }
   frm.total_sum.value = sum;
   }

</script>
</html>
