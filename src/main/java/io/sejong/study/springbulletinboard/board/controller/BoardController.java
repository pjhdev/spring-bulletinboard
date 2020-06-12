package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String getNewBoardPage(Model model, String type, @RequestParam(value = "board_id", required = false, defaultValue = "0") int boardId)
    {
        Board board = boardService.getBoardById(boardId);
        model.addAttribute("type", type);
        if (type.equals("edit")) {
            model.addAttribute("board", board);
        }
        return "board-form";
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

    /**
     * 게시글 수정
     */
    @PostMapping(value = "/board/edit/{boardId}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView updateBoard(@PathVariable int boardId, Board board)
    {
        Board updateBoard = boardService.getBoardById(boardId);
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContents(board.getContents());
        boardService.saveBoard(updateBoard);

        return new ModelAndView("board-one", "board", updateBoard);
    }

    /**
     * 게시글 삭제
     */
    @GetMapping(value = "/board/delete/{boardId}")
    public String deleteBoard(@PathVariable int boardId)
    {
        System.out.println("HEREREER");
        System.out.println(boardId);
        System.out.println("HEREREER");
        boardService.deleteBoardById(boardId);

        return "redirect:/api/v1/board/all";
    }
}
