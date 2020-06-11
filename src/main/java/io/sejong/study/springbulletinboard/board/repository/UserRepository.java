package io.sejong.study.springbulletinboard.board.repository;

import io.sejong.study.springbulletinboard.board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    User findById(String id);
}
