package com.ohgiraffers.sessionsecurity.auth.controller;

import com.ohgiraffers.sessionsecurity.config.handler.AuthFailHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login() {
    }

    @GetMapping("/fail")
    public void fail(ModelAndView mv, @RequestParam String message) {
        mv.addObject("message",message);
        mv.setViewName("/auth/fail");
    }

}
