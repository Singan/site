package com.spring.site.web;


import com.spring.site.domain.Member;
import com.spring.site.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    ServletContext sc;

    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Member> list = memberService.list();
        model.addAttribute("list", list);
        System.out.println("list");
        return "/member/memberList";
    }


}
