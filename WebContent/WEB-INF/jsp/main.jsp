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
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name }"/>さん、ログイン中
<a href="/docoTsubu/Logout">ログアウト</a>
</p>
<p><a href="/docoTsubu/Main">更新</a></p>
<form action="/docoTsubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
	<p>${errorMsg}</p>
</c:if>
<a href="/docoTsubu/Main?page=${page-1}">前のページ</a>　　<a href="/docoTsubu/Main?page=${page+1}">次のページ</a>
<c:forEach var="mutter" items="${mutterList}" begin="${(page-1)*10}" end="${page*10-1}">
	<p><c:out value="${mutter.userName}"/>(<c:out value="${mutter.date}" />)：<c:out value="${mutter.text}" /></p>
</c:forEach>
</body>
</html>