<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title> 게시글 조회 </title>

    <!-- Custom fonts for this template -->
    <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/static/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body>
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="card text-left">
                    <div class="card-body">
                        <div class="row card-header py-3">
                            <div class="col-form-label font-weight-bold text-primary">작성자</div>
                            <div class="col">${board.user.nickname}</div>
                        </div>
                        <div class="row card-header py-3">
                            <div class="col-form-label font-weight-bold text-primary">제목</div>
                            <div class="col">${board.title}</div>
                        </div>
                        <div class="row card-header py-3">
                            <div class="col-form-label font-weight-bold text-primary">내용</div>
                            <div class="col text-body text-left">${board.contents}</div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <ul class="nav nav-pills card-header-pills">
                            <li class="nav-item">
                                <#--<a class="nav-link" href="/api/v1/board/all">이전</a>-->
                                <a class="nav-link" href="javascript:history.back()">이전</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/api/v1/board/form?type=edit&board_id=${board.boardId}">수정</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/api/v1/board/delete/${board.boardId}">삭제</a>
                            </li>
                        </ul>
                    </div>
                    <#if board.getReplyList()??>
                        <#list board.getReplyList() as reply>
                            <ul>
                                <li>댓글 : ${reply.contents} <button type="button" onclick="location.href='/api/v1/reply/delete/${reply.replyId}'">delete</button> </li>
                            </ul>
                        </#list>
                    </#if>

                    <#--<form class="form-control-plaintext" action="/api/v1/reply/new?boardId=${board.boardId}" method="post">
                        댓글 : <input class="text-body" name="contents"><br>

                        <input type="submit" value="Submit">
                    </form>-->
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>