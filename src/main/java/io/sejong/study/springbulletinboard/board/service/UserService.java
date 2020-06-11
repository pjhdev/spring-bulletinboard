package io.sejong.study.springbulletinboard.board.service;

import io.sejong.study.springbulletinboard.board.entity.User;
import io.sejong.study.springbulletinboard.board.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(int userId) { return userRepository.findByUserId(userId); }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
