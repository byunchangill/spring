<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
</head>
<body>
    <h1>로그인</h1>
    <div>${requestScope.msg}</div>
    <form action="/user/login" method="post">
        <div>아이디<input type="text" name="uid" placeholder="아이디"></div>
        <div>비밀번호<input type="password" name="upw" placeholder="비밀번호"></div>
        <div><input type="submit" value="로그인"></div>
    </form>
    <div>
        <a href="/user/join"><input type="button" value="회원가입"></a>
    </div>
</body>
</html>
