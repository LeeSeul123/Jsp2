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
	<div align = "center">
		<div>
			<jsp:include page="../main/menu.jsp"/>
		</div>
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="70">순번</th>
					<td width="50" align="center">${notice.noticeId }</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${notice.noticeWriter }</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${notice.noticeWdate }</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${notice.noticeHit }</td>
				</tr>
				<tr>
					<th colspan= "2">제목</th>
					<td colspan = "6">${notice.noticeTitle }</td>
				<tr>
					<th colspan= "2">내용</th>
					<td colspan = "6">
						<textarea rows="10" cols="97"> ${notice.noticeSubject } </textarea>
					</td>
			</table>
		</div>
		<br>
		<div>
			<c:if test="${name eq notice.noticeWriter }">
				<!-- 하나의 메소드로 만들기 위해서 E와 D로 나눔. E면 edit.do 호출, D면 delete.do호출. 실어가는 값은 noticeId로 같음 -->
				<button type="button" onclick="callFunction('E')">수정</button>&nbsp;&nbsp;
				<button type="button" onclick="callFunction('D')">삭제</button>&nbsp;&nbsp;
			</c:if>
			<button type="button" onclick="location.href='noticeList.do'">목록</button>
		</div>
		<div>
			<jsp:include page="../main/footer.jsp"/>
		</div>
		<div>
			<!-- action은 E냐 D에 따라 액션이 달라지므로 적지않음. javascript에서 frm.action으로 설정 -->
			<form id="frm" method="post">
				<input type="hidden" id="noticeId" name="noticeId" value="${notice.noticeId }"><!-- noticeId는 같이 넘어가야하므로 히든폼에 noticeId를 담는다id와 name은 vo객체명 그대로 쓴다 -->
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function callFunction(str){
			let frm = document.getElementById("frm");
			if(str=='E'){
				frm.action = "noticeEdit.do"; //액션 = 동작되는 것. 폼객체가 가지고 있는 action속성에 noticeEdit을 담아라
			} else {
				frm.action = "noticeDelete.do";
			}
			
			frm.submit(); //이폼이 전송
		}
	</script>
</body>
</html>