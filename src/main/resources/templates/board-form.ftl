<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title> 게시글 작성/수정 </title>
</head>
<body>
<#if type == "new">
    <form action="/api/v1/board/new" method="post" content="">
<#else>
        <form action="/api/v1/board/edit/${board.boardId}" method="post" content="">
</#if>
    Title:<br>
    <input type="text" name="title">
    <br><br>
    Contents:<br>
    <input type="text" name="contents">
    <br><br>
    <#if type == "new">
        UserId:<br>
        <input type="text" name="userId">
        <br><br>
    </#if>
    <input type="submit" value="Submit">
</form>
</body>
</html>