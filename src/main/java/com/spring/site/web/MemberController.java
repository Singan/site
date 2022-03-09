package com.spring.site.web;


import com.spring.site.domain.Member;
import com.spring.site.etc.LoginSecurityService;
import com.spring.site.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.security.Principal;
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

    @GetMapping("/myPage")
        public String myPage(Model model, @AuthenticationPrincipal Principal principal) {
        Member member = new Member();
//        member.setName(principal.getName());
        model.addAttribute("member", member.getId());
        model.addAttribute("member", member);

            return "member/myPage";
        }

//    @PostMapping("/myPage")
//    public String userEdit(Member form, BindingResult result, Member currentMember) {
//        if(result.hasErrors()) {
//            return "redirect:/member/myPage";
//        }
//
//        currentMember.setPw(form.getPw());
//        currentMember.setName(form.getName());
//        return "redirect:/member/myPage";
//    }

}
