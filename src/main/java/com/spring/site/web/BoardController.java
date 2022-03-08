package com.spring.site.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/templates/board")
public class BoardController {
    @GetMapping("/")
    public String main(HttpServletRequest request, HttpServletResponse response) {

        return "home";
    }
}
