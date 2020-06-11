<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title> 게시글 전체 조회 </title>
</head>
<body>
    <#list boards.iterator() as board>
        <ul>
            <li>글 번호 : ${board.boardId}</li>
            <li>제목 : ${board.title}</li>
            <li>내용 : ${board.contents}</li>
            <li>작성시간 : ${board.createdAt}</li>
        </ul>

    </#list>
</body>
</html>