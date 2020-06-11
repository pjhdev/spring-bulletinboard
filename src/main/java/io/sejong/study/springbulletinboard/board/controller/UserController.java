package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.User;
import io.sejong.study.springbulletinboard.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/v2")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    /**
     * 게시글 내용 전체 조회 - Admin 조회 권한 추후 추가해야함.
     */
    @RequestMapping(value ="/user/all", produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(Model model) {
        List<User> userList = userService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-all");
        mv.addObject("users", userList);

        return mv;
    }

    /**
     * 유저 전체 조회 - Admin 조회 권한 추후 추가해야함.
     */
    @RequestMapping(value = "/user/id/{userId}", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(@PathVariable int userId) {
        User user = userService.getUserById(userId);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-one");
        mv.addObject("user", user);

        return mv;
    }

    /**
     * 유저 가입 페이지
     */
    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String getNewBoardPage(){
        return "user-new";
    }

    /**
     * 유저 가입
     */
    @PostMapping(value = "/user/new", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView createUser(User user) {
        User saveUser = userService.saveUser(user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-one");
        mv.addObject("user", saveUser);

        return mv;
    }
}
