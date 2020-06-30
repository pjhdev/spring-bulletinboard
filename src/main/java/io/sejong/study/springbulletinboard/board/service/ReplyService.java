package io.sejong.study.springbulletinboard.board.service;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.entity.Reply;
import io.sejong.study.springbulletinboard.board.repository.BoardRepository;
import io.sejong.study.springbulletinboard.board.repository.ReplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    public ReplyService(ReplyRepository replyRepository, BoardRepository boardRepository) {
        this.replyRepository = replyRepository;
        this.boardRepository = boardRepository;
    }

    public Page<Reply> getAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 3);

        return replyRepository.findAll(pageable);
    }

    public Reply getReplyById(int replyId) { return replyRepository.findByReplyId(replyId); }

    public Reply saveReply(Reply reply, int boardId) {
        Board board = boardRepository.findByBoardId(boardId);
        reply.setBoard(board);
        return replyRepository.save(reply);
    }

    public void deleteReplyById(int replyId) { replyRepository.deleteById(replyId); }
}
