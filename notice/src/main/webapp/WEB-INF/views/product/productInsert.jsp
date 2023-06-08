<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="../main/menu.jsp"/>
	</div>
	<div id="container">
		<div><h1>제 품 등 록</h1></div>
		<img src="c:/temp/포메라이언.jpg">
		<form id="frm" action="productInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">제품코드</th>
						<td width="100"><input type="text" id="productId" name="productId" required></td>
					</tr>
					<tr>
						<th>제품명</th>
						<td><input type="text" id="productName" name="productName" required></td>
					</tr>
					<tr>
						<th>이미지</th>
						<!-- pfile(파일명)받아서 multipart로 가져감 -->
						<td><input type="file" id="pfile" name="pfile"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" onclick="location.href='productList.do'" value="목록">
			</div>
		</form>   
	</div>
</body>
</html>