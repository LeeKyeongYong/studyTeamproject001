<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <title>오류</title>
<link rel="stylesheet" href="css/error.css" >
</head>
<body>
	<div id="content">
	<%@ include file="/inc/imgError404.jspf"%>
		<center><h3>오류</h3></center>
		<table align="center">
			<tr>
				<th>오류 메시지</th>
			</tr>
			<tr>
				<td>예상치 못한 오류가 발생했습니다.</td>
			</tr>
		</table>
		<br />
		<div align="center">
			<span class="button">
				<a href="index.jsp">확 인</a>
			</span>
		</div>
	</div>
</body>
</html>