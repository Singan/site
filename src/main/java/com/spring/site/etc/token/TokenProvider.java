package com.spring.site.etc.token;

import com.spring.site.etc.security.login.LoginSecurityService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Enumeration;

@Component
public class TokenProvider {

    private String secretKey = "secret";

    private long tokenValidTime = 1000L * 60 * 60;

    @Autowired
    private LoginSecurityService loginSecurityService;

    // 토큰 생성
    public String createToken(UserDetails userDetails) {
        Claims claims = Jwts.claims().setSubject(String.valueOf(userDetails.getUsername())); // JWT payload 에 저장되는 정보단위
        claims.put("roles", userDetails.getUsername()); // 정보는 key / value 쌍으로 저장된다.
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + tokenValidTime)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 사용할 암호화 알고리즘과
                // signature 에 들어갈 secret값 세팅
                .compact();

    }

    // 토큰 인증 정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = loginSecurityService.loadUserByUsername(getUserPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    // 토큰 회원 정보 추출
    public String getUserPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
//        Enumeration headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()) {
//            String name = (String)headerNames.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name + " : " + value + "<br>");
//        }
        System.out.println("헤더전체");
        System.out.println("request:"+request.getHeader("Authorization"));

        if(request.getHeader("cookie") == null){
            return null;
        }
        return request.getHeader("cookie").substring(6);

    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("jwt 서명 확인 x");
        } catch (MalformedJwtException e) {
            System.out.println("jwt 올바르게 구성 x");
        } catch (ExpiredJwtException e) {
            SecurityContextHolder.clearContext();
            System.out.println("jwt 기간 종료");
        } catch (UnsupportedJwtException e) {
            System.out.println("jwt 형식이 다름");
        } catch (IllegalArgumentException e) {
            System.out.println("jwt 내용이 비었음");
        } catch (NullPointerException e) {
            System.out.println("jwt null");
        }
        return false;
    }
}
