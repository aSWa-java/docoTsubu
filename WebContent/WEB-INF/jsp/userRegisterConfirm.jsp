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
<h1>どこつぶユーザー登録</h1>
以下の内容で登録します。<br>
ユーザーID：<c:out value="${registerUser.id}" /><br>
パスワード：非表示<br>
ユーザー名：<c:out value="${registerUser.name}" /><br>
<input type="submit" value="確認" onclick="location.replace('/docoTsubu/UserRegister?action=done')"><br>
<a href="index.jsp">トップへ</a>
</body>
</html>