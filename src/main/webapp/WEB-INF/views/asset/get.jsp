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

<c:forEach items="${asset}" var="asset">
	<div>
            <label>주식명</label> <input class="form-control" name='stock_name' value='<c:out value="${asset.stock_name}"/>' readonly>
            <label>1주당 가격</label> <input class="form-control" name='stock_price' value='<c:out value="${asset.stock_price}"/>' readonly>
            <label>주식 수량</label> <input class="form-control" name='stock_count' value='<c:out value="${asset.stock_count}"/>' readonly>
	</div>
	<br>
</c:forEach>

<a href="/asset/modify"> 수정 </a>
<a href="/"> 뒤로가기 </a>

<script>
window.onload = function(){

        var result ='${result}';

        if(result != ''){
            alert(result);
            console.log(result);
            return false;
        }
}

</script>

</body>
</html>



