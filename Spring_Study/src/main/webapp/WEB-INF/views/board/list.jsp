<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp"></jsp:include>

<div class="container-md">
	<h2 style="text-align: center;">Spring Study Board</h2>
	<table class="table table-striped table-hover">
		<thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Title</th>
		      <th scope="col">Writer</th>
		      <th scope="col">Regdate</th>
		      <th scope="col">Read Count</th>
		    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="bvo">
		    <tr>
		      <th scope="row">${bvo.bno}</th>
		      <td><a href="/board/detail?bno=${bvo.bno}">${bvo.title}</a></td>
		      <td>${bvo.writer}</td>
		      <td>${bvo.regdate}</td>
		      <td>${bvo.read_count}</td>
		    </tr>
		    </c:forEach>
	    </tbody>
	</table>
</div>

<jsp:include page="../layout/footer.jsp"></jsp:include>