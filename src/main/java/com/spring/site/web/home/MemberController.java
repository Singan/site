package com.spring.site.web.home;


import com.spring.site.domain.Member;
import com.spring.site.etc.security.login.LoginSecurity;
import com.spring.site.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.ArrayList;
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
    public String myPage(Model model, Authentication authentication) {
        LoginSecurity userDetails = (LoginSecurity) authentication.getPrincipal();
        userDetails.getMember();
        System.out.println("마이페이지" + userDetails.getMember());
        model.addAttribute("member", userDetails.getMember());
        return "/member/myPage";
    }

    @GetMapping("/camping")
    public String camping(Model model, String name, int no) throws Exception {
        List<String> cs = new ArrayList<>();
        for (int i = 0; i < no; i++) {
            cs.add(name + i);
        }
        model.addAttribute("name", name);
        model.addAttribute("cs", cs);
        System.out.println("camping");
        System.out.println("camping" + name);
        for (int i = 0; i < cs.size(); i++) {

            String abc = cs.get(i);
            System.out.println(abc);

        }
        return "/member/camping";
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
