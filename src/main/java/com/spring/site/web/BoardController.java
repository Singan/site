package com.spring.site.web;

import com.spring.site.domain.Board;
import com.spring.site.domain.Criteria;
import com.spring.site.domain.Member;
import com.spring.site.etc.LoginSecurity;
import com.spring.site.service.BoardService;
import com.spring.site.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;
    String dir = "/board";
    @GetMapping("/list")
    public String list(Model model,@RequestParam(defaultValue = "1") int no) throws Exception  {
        Criteria criteria = new Criteria(no);
        criteria.setCurrentPageNo(no);
        List<Board> bl = boardService.list(criteria);
        model.addAttribute("list",bl);
        System.out.println("보드 리스트 확인");
        int boardCount = (boardService.countBoard()+9)/criteria.getRecordsPerPage();
        model.addAttribute("boardCount",boardCount);
        return "/board/list";
    }
    // board writer , title,file , date,content
    @PostMapping("/insert")
    public String insert( @AuthenticationPrincipal LoginSecurity log,Board board) throws Exception  {

        Board inBoard = new Board();
        Member member = log.getMember();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lDate = LocalDate.now();
        inBoard.setWriter(member.getNo());
        inBoard.setTitle(board.getTitle());
        inBoard.setContent(board.getFile());
        inBoard.setContent(board.getContent());
        inBoard.setDate(lDate.format(formatter));
        System.out.println("보드 인설트 확인");
        System.out.println(inBoard.toString());
        boardService.insert(inBoard);
        return "redirect:/board/list";
    }
    @GetMapping("/insert")
    public String goInsert(Model model) {

        model.addAttribute("board", new Board());
        return "/board/insert";
    }

    @GetMapping("/detail")
    public String detail(int no,Model model) throws Exception  {
        System.out.println("디테일no 확인" + no);
        Board board = boardService.detailBoard(no);
        System.out.println(board.toString());
        model.addAttribute("board",board);
        return "/board/detail";
    }

}
