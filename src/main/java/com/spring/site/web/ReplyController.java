package com.spring.site.web;

import com.spring.site.domain.Member;
import com.spring.site.domain.Reply;
import com.spring.site.service.MemberService;
import com.spring.site.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
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
        reply2.setWriter("asdf1234");
        replyService.add(reply2);
        String redirect = "redirect:/board/detail?no="+ Integer.toString(no);
        return redirect;
    }

    @GetMapping("/list")
    @ResponseBody
    private List<Reply> commentList(@RequestParam int no, Model model) throws Exception{
        Reply reply = new Reply();
        List<Reply> list = replyService.get(no);
        reply.setNo(no);
        model.addAttribute("list", list);
        return replyService.get(no);
    }



}
