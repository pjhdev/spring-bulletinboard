package io.sejong.study.springbulletinboard.board.service;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.entity.User;
import io.sejong.study.springbulletinboard.board.repository.BoardRepository;
import io.sejong.study.springbulletinboard.board.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public Page<Board> getAll(int page) {
        page  = page <= 0 ? 0 : page - 1;
        PageRequest pageRequest = PageRequest.of(page, 3);
        return boardRepository.findAll(pageRequest);
    }

    public Board getBoardById(int boardId) { return boardRepository.findByBoardId(boardId); }

    public Board saveBoard(Board board) { return boardRepository.save(board); }

    public Board saveBoard(Board board, String id) {
        User user = userRepository.findById(id);
        board.setUser(user);

        return boardRepository.save(board);
    }

    public void deleteBoardById(int boardId) { boardRepository.deleteById(boardId); }
}
