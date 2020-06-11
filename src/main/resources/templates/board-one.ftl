<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title> 게시글 조회 </title>
</head>
<body>
    <ul>
        <li>
            제목 : ${board.title}
        </li>
        <li>
            내용 : ${board.contents}
        </li>
        <li>
            작성자 : ${board.user.nickname}
        </li>
    </ul>

</body>
</html>