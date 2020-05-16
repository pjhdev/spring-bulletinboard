<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>입력</title>
</head>
<body>
    <!-- form 태그 사용 -->
    <!-- '/sample/update', '/sample/create' 처리 분기 -->
    <#if type == "UPDATE">
        ${sample.name}<br />
        ${sample.age}<br />
        ${sample.birthday}<br />
        ${sample.address}<br />
    </#if>
</body>
</html>