<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#container{
		width: 1000px;
		margin : 0 auto;
		text-align: center;
	}
	#menu{
		background-color : black;
		display: flex;
		width: 800px;
	}
	
	li{
		display : inline-block;
		color: white;
		list-style : none;
		float: left;
		padding: 15px;
		flex : 1;
	}
	tbody{
		margin : 0 auto;
	}
	a{
		color: white;
		text-decoration : none;
	}
	
	section{
		display: inline-block;
		text-align: center;
		width: 1000px;
	}
	
	input{
		border: none;
		display: inline-block;
	}
</style>
</head>
<body>
	<div id="container">
		<header>
			<ul id="menu">
				<li><a href="#">메뉴</a></li>
				<li><a href="#">메뉴</a></li>
				<li><a href="#">메뉴</a></li>
				<li><a href="#">메뉴</a></li>
				<li><a href="#">메뉴</a></li>				
			</ul>
		</header>
		<section>
			<form id="frm" action = "memberInsert.do" onsubmit="return formCheck()" method="post">
				<div id="tb">
					<table border="1">
						<tr>
							<th width="150">*아이디</th>
							<td width="300"><input type="email" id="memberId" name="memberId" required="required">
								<button type="button" id = "checkId" value="No" onclick="idCheck()">중복체크</button></td>
							<!-- value가 no면 중복체크 -->
						</tr>
						<tr>	
							<th width="150">*패스워드</th>
							<td width="300"><input type="password" id="memberPW" name="memberPW" required="required"></td>
						</tr>
						<tr>
							<th width="150">*패스워드확인</th>
							<td width="300"><input type="password" id="passwordcheck" name="passwordcheck" required="required"></td>
						</tr>
						<tr>
							<th width="150">*사용자명</th>
							<td width="300"><input type="text" id="memberNamd" name="memberName" required="required"></td>
						</tr>
						<tr>
							<th width="150">나 이</th>
							<td width="300"><input type="text" id="memberAge" name="memberAge"></td>
						</tr>	
						<tr>
							<th width="150">*전화번호</th>
							<td width="300"><input type="tel" id="memberTel" name="memberTel" required="required"></td>
						</tr>
						<tr>
							<th width="150">*성별</th>
							<td width="300"><input type="text" id="memberGender" name="memberGender" required="required"></td>
						</tr>				
					</table>
				</div><br>
				<div>
					<input type="submit" value="등 록">&nbsp;&nbsp;
					<input type="reset" value="취 소">&nbsp;&nbsp;
					<input type="button" onclick="location.href='main.do'" value="홈가기">
				</div>
			</form>
			
		</section>
	</div>
	<script type="text/javascript">
		function formCheck(){
			let frm = document.getElementById("frm");
			if(frm.memberPW.value != frm.passwordcheck.value ){
				alert("패스워드가 일치 하지 않습니다.");
				frm.memberPW.value = "";
				frm.passwordcheck.value = "";
				frm.memberPW.focus();
				return false;
			}else if(frm.checkId.value != "Yes"){
				alert("아이디 중복체크를 수행하세요.");
				return false;
			}
			return true;
		}
		
		function idCheck(){
			let id = document.getElementById("memberId").value;
			let url = "ajaxCheckId.do?id="+id; //이건 get방식으로 보내는거 id라는 변수에 id(let id)라는 값을 담음. ajaxCheckId.do를 호출함
			fetch(url) //fetch = ajax를 사용하겠다. ajax호출(fetch api호출). get방식이니까 url만 던져주면 됨
				.then(response => response.text()) //여기 콜론안씀 처리된 결과를 text로 받고(text가 돌려받을 타입. json()이나 xml()도 가능)
				.then(text => htmlProcess(text)); //text받은 것을 화면에 alert로 찍어보겠다
		}
		
		function htmlProcess(data){
			if(data == 'Yes'){
				alert(document.getElementById("memberId").value + "\n 사용가능한 아이디 입니다.");
				document.getElementById("checkId").value = 'Yes';
			} else {
				alert(document.getElementById("memberId").value + "\n 이미 사용하는 아이디 입니다.");
				document.getElementById("memberId").value = "";
				document.getElementById("memberId").focus();
				
			}
		}
	</script>
</body>
</html>