package io.sejong.study.springbulletinboard.board.controller;

import io.sejong.study.springbulletinboard.board.entity.Board;
import io.sejong.study.springbulletinboard.board.entity.User;
import io.sejong.study.springbulletinboard.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.IntStream;

@Controller
@RequestMapping("/api/v1")
public class BoardController {

    //public static final int pageBarCount = 5;
    private final BoardService boardService;

    public BoardController(BoardService boardService) { this.boardService = boardService; }

    /**
     * 게시글 내용 전체 조회
     */
    @RequestMapping(value ="/board/all", produces = "application/json;charset=utf8")
    public ModelAndView getBoardAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        Page<Board> boardList = boardService.getAll(page);

        int pageBarCount = 5;
        int startIndex = pageBarCount * (page / (pageBarCount + 1)) + 1;
        int endIndex = page >= boardList.getTotalPages() ? boardList.getTotalPages() : ((startIndex / pageBarCount) + 1) * pageBarCount;

        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-all");
        mv.addObject("boards", boardList);
        mv.addObject("startIndex", startIndex);
        mv.addObject("endIndex", endIndex);

        return mv;
    }

    /**
     * 게시글 내용 단건 조회
     */
    @RequestMapping(value = "/board/{boardId}", method = RequestMethod.GET, produces = "application/json;charset=utf8")
    public String getBoardOne(Model model, @PathVariable int boardId) {
        Board board = boardService.getBoardById(boardId);
        model.addAttribute("replyList", board.getReplyList().iterator());
        model.addAttribute("board", board);

        return "board-one";
    }

    /**
     * 게시글 생성 페이지
     */
    @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String getNewBoardPage(Model model, String type, @RequestParam(value = "board_id", required = false, defaultValue = "0") int boardId)
    {
        model.addAttribute("type", type);
        if (type.equals("edit")) {
            Board board = boardService.getBoardById(boardId);
            model.addAttribute("board", board);
        }
        return "board-form";
    }

    /**
     * 게시글 생성
     */
    @PostMapping(value = "/board/new", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String createBoard(Model model, Board board, String userId) {
        Board savedBoard = boardService.saveBoard(board, userId);

        model.addAttribute("board", savedBoard);
        return "redirect:/api/v1/board/" + savedBoard.getBoardId();
    }

    /**
     * 게시글 수정
     */
    @PostMapping(value = "/board/edit/{boardId}", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String updateBoard(Model model, @PathVariable int boardId, Board board)
    {
        Board updateBoard = boardService.getBoardById(boardId);
        updateBoard.setTitle(board.getTitle());
        updateBoard.setContents(board.getContents());
        boardService.saveBoard(updateBoard);

        model.addAttribute("board", updateBoard);
        return "redirect:/api/v1/board/" + updateBoard.getBoardId();
    }

    /**
     * 게시글 삭제
     */
    @GetMapping(value = "/board/delete/{boardId}")
    public String deleteBoard(@PathVariable int boardId)
    {
        boardService.deleteBoardById(boardId);

        return "redirect:/api/v1/board/all";
    }

    /**
     * 테스트
     */
    @GetMapping(value = "/page")
    public String page()
    {
        return "page";
    }

    /**
     * 테스트 더미 데이터
     */
    @GetMapping(value = "/test/data")
    public String testData()
    {
        /*User user = new User();
        user.setId("zkdlwnfm");
        user.setNickname("pjh6274");
        user.setPassword("3214");
        userService.*/

        IntStream.range(1, 100).forEach(i -> {
            Board board = new Board();
            board.setTitle("Title"+i);
            board.setContents("Contents"+i);
            boardService.saveBoard(board, "zkdlwnfm");
        });

        return "board-all";
    }
}
