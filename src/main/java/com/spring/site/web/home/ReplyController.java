package com.spring.site.web.home;

import com.spring.site.domain.Board;
import com.spring.site.domain.Member;
import com.spring.site.domain.Reply;
import com.spring.site.etc.security.login.LoginSecurity;
import com.spring.site.service.MemberService;
import com.spring.site.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("/insert")
    private String  mCommentServiceInsert(@RequestParam int no, @RequestParam String reply) throws Exception{
        Reply reply2 = new Reply();
        reply2.setNo(no);
        reply2.setReply(reply);
        LoginSecurity log = (LoginSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Member member = log.getMember();
        reply2.setWriter(member.getId());
        replyService.add(reply2);
        String redirect = "redirect:/board/detail?no="+ Integer.toString(no);
        System.out.println("댓글 작동 확인");
        return redirect;
    }

    @GetMapping("/list")
    @ResponseBody
    private List<Reply> commentList(@RequestParam int no, Model model) throws Exception{
        Reply reply = new Reply();
        reply.setNo(no);
        return replyService.get(no);
    }



}
