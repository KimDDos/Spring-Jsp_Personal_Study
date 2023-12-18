<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h1>Spring Board register</h1>
	<form action="/board/register" method="post">
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요~!">
		</div>
		<div class="mb-3">
		  <label for="writer" class="form-label">Writer</label>
		  <input type="text" class="form-control" id="writer" name="writer">
		</div>
		<div class="mb-3">
		  <label for="content" class="form-label">Content</label>
		  <textarea class="form-control" id="content" name="content" rows="5"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>
