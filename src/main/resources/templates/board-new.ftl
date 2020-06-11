<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title> 게시글 생성 </title>
</head>
<body>
<form action="/api/v1/board/new" method="post" content="">
    Title:<br>
    <input type="text" name="title">
    <br><br>
    Contents:<br>
    <input type="text" name="contents">
    <br><br>
    UserId:<br>
    <input type="text" name="userId">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>