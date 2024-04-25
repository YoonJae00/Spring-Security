package com.ohgiraffers.sessionsecurity.config.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

// 사용자의 로그인 실패 시 실패 요청을 커스텀 하기 위한 핸들러 이다.
@Configuration
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

    /*
        @param request 사용자 요청 개체
        @param response 서버 응답값
        @param exception 발생한 오류를 담는 개체
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = "";
        // 사용자의 아이디가 DB 존재하지 않을 경우, 비밀번호가 맞지 않는 경우 발생하는 오류
        if(exception instanceof BadCredentialsException){
            errorMessage = "아이디가 존재하지 않거나, 비밀번호가 일치하지 않습니다.";
            // 서버에서 사용자 정보를 검증하는 과정에서 발생하는 에러
        } else if(exception instanceof InternalAuthenticationServiceException){
            errorMessage = "서버에서 오류가 발생하였습니다. 관리자에게 문의해주세요";
            // DB 에 사용자의 정보가 없는 경우 발생하는 오류
        } else if(exception instanceof UsernameNotFoundException){
            errorMessage = "존재하지 않는 ID 입니다.";
            // 보안 컨텍스트에 인증 객체가 존재하지 않거나 인증 정보가 없는 상태에서
            // 보안 처리 된 리소스에 접근하는 경우 발생
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "인증 요청이 거부되었습니다.";
        } else {
            errorMessage = "알 수 없는 오류 발생!!";
        }
        // URL 을 안전하게 인코딩 하는데 사용되는 유틸로 문자열을 URL 에 사용 가능한 형식으로 인코딩
        errorMessage = URLEncoder.encode(errorMessage, "UTF-8");

        // 오류를 처리할 페이지로 이동시킨다. URL 요청은 서블릿(페이지)가 있어야 함.
        setDefaultFailureUrl("/auth/fail?message=" + errorMessage);
        super.onAuthenticationFailure(request, response, exception);
    }
}
