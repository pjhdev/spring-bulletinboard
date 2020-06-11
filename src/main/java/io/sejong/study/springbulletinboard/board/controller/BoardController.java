package io.sejong.study.springbulletinboard.board.controller;

import ch.qos.logback.classic.Logger;
import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.service.BoardService;
import java.util.List;

import io.sejong.study.springbulletinboard.board.entity.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.jvm.hotspot.debugger.Debugger;

@Controller
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    /**
     * 게시글 내용 전체 조회
     */
    @RequestMapping(value ="/board/all", produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(Model model) {
        List<Board> boardList = boardService.getAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-all");
        mv.addObject("boards", boardList);

        return mv;
    }

    /**
     * 게시글 내용 전체 조회
     */
    @RequestMapping(value = "/board/id/{boardId}", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(@PathVariable int boardId) {
        Board board = boardService.getBoardById(boardId);
        System.out.println(board.getTitle());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-one");
        mv.addObject("board", board);

        return mv;
    }

    /**
     * 게시글 생성 페이지
     */
    @RequestMapping(value = "/board/new", method = RequestMethod.GET)
    public String getNewBoardPage(){
        return "board-new";
    }

    /**
     * 게시글 생성
     */
    @PostMapping(value = "/board/new", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView createBoard(Board board, String userId) {
        Board savedBoard = boardService.saveBoard(board, userId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-one");
        mv.addObject("board", savedBoard);

        return mv;
    }
}
