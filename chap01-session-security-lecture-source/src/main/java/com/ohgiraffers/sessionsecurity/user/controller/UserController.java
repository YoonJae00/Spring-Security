package com.ohgiraffers.sessionsecurity.user.controller;


import com.ohgiraffers.sessionsecurity.user.model.service.UserService;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public void singup() {}

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignupDTO signupDTO){

        int result = userService.regist(signupDTO);

        String message = "";

        if(result > 0){
            message = "회원가입이 정상적으로 완료되었습니다.";
        } else {
            message = "회원가입이 실패하셨습니다.";
        }
        mv.addObject("message", message);
        return mv;
    }

}
