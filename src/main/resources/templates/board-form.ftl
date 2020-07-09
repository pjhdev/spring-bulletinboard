<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title> 게시글 작성/수정 </title>

    <!-- Custom fonts for this template -->
    <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/static/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body>
<#if type == "new">
    <#assign actionUrl = "/api/v1/board/new">
    <#assign header = "새 글 입력">
<#else>
    <#assign actionUrl = "/api/v1/board/edit/${board.boardId}">
    <#assign header = "글 수정">
</#if>

<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">${header}</h6>
                    </div>
                    <div class="card-body">
                        <form action=${actionUrl} method="post" content="">
                            <label for="staticId" class="col-form-label font-weight-bold">작성자 ID</label>
                            <div class="form-group">
                                <input type="text" readonly class="form-control-plaintext" id="staticId" name="userId" value="zkdlwnfm">
                            </div>
                            <div class="form-group">
                                <label for="title" class="col-form-label font-weight-bold">제목</label>
                                <input type="text" class="form-control" id="title" aria-describedby="titleHelp" name="title" <#if board??> value="${board.title}" </#if>>
                                <small id="titleHelp" class="form-text text-muted">20자 미만</small>
                            </div>
                            <div class="form-group">
                                <label for="contents" class="col-form-label font-weight-bold">내용</label>
                                <textarea class="form-control" id="contents" rows="3" name="contents"><#if board??> ${board.contents} </#if></textarea>
                            </div>
                            <input type="submit" value="Submit">
                        </form>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->
        </div>
    </div>
</div>
<!-- End of Main Content -->

</body>
</html>