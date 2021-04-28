<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="./includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register
					New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#회원번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>연령대</th>
							<th>성별</th>
						</tr>
					</thead>
          <c:forEach items="${list}" var="list">
            <tr>
              <td><c:out value="${list.memberNo}" /></td>
               <td>
                  <a class='move' href='<c:out value="${list.memberNo}"/>'>
                  <c:out value="${list.memberNo}" />
                  </a>
              <td><c:out value="${list.memberId}" /></td>
              <td><c:out value="${list.memberName}" /></td>
              <td><c:out value="${list.memberEmail}" /></td>
              <td><c:out value="${list.memberAge}" /></td>
              <td><c:out value="${list.memberGender}" /></td>
          </c:forEach>
				</table>
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${page.prev}">
							<li class="paginate_button previous"><a
								href="${page.startPage -1}">Previous</a></li>
						</c:if>
						<c:forEach var="num" begin="${page.startPage}"
							end="${page.endPage}">
							<li class="paginate_button  ${page.cri.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${page.next}">
							<li class="paginate_button next"><a
								href="${page.endPage +1 }">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<form id='actionForm' action="/board/list" method='get'>
            				<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
            				<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>

            				<input type='hidden' name='type'
            					value='<c:out value="${ pageMaker.cri.type }"/>'> <input
            					type='hidden' name='keyword'
            					value='<c:out value="${ pageMaker.cri.keyword }"/>'>


            			</form>
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						var result = '<c:out value="${result}"/>';
						checkModal(result);
						history.replaceState({}, null, null);
						function checkModal(result) {
							if (result === '' || history.state) {
								return;
							}
							if (parseInt(result) > 0) {
								$(".modal-body").html(
										"게시글 " + parseInt(result)
												+ " 번이 등록되었습니다.");
							}
							$("#myModal").modal("show");
						}
						$("#regBtn").on("click", function() {
							self.location = "/board/register";
						});
						var actionForm = $("#actionForm");
						$(".paginate_button a").on(
								"click",
								function(e) {
									e.preventDefault();
									console.log('click');
									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href"));
									actionForm.submit();
								});
						$(".move")
								.on(
										"click",
										function(e) {
											e.preventDefault();
											actionForm
													.append("<input type='hidden' name='bno' value='"
															+ $(this).attr(
																	"href")
															+ "'>");
											actionForm.attr("action",
													"/board/get");
											actionForm.submit();
										});
						var searchForm = $("#searchForm");
						$("#searchForm button").on(
								"click",
								function(e) {
									if (!searchForm.find("option:selected")
											.val()) {
										alert("검색종류를 선택하세요");
										return false;
									}
									if (!searchForm.find(
											"input[name='keyword']").val()) {
										alert("키워드를 입력하세요");
										return false;
									}
									searchForm.find("input[name='pageNum']")
											.val("1");
									e.preventDefault();
									searchForm.submit();
								});
					});
</script>

<%@include file="./includes/footer.jsp"%>
