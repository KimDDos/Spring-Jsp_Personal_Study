<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<form action="/member/register" method="post">
		<div class="row g-3 align-items-center">
			<div class="col-auto">
			  <label for="id" class="col-form-label">ID</label>
			</div>
			<div class="col-auto">
			  <input type="text" id="id" name="id" class="form-control" aria-describedby="passwordHelpInline">
			</div>
		</div>
		<div class="row g-3 align-items-center">
			<div class="col-auto">
			  <label for="pw" class="col-form-label">Password</label>
			</div>
			<div class="col-auto">
			  <input type="password" id="pw" name="pw" class="form-control" aria-describedby="passwordHelpInline">
			</div>
			<div class="col-auto">
			  <span id="passwordHelpInline" class="form-text">
			    Must be 8-20 characters long.
			  </span>
			</div>
		</div>
		<div class="row g-3 align-items-center">
			<div class="col-auto">
			  <label for="name" class="col-form-label">Name</label>
			</div>
			<div class="col-auto">
			  <input type="text" id="name" name="name" class="form-control" aria-describedby="passwordHelpInline">
			</div>
		</div>
		<div class="row g-3 align-items-center">
			<div class="col-auto">
			  <label for="email" class="col-form-label">E-Mail</label>
			</div>
			<div class="col-auto">
			  <input type="text" id="email" name="email" class="form-control" aria-describedby="passwordHelpInline">
			</div>
		</div>
		<div class="row g-3 align-items-center">
			<div class="col-auto">
			  <label for="age" class="col-form-label">Age</label>
			</div>
			<div class="col-auto">
			  <input type="text" id="age" name="age" class="form-control" aria-describedby="passwordHelpInline">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>
