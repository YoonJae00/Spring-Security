package com.ohgiraffers.sessionsecurity.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/main"})
    public String main() {
        return "main";
    }

    @GetMapping("/admin/page")
    public String adminPage() {
        return "/admin/admin";
    }

    @GetMapping("/user/page")
    public String userPage() {
        return "/user/user";
    }
}
