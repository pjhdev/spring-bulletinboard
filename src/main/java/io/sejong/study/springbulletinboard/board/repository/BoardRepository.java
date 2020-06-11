package io.sejong.study.springbulletinboard.board.repository;

import io.sejong.study.springbulletinboard.board.entity.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findAll();

    Board findByBoardId(int boardId);
}
