<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h1 style="text-align: center;">Spring Board Detail Page</h1>
	<c:set value="${boardDTO.bvo}" var="bvo"></c:set>
	<div class="mb-3">
      <input type="hidden" name=bno value="${bvo.bno}">
	  <label for="title" class="form-label">Title</label>
	  <input type="text" class="form-control" id="title" name="title" value="${bvo.title}" readonly="readonly">
	</div>
	<div class="mb-3">
	  <label for="writer" class="form-label">Writer</label>
	  <input type="text" class="form-control" id="writer" name="writer" value="${bvo.writer}" readonly="readonly">
	</div>
	<div class="mb-3">
	  <label for="regdate" class="form-label">Regdate</label>
	  <span class="badge bg-secondary">Read Count ${bvo.read_count}</span>
	  <input type="text" class="form-control" id="regdate" name="regdate" value="${bvo.regdate}" readonly="readonly">
	</div>
	<div class="mb-3">
	  <label for="content" class="form-label">Content</label>
	  <textarea class="form-control" id="content" name="content" rows="5" readonly="readonly">${bvo.content}</textarea>
	</div>
	
	<!-- 파일 표시 라인 -->
	<c:set value="${boardDTO.flist}" var="flist"></c:set>
	<div>
		<ul style="list-style-type: none;">
			<!-- 파일 개수만큼 li를 추가하여 파일을 표시, 타입이 1인 경우만 표시 -->
			<!-- 
				li -> div => img 그림표시
					  div => 파일이름, 작성일, span size
			 -->
			<!-- 파일 리스트 중 하나만 가져와서 fvo로 저장 -->
			<!-- JSP와 JAVA의 seperator의 기준이 다름!! -->
			<c:forEach items="${flist }" var="fvo">
				<li>
					<c:choose>
						<c:when test="${fvo.file_type == 1}">
							<!-- /upload/save_dir/uuid + _ + file_name -->
							<!-- file 경로를 찾아가야 하는 것임! -->
							<div>
								<img class="rounded mx-auto d-block" alt="404 not Found" src="/upload/${fn:replace(fvo.save_dir,'\\','/')}/${fvo.uuid}_${fvo.file_name}">
							</div>
						</c:when>
						<c:otherwise>
							<div style="text-align: center;">
								<i class="bi bi-sign-do-not-enter"></i>
								이미지가 없어요!
							</div>
						</c:otherwise>
					</c:choose>
					<div style="text-align: center;">
						<!-- div => 파일이름, 작성일, span size -->
						<div><b>${fvo.file_name}</b></div>
						${fvo.reg_date }
						<span class="badge text-bg-warning">${fvo.file_size} Byte</span>
					</div>
				</li>
			</c:forEach>
		</ul>	
	</div>
	
	<a href="/board/modify?bno=${bvo.bno}"><button type="button" class="btn btn-primary">Modify</button></a>
	<a href="/board/remove?bno=${bvo.bno}"><button type="button" class="btn btn-danger">Delete</button></a>

	<br>
	<hr>
	<br>

	<!-- 댓글 등록 라인 -->
	<h2>댓글 등록</h2>
	<div class="input-group mb-3">
		<span class="input-group-text" id="cmtWriter" > ${ses.id } </span>
		<c:if test="${ses.id ne null}">
		<input type="text" id="cmtText" class="form-control" aria-label="Amount (to the nearest dollar)"
			placeholder="댓글을 입력 해주세요!">
		<button class="btn btn-outline-secondary input-group-text" id="cmtAddBtn" type="button">Comment
			<br>Registration</button>
		</c:if>
		<c:if test="${ses.id eq null}">
		<input type="text" id="cmtText" class="form-control" aria-label="Amount (to the nearest dollar)"
			placeholder="댓글을 작성하시려면 로그인을 해주세요!" disabled>
		<button class="btn btn-outline-secondary input-group-text" id="cmtAddBtn" type="button" disabled>Comment
			<br>Registration</button>
		</c:if>
	</div>
	
	<br>
	<hr>
	<br>
	
	<!-- 댓글 표시 라인 -->
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header">
				<button class="accordion-button" type="button" data-bs-toggle="collapse"
					data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					cno, writer, reg_date
				</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				data-bs-parent="#accordionExample" style="display: flex;">
				<div class="accordion-body">
					<strong> Add Comment.... </strong>
				</div>
				<div class="btn-group btn-group-sm" role="group" aria-label="Default button group">
					<button type="button" class="btn btn-outline-warning cmtModify">Modify</button>
					<button type="button" class="btn btn-outline-danger cmtRemove">Remove</button>
				</div>
			</div>
		</div>
	</div>

</div>
<script type="text/javascript">
	const bnoVal = `<c:out value="${bvo.bno}"/>`;
</script>
<script src="/resources/js/boardComment.js"></script>
<script type="text/javascript">
	getCommentList(bnoVal);
</script>

<jsp:include page="../layout/footer.jsp"></jsp:include>
