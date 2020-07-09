<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <#include "common/css.ftl">
    <title> 유저 생성 </title>
</head>
<body>
<form action="/api/v1/user/new" method="post" content="">
    Id:<br>
    <input type="text" name="id">
    <br><br>
    Nickname:<br>
    <input type="text" name="nickname">
    <br><br>
    Password:<br>
    <input type="text" name="password">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>