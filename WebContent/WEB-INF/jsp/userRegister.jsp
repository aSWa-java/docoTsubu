<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶユーザー名登録</h1>
<c:if test="${not empty errorMsg}">
<c:out value="${errorMsg}" /><br>
</c:if>
<form action="/docoTsubu/UserRegister" method="post">
ユーザーID：<input type="text" name="id"><br>
パスワード：<input type="password" name="pass"><br>
パスワード再入力：<input type="password" name="pass2"><br>
ユーザー名：<input type="text" name="name"><br>
<input type="submit" value="確認"><br>
<a href="index.jsp">トップへ</a>
</form>
</body>
</html>