package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.Reply;
import io.sejong.study.springbulletinboard.board.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ReplyController {

    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) { this.replyService = replyService; }

    /**
     * 댓글 생성
     */
    @PostMapping(value = "/reply/new", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String createReply(@RequestParam(value = "boardId") int boardId, Reply reply)
    {
        replyService.saveReply(reply, boardId);

        return "redirect:/api/v1/board/" + boardId;
    }

    /**
     * 댓글 삭제
     */
    @GetMapping(value = "/reply/delete/{replyId}")
    public String deleteBoard(@PathVariable int replyId)
    {
        Reply reply = replyService.getReplyById(replyId);
        replyService.deleteReplyById(replyId);

        return "redirect:/api/v1/board/" + reply.getBoard().getBoardId();
    }
}
