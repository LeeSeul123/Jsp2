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
	</div>
	<div align="center">
		<h1>게시글 등록</h1>
	</div>
	<div align="center">
		<form id="frm" action="noticeInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="150">
							<input type="text" id="noticeWriter" name="noticeWriter" value="${name }" readOnly>
						</td>
						<th width="150">작성일자</th>
						<td width="150">
							<input type="date" id="noticeWdate" name="noticeWdate" readOnly>
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" id="noticeTitle" name="noticeTitle" size="70" required>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="97" id="noticeSubject" name="noticeSubject" placeholder="내용을 입력해주세요." required></textarea>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
<script>
  document.getElementById('noticeWdate').value = new Date().toISOString().substring(0, 10);
</script>	
</body>
</html>