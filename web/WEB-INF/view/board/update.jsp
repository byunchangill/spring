<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>수정</title>
</head>
<body>
    <h1>수정</h1>
    <div>${requestScope.msg}</div>
    <form action="/board/update" method="post">
        <input type="hidden" name="iboard" value="${requestScope.data.iboard}">
        <div><input type="text" name="title" placeholder="제목" value="<c:out value='${requestScope.data.title}'/>"></div>
        <div><textarea name="ctnt" placeholder="내용"><c:out value="${requestScope.data.ctnt}"/></textarea></div>
        <div>
            <input type="submit" value="수정">
            <input type="reset" value="취소">
        </div>
    </form>
    <script src="/res/js/board/detail.js"></script>
</body>
</html>
