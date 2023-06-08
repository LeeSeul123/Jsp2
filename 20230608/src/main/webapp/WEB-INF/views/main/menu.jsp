<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin: 0;
		padding: 0;
		text-decoration: none;
		margin: 0 auto;
		text-align: center;
	}
	#nav{
		width: 1000px;
		background: black;
		margin: 0 auto;
	}
	#nav ul{
	 	list-style: none;
	 	display: flex;
	 	justify-content: space-around;
	}
	
	#nav a:hover{
		color: pink;
	}
	#nav a{
		color: white;
		padding:10px;
		display: inline-block;
	}
</style>
</head>
<body>
	<div id="nav">
		<ul>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
		</ul>
	</div>
</body>
</html>