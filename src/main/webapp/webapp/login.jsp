<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lnag="ko">

<head>
	<meta charset="UTF-8">
	<title>로그인</title>
	<link rel="stylesheet" href="./css/login.css">
	<script src="login.js"></script>

</head>

<body>

	<div class="main">

		<!--웹페이지 상단-->
	<!-- Header Section Begin -->
<center>  <a href="index.jsp"> <img alt="apple basket" src="./img/logo.png"></a> </center>
<!-- Header Section end -->
	<div class="main-signup">
		
		<!--로그인 부분-->
		<span></span>

		<section class="login-wrap">
			<form action="LoginCon.do" method="post">
			<div class="login-id-wrap">
				<input placeholder="아이디" type="text" class="input-id" name = "mbId"></input>
			</div>
			<div class="login-pw-wrap">
				<input placeholder="비밀번호" type="password" name = "mbPw" class="input-pw"></input>
			</div>
			<div class="login-btn-wrap" onclick="location.href='index.jsp'">
				<button class="login-btn" type ="submit" >로그인</button>
			</div>
			<div class="under-login">
				<span class="stay-check">
					<input type="checkbox" name="stay-btn" value="stay" class="stay-checkbox">로그인 상태 유지
				</span>
			</div>
			</form>
		</section>

		<!--회원가입-->
		<section class="join-wrap">

			<div class="join-box">
				<div class="join-btn"    
				onclick="location.href='join.jsp'"
				>
					<a href="join.jsp" target="_blank" title="join">회원가입</a>
				</div>

			</div>


		</section>

		</div>

		<!--저작권 정보-->
		<footer>
			<div class="copyright-wrap">
				<span> <img src="" width=70px> Copyright </span>
			</div>
		</footer>

	</div>

</body>

</html>