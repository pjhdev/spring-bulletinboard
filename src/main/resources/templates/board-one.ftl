<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <#include "common/css.ftl">
    <title> 게시글 조회 </title>
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

                    <div class="card" style="width: 18rem;">
                        <div class="card-header">
                            댓글
                        </div>
                        <div>
                            <ul class="list-group list-group-flush">
                                <#if board.getReplyList()??>
                                    <#list board.getReplyList() as reply>
                                        <li class="list-group-item">
                                            <div style="float:left">
                                                ${reply.contents}
                                            </div>
                                            <div style="float:right">
                                                <button class="btn btn-primary" onclick="location.href='/api/v1/reply/delete/${reply.replyId}'">삭제</button>
                                            </div>
                                        </li>
                                    </#list>
                                </#if>
                            </ul>
                        </div>
                    </div>

                    <#--<#if board.getReplyList()??>
                        <#list board.getReplyList() as reply>
                            <ul>
                                <li>${reply.contents} <button type="button" class="btn btn-primary" onclick="location.href='/api/v1/reply/delete/${reply.replyId}'">댓글 삭제</button> </li>
                            </ul>
                        </#list>
                    </#if>-->

                    <div class="card-footer">
                        <form class="form-control-plaintext" action="/api/v1/reply/new?boardId=${board.boardId}" method="post">
                            <ul class="nav nav-pills card-header-pills">
                                <li class="nav-item">
                                    <input type="text" class="form-control" id="reply" name="contents">
                                </li>
                                <li class="nav-item">
                                    <input type="submit" value="댓글 작성" class="btn btn-primary">
                                </li>
                            </ul>
                        </form>
                    </div>


                    <div class="card-footer">
                        <ul class="nav nav-pills card-header-pills">
                            <li class="nav-item">
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
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>