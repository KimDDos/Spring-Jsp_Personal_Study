<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<form action="/member/login" method="post">
		<label for="id" class="form-label">ID</label>
		<input type="text" id="id" name="id" class="form-control">
		<label for="pw" class="form-label">Password</label>
		<input type="password" id="pw" class="form-control" name="pw" aria-describedby="pw">
		<div id="pw" class="form-text">
		  Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
	
	<div class="form-text">
	    <a href="#">Your ID or PassWord Forget?</a>
	</div>
</div>



<jsp:include page="../layout/footer.jsp"></jsp:include>