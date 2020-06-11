package io.sejong.study.springbulletinboard.board.service;

import io.sejong.study.springbulletinboard.board.entity.User;
import io.sejong.study.springbulletinboard.board.repository.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) { this.userRepository = userRepository; }

    public Page<User> getAll(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 3);

        return userRepository.findAll(pageable);
    }

    public User getUserById(String id) { return userRepository.findById(id); }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
