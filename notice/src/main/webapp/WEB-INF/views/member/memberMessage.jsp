<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<jsp:include page="../main/menu.jsp"/>
		<h1>${message }</h1>
		<!-- 실패했든 성공했든 이 파일로 출력 후 홈이나 memberList로 감 -->
		<button type="button" onclick="location.href='memberList.do'">멤버목록</button>
		<!-- button은 value값이 text부분에 옴. input은 form태그 안에서 동작 -->
	</div>
</body>
</html>