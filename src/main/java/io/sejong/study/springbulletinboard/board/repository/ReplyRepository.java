package io.sejong.study.springbulletinboard.board.repository;

import io.sejong.study.springbulletinboard.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    List<Reply> findAll();

    Reply findByReplyId(int boardId);
}
