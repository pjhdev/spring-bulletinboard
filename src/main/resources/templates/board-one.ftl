<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf8">
    <title> 단건 조회 </title>
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