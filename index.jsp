<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link rel="stylesheet" href="style.css" >
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/docoTsubu/Login" method="post">
ユーザーID：<input type="text" name="id"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
※新規登録は<a href="/docoTsubu/UserRegister">こちら</a>から
</body>
</html>