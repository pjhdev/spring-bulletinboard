<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf8">
    <title> 전체 조회 </title>
</head>
<body>
    <#list users as user>
        <ul>
            <li>글 번호 : ${user.nickname}</li>
            <li>비밀 번호 : ${user.password}</li>
        </ul>

    </#list>
</body>
</html>