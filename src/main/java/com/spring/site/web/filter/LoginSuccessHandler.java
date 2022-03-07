package com.spring.site.web.filter;

import com.spring.site.etc.token.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenProvider tokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        String token = tokenProvider.createToken(authentication);
//        response.setHeader("token",token);
//        Cookie cookie = new Cookie("token", token);
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        cookie.setMaxAge(1000 * 60 * 60);
//        response.addCookie(cookie);
//        System.out.println("authentication : " + authentication);
//        System.out.println("successHandler실행 token :" + token);
//        System.out.println("successHandler실행 cookie :" + cookie);


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
