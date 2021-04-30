<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="./includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>회원번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>성별</th>
							<th>나이</th>
						</tr>
					</thead>
                    <c:forEach items="${member}" var="member">
                        <tr>
                          <td><c:out value="${member.member_no}" /></td>
                           <td><c:out value="${member.member_id}" /></td>
                          <td><c:out value="${member.member_name}" /></td>
                          <td><c:out value="${member.member_email}" /></td>
                          <td><c:out value="${member.member_gender}"/></td>
                          <td><c:out value="${member.member_age}" /></td>
                        </tr>
                    </c:forEach>
                </table>
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
							<a href="${pageMaker.startPage -1}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.cri.curPage == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
							    <a href="${pageMaker.endPage +1 }">Next</a>
							</li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->
			</div>

			<form id='actionForm' action="/adminPage" method='get'>
				<input type='hidden' name='curPage' value='${pageMaker.cri.curPage}'>
				<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
			</form>
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->

<script type="text/javascript">
$(document).ready(
    var actionForm = $("#actionForm");
    function() {
      $(".paginate_button a").on("click",e => {
        e.preventDefault();
        actionForm.find("input[name='curPage']").val($(this).attr("href"));
        actionForm.submit();
      });

}));
</script>
<%@include file="./includes/footer.jsp"%>
