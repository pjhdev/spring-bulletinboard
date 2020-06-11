package io.sejong.study.springbulletinboard.board.service;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.entity.User;
//import io.sejong.study.springbulletinboard.board.http.req.SampleCreateRequest;
//import io.sejong.study.springbulletinboard.board.http.req.SampleUpdateRequest;
import io.sejong.study.springbulletinboard.board.repository.BoardRepository;
import io.sejong.study.springbulletinboard.board.repository.UserRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    public Board getBoardById(int boardId) { return boardRepository.findByBoardId(boardId); }

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Board saveBoard(Board board, int userId) {
        User user = userRepository.findByUserId(userId);
        board.setUser(user);

        return boardRepository.save(board);
    }
}
