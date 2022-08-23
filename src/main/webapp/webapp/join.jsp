<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Apple Basket 회원가입</title>
<link rel="stylesheet" href="./css/join.css">
<script src="login.js"></script>

</head>

<body>

	<div class="main-signup">
		<!--웹페이지 상단-->
		<header>
			<!--Apple Basket LOGO-->
			<div class="logo">
				<center> <a href="index.jsp" target="_blank" title="Apple Basket 홈페이지"><img
					src="./img/logo.png" ></a> </center>
			</div>
		</header>

		<!--회원가입 부분-->
		<section class="signup-wrap">
		<form action="JoinCon.do" method="post">
			<div>
				<!--아이디,비번,비번재확인-->

				<h3>아이디</h3>
				<span class="signup-input"> <input id="signup-id" type="text" name="mbId"></input>
					<span class="signup-at"></span>
				</span>

				<h3>비밀번호</h3>
				<span class="signup-input"> <input id="signup-pw" name="mbPw"
					type="password"></input> <span class="pw-lock"></span>
				</span>

			</div>

			<div style="margin-top: 20px;">
				<!--이름,생년월일,성별,이메일-->
				
				<!-- 농부, 일반회원 선택 -->
			
				<h3>회원구분</h3>
				<div class="checkbox" style="text-align : left;">
					일반회원<input value="0" checked="checked" type="radio" name="mbGubun" class="checkbox1">
    				농부<input value="1" type="radio" name="mbGubun" class="checkbox1"><br>
				</div>
				
				<h3>이름</h3>
				<span class="signup-input"> <input id="signup-name" name="mbName"
					type="text"></input>
				</span>

				<h3>생년월일</h3>
				<span style="display: flex;"> <span
					class="signup-input-birth"> <input id="signup-birth-yy"
						type="text" name="year" placeholder="년(4자)"></input>
				</span> <span class="signup-input-birth" style="margin-left: 10px;">
						<input id="signup-birth-dd" type="text" name="month" placeholder="월"></input>
				</span> <span class="signup-input-birth" style="margin-left: 10px;">
						<input id="signup-birth-dd" type="text" name="day" placeholder="일"></input>
				</span>
				</span>

				<h3>성별</h3>
				<span class="signup-input"> <select id="signup-gender"
					class="selectbox" name="mbGender" onchange="">
						<option value="M">남자</option>
						<option value="F">여자</option>
				</select>
				</span> <span class="choice">
					<h3>휴대전화</h3>
				</span> <span class="signup-input"> <input id="signup-phone"
					type="text" name="mbPhone" ></input>
				</span>

			</div>

			<div style="margin-top: 20px;">
			
			<!-- 주소 -->
				<h3>주소</h3>
				<table>
					<tr>
                        <td>
                        <!-- 우편번호 -->   
                        <span class="signup-input" style="width: 300px;"><input type="text" id="re_postcode" name="re_postcode" style="border: none; " placeholder="우편번호">
						<span class="signup-at"></span></span>
						</td>
							<td>
						<!-- 우편번호 찾기 버튼-->  
						<input id="cnum-btn" type="button" style="height: 38px; width:110px; background-color: #7fad39;
  						border: none; color:#fff; font-size: 15px; outline:none; cursor: pointer; margin-left: 10px;"
                        onclick="user_region()" value="우편번호 찾기">
                           </td>
                   	</tr>   
                      <tr>  
                      	<td>
                     	<!-- 도로명주소 -->  
                        <span class="signup-input" style="width: 300px; "><input type="text" id="re_roadAddress" name="re_roadAddress" style=" width: 300px; border: none" placeholder="도로명주소">
						<span class="signup-at"></span></span>
                   	   </td> 
                     </tr>
                    <tr>
                    	<td>    
                    	<!-- 상세주소 -->  
                    	<span class="signup-input" style="width: 300px"><span id="guide" style="color: #999; display: none "></span> 
                    	<input type="text" id="re_detailAddress" name="re_detailAddress" placeholder="상세주소" style="border: none; width: 300px;"> 
                    	<input type="hidden" id="re_extraAddress" name="re_extraAddress" placeholder="법정동">
						<span class="signup-at"></span></span>    
						</td>  
                    </tr>
				</table>
			</div>

			<div>
				<!--가입하기-->
				<div class="signup-btn-wrap">
					<button id="signup-btn">가입하기</button>
				</div>
			</div>
			</form>
		</section>
		<!--저작권 정보-->
		<footer>
			<div class="copyright-wrap" style="font-size: 12px;">
				<span>이용약관 | 개인정보처리방침 | 책임의 한계와 고지 | 회원정보 고객센터</span>
			
			</div>
		</footer>

	</div>

</body>
<!-- 주소 관련 scripts -->
<script>
	// 본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 
	// 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function user_region() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						let roadAddr = data.roadAddress; // 도로명 주소 변수
						let extraRoadAddr = ''; // 참고 항목 변수
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('re_postcode').value = data.zonecode;
						document.getElementById("re_roadAddress").value = roadAddr;
						/* document.getElementById("re_jibunAddress").value = data.jibunAddress; */

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("re_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("re_extraAddress").value = '';
						}
						let guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							let expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';
						} else if (data.autoJibunAddress) {
							let expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}
</script>

<script>
	// 카카오 주소 api
	function findAddr() {
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data); // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다. // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
				let roadAddr = data.roadAddress;
				// 도로명 주소 변수 
				let jibunAddr = data.jibunAddress;
				// 지번 주소 변수 
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('member_post').value = data.zonecode;
				if (roadAddr !== '') {
					document.getElementById("member_addr").value = roadAddr;
				} else if (jibunAddr !== '') {
					document.getElementById("member_addr").value = jibunAddr;
				}
			}
		}).open();
	}
</script>


<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>