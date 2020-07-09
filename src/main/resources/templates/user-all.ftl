<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <#include "common/css.ftl">
    <title> 유저 조회 </title>
</head>
<body>
    <#list users.iterator() as user>
        <ul>
            <li>아이디 : ${user.id}</li>
            <li>닉네임 : ${user.nickname}</li>
            <li>비밀 번호 : ${user.password}</li>
        </ul>

    </#list>
</body>
</html>