<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="/asset/modify" method="post" id="form">
<c:forEach items="${asset}" var="asset">
	<div>
            <label>주식명</label> <input class="form-control" name='stock_name' value='<c:out value="${asset.stock_name}"/>' >
            <label>1주당 가격</label> <input class="form-control" name='stock_price' value='<c:out value="${asset.stock_price}"/>' >
            <label>주식 수량</label> <input class="form-control" name='stock_count' value='<c:out value="${asset.stock_count}"/>' >
            <button class='<c:out value="${asset.asset_no}"/>' type="submit" data-oper='remove' name="remove"> 삭제하기 </button>
            <input type="hidden" name='asset_no', id='asset_no' value='<c:out value="${asset.asset_no}"/>'>
	</div>
	<br>
</c:forEach>
</form>


<button type="submit" data-oper='modify'>수정하기</button>
<button type="submit" data-oper='back' id="back">뒤로가기</button>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

    var form = $("form");

    $('button').on("click" , function(e){
            e.preventDefault();

            var oper = $(this).data("oper");
            var asset_no = $(this).attr('class');

            var nameChk = /^[가-힣a-zA-Z0-9]{2,15}$/;
            var priceChk = /^[0-9]{4,7}$/;
            var countChk = /^[0-9]{1,4}$/;

            var stock_name =  $('input[name="stock_name"]')
            var stock_price =  $('input[name="stock_price"]')
            var stock_count =  $('input[name="stock_count"]')


         if(oper === 'modify'){

                for(i=0; i < stock_name.length; i++){

                             if(!nameChk.test(stock_name[i].value)){
                                alert("정확한 주식명을 입력해 주세요.");
                                return false;
                            }
                            if(!priceChk.test(stock_price[i].value)){
                                alert("정확한 주식 가격을 입력해 주세요.");
                                return false;
                            }
                            if(!countChk.test(stock_count[i].value)){
                                alert("정확한 주식 수량을 입력해 주세요.");
                                return false;
                            }

                            if(stock_name[i].value == ''){
                                alert("주식 이름을 입력해 주세요.");
                                return false;

                            } else if (stock_price[i].value == ''){
                                alert("주식 가격을 입력해 주세요.");
                                return false;

                            }else if (stock_count[i].value == ''){
                                alert("주식 수량을 입력해 주세요.");
                                return false;
                            }
                    }


                 form.submit();


        } else if(oper === 'back'){

                      form.attr("action", "/asset/get").attr("method", "get");
                      form.submit();


         }else if(oper === 'remove'){

                     var asset_no = $(this).attr('class');
                     var newForm = $('<form></form>');

                     newForm.attr("method","post");
                     newForm.attr("action","/asset/remove");

                    newForm.append($('<input/>', {type: 'hidden', name: 'asset_no', value:asset_no }));
                    newForm.appendTo('body');
                    newForm.submit();

        }

    });


</script>

</html>



