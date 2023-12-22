<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h1>${ses.id}(${ses.name })님의 마이페이지</h1>
	<form action="/member/modify" method="post">
		<div class="mb-3 row">
			<label for="UserId" class="col-sm-2 col-form-label">ID</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="UserId" name="id" value="${ses.id}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" name="pw" id="inputPassword">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="Username" class="col-sm-2 col-form-label">Name</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"	id="Username" name="name" value="${ses.name}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="Useremail" class="col-sm-2 col-form-label">E-Mail</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"	id="Useremail" name="email" value="${ses.email}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="Userhome" class="col-sm-2 col-form-label">Home</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"	id="Userhome" name="home" value="${ses.home}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="UserAge" class="col-sm-2 col-form-label">Age</label>
			<div class="col-sm-10">
				<input type="text" class="form-control"	id="UserAge" name="age" value="${ses.age}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="UserRegdate" class="col-sm-2 col-form-label">Regdate</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="UserRegdate" name="regdate" value="${ses.regdate}">
			</div>
		</div>
		<div class="mb-3 row">
			<label for="UserlastLogin" class="col-sm-2 col-form-label">Last login</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="UserlastLogin" name="last_login" value="${ses.last_login}">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Modify</button>
		<button type="button" class="btn btn-danger">Remove</button>
	</form>
</div>


<jsp:include page="../layout/footer.jsp"></jsp:include>
