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
<div align="center">
	<jsp:include page="../main/menu.jsp"></jsp:include>
	<div><h1>게시글 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="100">순번</th>
					<th width="150">작성자</th>
					<th width="200">제목</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notices }" var="n">
					<tr onmouseover='this.style.background="#9fff80";'
						onmouseleave='this.style.background="#FFFFFF";'
						onclick="noticeChois(${n.noticeId})"
					>
						<td align="center">${n.noticeId }</td>
						<td align="center">${n.noticeWriter }</td>
						<td>${n.noticeTitle }</td>
						<td align="center">${n.noticeWdate }</td>
						<td align="center">${n.noticeHit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div>
	<!-- 로그인한 사용자만 글 쓰도록 -->
	<c:if test="${not empty id }">
		<button type="button" onclick="location.href='noticeInsertForm.do'">새글작성</button>
	</c:if>
	</div>
	<div>
		<!-- 히든폼 -->
		<form id="frm" action="noticeSelect.do" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
</div>
<script type="text/javascript">
	function noticeChois(id){
		//자바스크립트 url호출(get방식)
//		let url = 'noticeSelect.do?noticeId=' + id; ->get방식이므로 post방식에는 안씀
//		location.href=url; ->get방식이므로 post방식에는 안씀
		//location.replace(url); //현재페이지에 덮어씌움 이전페이지로 돌아갈 수 없음	
		//window.open(url);
		let frm = document.getElementById("frm");	//post방식 (hidden폼이 날아감)
		frm.noticeId.value = id;	//post방식 (hidden폼이 날아감)
		frm.submit();	//post방식 (hidden폼이 날아감)
	}
</script>
</body>
</html>