<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<title>FoodSharing</title>

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>

<body>
	<%//memberVo vo = (userVo)session.getAttribute("vo"); %>
		
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
    
    <!-- Humberger Begin -->
		<%@ include file="/Humberger.jsp" %>
    <!-- Humberger End -->
    
	<!-- Header Section Begin -->
		<%@ include file="/header.jsp" %>
	<!-- Header Section end -->
    	<section class="featured spad">
    		<input type="hidden" value='<c:out value="${communittyView.reply}"/>'>
	        <div class="container">
	        	<div class="col-lg-3">
	        		<table border="1" width="1000px;" style="text-align:center;">
	        			<tr>
	        				<th><c:out value="${communittyView.articleTitle}"/></th>
	        			</tr>
	        			<tr>
	        			<td>
	        			작성자:&nbsp;&nbsp;<c:out value="${communittyView.mbId}"/>&nbsp;&nbsp;|&nbsp;&nbsp;작성일:&nbsp;&nbsp;<c:out value="${communittyView.articleDate}"/> | 조회수: 6
	        			&nbsp;|&nbsp;
		        			<c:choose>
			        				<c:when test="${!empty communittyView.articleFile}">
			        					파일업로드 됨
			        				</c:when>
			        				<c:otherwise>
			        					파일업로드 되지 않음
			        				</c:otherwise>
			        		</c:choose>
		        			</td>
	        			</tr>
		        		<tr>
		        		   <td><c:out value="${communittyView.articleContent}"/></td>
		        		</tr>
	        		</table>
	        		<br/>
	        		<a href="communittyList.do?page=${param.page}">이전 으로</a>&nbsp;
	        		<a href="communittyUpdate.do?page=${param.page}&articleSeq=${param.articleSeq}">수정 하기</a>&nbsp;
	        		<a href="communittyDelete.do?articleSeq=${param.articleSeq}">삭제 하기</a>
	        	</div>
	        	<br />
						<c:if test="${commentList!=null }">
							<h3>덧글</h3>
								<table>
									<tr>
										<th>덧글 번호</th>
										<th width="60">작성자</th>
										<th>덧글</th>
										<th width="150">작성일</th>
									</tr>
									<c:forEach var="reply" items="${commentList}">
									<tr>
										<td><c:out value="${reply.cmtSeq}"/></td>
										<td align="center">${reply.mbId}</td>
										<td>${reply.cmtContent}
											<a href="commentDelete.do?articleSeq=${param.articleSeq}&cmtSeq=${reply.cmtSeq}" class="small">삭제</a>
										</td>
										<td align="center"><c:out value="${reply.cmtDate}"/></td>
									</tr>
									</c:forEach>
								</table>
								<br />
						</c:if> 
						
						<h3>덧글 달기</h3>
					<form name="fm" action="commentInsert.do" method="post">
						<input type="hidden" name="articleSeq" value="${param.articleSeq}"/>
						<input type="hidden" name="page" value="${param.page}" />
						
						<table>
							<tr>
								<th width="60">작성자</th>
								<td>작성자아이디</td>
							</tr>
							<tr>
								<th>덧글</th>
								<td><input type="text" name="cmtContent" size="80" /></td>
							</tr>
						</table> 
						
						<br />
						<div align="center">
							<span class="button">
								<a href="javaScript:submit()">등 록</a>
							</span>
						</div>
	        		</form>
	        
	        </div>
        </section>
	<!-- Hero Section Begin -->
	<%-- <section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>재료종류</span>
						</div>
						<ul>
							<li><a href="#">채소</a></li>
							<li><a href="#">과일</a></li>
							<li><a href="#">견과류</a></li>
							<li><a href="#">유제품</a></li>
							<li><a href="#">신선육</a></li>
							<li><a href="#">수산물</a></li>
							<li><a href="#">귤</a></li>
							<li><a href="#">못난이 상점</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__search">
						<div class="hero__search__form">
							<form action="#">
								<div class="hero__search__categories">
									전체 카테고리 <span class="arrow_carrot-down"></span>
								</div>
								<input type="text" placeholder="어떤 재료가 필요하시나요?">
								<button type="submit" class="site-btn">검색</button>
							</form>
						</div>
					</div>
					<div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/img/hero/banner.jpg">
						<div class="hero__text">
							<span>신선한 과일</span>
							<h2>
								야채 <br />100% 유기농
							</h2>
							<p>무료 픽업 및 배송가능</p>
							<a href="#" class="primary-btn">SHOP NOW</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> --%>
	<!-- Hero Section End -->

	<!-- Categories Section Begin -->
	<%-- <section class="categories">
		<div class="container">
			<div class="row">
				<div class="categories__slider owl-carousel">
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="img/categories/cat-1.jpg">
							<h5>
								<a href="#">신선한 과일</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${pageContext.request.contextPath}/img/categories/cat-2.jpg">
							<h5>
								<a href="#">견과류</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${pageContext.request.contextPath}/img/categories/cat-3.jpg">
							<h5>
								<a href="#">채소</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${pageContext.request.contextPath}/img/categories/cat-4.jpg">
							<h5>
								<a href="#">수산물</a>
							</h5>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="categories__item set-bg"
							data-setbg="${pageContext.request.contextPath}/img/categories/cat-5.jpg">
							<h5>
								<a href="#">신선육</a>
							</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section> --%>
	<!-- Categories Section End -->

	
	<!-- Featured Section Begin -->
    <%-- <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>제품 목록</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".vegetable">채소</li>
                            <li data-filter=".fruit">과일</li>
                            <li data-filter=".nuts">견과류</li>
                            <li data-filter=".dairy">유제품</li>
                            <li data-filter=".meat">신선육</li>
                            <li data-filter=".fish">수산물</li>
                            <li data-filter=".tangerine">귤</li>
                            <li data-filter=".ugly">못난이</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
                <div class="col-lg-3 col-md-4 col-sm-6 mix oranges vegetable">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg">
                         <span><a href="shop-details.jsp"><img alt="freshmeat" src="${pageContext.request.contextPath}/img/featured/feature-1.jpg"></a></span>
                            <ul class="featured__item__pic__hover">      
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                            
                        </div>
                        <div class="featured__item__text">
                            <div>
	                        	<span class="clock">clock</span>
	                            <span><a href="./shop-details.jsp">신선한 사과</a></span>
                        	</div>
                            <div>
	                            <span class="seller"><i class="fa fa-solid fa-user"></i>판매자1</span>
	                            <span class="location"><i class="fa fa-solid fa-map"></i>장소1</span>
	                            <span class="price"><i class="fa fa-solid fa-won"></i>2000원</span>
                            </div>
						</div>
                    </div>
                </div>
             	 <div class="col-lg-3 col-md-4 col-sm-6 mix oranges vegetable">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/img/featured/feature-1.jpg">
                            <ul class="featured__item__pic__hover">
                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <div>
	                        	<span class="clock">clock</span>
	                            <span><a href="#">신선한 사과</a></span>
                        	</div>
                            <div>
	                            <span class="seller"><i class="fa fa-solid fa-user"></i>판매자2</span>
	                            <span class="location"><i class="fa fa-solid fa-map"></i>장소2</span>
	                            <span class="price"><i class="fa fa-solid fa-won"></i>3000원</span>
                            </div>
						</div>
                    </div>
                </div>
            </div>
        </div>
    </section> --%>
    <!-- Featured Section End -->


	<!-- Footer Section Begin -->
	<%@ include file="../footer.jsp" %>
	<!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>