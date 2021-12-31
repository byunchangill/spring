<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="/user/join" method="post">
        <div><input type="text" name="uid" placeholder="아이디" required></div>
        <div><input type="password" name="upw" placeholder="비밀번호" required></div>
        <div><input type="text" name="nm" placeholder="이름" required></div>
        <div>
            성별 : <label>여성 <input type="radio" value="2" name="gender"></label>
            <label>남성 <input type="radio" value="1" name="gender" checked></label>
        </div>
        <div>
            <input type="submit" value="회원가입">
        </div>
    </form>
</body>
</html>
