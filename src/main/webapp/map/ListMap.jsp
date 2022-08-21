<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>안전센터</title>
    
</head>
<body>
<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:100%;height:650px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7365c4645c814b3b6164f85f080385"></script>
<!-- <script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(35.14656630460124,126.92220365444032), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 
</script> -->
<!-- 발급받은 javascript app key -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9f7365c4645c814b3b6164f85f080385&libraries=services,clusterer,drawing"></script>

	<!-- 지도를 띄우는 코드 -->
	<script>
		var container = document.getElementById('map'); //지도를 표시할 div
		var options = {
			center : new kakao.maps.LatLng(35.14656630460124,126.92220365444032), //지도 중심좌표 36.10315425538241, 129.38842737437503
			level : 3
		//지도 확대 레벨 
		};

		var map = new kakao.maps.Map(container, options); //지도 생성

		// infowindow title+content 합치기 
		var dal_in = '<div style="padding:5px; background-color:#F15F5F"> <b>달인의 찜닭</b> <br>-매장 방문시 현금/계좌 송금 소자 1000원/ 중,대자 2000원 할인</div>';
		var dong_gung = '<div style="padding:5px; background-color:#F15F5F"> <b>동궁 찜닭</b> <br>-홀 방문시 찜닭 메뉴에 한해 10%할인</div>';
		var seoga = '<div style="padding:5px; background-color:#F15F5F"> <b>서가앤쿡</b> <br>-카드 5%, 현금 10%할인<br>-테이블당 음료수 한잔 서비스</div>';
		var shinjeon = '<div style="padding:5px; background-color:#F15F5F"> <b>신전 떡볶이</b> <br>-매장에서 현금결제시 1만원당 1천원 현금할인<br>-매장에서 카드결제시 1만원 이상 주문시 튀만두 or 튀오뎅 1인분 서비스<br>-배달 시 현금 or 이체의 경우 퀵비 2천원 할인</div>';
		var ssal = '<div style="padding:5px; background-color:#F15F5F"> <b>쌀통닭</b> <br>-매장 방문 시 현금결제 10% 할인<br>-카드 결제 5%할인</div>';
		var unggeup = '<div style="padding:5px; background-color:#F15F5F"> <b>응급실 떡볶이</b> <br>-16000원 이상 구매시 배달비 1000원 할인<br>-30000원 이상 구매시 배달비 무료<br>-수요일 팀모임 시간, 시험기간 점심, 저녁, 야식 이벤트 별도: 쿨피스 무료</div>';
		var pambal = '<div style="padding:5px; background-color:#F15F5F"> <b>팜스발리</b> <br>-현금/계좌 결제 6%할인</div>';
		var inbreeze = '<div style="padding:5px; background-color:#F15F5F"> <b>인브리즈</b> <br>-공연/행사 등을 위한 장소 무료 제공 (영업시간 등 조율 필요)</div>';
		var segoi = '<div style="padding:5px; background-color:#F15F5F"> <b>스고이 라멘</b> <br>-음료 or 밥 무료 제공</div>';
		var dolhar = '<div style="padding:5px; background-color:#F15F5F"> <b>돌하르방 국수</b></div>';

		var gecoffee = '<div style="padding:5px; background-color:#F2CB61"> <b>그냥 커피주세요</b> <br>-전체금액의 10%할인</div>';
		var nonstand = '<div style="padding:5px; background-color:#F2CB61"> <b>논스탠다드</b> <br>-전메뉴 10%할인<br>-프로젝트 공간 제공 가능</div>';
		var ydd = '<div style="padding:5px; background-color:#F2CB61"> <b>양덕동 마카롱</b> <br>-개당 100원 할인</div>';
		var hisbeans = '<div style="padding:5px; background-color:#F2CB61"> <b>히즈빈스 랩</b> <br>-음료 500원 할인</div>';
		var hayan = '<div style="padding:5px; background-color:#F2CB61"> <b>헤이안</b> <br>-음료 10%할인</div>';
		var pamtable = '<div style="padding:5px; background-color:#F2CB61"> <b>팜테이블</b> <br>-메뉴당 평일 10% 할인(주말,공휴일 제외)</div>';

		var onlyu = '<div style="padding:5px; background-color:#BCE55C"> <b>온리유 짐</b> <br>-월 10만원 (개인맞춤 자율운동&체형교정 관리)<br>-체형교정 및 관리 무료체험 가능</div>';
		var design = '<div style="padding:5px; background-color:#BCE55C"> <b>디자인 짐</b> <br>-2개월 등록시 20%할인(16만원)<br>-3개월 등록시 30%할인(18만원)</div>';
		var fitn = '<div style="padding:5px; background-color:#BCE55C"> <b>핏앤밸런스</b> <br>-1개월 등록시 50,000원+반신욕 포함</div>';
		var vida = '<div style="padding:5px; background-color:#BCE55C"> <b>비다펠리즈</b></div>';

		var coc = '<div style="padding:5px; background-color:#5CD125"> <b>COC 헤어</b> <br>-전체시술 현금/계좌 30%할인 , 카드 20%할인<br>-컷트, 뿌리시술 20%할인(현금,카드 상관 X)</div>';
		var igaza = '<div style="padding:5px; background-color:#5CD125"> <b>이가자 헤어비스</b> <br>-펌 30%, 컷트 20%, 염색 30% 할인</div>';
		var adam = '<div style="padding:5px; background-color:#5CD125"> <b>아담 네일</b> <br>-반영구눈썹,미인점,슈가왁싱,젤네일,패디,속눈썹펌 등 모든관리 10% 할인 (이벤트 적용불가, 동시 시술 불가)</div>';
		var hello = '<div style="padding:5px; background-color:#5CD125"> <b>반가워 뷰티</b> <br>-기본할인가 추가 10%할인 (속눈썹 연장, 펌, 스킨케어, 반영구)</div>';

		var simplefit = '<div style="padding:5px; background-color:#A366FF"> <b>Simple Fit</b> <br>-단체복 주문시 배송비 무료<br>-티 제작시 교수님티 무료</div>';
		var alpha = '<div style="padding:5px; background-color:#A366FF"> <b>알파문구</b> <br>-할인 10%(일부 품목제외)</div>';
		var onemusic = '<div style="padding:5px; background-color:#A366FF"> <b>원뮤직 피아노</b> <br>-원비의 10% 할인/레슨 30분 주 2회/ 50분 주 1회)</div>';
		var ouryard = '<div style="padding:5px; background-color:#A366FF"> <b>아워야드</b> <br>-대여료 50% 할인</div>';

		// 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [
				{
					title : '충장동주민센터',
					content : dal_in,
					latlng : new kakao.maps.LatLng(35.16093874439101,
					126.91847135349504)
				},

				{
					title : '동명동주민센터',
					content : dong_gung,
					latlng : new kakao.maps.LatLng(35.150355517232555,
					126.92785407506125)
				},

				{
					title : '계림1동주민센터',
					content : seoga,
					latlng : new kakao.maps.LatLng(35.158534716852735,
					126.91966788972043)
				},

				{
					title : '계림2동주민센터',
					content : shinjeon,
					latlng : new kakao.maps.LatLng(35.158213709356346,
					126.92510326606532)
				},

				{
					title : '산수1동주민센터',
					content : ssal,
					latlng : new kakao.maps.LatLng(35.15730487723084,
						126.93072348572973)
				},

				{
					title : '산수2동주민센터',
					conetent : unggeup,
					latlng : new kakao.maps.LatLng(35.15457852039259,
					126.93611232632594)
				},

				{
					title : '지산1동주민센터',
					content : pambal,
					latlng : new kakao.maps.LatLng(35.824879383765385,
							129.39151503979966)
				},

				{
					title : '지산2동주민센터',
					content : inbreeze,
					latlng : new kakao.maps.LatLng(35.82311968332472,
					128.62800598521366)
				},

				{
					title : '서남동주민센터',
					content : segoi,
					latlng : new kakao.maps.LatLng(35.144944459905744,
					126.92315332586558)
				},

				{
					title : '학동주민센터',
					content : dolhar,
					latlng : new kakao.maps.LatLng(35.135587961636205,
					126.92259155129578)
				}

				

		];

		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
		//var imageSrc2 = "../img/placeholder.png"; 

		for (var i = 0; i < positions.length; i++) {

			// 마커 이미지의 이미지 크기 입니다
			var imageSize = new kakao.maps.Size(24, 35);

			// 마커 이미지를 생성합니다    
			var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

			// 마커를 생성합니다
			var marker = new kakao.maps.Marker({
				map : map, // 마커를 표시할 지도
				position : positions[i].latlng, // 마커를 표시할 위치
				image : markerImage
			// 마커 이미지 
			});

			// 마커에 표시할 인포윈도우를 생성합니다 
			var infowindow = new kakao.maps.InfoWindow({
				content : positions[i].content
			// 인포윈도우에 표시할 내용
			});

			// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
			// 이벤트 리스너로는 클로저를 만들어 등록합니다 
			// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
			kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(
					map, marker, infowindow));
			kakao.maps.event.addListener(marker, 'mouseout',
					makeOutListener(infowindow));
		}

		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
			return function() {
				infowindow.open(map, marker);
			};
		}

		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
			return function() {
				infowindow.close();
			};
		}
	</script>
</body>
</html>