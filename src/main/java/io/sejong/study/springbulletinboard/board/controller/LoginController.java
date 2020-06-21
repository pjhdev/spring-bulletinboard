package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

    /**
     * 로그인 페이지
     */
    @GetMapping(value = "/login")
    public String loginForm() { return "login"; }

    /**
     * 로그인
     */
    @PostMapping(value = "/login")
    public String login()
    {
        return "page";
    }

    /**
     * 로그아웃
     */
}
