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
<c:choose>
<c:when test="${result}"><p>ユーザー登録が完了しました<p></c:when>
<c:otherwise><p>ユーザー登録に失敗しました</p></c:otherwise>
</c:choose>

<a href="/docoTsubu/index.jsp">トップへ</a>
</body>
</html>