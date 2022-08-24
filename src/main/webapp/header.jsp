<%@page import="com.foodshring.VO.t_memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>FoodSharing</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<% t_memberVO vo = (t_memberVO)session.getAttribute("vo"); %>
	<!-- Header Section Begin -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="./index.jsp"><img src="img/logo.png" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li class="active"><a href="./index.jsp">홈</a></li>
							<li><a href="./shop-grid.jsp">상품목록</a></li>
							<li><a href="#">기타</a>
								<ul class="header__menu__dropdown">
									<li><a href="#">1.결재</a></li>
									<li><a href="communittyList.do?page=1">2.게시판</a></li>
									<li><a href="#">3.카테고리</a></li>
								</ul></li>
							<!--  
							<li><a href="./blog.jsp">농부</a></li>
							-->
							<li><a href="./contact.jsp">안전주소</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
						<ul>
							<li><a href="./shoping-cart.jsp"><i class="fa fa-shopping-bag"></i> <span>0</span></a></li>
						</ul>
						<div class="header__cart__price">
							item: <span>0원</span>
						</div>
						<div class="header__top__right__auth">
							<%if(vo != null){%>
								<a href="LogoutCon.do"><i class="fa fa-user">로그아웃</i></a>
								
							<%}else{%>
								<a href="login.jsp"><i class="fa fa-user">로그인</i></a>
							<%}%>
						</div>
				
					</div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->
</body>
</html>