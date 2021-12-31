<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글쓰기</title>
</head>
<body>
    <h1>글쓰기</h1>
    <div>${requestScope.msg}</div>
    <form action="/board/write" method="post">
        <div><input type="text" name="title" placeholder="제목" value="${requestScope.data.title}"></div>
        <div><textarea name="ctnt" placeholder="내용">${requestScope.data.ctnt}</textarea></div>
        <div>
            <input type="submit" value="저장">
        </div>
    </form>
</body>
</html>
