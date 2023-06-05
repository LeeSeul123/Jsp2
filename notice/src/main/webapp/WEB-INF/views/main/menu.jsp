<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<nav id="topMenu">
			<ul>
				<li><a class="menulink" href="noticeList.do">게시글 목록</a></li>
				<li><a class="menulink" href="memberList.do">멤버 목록</a></li>
				<c:if test="${empty id }"><!-- id가 비어있으면 얘를 뿌려라. 이때 id는 session변수 -->
					<li><a class="menulink" href="memberJoin.do">회원가입</a></li>
				</c:if>
				<li><a class="menulink" href="#"></a></li>
				<li><a class="menulink" href="#"></a></li>
				<c:if test="${empty id }">
					<li><a class="menulink" href="memberList.do">로그인</a></li>	
				</c:if>
				<c:if test="${not empty id }">
					<li><a class="menulink" href="#">로그아웃</a></li>	
				</c:if>
				<c:if test="${not empty name }">
					<li><a class="menulink" href="#">"${name }"님 로그인</a></li>	
				</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>