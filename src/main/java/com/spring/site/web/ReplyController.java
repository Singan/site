package com.spring.site.web;

import com.spring.site.domain.Reply;
import com.spring.site.service.MemberService;
import com.spring.site.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("board/reply/write")
    private String string() {
        Reply replyDto = new Reply();
        replyService.add(replyDto);
        return "redirect:/board/detail?no=";
    }


}
