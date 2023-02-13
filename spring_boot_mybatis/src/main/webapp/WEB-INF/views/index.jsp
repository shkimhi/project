<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index</title>
	</head>
	<body>
		<!--로그인 하기 전에 보여줄 메뉴 항목  -->
		<c:if test="${empty sessionScope.sid }">
			<a href="<c:url value='/loginForm'/>">로그인</a> 
			<a href="<c:url value='/joinForm'/>">회원가입</a>
		</c:if>		
		
		<!-- 로그인 성공 후 보여줄 메뉴 항목 -->
		<c:if test="${not empty sessionScope.sid }">
			${sessionScope.sid}님 환영합니다! 
			<a href="<c:url value='/logout'/>">로그아웃</a> 
			<a href="<c:url value='/board/boardList'/>">게시판</a> 
			<a href="<c:url value='/member/myPage'/>">My Page</a>
		</c:if>
		<h3>Mybatis 사용</h3>
		<br>
		<a href="<c:url value='/product/productListAll'/>">전체 상품 조회</a><br><br>
		<a href="<c:url value='/product/productNewForm'/>"> 상품 등록</a>
		<hr>
		이미지 출력 <br>
		<!--resources 에서 image로 매핑 설정한 경우  -->
		<img src="image/apple.png"><br><br>
		<hr>
		
		<h3>Ajax 연습</h3>
		<a href="<c:url value='/loginForm'/>">로그인</a><br><br>
		<a href="<c:url value='/loginForm2'/>">로그인2</a>
		<hr>
		<a href="<c:url value='/product/productSearchForm1'/>">상품검색1</a><br><br>
		<a href="<c:url value='/product/productSearchForm2'/>">상품검색2</a><br><br>
		<a href="<c:url value='/product/productSearchForm3'/>">상품검색3</a><br><br>
		
		
		<hr>
		<a href="<c:url value='/fileUploadForm'/>">파일 업로드 </a><br/>
		<a href="<c:url value='/fileDownloadList'/>">파일 다운로드 </a><br/>
		
		<a href="<c:url value='/imageFileUploadForm'/>">이미지 파일 업로드 </a><br/>
		
	</body>
</html>