<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf8">
    <title> 전체 조회 </title>
</head>
<body>
    <#list boards as board>
        <ul>
            <li>글 번호 : ${board.boardId}</li>
            <li>제목 : ${board.title}</li>
            <li>내용 : ${board.contents}</li>
            <li>작성시간 : ${board.createdAt}</li>
        </ul>

    </#list>
</body>
</html>