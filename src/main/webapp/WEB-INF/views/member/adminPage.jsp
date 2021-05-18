<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" contentType = "text/html; charset=UTF-8" %>

<%@include file="../includes/header.jsp"%>
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
							<th>회원번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>이메일</th>
							<th>연령대</th>
							<th>성별</th>
						</tr>
					</thead>
			        <c:forEach items="${list}" var="list">
			           <tr>
			             <td><c:out value="${list.member_no}" /></td>
			             <td><c:out value="${list.member_id}" /></td>
			             <td><c:out value="${list.member_name}" /></td>
			             <td><c:out value="${list.member_email}" /></td>
			             <td><c:out value="${list.member_age}" /></td>
			             <td><c:out value="${list.member_gender}" /></td>
			             </tr>
			        </c:forEach>
				</table>

				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a href="${pageMaker.startPage -1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.cri.pageNum == num ? 'active':''} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${pageMaker.endPage +1 }">Next</a></li>
						</c:if>

					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<form id='actionForm' action="/adminPage" method='get'>
            	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
            	<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
            </form>
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>

<!-- modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
                    <h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Reply</label>
                        <input class="form-control" name='reply' value=''>
                    </div>
                    <div class="form-group">
                        <label>Replyer</label>
                        <input class="form-control" name='replyer' value='replyer'>
                    </div>
                    <div class="form-group">
                        <label>Reply Date</label>
                        <input class="form-control" name='replyDate' value='2018-01-01 13:13'>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
                    <button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
                </div>
            </div>
        </div>
    </div>


<script type="text/javascript">
	$(document).ready(function(){
		var actionForm = $("#actionForm");

		var paginate_button = $(".paginate_button a").on("click",function(e){
			e.preventDefault();
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
	});
</script>

<%@include file="../includes/footer.jsp"%>
