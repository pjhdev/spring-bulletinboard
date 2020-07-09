<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <#include "common/css.ftl">
    <title> 게시글 전체 조회 </title>
</head>
<body id="page-top">
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
                            <h6 class="m-0 font-weight-bold text-primary">게시글</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                                <thead class="thead-dark">
                                                <tr>
                                                    <th>게시글 번호</th>
                                                    <th>제목</th>
                                                    <th>작성자</th>
                                                    <th>작성시간</th>
                                                </tr>
                                                </thead>
                                                <tfoot>
                                                <tbody>
                                                <#list boards.iterator() as board>
                                                    <tr>
                                                        <td><a href="/api/v1/board/${board.boardId}">${board.boardId}</a></td>
                                                        <td>${board.title}</td>
                                                        <td>${board.user.nickname}</td>
                                                        <td>${board.createdAt}</td>
                                                    </tr>
                                                </#list>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <#assign lastPage = boards.getTotalPages()>
                                    <#include "common/page-bar.ftl">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
            </div>
        </div>
    </div>
    <!-- End of Main Content -->

    <a class="scroll-to-top rounded" href="#page-top" style="display: inline;">
        <i class="fas fa-angle-up"></i>
    </a>
</body>
</html>