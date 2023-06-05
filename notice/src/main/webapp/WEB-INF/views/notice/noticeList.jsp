<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<div><h1>게시글 목록</h1></div>
	<div>
	<!-- 데이터가 커맨드에서 날아온지 확인 -->
		<c:forEach items = "${notices }" var="n"> <!-- 변수의 이름을 n으로 읽겠다. 참고로 n은 1차원 배열(1줄씩 읽는다). 자바의 foreach문과 같음. 밑은 vo객체가 가지고 있는 변수명 그대로 사용해야함-->
			${n.noticeId } : ${n.noticeWriter } : ${n.noticeTitle } : ${n.noticeWdate } : ${n.noticeHit } <br>
		</c:forEach>
	
	</div>
</div>
</body>
</html>