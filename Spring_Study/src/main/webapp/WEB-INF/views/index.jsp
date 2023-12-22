<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./layout/header.jsp"></jsp:include>
<h1>
	Hello My first Spring Project! 
</h1>
<c:if test="${ses.id ne null}">
	<P> ${ses.id }(${ses.name})님 안녕하세요!<br>
		<span class="badge text-bg-primary">최근 로그인 : ${ses.last_login }</span> 
	</P>
</c:if>

<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}"/>`;
	const msg_logout = `<c:out value="${msg_logout}"/>`;
	const msg_modify = `<c:out value="${msg_modify}"/>`;
	
	if(msg_login === "1"){
		alert("로그인 실패~!!");
	}
	if(msg_logout === "1"){
		alert("로그아웃 성공~!!");
	}
	if(msg_modify === "1"){
		alert("회원정보 수정완료, 로그아웃후 다시 로그인 해주세요~!!");
	} else if(msg_modify === "2"){
		alert("회원정보 수정 실패~!!");
	}
</script>

<jsp:include page="./layout/footer.jsp"></jsp:include>
