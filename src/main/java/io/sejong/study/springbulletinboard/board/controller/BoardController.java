package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    /**
     * 게시글 내용 전체 조회
     */
    @RequestMapping(value ="/board/all", produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(Pageable pageable) {
        Page<Board> boardList = boardService.getAll(pageable);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-all");
        mv.addObject("boards", boardList);

        return mv;
    }

    /**
     * 게시글 내용 단건 조회
     */
    @RequestMapping(value = "/board/id/{boardId}", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(@PathVariable int boardId) {
        Board board = boardService.getBoardById(boardId);

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
