<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/asset/register" method="post" id="form">

	<div class="itr">
            <label>주식명</label> <input class="required" name='stock_name' id="stock_name">
            <label>1주당 가격</label> <input class="required" name='stock_price' id="stock_price">
            <label>주식 수량</label> <input class="required" name='stock_count' id="stock_count">
           <input type="hidden" name= "member_id" value = "${member.id}">
	</div>
	</br>
	<div class="itr">
            <label>주식명</label> <input class="required" name='stock_name' id="stock_name">
            <label>1주당 가격</label> <input class="required" name='stock_price' id="stock_price">
            <label>주식 수량</label> <input class="required" name='stock_count' id="stock_count">
            <input type="hidden" name = "member_id" value = "${member.id}">
	</div>
	</br>
	<div class="itr">
            <label>주식명</label> <input class="required" name='stock_name' id="stock_name">
            <label>1주당 가격</label> <input class="required" name='stock_price' id="stock_price">
            <label>주식 수량</label> <input class="required" name='stock_count' id="stock_count">
            <input type="hidden" name = "member_id" value = "${member.id}">
            <input type="button" name = "plus" id="plus" value="+">

	</div>
	</br>

    <div id="add">

    </div>
<input type="submit" value="등록하기">
</form>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function(){

                 var maxAppend=0;

               $("#plus").on("click", function(){

                       if(maxAppend <= 1) {

                            var newDiv = document.getElementById("add");

                            var output ="";

                            output += "<label>주식명</label> <input class='required' name='stock_name' id='stock_name'>&nbsp;";
                            output += "<label>1주당 가격</label> <input class='required' name='stock_price'  id='stock_price'>&nbsp;";
                            output += "<label>주식 수량</label> <input class='required' name='stock_count'  id='stock_count'>&nbsp;";
                            output += "<input type='hidden' name = 'member_id' value = '${member.id}'>";
                            output += "  </br></br>"


                            var childDiv = document.createElement("div");
                             childDiv.innerHTML =output;
                             newDiv.appendChild(childDiv);


                        }
                        else if(maxAppend > 1){

                             alert("최대 5개까지만 생성 가능합니다.");
                             return false;
                       }
                       maxAppend++;
                       console.log(maxAppend);
             });



    });


    $("#form").submit(function(e){
        e.preventDefault();

        var form = document.getElementById("form");

        var nameChk = /^[가-힣a-zA-Z0-9]{2,15}$/;
        var priceChk = /^[0-9]{4,7}$/;
        var countChk = /^[0-9]{1,4}$/;

        var stock_name =  $('input[name="stock_name"]')
        var stock_price =  $('input[name="stock_price"]')
        var stock_count =  $('input[name="stock_count"]')

        for(i=0; i < stock_name.length; i++){

                 if(!nameChk.test(stock_name[i].value)){
                    alert("정확한 주식명을 입력해 주세요.");
                    return false;
                }

               for(j=i+1; j < stock_name.length; j++){
                     if(stock_name[i].value == stock_name[j].value){
                        console.log([i]);
                        console.log([j]);

                        alert("동일한 주식명이 존재합니다.");
                        return false;
                    }
                }

                if(!priceChk.test(stock_price[i].value)){
                    alert("정확한 주식 가격을 입력해 주세요.");
                    return false;
                }
                if(!countChk.test(stock_count[i].value)){
                    alert("정확한 주식 수량을 입력해 주세요.");
                    return false;
                }

        }

        form.submit();
    });






</script>
</html>



