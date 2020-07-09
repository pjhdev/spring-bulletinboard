<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <#include "common/css.ftl">
    <title> 유저 조회 </title>
</head>
<body>
    <ul>
        <li>
            아이디 : ${user.id}<br>
            닉네임 : ${user.nickname}<br>
            비밀번호 : ${user.password}<br>
        </li>
    </ul>

</body>
</html>