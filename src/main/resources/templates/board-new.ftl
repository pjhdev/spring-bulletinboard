<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf8">
    <title> New Board </title>
</head>
<body>
<form action="/board/new" method="post" content="">
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