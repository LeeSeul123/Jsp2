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
		<h1>게시글 수정</h1>
	</div>
	<div align="center">
		<form id="frm" action="noticeUpdate.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="150">
							<!-- 수정하면 안되는거라서 -->
							${notice.noticeWriter}     
						</td>
						<th width="150">작성일자</th>
						<td width="150">
							<input type="date" id="noticeWdate" name="noticeWdate" value="${notice.noticeWdate }">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" id="noticeTitle" name="noticeTitle" size="70" value="${notice.noticeTitle }">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="97" id="noticeSubject" name="noticeSubject" placeholder="내용을 입력해주세요." required>${notice.noticeSubject }</textarea>
						</td>
					</tr>
				</table>
			</div>
			<br>
			<div>
			<!-- key(notice_id를 넘겨야 하므로 hidden form이용) -->
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
			</div>
			<div>
				<input type="submit" value="저장">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" value="목록" onclick="location.href='noticeList.do'">
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>

</body>
</html>