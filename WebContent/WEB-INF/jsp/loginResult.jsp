<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h1>どこつぶログイン</h1>
<c:choose>
	<c:when test="${not empty sessionScope.loginUser}">
		<p>ログインに成功しました</p>
		<p>ようこそ<c:out value="${sessionScope.loginUser.name}" />さん</p>
		<a href="/docoTsubu/Main">つぶやき投稿・閲覧へ</a>
	</c:when>
	<c:otherwise>
		<p>ログインに失敗しました</p>
		<a href="/docoTsubu/">TOPへ</a>
	</c:otherwise>
</c:choose>
</body>
</html>