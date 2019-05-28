<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜尋租借編號</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
#X1 {
	border: thick solid #99BBFF;
	width: 700px;
	border-radius: 20px;
	margin: 200px 400px;
	background-color: #FFCCCC;
	height: 400px;
}
h1 {
	color: #003C9D;
	font-family: 標楷體;
	font-weight: 700;
	letter-spacing: 3px;
}
h2 {
	text-align: center;
}
#Y1 {
	text-align: center;
}
</style>
</head>
<body>
	<div id='X1'>
		<div style="padding-left: 50px">
			<h1>EEIT-10728 單車租借資訊系統</h1>
		</div>
		<form name="findForm" action="<c:url value='find.do' />" method="POST">
			<h2>想要搜尋的租借編號:</h2>
			<div id='Y1'>
				<input id='num' style="text-align: left" name="caseNum" type="text"
					size="14"> <input type="submit" value="送出">
			</div>
		</form>
		<div style="text-align: center; padding-top: 20px">
			<a href="<c:url value='index.jsp'/>">返回首頁</a>
		</div>
	</div>
</body>
</html>