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
    <#list replyList as reply>
        <ul>
            <li>댓글 : ${reply.contents} <button type="button" onclick="location.href='/api/v1/reply/delete/${reply.replyId}'">delete</button> </li>
        </ul>
    </#list>
    <button type ="button" onclick="location.href='/api/v1/board/delete/${board.boardId}'">delete</button>
    <form class="form-control-plaintext" action="/api/v1/reply/new?boardId=${board.boardId}" method="post">
        댓글 : <input class="text-body" name="contents"><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>