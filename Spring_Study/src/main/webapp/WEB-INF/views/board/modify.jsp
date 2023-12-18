<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h1 style="text-align: center;">Spring Board Modify Page</h1>
	<form action="/board/modify" method="post">
	      <input type="hidden" name=bno value="${bvo.bno}">
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  <input type="text" class="form-control" id="title" name="title" value="${bvo.title}">
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
		  <textarea class="form-control" id="content" name="content" rows="5">${bvo.content}</textarea>
		</div>
		<button type="submit" class="btn btn-primary">Modify</button>
		<a href="/board/remove?bno=${bvo.bno}"><button type="button" class="btn btn-danger">Delete</button></a>
	</form>

</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>
